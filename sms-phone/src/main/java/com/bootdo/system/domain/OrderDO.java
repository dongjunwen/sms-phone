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
	//生效类型
	private String invalidType;
	//创建时间
	private Date createTime;
	//使用时间
	private Date useTime;
	//失效时间
	private Date unvalidTime;
	//使用人
	private Long useUserId;
	private String useUserName;
	private String useUserQq;
	private String useUserWeiXin;
	//拥有人
	private Long ownerUserId;
	private String ownerUserName;
	private String ownerUserQq;
	private String ownerUserWeiXin;


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

	public String getInvalidType() {
		return invalidType;
	}

	public void setInvalidType(String invalidType) {
		this.invalidType = invalidType;
	}

	public Long getOwnerUserId() {
		return ownerUserId;
	}

	public void setOwnerUserId(Long ownerUserId) {
		this.ownerUserId = ownerUserId;
	}

	public String getUseUserName() {
		return useUserName;
	}

	public void setUseUserName(String useUserName) {
		this.useUserName = useUserName;
	}

	public String getUseUserQq() {
		return useUserQq;
	}

	public void setUseUserQq(String useUserQq) {
		this.useUserQq = useUserQq;
	}

	public String getOwnerUserName() {
		return ownerUserName;
	}

	public void setOwnerUserName(String ownerUserName) {
		this.ownerUserName = ownerUserName;
	}

	public String getOwnerUserQq() {
		return ownerUserQq;
	}

	public void setOwnerUserQq(String ownerUserQq) {
		this.ownerUserQq = ownerUserQq;
	}

	public String getOwnerUserWeiXin() {
		return ownerUserWeiXin;
	}

	public void setOwnerUserWeiXin(String ownerUserWeiXin) {
		this.ownerUserWeiXin = ownerUserWeiXin;
	}

	public String getUseUserWeiXin() {
		return useUserWeiXin;
	}

	public void setUseUserWeiXin(String useUserWeiXin) {
		this.useUserWeiXin = useUserWeiXin;
	}
}
