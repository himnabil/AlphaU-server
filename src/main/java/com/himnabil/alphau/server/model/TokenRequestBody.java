package com.himnabil.alphau.server.model;

/**
 * Created by himna on 2/13/2017.
 */
public class TokenRequestBody {
    private String appName ;
    private String userName ;
    private String password ;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
