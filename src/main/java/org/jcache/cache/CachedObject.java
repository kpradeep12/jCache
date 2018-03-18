package org.jcache.cache;

import org.jcache.cache.purge.PurgeStrategy;

public class CachedObject implements Cacheable{

	Object object;
	Object identifier;
	public CachedObject(Object object, Object identifier){
        this.object = object;
        this.identifier = identifier;
    }

	public Object getIdentifier() {
		return identifier;
	}

    public Object getObject() {
        return object;
    }
}
