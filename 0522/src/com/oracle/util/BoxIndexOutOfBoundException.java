package com.oracle.util;

/**
 * 容器下标越界
 * @author aidenli
 */
public class BoxIndexOutOfBoundException extends RuntimeException {
    public BoxIndexOutOfBoundException() {
    }

    public BoxIndexOutOfBoundException(String message) {
        super(message);
    }
}
