package org.jcache.cache.purge.impl;

import org.jcache.cache.CachedObject;
import org.jcache.cache.purge.PurgeStrategy;

public class LeastFrequentlyUsedPurgeStrategy implements PurgeStrategy {

    @Override
    public boolean isExpired(CachedObject cachedObject) {
        return false;
    }
}
