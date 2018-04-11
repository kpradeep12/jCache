package org.jcache.cache.store;

import org.jcache.cache.CachedObject;

import java.util.Map;

public class Store {
    private Map cacheHashMap = new java.util.HashMap();

    public void put(Object identifier, CachedObject co){
        this.cacheHashMap.put(identifier, co);
    }

    public CachedObject get(Object identifier){
        return (CachedObject) this.cacheHashMap.get(identifier);
    }
}
