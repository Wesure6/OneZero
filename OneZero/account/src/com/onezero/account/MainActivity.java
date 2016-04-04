package com.onezero.account;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.hr.sqltest.SqlCrud;
import com.onezero.account.controller.Account;
import com.onezero.account.controller.AccountManager;
import com.onezero.account.controller.AccountManagerImpl;

public class MainActivity extends Activity {

	SqlCrud db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//        Intent intent = new Intent(MainActivity.this, MainActivity.class);  
//        startActivity(intent);  
		db = new SqlCrud(this);
		// 主页显示事件信息
		AccountManager accountManager = new AccountManagerImpl();
		List<Account> accountList = accountManager.queryAcount(db);
		List<String> accountStrList = AccountUtil.account2String(accountList);

		ListView listView = (ListView) findViewById(R.id.listView1);
		listView.setAdapter(new ArrayAdapter<String>(this,
			android.R.layout.simple_expandable_list_item_1, accountStrList));
		listView.deferNotifyDataSetChanged();  

		
		ImageButton imageButton1 = (ImageButton) findViewById(R.id.imageButton1);
		ImageButton imageButton2 = (ImageButton) findViewById(R.id.imageButton2);

		imageButton1.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				// 跳转到add界面
				
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, add.class);
				startActivity(intent);
				finish();
//				setContentView(R.layout.add_main);

			}
		});

		imageButton2.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {

				Log.e("$$$$$$$$$$$$", "WWWWWWWWW");
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		// int id = item.getItemId();

		return super.onOptionsItemSelected(item);
	}
}
