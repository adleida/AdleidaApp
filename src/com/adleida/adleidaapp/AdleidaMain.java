package com.adleida.adleidaapp;

import net.youmi.android.AdManager;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class AdleidaMain extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//无标题
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.adleida_main_layout);
		Button btn1 = (Button)findViewById(R.id.button_1);
		//初始化有米广告，id，密钥		
		AdManager.getInstance(this).init("28fa7285c76df78e", "aa74fc36b19cf2a4", true);
		btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Toast.makeText(AdleidaMain.this, R.string.goto_ad_page, Toast.LENGTH_SHORT);
				//btn设置点击跳转到AdPageActivity
				Intent intent  = new Intent(AdleidaMain.this,AdPageActivity.class);
				startActivity(intent);
			}
		});
	}
}
