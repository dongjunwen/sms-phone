package com.bootdo.system.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 产品定价表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-08-02 09:55:43
 */
public class ProductDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Long id;
	//最小天数
	private Long minTime;
	//最大天数
	private Long maxTime;
	//价格
	private BigDecimal price;
	//生效时间
	private Date beginDate;
	//失效时间
	private Date endDate;
	//1:有效 0:无效
	private Integer status;
	//创建时间
	private Date createTime;
	//修改时间
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
	 * 设置：最小天数
	 */
	public void setMinTime(Long minTime) {
		this.minTime = minTime;
	}
	/**
	 * 获取：最小天数
	 */
	public Long getMinTime() {
		return minTime;
	}
	/**
	 * 设置：最大天数
	 */
	public void setMaxTime(Long maxTime) {
		this.maxTime = maxTime;
	}
	/**
	 * 获取：最大天数
	 */
	public Long getMaxTime() {
		return maxTime;
	}
	/**
	 * 设置：价格
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * 获取：价格
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * 设置：生效时间
	 */
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	/**
	 * 获取：生效时间
	 */
	public Date getBeginDate() {
		return beginDate;
	}
	/**
	 * 设置：失效时间
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * 获取：失效时间
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * 设置：1:有效 0:无效
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：1:有效 0:无效
	 */
	public Integer getStatus() {
		return status;
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
	 * 设置：修改时间
	 */
	public void setModiTime(Date modiTime) {
		this.modiTime = modiTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getModiTime() {
		return modiTime;
	}
}
