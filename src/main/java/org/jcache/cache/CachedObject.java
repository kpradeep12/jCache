package org.jcache.cache;

import org.jcache.cache.purge.PurgeStrategy;

public class CachedObject implements Cacheable, PurgeStrategy{

	public CachedObject(Object obj, Object identifier, PurgeStrategy purgeStrategy){

    }
	public boolean isExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	public Object getIdentifier() {
		// TODO Auto-generated method stub
		return null;
	}

    public PurgeStrategy getPurgeStrategy() {
        return null;
    }
}
