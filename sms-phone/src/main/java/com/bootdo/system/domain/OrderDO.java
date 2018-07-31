package com.bootdo.system.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 卡密相关
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-07-31 10:30:38
 */
public class OrderDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//订单号(卡密)
	private String orderNo;
	//名称
	private String orderName;
	//生效状态 0:未使用 1:已使用
	private String invalidStatus;
	//生效天数
	private Integer invalidDays;
	//创建时间
	private Date createTime;
	//使用时间
	private Date useTime;
	//失效时间
	private Date unvalidTime;
	//使用人
	private Long useUserId;

	/**
	 * 设置：主键ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：主键ID
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：订单号(卡密)
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	/**
	 * 获取：订单号(卡密)
	 */
	public String getOrderNo() {
		return orderNo;
	}
	/**
	 * 设置：名称
	 */
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	/**
	 * 获取：名称
	 */
	public String getOrderName() {
		return orderName;
	}
	/**
	 * 设置：生效状态 0:未使用 1:已使用
	 */
	public void setInvalidStatus(String invalidStatus) {
		this.invalidStatus = invalidStatus;
	}
	/**
	 * 获取：生效状态 0:未使用 1:已使用
	 */
	public String getInvalidStatus() {
		return invalidStatus;
	}
	/**
	 * 设置：生效天数
	 */
	public void setInvalidDays(Integer invalidDays) {
		this.invalidDays = invalidDays;
	}
	/**
	 * 获取：生效天数
	 */
	public Integer getInvalidDays() {
		return invalidDays;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：使用时间
	 */
	public void setUseTime(Date useTime) {
		this.useTime = useTime;
	}
	/**
	 * 获取：使用时间
	 */
	public Date getUseTime() {
		return useTime;
	}
	/**
	 * 设置：失效时间
	 */
	public void setUnvalidTime(Date unvalidTime) {
		this.unvalidTime = unvalidTime;
	}
	/**
	 * 获取：失效时间
	 */
	public Date getUnvalidTime() {
		return unvalidTime;
	}

	public Long getUseUserId() {
		return useUserId;
	}

	public void setUseUserId(Long useUserId) {
		this.useUserId = useUserId;
	}
}