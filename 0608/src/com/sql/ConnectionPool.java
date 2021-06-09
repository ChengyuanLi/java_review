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

    List<Connection> freePool = new Vector<Connection>();
    List<Connection> usedPool = new Vector<Connection>();

    private void init() {
        createConnections(10);
    }

    private final FreeConnectionRecyler recyler = new FreeConnectionRecyler();

    public void startRecycleTimer() {
        Timer t = new Timer();
        t.schedule(recyler, 0, 500);
    }

    private void createConnections(int count) {
        for (int i = 0; i < count; i++) {
            try {
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/lcy",
                        "root",
                        ",,,,"
                );
                ConnectionProxy connectionProxy = new ConnectionProxy(connection);
                freePool.add(connectionProxy);
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

    class FreeConnectionRecyler extends TimerTask {

        public void recycle() throws SQLException {
            Iterator<Connection> iterator = usedPool.iterator();
            while (iterator.hasNext()) {
                Connection connection = iterator.next();
                iterator.remove();
                freePool.add(connection);
                break;
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
