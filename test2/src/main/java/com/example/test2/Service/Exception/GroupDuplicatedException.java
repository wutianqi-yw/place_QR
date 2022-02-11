package com.example.test2.Service.Exception;

public class GroupDuplicatedException extends ServiceException{
    public GroupDuplicatedException() {
        super();
    }

    public GroupDuplicatedException(String message) {
        super(message);
    }

    public GroupDuplicatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public GroupDuplicatedException(Throwable cause) {
        super(cause);
    }

    protected GroupDuplicatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
