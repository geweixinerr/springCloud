package com.zj.port;

import lombok.Getter;

@Getter
public enum CaffeineCacheEnum {

	HUODAI("HUODAI","货代");
	
	CaffeineCacheEnum(String code, String comment) {
		this.code = code;
		this.comment = comment;
	}
	
	private String code;
	
	private String comment;
}
