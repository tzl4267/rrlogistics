package com.tsinghuait.logistics.cache;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import com.tsinghuait.logistics.service.impl.UserServiceImpl;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

public class EhRedis implements org.apache.ibatis.cache.Cache{

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    private String id;

    
    @Autowired
    private Ehcache ehCache;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private long liveTime = 1*60*60; //默认1h=1*60*60
     
    private final static int count= 10;

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    
    
    public void setId(String id) {
		this.id = id;
	}

	@Override
    public Object getObject(Object key) {
         Element value = ehCache.get(key);
         LOG.info("Cache L1 (cache) :{}={}",key,value);
        
         if (value!=null&&count<=10) {
             if(value.getHitCount() < count){
                 return (value != null ? new SimpleValueWrapper(value.getObjectValue()) : null);
             }else{
                 value.resetAccessStatistics();
             }

         } 
         //TODO 这样会不会更好？访问10次cache 强制访问一次redis 使得数据不失效
         
         final String keyStr = key.toString();  
         Object objectValue = redisTemplate.execute(new RedisCallback<Object>() {  
            public Object doInRedis(RedisConnection connection)  
                    throws DataAccessException {  
                byte[] key = keyStr.getBytes();  
                byte[] value = connection.get(key);  
                if (value == null) {  
                    return null;  
                }  
                //每次获得，重置缓存过期时间
                if (liveTime > 0) {  
                    connection.expire(key, liveTime);  
                }  
                return toObject(value);  
            }  
        },true);  
         ehCache.put(new Element(key, objectValue));//取出来之后缓存到本地
         LOG.info("Cache L2 (redis) :{}={}",key,objectValue);
         return  (objectValue != null ? new SimpleValueWrapper(objectValue) : null);

    }

    @Override
    public void putObject(Object key, Object value) {
    	ehCache.put(new Element(key, value));
        final String keyStr =  key.toString(); 
        final Object valueStr = value;  
        redisTemplate.execute(new RedisCallback<Long>() {  
            public Long doInRedis(RedisConnection connection)  
                    throws DataAccessException {  
                byte[] keyb = keyStr.getBytes();  
                byte[] valueb = toByteArray(valueStr);  
                connection.set(keyb, valueb);  
                if (liveTime > 0) {  
                    connection.expire(keyb, liveTime);  
                }  
                return 1L;  
            }  
        },true);  

    }

    @Override
    public Object removeObject(Object key) {
    
    	ehCache.remove(key);
        final String keyStr =  key.toString();  
        redisTemplate.execute(new RedisCallback<Long>() {  
            public Long doInRedis(RedisConnection connection)  
                    throws DataAccessException {  
                return connection.del(keyStr.getBytes());  
            }  
        },true); 
        return "";
    }

    @Override
    public void clear(){
    	System.out.println("ehCacheFactory"+(ehCache==null));
    	ehCache.removeAll();
        redisTemplate.execute(new RedisCallback<String>() {  
            public String doInRedis(RedisConnection connection)  
                    throws DataAccessException {  
                connection.flushDb();  
                return "clear done.";  
            }  
        },true);
    }

    


    public long getLiveTime() {
        return liveTime;
    }

    public void setLiveTime(long liveTime) {
        this.liveTime = liveTime;
    }

   
    /** 
     * 描述 : Object转byte[]. <br> 
     * @param obj 
     * @return 
     */  
    private byte[] toByteArray(Object obj) {  
        byte[] bytes = null;  
        ByteArrayOutputStream bos = new ByteArrayOutputStream();  
        try {  
            ObjectOutputStream oos = new ObjectOutputStream(bos);  
            oos.writeObject(obj);  
            oos.flush();  
            bytes = bos.toByteArray();  
            oos.close();  
            bos.close();  
        } catch (IOException ex) {  
            ex.printStackTrace();  
        }  
        return bytes;  
    }  

    /** 
     * 描述 :  byte[]转Object . <br> 
     * @param bytes 
     * @return 
     */  
    private Object toObject(byte[] bytes) {  
        Object obj = null;  
        try {  
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);  
            ObjectInputStream ois = new ObjectInputStream(bis);  
            obj = ois.readObject();  
            ois.close();  
            bis.close();  
        } catch (IOException ex) {  
            ex.printStackTrace();  
        } catch (ClassNotFoundException ex) {  
            ex.printStackTrace();  
        }  
        return obj;  
    }
    
   
  

   

   

   

    @Override
    public int getSize()
    {
        int result = 0;
       /* JedisConnection connection = null;
        try
        {
            connection = jedisConnectionFactory.getConnection();
            result = Integer.valueOf(connection.dbSize().toString());
        }
        catch (JedisConnectionException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (connection != null) {
                connection.close();
            }
        }*/
        return result;
    }
	@Override
	public String getId() {
		
		return this.id;
	}
	
	public EhRedis(final String id) {
		   if (id == null) {
		    throw new IllegalArgumentException("Cache instances require an ID");
		  }
		   this.id = id;
		  }
	@Override
	public ReadWriteLock getReadWriteLock() {
		
		return this.readWriteLock;
	}

	public EhRedis() {
		super();
		// TODO Auto-generated constructor stub
	}

	

  


	

	
	

	
}
