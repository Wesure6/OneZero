package com.onezero.account.controller;

import java.util.List; 

import com.hr.sqltest.SqlCrud;

public interface AccountManager {

	/**
	 * ����˱���Ϣ
	 * 
	 * @param account �ʱ���Ϣ
	 * @return true ��ӳɹ�  false:���ʧ��
	 * 
	 *TODO�� ��Ҫȷ�����ʧ���Ƿ��׳��쳣�����û��Ѻ���ʾ
	 */
	boolean addAcount(Account account, SqlCrud db);//�޸Ľӿں���
	
	/**
	 * ��ѯȫ���˱���Ϣ��������Ϣ��ʱ�併������
	 * 
	 * @return ȫ���˱���Ϣ
	 */
	List<Account> queryAcount(SqlCrud db);
}
