package org.jcache.cache.purge;

import org.jcache.cache.purge.impl.LastTimeUsedPurgeStrategy;
import org.jcache.cache.purge.impl.LeastFrequentlyUsedPurgeStrategy;

public enum PurgeStrategyType {
    LFU{
        public PurgeStrategy createPurgeStrategy() {
            return new LeastFrequentlyUsedPurgeStrategy();
        }
    },
	LTU{
        public PurgeStrategy createPurgeStrategy() {
            return new LastTimeUsedPurgeStrategy();
        }
    };
    public abstract PurgeStrategy createPurgeStrategy();
}
