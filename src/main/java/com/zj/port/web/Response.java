package com.zj.port.web;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

/**
 * 网关响应设计
 * 
 * @author gewx
 **/
public enum Response {

	// 响应成功
	SUCCESS(true, "SUCCESS"),

	// 响应失败
	FAIL(false, "FAIL");

	/**
	 * 网关响应码枚举
	 **/
	@Getter
	public static enum GateWayCode {

		/**
		 * 网关默认响应,成功
		 **/
		S0000("0000", "SUCCESS"),

		/**
		 * 未登录
		 **/
		E0001("0001", "未登录"),

		/**
		 * 登录超时
		 **/
		E0002("0002", "登录超时"),

		/**
		 * 远程鉴权失败
		 **/
		E0003("0003", "非法请求"),

		/**
		 * 权限不足
		 **/
		E0101("0101", "权限不足"),

		/**
		 * 账号不存在
		 **/
		E0102("0102", "账号不存在"),

		/**
		 * 通用数据校验失败
		 **/
		E0200("0200", "通用数据校验失败"),

		/**
		 * 缺失必填参数
		 **/
		E0201("0201", "缺失必填参数"),
		
		/**
		 * 数值格式不正确
		 **/
		E0202("0202", "数值格式不正确"),
		
		/**
		 * 系统错误
		 **/
		E9999("9999", "系统错误");

		GateWayCode(String code, String comment) {
			this.code = code;
			this.comment = comment;
		}

		private String code;

		private String comment;
	}

	Response(boolean success, String msg) {
		this.success = success;
		this.msg = msg;
	}

	private final boolean success;

	private final String msg;

	public boolean isSuccess() {
		return success;
	}

	public String getMsg() {
		return msg;
	}

	/**
	 * 响应消息构建方法
	 * 
	 * @author gewx
	 * @return 响应消息对象
	 **/
	public ResponseBuild newBuilder() {
		return new ResponseBuild(this);
	}

	/**
	 * 内部类,消息构建
	 * 
	 * @author gewx
	 **/
	public class ResponseBuild {

		private final boolean success;

		private String code;

		private String msg;

		ResponseBuild(Response response) {
			this.success = response.isSuccess();
			this.msg = response.getMsg();
			this.code = response.isSuccess() ? GateWayCode.S0000.getCode() : GateWayCode.E9999.getCode();
		}

		public ResponseBuild out(String msg) {
			this.msg = msg;
			return this;
		}

		public ResponseBuild addGateWayCode(GateWayCode geteWayCode) {
			this.code = geteWayCode.getCode();
			this.msg = geteWayCode.getComment();
			return this;
		}

		public Map<String, Object> toResult() {
			return buildMap();
		}

		/**
		 * 构建消息体
		 * 
		 * @author gewx
		 * @return 消息体
		 **/
		public <T extends java.io.Serializable> Map<String, Object> toResult(T model) {
			Map<String, Object> map = buildMap();
			map.put("data", model);
			return map;
		}

		/**
		 * 构建消息体
		 * 
		 * @author gewx
		 * @return 消息体
		 **/
		@SuppressWarnings("rawtypes")
		public <T extends java.util.Collection> Map<String, Object> toResult(T model) {
			Map<String, Object> map = buildMap();
			map.put("data", model);
			return map;
		}

		/**
		 * 构建消息体
		 * 
		 * @author gewx
		 * @return 消息体
		 **/
		@SuppressWarnings("rawtypes")
		public <T extends java.util.Map> Map<String, Object> toResult(T model) {
			Map<String, Object> map = buildMap();
			map.put("data", model);
			return map;
		}

		/**
		 * 构建消息体
		 * 
		 * @author gewx
		 * @return 消息体
		 **/
		private Map<String, Object> buildMap() {
			Map<String, Object> map = new HashMap<>(6);
			map.put("success", this.success);
			map.put("msg", this.msg);
			map.put("code", this.code);
			return map;
		}
	}
}
