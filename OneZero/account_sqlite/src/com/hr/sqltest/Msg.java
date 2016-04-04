package com.hr.sqltest;

/**
 * @author by hr
 *
 */
public class Msg {
	private String idNum;
	private String time;
	private String money;
	private String moneytype;
	private String costtype;
	private String content;
	public Msg() {
		
	}
	public Msg(String idNum,String time, String money, String moneytype,String costtype,String content) {
		this.idNum = idNum;
		this.time = time;
		this.money = money;
		this.moneytype = moneytype;
		this.costtype = costtype;
		this.content = content;
		
	}
	public String getIdNum() {
		return idNum;
	}
	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getMoneytype() {
		return moneytype;
	}
	public void setMoneytype(String moneytype) {
		this.moneytype = moneytype;
	}
	public String getCosttype() {
		return costtype;
	}
	public void setCosttype(String costtype) {
		this.costtype = costtype;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}
