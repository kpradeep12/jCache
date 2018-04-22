package org.jcache.cache.store;

import org.jcache.cache.Cacheable;
import org.jcache.cache.CachedObject;
import org.jcache.cache.purge.PurgeStrategy;

import java.util.Map;

public class Store {
    private Map cacheHashMap = new java.util.HashMap();
    private PurgeStrategy strategy;
    private String storeName;
    public Store(PurgeStrategy stragegy) {
    	this.strategy  = stragegy;
    }
    public void put(String identifier, Cacheable co){
    	if(this.cacheHashMap.get(identifier) == null) {
    		this.cacheHashMap.put(identifier, co);
    		System.out.println("SORE::PUT::"+identifier+"::::"+co.getObject());
    	}	
    }

    public CachedObject get(String identifier){
        return (CachedObject) this.cacheHashMap.get(identifier);
    }
    public Map getStoreMap() {
    	return cacheHashMap;
    }
	public PurgeStrategy getStrategy() {
		return strategy;
	}
	public void setStrategy(PurgeStrategy strategy) {
		this.strategy = strategy;
	}
    
}
