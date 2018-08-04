package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 短信轰炸
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-07-30 19:34:12
 */
public class SmsDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Long id;
	private String orderNo;
	//手机号码
	private String phoneNum;
	//0:停止 1:运行中
	private Integer execStatus;
	private String execStatusName;
	//运行类型
	private String execType;
	private Integer successNum;
	private Long userId;
	private Date createTime;
	private Date modiTime;

	/**
	 * 设置：主键ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：主键ID
	 */
	public Long getId() {
		return id;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	/**
	 * 设置：手机号码
	 */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	/**
	 * 获取：手机号码
	 */
	public String getPhoneNum() {
		return phoneNum;
	}
	/**
	 * 设置：0:停止 1:运行中
	 */
	public void setExecStatus(Integer execStatus) {
		this.execStatus = execStatus;
	}
	/**
	 * 获取：0:停止 1:运行中
	 */
	public Integer getExecStatus() {
		return execStatus;
	}
	/**
	 * 设置：运行类型
	 */
	public void setExecType(String execType) {
		this.execType = execType;
	}
	/**
	 * 获取：运行类型
	 */
	public String getExecType() {
		return execType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModiTime() {
		return modiTime;
	}

	public void setModiTime(Date modiTime) {
		this.modiTime = modiTime;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getSuccessNum() {
		return successNum;
	}

	public void setSuccessNum(Integer successNum) {
		this.successNum = successNum;
	}

	public String getExecStatusName() {
		return execStatusName;
	}

	public void setExecStatusName(String execStatusName) {
		this.execStatusName = execStatusName;
	}
}
