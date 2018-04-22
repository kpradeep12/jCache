package org.jcache.cache.manager;

import org.jcache.cache.Cacheable;
import org.jcache.cache.purge.ExpirationPolicy;
import org.jcache.cache.purge.PurgeStrategy;
import org.jcache.cache.purge.PurgeStrategyType;
import org.jcache.cache.purge.daemon.PurgeDaemon;
import org.jcache.cache.store.Store;

import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CacheManager {
    /* This is the HashMap that contains all objects in the cache. */
    private static Map<String, Store> cacheHashMap = new java.util.HashMap<String, Store>();
    private static PurgeStrategy purgeStrategy;
    private static CacheManager cacheManager;
    /* RESERVED FOR FUTURE USE  private static Object lock = new Object(); */
    /*static
    {
        try
        {

            Thread threadCleanerUpper = new PurgeDaemon(cacheHashMap);
            // Sets the thread's priority to the minimum value.
            threadCleanerUpper.setPriority(Thread.MIN_PRIORITY);
            // Starts the thread.
            threadCleanerUpper.start();
        }
        catch(Exception e)
        {
            System.out.println("CacheManager.Static Block: " + e);
        }
    }*/ /* End static block */
    private CacheManager(PurgeStrategy purgeStrategy)
    {
        this.purgeStrategy = purgeStrategy;
        try
        {
        	ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        	
            Thread threadCleanerUpper = new PurgeDaemon(cacheHashMap);
            // Sets the thread's priority to the minimum value.
            //threadCleanerUpper.setPriority(Thread.MIN_PRIORITY);
            executor.scheduleWithFixedDelay(threadCleanerUpper, 30, 30, TimeUnit.SECONDS);
        }
        catch(Exception e)
        {
            System.out.println("CacheManager.Static Block: " + e);
        }
    }

    /*Singleton design pattern is used to maintain single instance of cache manager */
    public static CacheManager getInstance(PurgeStrategyType purgeStrategyType){
        if(cacheManager == null){
            synchronized (CacheManager.class) {
                cacheManager = new CacheManager(purgeStrategyType.createPurgeStrategy());
            }
        }
        return cacheManager;
    }

    public Store createStore(String name,ExpirationPolicy policy){
    	if(cacheManager.cacheHashMap != null){
            synchronized (Store.class) {
            	if(CacheManager.cacheHashMap.get(name) == null) {
            		PurgeStrategy strategy = policy.getStrategyType().createPurgeStrategy();
            	    strategy.setExpirationTimeInHours(policy.getExpirationTimeInHours());
            		CacheManager.cacheHashMap.put(name, new Store(strategy));
            	}	
            }
    	}    	
        return CacheManager.cacheHashMap.get(name);
    }

    /*public void putCache(Cacheable object)
    {
        // Remember if the HashMap previously contains a mapping for the key, the old value
        // will be replaced.  This is valid functioning.
        cacheHashMap.put(object.getIdentifier(), object);
    }
    public Cacheable getCache(Object identifier)
    {
        //synchronized (lock)  // UNCOMMENT LINE XXX
        //{                    // UNCOMMENT LINE XXX
        Cacheable object = (Cacheable)cacheHashMap.get(identifier);
        // The code to create the object would be placed here.
        //}                    // UNCOMMENT LINE XXX

        *//*if (object == null)
            return null;
        if (object.getPurgeStrategy().isExpired())
        {
            cacheHashMap.remove(identifier);
            return null;
        }
        else
        {
            return object;
        }*//*
        return object;
    }*/
}
