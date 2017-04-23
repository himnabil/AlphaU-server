package com.himnabil.alphau.server.model.builder;

import com.himnabil.alphau.server.model.User;

import java.util.Map;

public class UserBuilder {
    private String id;
    private String userName;
    private String hashedPassword;
    private String appName;
    private Map<String, Object> properties;

    public UserBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public UserBuilder setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public UserBuilder setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
        return this;
    }

    public UserBuilder setAppName(String appName) {
        this.appName = appName;
        return this;
    }

    public UserBuilder setProperties(Map<String, Object> properties) {
        this.properties = properties;
        return this;
    }

    public User build() {
        return new User(id, userName, hashedPassword, appName, properties);
    }
}