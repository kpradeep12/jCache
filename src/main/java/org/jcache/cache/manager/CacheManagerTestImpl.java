package org.jcache.cache.manager;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.jcache.cache.Cacheable;
import org.jcache.cache.CachedObject;
import org.jcache.cache.purge.ExpirationPolicy;
import org.jcache.cache.purge.PurgeStrategyType;
import org.jcache.cache.store.Store;

public class CacheManagerTestImpl {
	/**
	 * @param args
	 */
	public static void main(String args[]) {
		 CachedObject co1 = new CachedObject(1, 1);
	        CacheManager cm = CacheManager.getInstance(PurgeStrategyType.LTU);
	        
	        /*Store store1 = cm.createStore("strings",);
	        store1.put(1,co1);
	        assertNotNull(store1.get(1));
	        Store store2 = cm.createStore("strings2");
	        assertNull(store2.get(1));*/
	        ExpirationPolicy policy = new ExpirationPolicy();
	        policy.setExpirationTimeInHours(1);
	        policy.setStrategyType(PurgeStrategyType.LTU);
	        Store store = cm.createStore("testStore",policy);
	        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
	        AtomicInteger ai = new AtomicInteger(0);
	        AtomicInteger ai2 = new AtomicInteger(0);
	        executor.scheduleWithFixedDelay(new StorePutThread(store, ai.getAndIncrement()), 10,20,TimeUnit.SECONDS);
	        executor.scheduleWithFixedDelay(new StoreGetThread(store, ai2.getAndIncrement()), 10,10,TimeUnit.SECONDS);
	       /* executor.scheduleWithFixedDelay(() -> {
	        	if(ai.get() == 10) ai.set(0);
	        	String key = "key"+ai.getAndIncrement();
	        	CacheImpl ci = new CacheImpl((new java.util.Date()).toString());
	        	Cacheable ca = new CachedObject(ci,key);
	        	System.out.println("PUT CACHEIMPL ::"+key+"::::Value::"+ci.getCacheData());
	        	store.put(key, ca);
	        	
	        	
	        }, 10,20,TimeUnit.SECONDS);
	        
	        executor.scheduleWithFixedDelay(() -> {
	        	if(ai2.get() == 10) ai2.set(0);
	        	String key = "key"+ai2.getAndIncrement();
	        	Cacheable cab =store.get(key);
	        	CacheImpl cimpl = (CacheImpl)cab.getObject(); 
	        	System.out.println("GET CACHEIMPL ::"+key+"::::Value::"+cimpl.getCacheData());
	        }, 10,10,TimeUnit.SECONDS);*/
		 
	}
}
class StorePutThread implements Runnable {
	int i;
	Store store;
	StorePutThread(Store store, int i) {
		this.store = store;
		this.i = i;
	}
	public void run() {
		String key = "key"+i;
    	CacheImpl ci = new CacheImpl((new java.util.Date()).toString());
    	Cacheable ca = new CachedObject(ci,key);
    	System.out.println("PUT CACHEIMPL ::"+key+"::::Value::"+ci.getCacheData());
    	this.store.put(key, ca);
		
	}
}
class StoreGetThread implements Runnable {
	int i;
	Store store;
	StoreGetThread(Store store, int i) {
		this.store = store;
		this.i = i;
	}
	public void run() {
		String key = "key"+i;
    	Cacheable cab =store.get(key);
    	CacheImpl cimpl = (CacheImpl)cab.getObject(); 
    	System.out.println("GET CACHEIMPL ::"+key+"::::Value::"+cimpl.getCacheData());
		
	}
}
class CacheImpl{
	private String cacheData ;
	
	public CacheImpl(String data) {
		this.cacheData = data;
	}
	public String getCacheData() {
		return cacheData;
	}
	public void setCacheData(String cacheData) {
		this.cacheData = cacheData;
	}
}
