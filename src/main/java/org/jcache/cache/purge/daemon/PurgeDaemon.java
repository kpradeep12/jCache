package org.jcache.cache.purge.daemon;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.jcache.cache.Cacheable;
import org.jcache.cache.CachedObject;
import org.jcache.cache.purge.PurgeStrategy;
import org.jcache.cache.store.Store;

/* Create background thread, which will be responsible for
purging expired items. */
/* This object acts as a semaphore, which protects the HashMap */
public class PurgeDaemon extends Thread{
    /*  The default time the thread should sleep between scans.
                            The sleep method takes in a millisecond value so 5000 = 5
          Seconds.
                        */
    static int milliSecondSleepTime = 5000;
    private Map<String, Store> cacheHashMap;
    private PurgeStrategy purgeStrategy;

    public PurgeDaemon(Map cacheHashMap){
        this.cacheHashMap = cacheHashMap;
        //this.purgeStrategy = purgeStrategy;
    }

    public void run()
    {
        try
        {
                  /* Sets up an infinite loop.  The thread will continue
looping forever. */
           // while (true)
            //{
                System.out.println("ThreadCleanerUpper Scanning For Expired Objects...");
                    /* Get the set of all keys that are in cache.  These are
the unique identifiers */
                java.util.Set keySet = cacheHashMap.keySet();
                /* An iterator is used to move through the Keyset */
                java.util.Iterator keys = keySet.iterator();
                    /* Sets up a loop that will iterate through each key in
the KeySet */
                while(keys.hasNext())
                {
                      /* Get the individual key.  We need to hold on to this
key in case it needs to be removed */
                    Object key = keys.next();
                      /* Get the cacheable object associated with the key
inside the cache */
                    //CachedObject value = (CachedObject) cacheHashMap.get(key);
                    /* Is the cacheable object expired? */
                    /*if (this.purgeStrategy.isExpired(value))
                    {
                        cacheHashMap.remove(key);
                        System.out.println("ThreadCleanerUpper Running. Found an Expired Object in the Cache.");
                    }*/
                    Store store =(Store)cacheHashMap.get(key);
                    Map<String, CachedObject> sm = store.getStoreMap();
                    Set keySet1 = sm.keySet();
                    Iterator keys1 = keySet1.iterator();
                    while(keys1.hasNext()) {
                    	String sk =(String) keys1.next();
                    	CachedObject co = sm.get(sk);
                    	store.getStrategy().isExpired(co);
                    	System.out.println("LOOPING STORE");
                    }
                }
                /*
                 ************************************************************************
                 ******* A LRU (least-recently used) or LFU (least-frequently used) *****
                 *******              would best be inserted here
                 *****
                 ************************************************************************
                 */
                    /* Puts the thread to sleep.  Don't need to check it
continuously */
              //  Thread.sleep(this.milliSecondSleepTime);
                
          //  }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return;
    }
}
