package com.bootdo.waimao.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 发票单据
 * 
 * @author luiz
 * @email 1992lcg@163.com
 * @date 2018-09-27 15:28:58
 */
public class WmInvoiceOrderDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键ID
	private Integer id;
	//发票号码
	private String invoiceNum;
	//发票日期
	private String invoiceDate;
	//制单日期
	private String createDate;
	//备单号码
	private String reserveInvoiceNum;
	//业务员
	private String salerNo;
	//出口合同号
	private String exportContractNo;
	//客户订单号
	private String custOrderNo;
	//信用证号
	private String creditCardNo;
	//开证日期
	private Date openDate;
	//信用证装期
	private Date loadDate;
	//信用证效期
	private Date validDate;
	//装船港
	private String loadPort;
	//允许转船 1:允许 0:不允许
	private Integer isTransfer;
	//允许分装 1:允许 0:不允许
	private Integer isSplit;
	//转船港
	private String trasferPort;
	//卸货港
	private String unloadPort;
	//目的港
	private String destPort;
	//最终交货地
	private String destPlace;
	//贸易国
	private String tradeCountry;
	//消费国
	private String consumContry;
	//结汇方式
	private String settleType;
	//运输方式
	private String transportType;
	//运费付款方式
	private String payType;
	//成交条件
	private String dealCond;
	//船名
	private String shipName;
	//航次
	private String voyageNum;
	//提单号码
	private String billNo;
	//提单日期
	private Date billDate;
	//议付日期
	private Date billPayDate;
	//单证状态
	private String billStatus;
	//是否存档
	private String isSave;
	//提单正本
	private String billOrigin;
	//创建时间
	private Date createTime;
	//创建人
	private String createName;
	//修改时间
	private Date modiTime;
	//修改人
	private String modiName;

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
	 * 设置：发票号码
	 */
	public void setInvoiceNum(String invoiceNum) {
		this.invoiceNum = invoiceNum;
	}
	/**
	 * 获取：发票号码
	 */
	public String getInvoiceNum() {
		return invoiceNum;
	}
	/**
	 * 设置：发票日期
	 */
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	/**
	 * 获取：发票日期
	 */
	public String getInvoiceDate() {
		return invoiceDate;
	}
	/**
	 * 设置：制单日期
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：制单日期
	 */
	public String getCreateDate() {
		return createDate;
	}
	/**
	 * 设置：备单号码
	 */
	public void setReserveInvoiceNum(String reserveInvoiceNum) {
		this.reserveInvoiceNum = reserveInvoiceNum;
	}
	/**
	 * 获取：备单号码
	 */
	public String getReserveInvoiceNum() {
		return reserveInvoiceNum;
	}
	/**
	 * 设置：业务员
	 */
	public void setSalerNo(String salerNo) {
		this.salerNo = salerNo;
	}
	/**
	 * 获取：业务员
	 */
	public String getSalerNo() {
		return salerNo;
	}
	/**
	 * 设置：出口合同号
	 */
	public void setExportContractNo(String exportContractNo) {
		this.exportContractNo = exportContractNo;
	}
	/**
	 * 获取：出口合同号
	 */
	public String getExportContractNo() {
		return exportContractNo;
	}
	/**
	 * 设置：客户订单号
	 */
	public void setCustOrderNo(String custOrderNo) {
		this.custOrderNo = custOrderNo;
	}
	/**
	 * 获取：客户订单号
	 */
	public String getCustOrderNo() {
		return custOrderNo;
	}
	/**
	 * 设置：信用证号
	 */
	public void setCreditCardNo(String creditCardNo) {
		this.creditCardNo = creditCardNo;
	}
	/**
	 * 获取：信用证号
	 */
	public String getCreditCardNo() {
		return creditCardNo;
	}
	/**
	 * 设置：开证日期
	 */
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	/**
	 * 获取：开证日期
	 */
	public Date getOpenDate() {
		return openDate;
	}
	/**
	 * 设置：信用证装期
	 */
	public void setLoadDate(Date loadDate) {
		this.loadDate = loadDate;
	}
	/**
	 * 获取：信用证装期
	 */
	public Date getLoadDate() {
		return loadDate;
	}
	/**
	 * 设置：信用证效期
	 */
	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}
	/**
	 * 获取：信用证效期
	 */
	public Date getValidDate() {
		return validDate;
	}
	/**
	 * 设置：装船港
	 */
	public void setLoadPort(String loadPort) {
		this.loadPort = loadPort;
	}
	/**
	 * 获取：装船港
	 */
	public String getLoadPort() {
		return loadPort;
	}
	/**
	 * 设置：允许转船 1:允许 0:不允许
	 */
	public void setIsTransfer(Integer isTransfer) {
		this.isTransfer = isTransfer;
	}
	/**
	 * 获取：允许转船 1:允许 0:不允许
	 */
	public Integer getIsTransfer() {
		return isTransfer;
	}
	/**
	 * 设置：允许分装 1:允许 0:不允许
	 */
	public void setIsSplit(Integer isSplit) {
		this.isSplit = isSplit;
	}
	/**
	 * 获取：允许分装 1:允许 0:不允许
	 */
	public Integer getIsSplit() {
		return isSplit;
	}
	/**
	 * 设置：转船港
	 */
	public void setTrasferPort(String trasferPort) {
		this.trasferPort = trasferPort;
	}
	/**
	 * 获取：转船港
	 */
	public String getTrasferPort() {
		return trasferPort;
	}
	/**
	 * 设置：卸货港
	 */
	public void setUnloadPort(String unloadPort) {
		this.unloadPort = unloadPort;
	}
	/**
	 * 获取：卸货港
	 */
	public String getUnloadPort() {
		return unloadPort;
	}
	/**
	 * 设置：目的港
	 */
	public void setDestPort(String destPort) {
		this.destPort = destPort;
	}
	/**
	 * 获取：目的港
	 */
	public String getDestPort() {
		return destPort;
	}
	/**
	 * 设置：最终交货地
	 */
	public void setDestPlace(String destPlace) {
		this.destPlace = destPlace;
	}
	/**
	 * 获取：最终交货地
	 */
	public String getDestPlace() {
		return destPlace;
	}
	/**
	 * 设置：贸易国
	 */
	public void setTradeCountry(String tradeCountry) {
		this.tradeCountry = tradeCountry;
	}
	/**
	 * 获取：贸易国
	 */
	public String getTradeCountry() {
		return tradeCountry;
	}
	/**
	 * 设置：消费国
	 */
	public void setConsumContry(String consumContry) {
		this.consumContry = consumContry;
	}
	/**
	 * 获取：消费国
	 */
	public String getConsumContry() {
		return consumContry;
	}
	/**
	 * 设置：结汇方式
	 */
	public void setSettleType(String settleType) {
		this.settleType = settleType;
	}
	/**
	 * 获取：结汇方式
	 */
	public String getSettleType() {
		return settleType;
	}
	/**
	 * 设置：运输方式
	 */
	public void setTransportType(String transportType) {
		this.transportType = transportType;
	}
	/**
	 * 获取：运输方式
	 */
	public String getTransportType() {
		return transportType;
	}
	/**
	 * 设置：运费付款方式
	 */
	public void setPayType(String payType) {
		this.payType = payType;
	}
	/**
	 * 获取：运费付款方式
	 */
	public String getPayType() {
		return payType;
	}
	/**
	 * 设置：成交条件
	 */
	public void setDealCond(String dealCond) {
		this.dealCond = dealCond;
	}
	/**
	 * 获取：成交条件
	 */
	public String getDealCond() {
		return dealCond;
	}
	/**
	 * 设置：船名
	 */
	public void setShipName(String shipName) {
		this.shipName = shipName;
	}
	/**
	 * 获取：船名
	 */
	public String getShipName() {
		return shipName;
	}
	/**
	 * 设置：航次
	 */
	public void setVoyageNum(String voyageNum) {
		this.voyageNum = voyageNum;
	}
	/**
	 * 获取：航次
	 */
	public String getVoyageNum() {
		return voyageNum;
	}
	/**
	 * 设置：提单号码
	 */
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	/**
	 * 获取：提单号码
	 */
	public String getBillNo() {
		return billNo;
	}
	/**
	 * 设置：提单日期
	 */
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	/**
	 * 获取：提单日期
	 */
	public Date getBillDate() {
		return billDate;
	}
	/**
	 * 设置：议付日期
	 */
	public void setBillPayDate(Date billPayDate) {
		this.billPayDate = billPayDate;
	}
	/**
	 * 获取：议付日期
	 */
	public Date getBillPayDate() {
		return billPayDate;
	}
	/**
	 * 设置：单证状态
	 */
	public void setBillStatus(String billStatus) {
		this.billStatus = billStatus;
	}
	/**
	 * 获取：单证状态
	 */
	public String getBillStatus() {
		return billStatus;
	}
	/**
	 * 设置：是否存档
	 */
	public void setIsSave(String isSave) {
		this.isSave = isSave;
	}
	/**
	 * 获取：是否存档
	 */
	public String getIsSave() {
		return isSave;
	}
	/**
	 * 设置：提单正本
	 */
	public void setBillOrigin(String billOrigin) {
		this.billOrigin = billOrigin;
	}
	/**
	 * 获取：提单正本
	 */
	public String getBillOrigin() {
		return billOrigin;
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
	 * 设置：创建人
	 */
	public void setCreateName(String createName) {
		this.createName = createName;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreateName() {
		return createName;
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
	/**
	 * 设置：修改人
	 */
	public void setModiName(String modiName) {
		this.modiName = modiName;
	}
	/**
	 * 获取：修改人
	 */
	public String getModiName() {
		return modiName;
	}
}
