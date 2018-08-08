package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 请求路径配置
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-07-31 18:38:42
 */
public class ConfigDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Long id;
	//1.第一步
	private String step1Url;
	private String step1Type;
	private String step1Param;
	private String step1ContainKey;
	private String step1HtmlCode;


	//请求地址
	private String urlStr;
	//请求参数
	private String paramValue;
	//请求类型 POSTJSON GET POST
	private String postType;
	//是否生效 1：生效
	private String isValid;

	/**
	 * 设置：主键ID
	 */
	public void setId(Long id) {
		this.id = id;
	}

	public String getStep1Url() {
		return step1Url;
	}

	public void setStep1Url(String step1Url) {
		this.step1Url = step1Url;
	}

	public String getStep1Type() {
		return step1Type;
	}

	public void setStep1Type(String step1Type) {
		this.step1Type = step1Type;
	}

	public String getStep1Param() {
		return step1Param;
	}

	public void setStep1Param(String step1Param) {
		this.step1Param = step1Param;
	}

	public String getStep1ContainKey() {
		return step1ContainKey;
	}

	public void setStep1ContainKey(String step1ContainKey) {
		this.step1ContainKey = step1ContainKey;
	}

	public String getStep1HtmlCode() {
		return step1HtmlCode;
	}

	public void setStep1HtmlCode(String step1HtmlCode) {
		this.step1HtmlCode = step1HtmlCode;
	}

	/**
	 * 获取：主键ID
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：请求地址
	 */
	public void setUrlStr(String urlStr) {
		this.urlStr = urlStr;
	}
	/**
	 * 获取：请求地址
	 */
	public String getUrlStr() {
		return urlStr;
	}
	/**
	 * 设置：请求参数
	 */
	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}
	/**
	 * 获取：请求参数
	 */
	public String getParamValue() {
		return paramValue;
	}
	/**
	 * 设置：请求类型 POSTJSON GET POST
	 */
	public void setPostType(String postType) {
		this.postType = postType;
	}
	/**
	 * 获取：请求类型 POSTJSON GET POST
	 */
	public String getPostType() {
		return postType;
	}
	/**
	 * 设置：是否生效 1：生效
	 */
	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}
	/**
	 * 获取：是否生效 1：生效
	 */
	public String getIsValid() {
		return isValid;
	}
}
