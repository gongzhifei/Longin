package com.gzf.exception;

public class UserNotExitsException extends RuntimeException {

    private String id;

    public UserNotExitsException(String id) {
        super("user not exist");
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
