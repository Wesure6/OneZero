package com.onezero.account.controller;

import java.util.Date;
import java.lang.String;

public class Account {

	private String accountId;
	
	// ��Ŀ��Ϣ����ʱ��
	private Date accountDate;
	
	// ��Ŀ��Ϣ��������
	private String accountType;
	
	// ���ѽ��
	private String accountSum;
	
	// TODO:
	private String moneyType;
	
	// ��ע
	private String content;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public Date getAccountDate() {
		return accountDate;
	}

	public void setAccountDate(Date accountDate) {
		this.accountDate = accountDate;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountSum() {
		return accountSum;
	}

	public void setAccountSum(String accountSum) {
		this.accountSum = accountSum;
	}

	public String getMoneyType() {
		return moneyType;
	}

	public void setMoneyType(String moneyType) {
		this.moneyType = moneyType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
