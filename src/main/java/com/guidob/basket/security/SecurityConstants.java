package com.guidob.basket.security;

public class SecurityConstants {

    public static final String SIGN_UP_URLS = "/users/**";
    public static final String H2_URL = "h2-console/**";
    public static final String SECRET ="SecretKeyToGenJWTs";
    public static final String TOKEN_PREFIX= "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final long EXPIRATION_TIME = 3900_000; //30 seconds
}