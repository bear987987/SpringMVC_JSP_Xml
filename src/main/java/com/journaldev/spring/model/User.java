package com.journaldev.spring.model;

import com.sun.istack.internal.NotNull;

import java.io.Serializable;

public class User implements Serializable {
    @NotNull
    private String userName;
    private String apple;

    public String getApple() {
        return apple;
    }

    public void setApple(String apple) {
        this.apple = apple;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
