package com.compass.examination.pojo.bo;

import java.io.Serializable;

/**
 * 
 * <p>Class Name: ResultBO</p>
 * <p>Description: 返回值对象类</p>
 * <p>Company: www.compass.com</p> 
 * @author wkm
 * @date 2017年8月15日下午4:27:28
 * @version 2.0
 */
public class ResultBO implements Serializable {

	private static final long serialVersionUID = 1532450662730900369L;

	private String code; // 返回状态码
	private String msg; // 返回描述
	private Object obj; // 返回对象

	public ResultBO() {
		super();
	}
	
	/**
	 * 
	 * <p>Constructor Name: ResultBO</p>
	 * <p>Description: </p>
	 * @author wkm
	 * @date 2017年8月15日下午4:28:09
	 * @version 2.0
	 * @param code
	 * @param msg
	 * @param obj
	 */
	public ResultBO(String code, String msg, Object obj) {
		super();
		this.code = code;
		this.msg = msg;
		this.obj = obj;
	}


	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}

	@Override
	public String toString() {
		return "ResultBO [code=" + code + ", msg=" + msg + ", obj=" + obj + "]";
	}
}
