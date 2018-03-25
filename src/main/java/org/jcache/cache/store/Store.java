package org.jcache.cache.store;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Store {
    // hash map contains all objects in the cache.
    private java.util.HashMap cacheHashMap = new java.util.HashMap();
    // queue contains keys based on the priority
    private java.util.PriorityQueue queue = new PriorityQueue();

    public Store(Comparator comparator){
        this.queue = new PriorityQueue(comparator);
    }

    public void insert(Object key, Object value){
        cacheHashMap.put(key, value);
        queue.offer(key);
    }

    public Object get(Object key){
        return cacheHashMap.get(key);
    }

    public void remove(Object key){
        cacheHashMap.remove(key);
        queue.remove(key);
    }
}
