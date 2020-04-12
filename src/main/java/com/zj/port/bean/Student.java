package com.zj.port.bean;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 学生VO
 * 
 * @author gewx
 * **/
@Getter
@Setter
@ToString
public class Student implements Serializable {

	private static final long serialVersionUID = -8996927554629529829L;

	private Long id;
	
	@NotBlank(message = "用户名缺失")
	private String userName;
	
	@NotNull(message = "年龄必填")
	private Integer age;
}
