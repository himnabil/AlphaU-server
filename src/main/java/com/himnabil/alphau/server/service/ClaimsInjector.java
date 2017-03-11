package com.himnabil.alphau.server.service;

/**
 * @author himna
 *
 */


public interface ClaimsInjector <E , TokenBuilder> {
    public TokenBuilder inject ( TokenBuilder builder , E entity);
}
