package com.dbcp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

/**
 * java数据库连接池
 * @author aidenli
 */
public class ConnectionPool {


    public ConnectionPool(){
        startRecycleTimer();
        this.init();
    }




    private final FreeConnectionRecycler r = new FreeConnectionRecycler();

    public void startRecycleTimer() {
        Manager m = new Manager();
        m.setDaemon(true);
        m.setPriority(8);
        m.start();
        Timer t = new Timer();
        t.schedule(r, 0, 500);
    }

    private final int MIN_CONNECTIONS = 10;
    private final int MIN_IDLE = 5;
    private final int MAX_IDLE = 10;
    private final int MAX_TOTAL = 50;
    private final long MAX_TIMEOUT = 2000;

    List<Connection> freepool = new Vector<Connection>();
    List<Connection> usedpool = new Vector<Connection>();
    int count = 0;


    private String dbUrl = "jdbc:mysql://localhost:3306/lcy";
    private String username = "root";
    private String password = ",,,,";

    private void init() {
        createConnections(MIN_CONNECTIONS);
    }

    private void createConnections(int count) {
        if (this.count == MAX_TOTAL) {
            return;
        }
        count = Math.min(MAX_TOTAL - this.count, count);
        for (int i = 0; i < count; i++) {
            try {
                Connection connection = DriverManager.getConnection(dbUrl, username, password);
                ConnectionProxy cp = new ConnectionProxy(connection);
                freepool.add(cp);
                this.count ++;
                } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public Connection getConnection() {
        long total = 0;
        while (true) {
            while (freepool.size() == 0) {
                try {
                    total += 500;
                    Thread.sleep(500);
                    if (total >= MAX_TIMEOUT) {
                        throw new ConnectionTimeoutException();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Connection connection = null;
            try {
                connection = freepool.remove(0);
            } catch (Exception e) {

            }

            ConnectionProxy cp = (ConnectionProxy) connection;
            cp.setFlag(true);
            cp.setUsedTime(System.currentTimeMillis());
            usedpool.add(connection);
            return connection;
        }
    }


    class Manager extends Thread{

        @Override
        public void run() {
            while (true) {
                this.checkFreeCount();
                this.checkUsedTime();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void checkFreeCount() {
            if (freepool.size() < MIN_IDLE) {
                createConnections(10);
                return;
            }
            if (freepool.size() > MAX_IDLE) {
                while (freepool.size() > MAX_IDLE) {
                    ConnectionProxy connection = (ConnectionProxy) freepool.remove(freepool.size() - 1);
                    try {
                        connection.realClose();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

        public void checkUsedTime() {
            for (Connection connection: usedpool) {
                ConnectionProxy cp = (ConnectionProxy) connection;
                long currentTime = System.currentTimeMillis();
                if (currentTime - cp.getUsedTime() > 5000) {
                    try {
                        cp.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }



    class FreeConnectionRecycler extends TimerTask {

        public void recycle() throws SQLException {
            Iterator<Connection> it = usedpool.iterator();
            for (;it.hasNext();) {
                Connection conn = it.next();
                if (conn.isClosed()) {
                    it.remove();
                    freepool.add(conn);
                    break;
                }
            }

        }






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
