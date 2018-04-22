package org.jcache.cache.purge;

import org.jcache.cache.CachedObject;

public interface PurgeStrategy {

    public boolean isExpired(CachedObject cachedObject);
    public int getExpirationTimeInHours();
    public void setExpirationTimeInHours(int time);
}
