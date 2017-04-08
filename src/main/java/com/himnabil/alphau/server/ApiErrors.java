package com.himnabil.alphau.server;

/**
 * @author himna
 * @since 4/8/2017.
 */
public class ApiErrors {

    public static final ApiError USER_NOT_FOUND     = new ApiError("USER_NOT_FOUND"     , "user not found in db.");
    public static final ApiError INVALIDE_PASSWORD  = new ApiError("INVALIDE_PASSWORD"  , "password does not match with user's password ");
}
