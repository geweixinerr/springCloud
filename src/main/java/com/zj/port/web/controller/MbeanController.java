package com.zj.port.web.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zj.port.bean.Student;
import com.zj.port.commons.log.MicroLogger;
import com.zj.port.web.Response;

@RestController
@RequestMapping("/api")
public class MbeanController {

	/**
	 * 日志
	 **/
	private static final MicroLogger LOGGER = new MicroLogger(MbeanController.class);

	@PostMapping("/save")
	public Map<String, Object> save(@RequestBody @Valid Student data, BindingResult result) {
		final String methodName = "save";
		LOGGER.enter(methodName, "新增, data: " + data);
		if (result.hasErrors()) {
			String msg = result.getFieldError().getDefaultMessage();
			LOGGER.warn("校验异常: " + msg);
			return Response.FAIL.newBuilder().out(msg).toResult();
		}
		return Response.SUCCESS.newBuilder().toResult();
	}
}
