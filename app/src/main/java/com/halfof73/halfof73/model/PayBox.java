package com.halfof73.halfof73.model;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;




public class PayBox implements Serializable {
	private Integer payBoxNumber;
	private String payBoxName;
	private Integer balance;
	private String payBoxDetail;
	private String payBankId;
	private String payATMAccount;
	private Date insertDate;
	private Integer viewTimes;
	private Integer payBoxType;
	private transient FoundationBean_HO73 foundationBean;
	private Set<PayBoxIn> payBoxIn = new LinkedHashSet<>();
	private Set<PayBoxOut> payBoxOut = new LinkedHashSet<>();
	
	public PayBox() {
		super();
	}

	
	
	public PayBox(Integer payBoxNumber, String payBoxName, FoundationBean_HO73 foundationBean) {
		super();
		this.payBoxNumber = payBoxNumber;
		this.payBoxName = payBoxName;
		this.foundationBean = foundationBean;
	}



	public PayBox(String payBoxName, String payBoxDetail, String payBankId, String payATMAccount, Integer payBoxType,
			FoundationBean_HO73 foundationBean) {
		super();
		this.payBoxName = payBoxName;
		this.payBoxDetail = payBoxDetail;
		this.payBankId = payBankId;
		this.payATMAccount = payATMAccount;
		this.payBoxType = payBoxType;
		this.foundationBean = foundationBean;
		insertDate = new Date();
		viewTimes = 0;
		balance = 0;
	}



	public PayBox(Integer payBoxNumber, String payBoxName, String payBoxDetail, String payBankId,
			String payATMAccount, Date insertDate, Integer viewTimes, Integer payBoxType,
			FoundationBean_HO73 foundationBean) {
		super();
		this.payBoxNumber = payBoxNumber;
		this.payBoxName = payBoxName;
		this.payBoxDetail = payBoxDetail;
		this.payBankId = payBankId;
		this.payATMAccount = payATMAccount;
		this.insertDate = insertDate;
		this.viewTimes = viewTimes;
		this.payBoxType = payBoxType;
		this.foundationBean = foundationBean;
	}



	public Integer getPayBoxNumber() {
		return payBoxNumber;
	}

	public void setPayBoxNumber(Integer payBoxNumber) {
		this.payBoxNumber = payBoxNumber;
	}


	public String getPayBoxName() {
		return payBoxName;
	}

	public void setPayBoxName(String payBoxName) {
		this.payBoxName = payBoxName;
	}


	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}



	public String getPayBoxDetail() {
		return payBoxDetail;
	}

	public void setPayBoxDetail(String payBoxDetail) {
		this.payBoxDetail = payBoxDetail;
	}

	public String getPayBankId() {
		return payBankId;
	}

	public void setPayBankId(String payBankId) {
		this.payBankId = payBankId;
	}

	public String getPayATMAccount() {
		return payATMAccount;
	}

	public void setPayATMAccount(String payATMAccount) {
		this.payATMAccount = payATMAccount;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public Integer getViewTimes() {
		return viewTimes;
	}

	public void setViewTimes(Integer viewTimes) {
		this.viewTimes = viewTimes;
	}

	public Integer getPayBoxType() {
		return payBoxType;
	}

	public void setPayBoxType(Integer payBoxType) {
		this.payBoxType = payBoxType;
	}

	public FoundationBean_HO73 getFoundationBean() {
		return foundationBean;
	}

	public void setFoundationBean(FoundationBean_HO73 foundationBean) {
		this.foundationBean = foundationBean;
	}
	

	public Set<PayBoxIn> getpayBoxIn() {
		return payBoxIn;
	}
	public void setpayBoxIn(Set<PayBoxIn> paymentIn) {
		this.payBoxIn = paymentIn;
	}

	public Set<PayBoxOut> getpayBoxOut() {
		return payBoxOut;
	}
	public void setpayBoxOut(Set<PayBoxOut> paymentOut) {
		this.payBoxOut = paymentOut;
	}
}