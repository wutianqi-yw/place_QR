package com.example.test2.Service.Exception;

public class AuthorityNotFoundException extends ServiceException{
    public AuthorityNotFoundException() {
        super();
    }

    public AuthorityNotFoundException(String message) {
        super(message);
    }

    public AuthorityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthorityNotFoundException(Throwable cause) {
        super(cause);
    }

    protected AuthorityNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
