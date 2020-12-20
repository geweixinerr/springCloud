package com.zj.port.plugin;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "psys-master-service", path = "/psys-master", contextId = "springcloud")
public interface PsysMasterPlugin {

	@GetMapping(value = "/fegin/test")
	Map<String,Object> getResult(String userId);
}
