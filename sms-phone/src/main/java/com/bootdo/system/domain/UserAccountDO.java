package com.bootdo.system.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-08-01 18:37:50
 */
public class UserAccountDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Long id;
	//用户编号
	private Long userId;
	//账户余额
	private BigDecimal acctAmt;
	//账户类型
	private String acctType;
	//账户1金额
	private BigDecimal acctAmt1;
	//账户2金额
	private BigDecimal acctAmt2;
	//账户3金额
	private BigDecimal acctAmt3;
	//账户4金额
	private BigDecimal acctAmt4;
	//最后一次修改时间
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
	/**
	 * 设置：用户编号
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户编号
	 */
	public long getUserId() {
		return userId;
	}
	/**
	 * 设置：账户余额
	 */
	public void setAcctAmt(BigDecimal acctAmt) {
		this.acctAmt = acctAmt;
	}
	/**
	 * 获取：账户余额
	 */
	public BigDecimal getAcctAmt() {
		return acctAmt;
	}
	/**
	 * 设置：账户类型
	 */
	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}
	/**
	 * 获取：账户类型
	 */
	public String getAcctType() {
		return acctType;
	}
	/**
	 * 设置：账户1金额
	 */
	public void setAcctAmt1(BigDecimal acctAmt1) {
		this.acctAmt1 = acctAmt1;
	}
	/**
	 * 获取：账户1金额
	 */
	public BigDecimal getAcctAmt1() {
		return acctAmt1;
	}
	/**
	 * 设置：账户2金额
	 */
	public void setAcctAmt2(BigDecimal acctAmt2) {
		this.acctAmt2 = acctAmt2;
	}
	/**
	 * 获取：账户2金额
	 */
	public BigDecimal getAcctAmt2() {
		return acctAmt2;
	}
	/**
	 * 设置：账户3金额
	 */
	public void setAcctAmt3(BigDecimal acctAmt3) {
		this.acctAmt3 = acctAmt3;
	}
	/**
	 * 获取：账户3金额
	 */
	public BigDecimal getAcctAmt3() {
		return acctAmt3;
	}
	/**
	 * 设置：账户4金额
	 */
	public void setAcctAmt4(BigDecimal acctAmt4) {
		this.acctAmt4 = acctAmt4;
	}
	/**
	 * 获取：账户4金额
	 */
	public BigDecimal getAcctAmt4() {
		return acctAmt4;
	}
	/**
	 * 设置：最后一次修改时间
	 */
	public void setModiTime(Date modiTime) {
		this.modiTime = modiTime;
	}
	/**
	 * 获取：最后一次修改时间
	 */
	public Date getModiTime() {
		return modiTime;
	}
}
