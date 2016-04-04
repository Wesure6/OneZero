package com.onezero.account.controller;

import java.util.List; 

import com.hr.sqltest.SqlCrud;

public interface AccountManager {

	/**
	 * 添加账本信息
	 * 
	 * @param account 帐本信息
	 * @return true 添加成功  false:添加失败
	 * 
	 *TODO： 需要确认添加失败是否抛出异常，给用户友好提示
	 */
	boolean addAcount(Account account, SqlCrud db);//修改接口函数
	
	/**
	 * 查询全部账本信息，返回信息按时间降序排序
	 * 
	 * @return 全部账本信息
	 */
	List<Account> queryAcount(SqlCrud db);
}
