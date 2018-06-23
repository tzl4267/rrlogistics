package com.tsinghuait.logistics;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class Redis_config {                               
	@Bean
	public JedisPoolConfig jedisPoolConfig(){
		return new JedisPoolConfig();
	}
	
	@Bean
	public JedisPool jedisPool(){
		return new JedisPool(jedisPoolConfig(), "192.168.25.142");
	}

}
