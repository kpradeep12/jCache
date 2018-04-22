package org.jcache.cache;

import java.util.Date;


public interface Cacheable {
	
	public Object getIdentifier();
	public Object getObject();
	String getPurgeStrategyType();
	Date getCreatedOn();
	Date getUpdatedOn();
	int getCount();
	String getData();
}
