package com.himnabil.alphau.server.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.util.Map;

/**
 * @author himna
 * @since 4/23/2017.
 */
public class UserSubscriptionResult {

    private User user;

    public UserSubscriptionResult (User user){
        this.user = user;
    }

    public String getId() {
        return user.getId();
    }

    public String getUserName() {
        return user.getUserName();
    }

    public String getAppName() {
        return user.getAppName();
    }

    @JsonAnyGetter
    public Map<String, Object> getProperties() {
        return user.getProperties();
    }

}
