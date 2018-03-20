package org.jcache.cache.manager;

import org.jcache.cache.CachedObject;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
class CacheManagerTest {

    @Test
    void putAndGetCacheManagerTest(){
        CachedObject co1 = new CachedObject(1, 1);
        CacheManager.putCache(co1);
        assertNotNull(CacheManager.getCache(1));
    }

}
