package com.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

/**
 * 连接池
 * @author aidenli
 */
public class ConnectionPool {
    public ConnectionPool() {
        this.init();
    }


    private final FreeConnectionRecyler recyler = new FreeConnectionRecyler();



    public void startRecycleTimer() {

        Manager manager = new Manager();
        manager.setDaemon(true);
        manager.setPriority(8);
        manager.start();
        Timer t = new Timer();
        t.schedule(recyler, 0, 500);

    }

    private final int MIN_IDLE = 5;
    private final int MAX_TOTAL = 50;

    List<Connection> freePool = new Vector<Connection>();
    List<Connection> usedPool = new Vector<Connection>();
    int count = 0;

    private void init() {
        createConnections(10);
    }

    private void createConnections(int count) {
        if(this.count == MAX_TOTAL) {
            return;
        }
        count = Math.min(MAX_TOTAL-this.count, this.count);
        for (int i = 0; i < count; i++) {
            try {
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/lcy",
                        "root",
                        ",,,,"
                );
                ConnectionProxy connectionProxy = new ConnectionProxy(connection);
                freePool.add(connectionProxy);
                this.count++;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Connection getConnection(){
        long total = 0;
        while (true) {
            while (freePool.size() == 0) {
                try {
                    total += 500;
                    Thread.sleep(500);
                    if (total == 2000) {
                        throw new RuntimeException("Connection rejected");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Connection conn = null;
            try {
                conn =  freePool.remove(0);
            } catch (Exception e) {

            }

            ConnectionProxy connectionProxy = (ConnectionProxy) conn;
            connectionProxy.setFlag(true);
            usedPool.add(conn);
            return conn;
        }
    }

    class Manager extends Thread{
        @Override
        public void run() {
            while (true) {
                this.checkFreeCount();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void checkFreeCount() {
            if (freePool.size() < MIN_IDLE) {
                createConnections(10);
            }
        }
    }

    class FreeConnectionRecyler extends TimerTask {

        public void recycle() throws SQLException {
            Iterator<Connection> iterator = usedPool.iterator();
            for (;iterator.hasNext();) {
                Connection connection = iterator.next();
                if (connection.isClosed()) {
                    iterator.remove();
                    freePool.add(connection);
                    break;
                }
            }
        }

        /**
         * The action to be performed by this timer task.
         */
        @Override
        public void run() {
            try {
                this.recycle();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
