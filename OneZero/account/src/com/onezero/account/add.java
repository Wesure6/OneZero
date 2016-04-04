package com.onezero.account;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hr.sqltest.SqlCrud;
import com.onezero.account.controller.Account;
import com.onezero.account.controller.AccountManager;
import com.onezero.account.controller.AccountManagerImpl;

public class add extends Activity {
	SqlCrud db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_main);
		
		db = new SqlCrud(this);
		// ��ʾ��ǰʱ��
		SimpleDateFormat formatter = new SimpleDateFormat(
				"yyyy��MM��dd��    HH:mm:ss");
		Date curDate = new Date(System.currentTimeMillis());// ��ȡ��ǰʱ��
		String str = formatter.format(curDate);

		TextView mTime = (TextView) findViewById(R.id.mytime);
		mTime.setText(str);
		
		
		 

		// ʵ���¼�����ѡ�񣬵�����ı���ʾ��
		final TextView accounttype = (TextView) findViewById(R.id.accounttype);
		// һ��
		Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Button button1 = (Button) findViewById(R.id.button1);
				accounttype.setText(button1.getText());

			}
		});
		// ����
		Button button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Button button2 = (Button) findViewById(R.id.button2);
				accounttype.setText(button2.getText());

			}
		});

		// ����
		Button button3 = (Button) findViewById(R.id.button3);
		button3.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Button button3 = (Button) findViewById(R.id.button3);
				accounttype.setText(button3.getText());

			}
		});
		// ��ͨ
		Button button4 = (Button) findViewById(R.id.button4);
		button4.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Button button4 = (Button) findViewById(R.id.button4);
				accounttype.setText(button4.getText());

			}
		});
		// ����
		Button button5 = (Button) findViewById(R.id.button5);
		button5.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Button button5 = (Button) findViewById(R.id.button5);
				accounttype.setText(button5.getText());

			}
		});

		// ҽ��
		Button button6 = (Button) findViewById(R.id.button6);
		button6.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Button button6 = (Button) findViewById(R.id.button6);
				accounttype.setText(button6.getText());

			}
		});

		Button button7 = (Button) findViewById(R.id.button7);
		button7.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				OK();

			}
		});

	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.

		// ��ȡ��¼�롱�ķ��ؼ�����ִ�з��ء�
		int id = item.getItemId();
		if (id == R.id.action_add_back) {

			onBackPressed();
		}

		return super.onOptionsItemSelected(item);
	}

	// OK��ť
	public void OK() {

		TextView mytime = (TextView) findViewById(R.id.mytime);
		String text1 = mytime.getText().toString();

		TextView accounttype = (TextView) findViewById(R.id.accounttype);
		String text2 = accounttype.getText().toString();

		EditText editText1 = (EditText) findViewById(R.id.editText1);
		String text3 = editText1.getText().toString();

		EditText editText2 = (EditText) findViewById(R.id.editText2);
		String text4 = editText2.getText().toString();

		if (text3.equals("")) {

			Log.e("$%^", "toast");
			Toast toast = Toast
					.makeText(add.this, "�������", Toast.LENGTH_SHORT);
			toast.show();
		}

		else if (text3.equals(".") || text3.substring(0, 1).equals("0")) {

			Toast toast = Toast.makeText(add.this, "�����������������롣",
					Toast.LENGTH_SHORT);
			toast.show();

		}

		else {

			AccountManager accountManager =new AccountManagerImpl();

			Account account = new Account();
			//account.setAccountId(1);

			try {
				account.setAccountDate(new SimpleDateFormat(
						"yyyy��MM��dd��    HH:mm:ss").parse(text1));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			account.setAccountType(text2);
			account.setAccountSum(text3);
			account.setContent(text4);
			
			
			boolean addResult = accountManager.addAcount(account,db);//�޸ļ̳�
			
			if (addResult) {
				// goto to main
				
			
				Intent intent = new Intent();
				intent.setClass(add.this, MainActivity.class);
				startActivity(intent);
				finish();
			} else {
				// ��ʾ
				
			}
			

			
		}
		
	

		
	}
	
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		 
        if (keyCode == KeyEvent.KEYCODE_BACK
                 && event.getRepeatCount() == 0) {
            //do something...
        	Intent intent = new Intent();
			intent.setClass(add.this, MainActivity.class);
			startActivity(intent);
			finish();
             return true;
         }
         return super.onKeyDown(keyCode, event);
     }

}
