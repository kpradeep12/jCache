package org.jcache.cache.purge.impl;

import java.time.Duration;
import java.util.Date;

import org.jcache.cache.CachedObject;
import org.jcache.cache.purge.PurgeStrategy;

public class TimePeriodExperiedPurgeStrategy implements PurgeStrategy{
	int expirationTimeInHours;
	
	public int getExpirationTimeInHours() {
		return expirationTimeInHours;
	}

	public void setExpirationTimeInHours(int expirationTimeInHours) {
		this.expirationTimeInHours = expirationTimeInHours;
	}
	public boolean isExpired(CachedObject co) {
		Date currentDate = new Date();
		Duration duration = Duration.ofHours(currentDate.getTime() - co.getCreatedOn().getTime());
		if(duration.toHours() > this.expirationTimeInHours)
			return true;
		else 
			return false;
	}

}
