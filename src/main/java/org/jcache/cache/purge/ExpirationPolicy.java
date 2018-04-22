package org.jcache.cache.purge;

public class ExpirationPolicy {
	PurgeStrategyType strategyType;
	int expirationTimeInHours;
	public PurgeStrategyType getStrategyType() {
		return strategyType;
	}
	public void setStrategyType(PurgeStrategyType strategyType) {
		this.strategyType = strategyType;
	}
	public int getExpirationTimeInHours() {
		return expirationTimeInHours;
	}
	public void setExpirationTimeInHours(int expirationTimeInHours) {
		this.expirationTimeInHours = expirationTimeInHours;
	}
	
	
}
