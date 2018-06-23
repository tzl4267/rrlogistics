package com.tsinghuait.logistics;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import redis.clients.jedis.JedisPoolConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration.JedisClientConfigurationBuilder;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/*@Configuration
@EnableCaching//开启注解
*/
@Configuration
@PropertySource("classpath:redis.properties")
public class RedisConfig {

		@Value("${spring.redis.database}")  
	    private int database;  
	 	@Value("${spring.redis.host}")  
	    private String host;  
	    @Value("${spring.redis.port}")  
	    private int port;  
	    @Value("${spring.redis.password}")  
	    private String password;  
	    @Value("${spring.redis.pool.max-active}")  
	    private int maxActive;  
	    @Value("${spring.redis.pool.max-idle}")  
	    private int maxIdle;  
	    @Value("${spring.redis.pool.min-idle}")  
	    private int minIdle;  
	    @Value("${spring.redis.pool.max-wait}")  
	    private int maxWait;  
	    @Value("${spring.redis.timeout}")  
	    private long timeout; 
	
		@Bean
		public JedisPoolConfig jedisPoolConfig(){
			JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
			jedisPoolConfig.setMaxTotal(maxActive);
			jedisPoolConfig.setMaxIdle(maxIdle);
			jedisPoolConfig.setMinIdle(minIdle);
			jedisPoolConfig.setMaxWaitMillis(maxWait);
			return jedisPoolConfig;
		}
	
		@Bean(name="jedisConnection")
		public JedisConnectionFactory jedisConnection(){
			RedisStandaloneConfiguration standaloneConfig = new RedisStandaloneConfiguration(host,port);
			JedisClientConfigurationBuilder builder = JedisClientConfiguration.builder();
			builder.connectTimeout(Duration.ofSeconds(timeout));
			JedisClientConfiguration build = builder.build();
			JedisConnectionFactory jedisConnection = new JedisConnectionFactory(standaloneConfig,build);
			return jedisConnection;
		}
		
		
		
		
	    @Bean(name="redisTemplate")
	    public RedisTemplate<String, Object> redisTemplate(JedisConnectionFactory jedisConnection) {
	        RedisTemplate<String, Object> template = new RedisTemplate<>();
	        template.setConnectionFactory(jedisConnection);

	        //使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值（默认使用JDK的序列化方式）
	        Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer(Object.class);

	        ObjectMapper mapper = new ObjectMapper();
	        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
	        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
	        serializer.setObjectMapper(mapper);

	        template.setValueSerializer(serializer);
	        //使用StringRedisSerializer来序列化和反序列化redis的key值
	        template.setKeySerializer(new StringRedisSerializer());
	        template.afterPropertiesSet();
	        return template;
	    }
	    @Bean
	    public StringRedisTemplate stringRedisTemplate(JedisConnectionFactory jedisConnection) {
	        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
	        stringRedisTemplate.setConnectionFactory(jedisConnection);
	        return stringRedisTemplate;
	    }

	    
	    /*@Bean
	    public KeyGenerator keyGenerator() {
	        return new KeyGenerator() {
	            @Override
	            public Object generate(Object target, Method method, Object... params) {
	                StringBuilder sb = new StringBuilder();
	                sb.append(target.getClass().getName());
	                sb.append(method.getName());
	                for (Object obj : params) {
	                    sb.append(obj.toString());
	                }
	                return sb.toString();
	            }
	        };
	    }*/
	    
}
