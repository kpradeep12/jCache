package org.jcache.cache.manager;

import org.jcache.cache.Cacheable;
import org.jcache.cache.purge.PurgeDaemon;

class CacheManager {
    /* This is the HashMap that contains all objects in the cache. */
    private static java.util.HashMap cacheHashMap = new java.util.HashMap();
    /* This object acts as a semaphore, which protects the HashMap */
    /* RESERVED FOR FUTURE USE  private static Object lock = new Object(); */
    static
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
    } /* End static block */
    public CacheManager()
    {
    }
    public static void putCache(Cacheable object)
    {
        // Remember if the HashMap previously contains a mapping for the key, the old value
        // will be replaced.  This is valid functioning.
        cacheHashMap.put(object.getIdentifier(), object);
    }
    public static Cacheable getCache(Object identifier)
    {
        //synchronized (lock)  // UNCOMMENT LINE XXX
        //{                    // UNCOMMENT LINE XXX
        Cacheable object = (Cacheable)cacheHashMap.get(identifier);
        // The code to create the object would be placed here.
        //}                    // UNCOMMENT LINE XXX
        if (object == null)
            return null;
        if (object.getPurgeStrategy().isExpired())
        {
            cacheHashMap.remove(identifier);
            return null;
        }
        else
        {
            return object;
        }
    }
}
