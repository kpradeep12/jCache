package org.jcache.cache.purge.impl;

import org.jcache.cache.purge.PurgeStrategy;

public class LeastFrequentlyUsedPurgeStrategy implements PurgeStrategy {
    public boolean isExpired() {
        return false;
    }
}
