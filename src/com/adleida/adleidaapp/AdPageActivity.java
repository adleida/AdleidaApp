package com.adleida.adleidaapp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;

import android.R.integer;
import android.R.layout;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AdPageActivity extends Activity {
	
	private TextView tv1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ad_page);
		DisplayMetrics dm=new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int height = dm.heightPixels;
		int width = dm.widthPixels;
		tv1=(TextView) findViewById(R.id.textView);
		tv1.setText(getAllapp().toString()+"\n"+"height:"+height+"\n"+"width"+width+"\n"+"model:"+android.os.Build.MODEL+"\n"+"version:"+android.os.Build.VERSION.RELEASE);
		WebView webView = new WebView(this);
		//AdView.java
		AdView adView = new AdView(this);
//		AdView adView = new AdView(this, AdSize.FIT_SCREEN);
		LinearLayout adLayout = (LinearLayout)findViewById(R.id.adLayout);
//		RelativeLayout.LayoutParams lParams = new RelativeLayout.LayoutParams(400,400);
//		adLayout.addView(webView);
		adLayout.addView(adView);
		adView.Show();
	}	
	
	private String getAllapp() {
		List<PackageInfo> installed = this.getPackageManager()
				.getInstalledPackages(0);
		HashMap<String, String> resaultMap = new HashMap<String, String>();
		HashSet<String> appSet = new HashSet<String>();
		for (PackageInfo pi : installed)
		{
			if ((pi.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 1)
			{
				appSet.add(pi.packageName);
				Log.i("appname",pi.packageName);
			}
		}
		return appSet.toString();
 }
}
