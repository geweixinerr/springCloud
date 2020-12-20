package com.zj.port.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.zj.port.commons.log.MicroLogger;

/**
 * 系统首页入口,心跳检测页
 * 
 * @author gewx
 **/
@RestController
public class IndexController {

	private final MicroLogger logger = new MicroLogger(IndexController.class);

	@GetMapping("/")
	public ModelAndView index() {
		final String methodName = "index";
		logger.enter(methodName, "服务首页调用");
		ModelAndView view = new ModelAndView("/index");
		logger.exit(methodName, "服务首页调用");
		return view;
	}
}
