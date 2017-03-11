package com.himnabil.alphau.server.service;

import com.himnabil.alphau.server.model.User;

import java.util.Collection;

/**
 * @author himna
 * @since 3/4/2017.
 */
public interface Tokenizer <E , Builder> {

    public String tokenize (E entity);

    public void setClaimInjectors (Collection< ClaimsInjector<E , Builder> > claimInjectors);
}
