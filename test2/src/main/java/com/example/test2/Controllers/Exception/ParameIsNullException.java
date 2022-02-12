package com.example.test2.Controllers.Exception;

public class ParameIsNullException extends ControllerException{
    public ParameIsNullException() {
        super();
    }

    public ParameIsNullException(String message) {
        super(message);
    }

    public ParameIsNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParameIsNullException(Throwable cause) {
        super(cause);
    }

    protected ParameIsNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
