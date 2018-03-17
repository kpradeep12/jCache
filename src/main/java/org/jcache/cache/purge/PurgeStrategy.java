package org.jcache.cache.purge;

public interface PurgeStrategy {

    public boolean isExpired();
}
