package com.tsinghuait.logistics;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import com.github.tobato.fastdfs.FdfsClientConfig;

@SpringBootApplication
@Import(FdfsClientConfig.class)//fastdfs 上传
@MapperScan("com.tsinghuait.logistics.mapper")//mapper扫描
@ServletComponentScan//serlvet3.0配置方式必须加此注解监听器过滤器才能生效
@ComponentScan("com.tsinghuait.logistics")
@EnableCaching
@PropertySource("classpath:contansConfig.properties")
public class RrlogisticsApplication{

	public static void main(String[] args) {
		SpringApplication.run(RrlogisticsApplication.class, args);
	}
	
	
}
