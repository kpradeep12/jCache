# jCache
Simple and configurable cache manager built on Java.

This library depends on three main entry points, they are:


**CacheManager**: Single instance of this class should be instantiated per VM instance.  
**PurgeStrategy**: This interface have two implementations; Least frequently used and Least recently used. CacheManager depends on this interface.  
**CachedObject**: This class is the real object which is cached and CacheManager manages this instance.


Sample code below shows example to use jCache  
//Create Cached wrapper object.   
CachedObject co1 = new CachedObject(1, 1);  
//Create CacheManager by passing purge strategy (LFU is Least frequently used)  
CacheManager cm = CacheManager.getInstance(PurgeStrategyType.LFU);  
//Store and retrieve  
cm.putCache(co1);  
System.out.println(cm.getCache(1));
