package org.jcache.cache.purge;

import java.util.HashMap;
import org.jcache.cache.Cacheable;
/* Create background thread, which will be responsible for
purging expired items. */
public class PurgeDaemon extends Thread{
    /*  The default time the thread should sleep between scans.
                            The sleep method takes in a millisecond value so 5000 = 5
          Seconds.
                        */
    static int milliSecondSleepTime = 5000;
    private static java.util.HashMap cacheHashMap;

    public PurgeDaemon(HashMap cacheHashMap){
        this.cacheHashMap = cacheHashMap;
    }

    public void run()
    {
        try
        {
                  /* Sets up an infinite loop.  The thread will continue
looping forever. */
            while (true)
            {
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
                    Cacheable value = (Cacheable)cacheHashMap.get(key);
                    /* Is the cacheable object expired? */
                    if (value.getPurgeStrategy().isExpired())
                    {
                        /* Yes it's expired! Remove it from the cache */
                        cacheHashMap.remove(key);
                        System.out.println("ThreadCleanerUpper Running. Found an Expired Object in the Cache.");
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
                Thread.sleep(this.milliSecondSleepTime);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return;
    }
}
