package org.jcache.cache;

import java.util.Date;


public class CachedObject implements Cacheable{

	Object object;
	Object identifier;
	
	public CachedObject(Object object, Object identifier){
        this.object = object;
        this.identifier = identifier;
        this.createdOn = new Date();
        this.updatedOn = new Date();
        this.count =0;
        
    }

	public Object getIdentifier() {
		return identifier;
	}

    public Object getObject() {
        return object;
    }
    
    private String purgeStrategyType;
    private Date createdOn;
    private Date updatedOn;
    private int count;
    private String data;

	public String getPurgeStrategyType() {
		return purgeStrategyType;
	}

	public void setPurgeStrategyType(String purgeStrategyType) {
		this.purgeStrategyType = purgeStrategyType;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	
    
    
}
