package com.tsinghuait.logistics;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheFactoryBean;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;

@Configuration
@EnableCaching
public class EhcacheConfig {

	
	 	@Bean(name="bean")  
	    public EhCacheManagerFactoryBean cacheManagerFactoryBean(){  
	        EhCacheManagerFactoryBean bean = new EhCacheManagerFactoryBean();
	        ClassPathResource classPathResource = new ClassPathResource("ehcache.xml");
	        System.out.println(classPathResource);
	        bean.setConfigLocation(classPathResource);  
	        bean.setShared(true);  
	        return bean;  
	    }  
	    @Bean(name="ehCache")  
	    public Ehcache getehCache(EhCacheManagerFactoryBean cacheManagerFactory){  
	    	EhCacheFactoryBean ehCacheFactory = new EhCacheFactoryBean();
	    	//EhCacheManagerFactoryBean cacheManagerFactory = cacheManagerFactoryBean();
	    	System.out.println(cacheManagerFactory);
	    	CacheManager cachemanager = cacheManagerFactory.getObject();
	    	System.out.println(cachemanager);
	    	ehCacheFactory.setCacheManager(cachemanager);
	    	ehCacheFactory.setCacheName("eh");
	    	System.out.println(ehCacheFactory);
	    	Ehcache ehcache = ehCacheFactory.getObject();
	    	System.out.println(ehcache);
	      return ehcache;
	    }  
	    @Bean(name="ehCachemanager")
	    public EhCacheCacheManager ehCacheCache(EhCacheManagerFactoryBean bean){
	        return new EhCacheCacheManager (cacheManagerFactoryBean().getObject ());
	    }

}
