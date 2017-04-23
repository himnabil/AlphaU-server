package com.himnabil.alphau.server;

/**
 * @author himna
 * @since 4/8/2017.
 */
public class ApiErrors {

    public static final ApiError USER_NOT_FOUND     = new ApiError("USER_NOT_FOUND"     , "user not found in db.");
    public static final ApiError INVALID_PASSWORD  = new ApiError("INVALID_PASSWORD"  , "password does not match with user's password.");
    public static final ApiError USER_ALREADY_EXIST  = new ApiError("USER_ALREADY_EXIST"  , "can not save user, user already exist in db.");
}
