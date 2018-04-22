package org.jcache.cache.purge.impl;

import org.jcache.cache.CachedObject;
import org.jcache.cache.purge.PurgeStrategy;

public class LeastFrequentlyUsedPurgeStrategy implements PurgeStrategy {
	int expirationTimeInHours;
	
	public int getExpirationTimeInHours() {
		return expirationTimeInHours;
	}

	public void setExpirationTimeInHours(int expirationTimeInHours) {
		this.expirationTimeInHours = expirationTimeInHours;
	}
    public boolean isExpired(CachedObject cachedObject) {
        return false;
    }
}
