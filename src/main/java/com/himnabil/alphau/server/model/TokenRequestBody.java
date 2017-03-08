package com.himnabil.alphau.server.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author himna on 2/13/2017.
 */
public class TokenRequestBody {

    private String appName ;
    private String userName ;
    private String password ;
    private Map<String, Object> properties = new HashMap<String,Object>();

    @JsonGetter("app_name")
    public String getAppName() {
        return appName;
    }
    @JsonSetter("app_name")
    public void setAppName(String appName) {
        this.appName = appName;
    }

    @JsonGetter("user_name")
    public String getUserName() {
        return userName;
    }
    @JsonSetter("user_name")
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonGetter("password")
    public String getPassword() {
        return password;
    }
    @JsonSetter("password")
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonAnyGetter
    public Map<String,Object> getProperties (){
        return properties;
    }
    @JsonAnySetter
    public void setPropertie (String key , Object value){
        properties.put(key , value);
    }
}
