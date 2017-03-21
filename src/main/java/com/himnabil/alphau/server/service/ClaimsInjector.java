package com.himnabil.alphau.server.service;

/**
 * @author himna
 *
 */

@FunctionalInterface
public interface ClaimsInjector <E , B> {
    public B inject (B builder , E entity);
}
