package com.onezero.account.controller;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import com.hr.sqltest.Msg;
import com.hr.sqltest.SqlCrud;

public class AccountManagerImpl implements AccountManager{

	/**
	 * ����˱���Ϣ
	 * 
	 * @param account �ʱ���Ϣ
	 * @return true ��ӳɹ�  false:���ʧ��
	 * 
	 *TODO�� ��Ҫȷ�����ʧ���Ƿ��׳��쳣�����û��Ѻ���ʾ
	 */
	public boolean addAcount(Account account,SqlCrud db){
		//SqlCrud sqlCrud = db; 
		Msg msg = new Msg();
		msg.setTime(account.getAccountDate().toString());
		msg.setCosttype(account.getAccountType());
		msg.setMoney(account.getAccountSum());
		msg.setMoneytype(account.getMoneyType());
		msg.setContent(account.getContent());
		//sqlCrud.insertInfoOne(msg);��
		db.insertInfoOne(msg);
		// TODO: ���ݿ�����û�з����κβ�����Ҳû���׳��쳣�� ���������ʧ�ܣ�
		return true;
	}
	
	/**
	 * ��ѯȫ���˱���Ϣ��������Ϣ��ʱ�併������
	 * 
	 * @return ȫ���˱���Ϣ
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
