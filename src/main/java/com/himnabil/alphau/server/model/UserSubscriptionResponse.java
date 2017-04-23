package com.himnabil.alphau.server.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.util.Map;

/**
 * @author himna
 * @since 4/23/2017.
 */
public class UserSubscriptionResponse {

    private User user;

    public UserSubscriptionResponse(User user){
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
