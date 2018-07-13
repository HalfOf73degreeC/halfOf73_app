package com.halfof73.halfof73.model;

import java.io.Serializable;
import java.util.Date;


public class PayBoxOut implements Serializable {
	private 			Integer 				Id;
	private transient 	PayBox 					payBoxNumber;
	private transient 	FoundationBean_HO73 	foundationBean;
	private 			String 					payForName;
	private 			String 					payForDetail;
	private 			Integer 				payForCost;	
	private 			String 					receipt;
	private 			Date 					insertDate;
	
	public PayBoxOut(PayBox payBoxNumber, String payForName, Integer payForCost) {
		super();
		this.payBoxNumber = payBoxNumber;
		this.payForName = payForName;
		this.payForCost = payForCost;
	}
	
	public PayBoxOut(PayBox payBoxNumber, FoundationBean_HO73 foundationBean, String payForName, String payForDetail, Integer payForCost,
			String receipt) {
		super();
		this.payBoxNumber = payBoxNumber;
		this.foundationBean = foundationBean;
		this.payForName = payForName;
		this.payForDetail = payForDetail;
		this.payForCost = payForCost;
		this.receipt = receipt;
		insertDate = new Date();
	}

	public PayBoxOut(Integer id, PayBox payBoxNumber, FoundationBean_HO73 foundationBean, String payForName, String payForDetail,
			Integer payForCost, String receipt, Date insertDate) {
		super();
		Id = id;
		this.payBoxNumber = payBoxNumber;
		this.foundationBean = foundationBean;
		this.payForName = payForName;
		this.payForDetail = payForDetail;
		this.payForCost = payForCost;
		this.receipt = receipt;
		this.insertDate = insertDate;
	}
	public PayBoxOut() {
		super();
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return Id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		Id = id;
	}
	/**
	 * @return the payBoxNumber
	 */
	public PayBox getPayBoxNumber() {
		return payBoxNumber;
	}
	/**
	 * @param payBoxNumber the payBoxNumber to set
	 */
	public void setPayBoxNumber(PayBox payBoxNumber) {
		this.payBoxNumber = payBoxNumber;
	}
	public FoundationBean_HO73 getFoundationBean() {
		return foundationBean;
	}

	public void setFoundationBean(FoundationBean_HO73 foundationBean) {
		this.foundationBean = foundationBean;
	}
	/**
	 * @return the payForName
	 */
	public String getPayForName() {
		return payForName;
	}
	/**
	 * @param payForName the payForName to set
	 */
	public void setPayForName(String payForName) {
		this.payForName = payForName;
	}
	/**
	 * @return the payForDetail
	 */
	public String getPayForDetail() {
		return payForDetail;
	}
	/**
	 * @param payForDetail the payForDetail to set
	 */
	public void setPayForDetail(String payForDetail) {
		this.payForDetail = payForDetail;
	}
	/**
	 * @return the payForCost
	 */
	public Integer getPayForCost() {
		return payForCost;
	}
	/**
	 * @param payForCost the payForCost to set
	 */
	public void setPayForCost(Integer payForCost) {
		this.payForCost = payForCost;
	}
	/**
	 * @return the receipt
	 */
	public String getReceipt() {
		return receipt;
	}
	/**
	 * @param receipt the receipt to set
	 */
	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}
	/**
	 * @return the insertDate
	 */
	public Date getInsertDate() {
		return insertDate;
	}
	/**
	 * @param insertDate the insertDate to set
	 */
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PaymentCost [payBoxNumber=" + payBoxNumber + ", payForName=" + payForName + ", payForCost=" + payForCost
				+ "]";
	}
	
	
}
