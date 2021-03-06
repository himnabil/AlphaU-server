package com.himnabil.alphau.server.service;

import java.util.Collection;

/**
 * @author himna
 * @since 3/4/2017.
 */
public interface Tokenizer <E , B> {

    public String tokenize (E entity);

    public void setClaimInjectors (Collection< ClaimsInjector<E , B> > claimInjectors);
}
