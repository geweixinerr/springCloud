package com.zj.port.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HeartbeatController {

	/**
	 * 心跳检测
	 * 
	 * @author gewx
	 * @return 心跳视图
	 **/
	@GetMapping
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("/index");
		return view;
	}
}
