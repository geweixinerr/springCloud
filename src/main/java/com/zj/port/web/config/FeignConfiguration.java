package com.zj.port.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;

/**
 * 自定义Bean配置
 * 
 * @author gewx
 **/
@Configuration
public class FeignConfiguration {

	/**
	 * Feign组件日志输出等级
	 * 
	 * @author gewx
	 **/
	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}
}
