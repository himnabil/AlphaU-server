package com.himnabil.alphau.server.model;

import java.util.HashMap;
import java.util.Map;

public class User  {
    private String id;
    private String userName;
    private String hashedPassword;
    private String appName ;
    private Map<String, Object> properties = new HashMap<String, Object>();

    public User(
            String id,
            String userName,
            String hashedPassword,
            String appName,
            Map<String, Object> properties
    ) {
        this.id = id;
        this.userName = userName;
        this.hashedPassword = hashedPassword;
        this.appName = appName;
        this.properties = properties;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }
}
