package org.jcache.cache.manager;

import org.jcache.cache.CachedObject;
import sun.security.util.Cache;

public class CacheManagerTest {
    public static void main(String args[]){
        CachedObject co1 = new CachedObject(1, 1);
        CachedObject co2 = new CachedObject(3, 2);
        CacheManager.putCache(co1);
        CacheManager.putCache(co2);
        System.out.println(CacheManager.getCache(1));
        System.out.println(CacheManager.getCache(2));
        System.out.println(CacheManager.getCache(3));
    }
}
