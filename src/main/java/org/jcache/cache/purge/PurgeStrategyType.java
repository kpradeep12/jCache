package org.jcache.cache.purge;

import org.jcache.cache.purge.impl.LeastFrequentlyUsedPurgeStrategy;

public enum PurgeStrategyType {
    LFU{
        public PurgeStrategy createPurgeStrategy() {
            return new LeastFrequentlyUsedPurgeStrategy();
        }
    };
    public abstract PurgeStrategy createPurgeStrategy();
}
