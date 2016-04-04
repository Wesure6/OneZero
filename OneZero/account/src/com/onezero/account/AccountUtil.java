package com.onezero.account;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


import com.onezero.account.controller.Account;

public class AccountUtil {
	// 将<Account>转化为<String>
	public static List<String> account2String(List<Account> accountList) {
		List<String> strList = new ArrayList<String>();
		 DateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");  

		for (Account account : accountList) {
			StringBuilder accountItem = new StringBuilder();

			accountItem.append(format.format(account.getAccountDate()));
			accountItem.append("\n");
			accountItem.append(account.getAccountType());
			accountItem.append("  ");
			accountItem.append(account.getAccountSum());
			accountItem.append("元");
			accountItem.append("  ");
			accountItem.append(account.getContent());

			strList.add(accountItem.toString());
		}

		return strList;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
