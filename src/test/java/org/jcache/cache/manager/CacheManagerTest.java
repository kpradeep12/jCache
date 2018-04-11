package org.jcache.cache.manager;

import org.jcache.cache.CachedObject;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.jcache.cache.purge.PurgeStrategyType;
import org.jcache.cache.store.Store;
import org.junit.jupiter.api.Test;
class CacheManagerTest {

    @Test
    void putAndGetCacheManagerTest(){
        CachedObject co1 = new CachedObject(1, 1);
        CacheManager cm = CacheManager.getInstance(PurgeStrategyType.LFU);
        Store store1 = cm.createStore("strings");
        store1.put(1,co1);
        assertNotNull(store1.get(1));
        Store store2 = cm.createStore("strings2");
        assertNull(store2.get(1));
    }

}
