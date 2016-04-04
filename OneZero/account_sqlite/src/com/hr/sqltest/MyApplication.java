package com.hr.sqltest;

import android.app.Application;


//get context
public class MyApplication  extends Application {
	    private static MyApplication instance;
	 
	    public static MyApplication getApplication() {
	        return instance;
	    }
	 
	    @Override
	    public void onCreate() {
	        super.onCreate();
	        instance = this;
	    }
	}
