package com.hr.sqltest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author by hr
 *
 */
public class SqlLite extends SQLiteOpenHelper {
	
	public static String CREATE_INFO = "create table info ("
			+ " id integer primary key autoincrement, "
			+ " time text, "
			+ " money real, "
			+ " moneytype text, "
			+ " costtype text, "
			+ " content text) ";
	
	private Context mContext;
	
	public SqlLite(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		mContext = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		db.execSQL(CREATE_INFO);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
		
	}
	

}
