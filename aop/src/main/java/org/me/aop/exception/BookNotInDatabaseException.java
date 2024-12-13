package org.me.aop.exception;

public class BookNotInDatabaseException extends Exception {

    public BookNotInDatabaseException(String message) {
        super(message);
    }
}
