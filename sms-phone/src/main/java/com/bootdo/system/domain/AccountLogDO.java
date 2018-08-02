package com.bootdo.system.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 账户交易记录
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-08-01 18:37:43
 */
public class AccountLogDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Long id;
	//账户id
	private Long acctId;
	//用户Id
	private Long userId;
	private String userName;
	private String userQq;
	//操作类型
	private String operType;
	private String operTypeName;
	//资金方向 + 增加 - 减小
	private String amtDirect;
	//操作金额
	private BigDecimal operAmt;
	//操作前账户余额
	private BigDecimal acctAmtB;
	//操作后账户余额
	private BigDecimal acctAmtA;
	//操作状态 0:初始化 1:处理中 2:处理成功 3:处理失败
	private Integer operStatus;
	private String operStatusName;
	//操作内容
	private String operMsg;
	//操作时间
	private Date createTime;

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
	/**
	 * 设置：账户id
	 */
	public void setAcctId(Long acctId) {
		this.acctId = acctId;
	}
	/**
	 * 获取：账户id
	 */
	public Long getAcctId() {
		return acctId;
	}
	/**
	 * 设置：用户Id
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户Id
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：操作类型
	 */
	public void setOperType(String operType) {
		this.operType = operType;
	}
	/**
	 * 获取：操作类型
	 */
	public String getOperType() {
		return operType;
	}
	/**
	 * 设置：资金方向 + 增加 - 减小
	 */
	public void setAmtDirect(String amtDirect) {
		this.amtDirect = amtDirect;
	}
	/**
	 * 获取：资金方向 + 增加 - 减小
	 */
	public String getAmtDirect() {
		return amtDirect;
	}
	/**
	 * 设置：操作金额
	 */
	public void setOperAmt(BigDecimal operAmt) {
		this.operAmt = operAmt;
	}
	/**
	 * 获取：操作金额
	 */
	public BigDecimal getOperAmt() {
		return operAmt;
	}
	/**
	 * 设置：操作前账户余额
	 */
	public void setAcctAmtB(BigDecimal acctAmtB) {
		this.acctAmtB = acctAmtB;
	}
	/**
	 * 获取：操作前账户余额
	 */
	public BigDecimal getAcctAmtB() {
		return acctAmtB;
	}
	/**
	 * 设置：操作后账户余额
	 */
	public void setAcctAmtA(BigDecimal acctAmtA) {
		this.acctAmtA = acctAmtA;
	}
	/**
	 * 获取：操作后账户余额
	 */
	public BigDecimal getAcctAmtA() {
		return acctAmtA;
	}
	/**
	 * 设置：操作状态 0:初始化 1:处理中 2:处理成功 3:处理失败
	 */
	public void setOperStatus(Integer operStatus) {
		this.operStatus = operStatus;
	}
	/**
	 * 获取：操作状态 0:初始化 1:处理中 2:处理成功 3:处理失败
	 */
	public Integer getOperStatus() {
		return operStatus;
	}
	/**
	 * 设置：操作内容
	 */
	public void setOperMsg(String operMsg) {
		this.operMsg = operMsg;
	}
	/**
	 * 获取：操作内容
	 */
	public String getOperMsg() {
		return operMsg;
	}
	/**
	 * 设置：操作时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：操作时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserQq() {
		return userQq;
	}

	public void setUserQq(String userQq) {
		this.userQq = userQq;
	}

	public String getOperStatusName() {
		return operStatusName;
	}

	public void setOperStatusName(String operStatusName) {
		this.operStatusName = operStatusName;
	}

	public String getOperTypeName() {
		return operTypeName;
	}

	public void setOperTypeName(String operTypeName) {
		this.operTypeName = operTypeName;
	}
}
