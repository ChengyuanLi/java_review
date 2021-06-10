package com.dbcp;

/**
 * @author aidenli
 */
public class ConnectionTimeoutException extends RuntimeException{
    public ConnectionTimeoutException() {
        super();
    }

    public ConnectionTimeoutException(String msg) {
        super(msg);
    }
}
