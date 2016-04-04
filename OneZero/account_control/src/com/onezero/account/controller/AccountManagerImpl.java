package com.onezero.account.controller;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import com.hr.sqltest.Msg;
import com.hr.sqltest.SqlCrud;

public class AccountManagerImpl implements AccountManager{

	/**
	 * 添加账本信息
	 * 
	 * @param account 帐本信息
	 * @return true 添加成功  false:添加失败
	 * 
	 *TODO： 需要确认添加失败是否抛出异常，给用户友好提示
	 */
	public boolean addAcount(Account account,SqlCrud db){
		//SqlCrud sqlCrud = db; 
		Msg msg = new Msg();
		msg.setTime(account.getAccountDate().toString());
		msg.setCosttype(account.getAccountType());
		msg.setMoney(account.getAccountSum());
		msg.setMoneytype(account.getMoneyType());
		msg.setContent(account.getContent());
		//sqlCrud.insertInfoOne(msg);、
		db.insertInfoOne(msg);
		// TODO: 数据库这里没有返回任何参数，也没有抛出异常？ 不存在添加失败？
		return true;
	}
	
	/**
	 * 查询全部账本信息，返回信息按时间降序排序
	 * 
	 * @return 全部账本信息
	 */
	public List<Account> queryAcount(SqlCrud db){
		List<Account> accountList = new ArrayList<Account>();
		
		//SqlCrud sqlCrud = new SqlCrud();
		List<Msg> msgList = db.queryAllDesc();
		for(Msg msg : msgList){
			Account account = new Account();
			account.setAccountId(msg.getIdNum());
			account.setAccountDate(new Date(msg.getTime()));
			account.setAccountType(msg.getCosttype());
			account.setAccountSum(msg.getMoney());
			account.setMoneyType(msg.getMoneytype());
			account.setContent(msg.getContent());
			
			accountList.add(account);
		}
		
		return accountList;
	}
}
