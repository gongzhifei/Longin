package com.gzf.exception;

public class ServiceException extends RuntimeException {

    private String className;

    public ServiceException(String className) {
        super("class Exception");
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
