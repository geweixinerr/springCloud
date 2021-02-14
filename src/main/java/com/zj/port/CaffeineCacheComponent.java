package com.zj.port;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

/**
 * Caffeine Cache 组件
 * 
 * @author gewx
 **/

public class CaffeineCacheComponent {

	/**
	 * 定义本地Cache实例
	 **/
	private final Cache<String, String> cache = Caffeine.newBuilder().initialCapacity(Byte.MAX_VALUE * 10)
			.maximumSize(Short.MAX_VALUE).weakKeys().weakValues().expireAfterWrite(30, TimeUnit.SECONDS).build();

	/**
	 * 获取本地缓存数值
	 * 
	 * @author gewx
	 * @param prefix 缓存前缀
	 * @param key    缓存键
	 * @return 缓存值
	 **/
	public String getValue(CaffeineCacheEnum prefix, String key) {
		Optional<String> optCache = Optional.empty();
		try {
			String cacheKey = new StringBuilder(prefix.getCode() + "_" + key).toString().intern();
			optCache = Optional.ofNullable(cache.get(cacheKey, val -> {
				System.out.println("加载: " + val);
				return "Hello";
			}));
		} catch (Exception ex) {
			// Fix: 缓存查询失败,不做处理
		}
		return optCache.orElse(StringUtils.EMPTY);
	}

	public static void main(String[] args) throws InterruptedException {
		CaffeineCacheComponent component = new CaffeineCacheComponent();
		String val = component.getValue(CaffeineCacheEnum.HUODAI, "123456");
		System.out.println(val);
		val = component.getValue(CaffeineCacheEnum.HUODAI, "123456");
		System.out.println(val);
		
		TimeUnit.SECONDS.sleep(31); 
		val = component.getValue(CaffeineCacheEnum.HUODAI, "123456");
		System.out.println(val);
	}
}
