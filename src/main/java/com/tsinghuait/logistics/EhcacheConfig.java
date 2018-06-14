package com.tsinghuait.logistics;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@EnableCaching
public class EhcacheConfig {

	
	 	@Bean  
	    public EhCacheManagerFactoryBean cacheManagerFactoryBean(){  
	        EhCacheManagerFactoryBean bean = new EhCacheManagerFactoryBean();  
	        bean.setConfigLocation(new ClassPathResource("ehcache.xml"));  
	        bean.setShared(true);  
	        return bean;  
	    }  
	    @Bean  
	    public EhCacheCacheManager ehCache(EhCacheManagerFactoryBean bean){  
	      return new EhCacheCacheManager(bean.getObject());  
	    }  
}
