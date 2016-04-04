package com.hr.sqltest;

import java.util.ArrayList;
import java.util.List;


import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * @author by hr
 *
 */
public class SqlCrud {
	
	private static String INSERT_INFO_ONE = "insert into info(time,money,moneytype,costtype,content) values(?,?,?,?,?)"; 
	private static String DELETE_INFO_ONE_BY_ID = "delete from info where id = ?"; 
	private static String UPDATE_INFO = "update info set time = ?,money=?,moneytype=?,costtype=?,content=?"; 
	private static String QUERY_INFO_ALL_ASC = "select * from info order by time asc"; 
	private static String QUERY_INFO_ALL_DESC = "select * from info order by time asc"; 
	private static String QUERY_INFO_ONE_BY_ID = "select * from info where id =?"; 
	
	private static SqlLite dbHelper;
	private  SQLiteDatabase db;
	
	public SqlCrud() {

	}
	
	//create db and table
	public SqlCrud(Context context) {
		dbHelper = new SqlLite(context, "Jizhangben.db", null, 1);
		db = dbHelper.getWritableDatabase();
	}
	
	//insert one data
	public void insertInfoOne(Msg bindArgs) {
		db = dbHelper.getWritableDatabase();
		String[] insertData = new String[]{bindArgs.getTime(),bindArgs.getMoney(),bindArgs.getMoneytype(),bindArgs.getCosttype(),bindArgs.getContent()};
		db.execSQL(INSERT_INFO_ONE, insertData);
	}
	
	//delete one data
	public void deleteInfoOne(Object[] bindArgs) {
		db = dbHelper.getWritableDatabase();
		db.execSQL(DELETE_INFO_ONE_BY_ID, bindArgs);
	}
	
	//update one data
	public void updateInfo(Object[] bindArgs) {
		db = dbHelper.getWritableDatabase();
		db.execSQL(UPDATE_INFO, bindArgs);
	}
	
	//query one data
	public String[] queryOne(String[] selectionArgs) {
		String[] OneData = null;
		db = dbHelper.getWritableDatabase();
		Cursor  cursor = db.rawQuery(QUERY_INFO_ONE_BY_ID, selectionArgs);
		if (cursor.moveToFirst()) {
				String idNum = cursor.getString(cursor.getColumnIndex("id"));
				String time = cursor.getString(cursor.getColumnIndex("time"));
				String money = cursor.getString(cursor.getColumnIndex("money"));
				String  timetype = cursor.getString(cursor.getColumnIndex("moneytype"));
				String costtype = cursor.getString(cursor.getColumnIndex("costtype"));
				String content = cursor.getString(cursor.getColumnIndex("content"));
				OneData = new String[]{idNum,time,money,timetype,costtype,content};
		}
		cursor.close();	
		db.close();

		return OneData;
	}

	//query all data by asc
	public List<Msg> queryAllAsc() {
		db = dbHelper.getWritableDatabase();
		Cursor  cursor = db.rawQuery(QUERY_INFO_ALL_ASC, null);
		List<Msg> msglist = new ArrayList<Msg>();
		if (cursor.moveToFirst()) {
			do {
				String idNum = cursor.getString(cursor.getColumnIndex("id"));
				String time = cursor.getString(cursor.getColumnIndex("time"));
				String money = cursor.getString(cursor.getColumnIndex("money"));
				String  timetype = cursor.getString(cursor.getColumnIndex("moneytype"));
				String costtype = cursor.getString(cursor.getColumnIndex("costtype"));
				String content = cursor.getString(cursor.getColumnIndex("content"));
				Msg msg = new Msg(idNum, time, money, timetype,costtype,content);
				msglist.add(msg);
			} while (cursor.moveToNext());
		}
		cursor.close();	
		db.close();
	
		return msglist;
	}

	//query all data by desc
	public List<Msg> queryAllDesc() {
		db = dbHelper.getWritableDatabase();
		Cursor  cursor = db.rawQuery(QUERY_INFO_ALL_DESC, null);
		List<Msg> msglist = new ArrayList<Msg>();
		if (cursor.moveToFirst()) {
			do {
				String idNum = cursor.getString(cursor.getColumnIndex("id"));
				String time = cursor.getString(cursor.getColumnIndex("time"));
				String money = cursor.getString(cursor.getColumnIndex("money"));
				String  timetype = cursor.getString(cursor.getColumnIndex("moneytype"));
				String costtype = cursor.getString(cursor.getColumnIndex("costtype"));
				String content = cursor.getString(cursor.getColumnIndex("content"));
				Msg msg = new Msg(idNum, time, money, timetype,costtype,content);
				msglist.add(msg);				
			} while (cursor.moveToNext());
		}
		cursor.close();	
		db.close();

		return msglist;
	}


}
