package org.jcache.cache;

interface Cacheable {

	public boolean isExpired();
	
	public Object getIdentifier();
}
