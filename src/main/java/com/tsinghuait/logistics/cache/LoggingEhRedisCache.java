package com.tsinghuait.logistics.cache;

import org.apache.ibatis.cache.decorators.LoggingCache;

public class LoggingEhRedisCache extends LoggingCache{

	public LoggingEhRedisCache(String id) {
		super(new EhRedis(id));
		// TODO Auto-generated constructor stub
	}

}
