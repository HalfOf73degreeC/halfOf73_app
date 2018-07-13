package com.halfof73.halfof73.model;

import java.io.Serializable;
import java.util.Date;



public class PayBoxIn implements Serializable {
	private 			Integer 	Id;
	private transient	PayBox	 	payBoxNumber;
	private 			String 		MemAccount;
	private				String		MemName;
	private 			Integer 	payAmount;
	private 			String 		payMemBankId;
	private 			String 		payMemAccount;
	private 			Date 		payDate;
	
	public PayBoxIn(PayBox payBoxNumber, String memAccount, String MemName, Integer payAmount) {
		super();
		this.payBoxNumber = payBoxNumber;
		MemAccount = memAccount;
		this.MemName = MemName;
		this.payAmount = payAmount;
		payDate = new Date();
	}
	
	public PayBoxIn(Integer id, PayBox payBoxNumber, String memAccount, Integer payAmount, String payMemBankId,
			String payMemAccount, Date payDate) {
		super();
		Id = id;
		this.payBoxNumber = payBoxNumber;
		MemAccount = memAccount;
		this.payAmount = payAmount;
		this.payMemBankId = payMemBankId;
		this.payMemAccount = payMemAccount;
		this.payDate = payDate;
	}
	public PayBoxIn() {
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
	/**
	 * @return the memAccount
	 */
	public String getMemAccount() {
		return MemAccount;
	}
	/**
	 * @param memAccount the memAccount to set
	 */
	public void setMemAccount(String memAccount) {
		MemAccount = memAccount;
	}
	/**
	 * @return the payAmount
	 */
	public String getMemName() {
		return MemName;
	}

	public void setMemName(String memName) {
		MemName = memName;
	}
	public Integer getPayAmount() {
		return payAmount;
	}
	/**
	 * @param payAmount the payAmount to set
	 */
	public void setPayAmount(Integer payAmount) {
		this.payAmount = payAmount;
	}
	/**
	 * @return the payMemBankId
	 */
	public String getPayMemBankId() {
		return payMemBankId;
	}
	/**
	 * @param payMemBankId the payMemBankId to set
	 */
	public void setPayMemBankId(String payMemBankId) {
		this.payMemBankId = payMemBankId;
	}
	/**
	 * @return the payMemAccount
	 */
	public String getPayMemAccount() {
		return payMemAccount;
	}
	/**
	 * @param payMemAccount the payMemAccount to set
	 */
	public void setPayMemAccount(String payMemAccount) {
		this.payMemAccount = payMemAccount;
	}
	/**
	 * @return the payDate
	 */
	public Date getPayDate() {
		return payDate;
	}
	/**
	 * @param payDate the payDate to set
	 */
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PaymentDetail [payBoxNumber=" + payBoxNumber + ", MemAccount=" + MemAccount + ", payAmount=" + payAmount
				+ "]";
	}
	
	
	
	
	
}
