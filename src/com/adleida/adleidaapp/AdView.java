package com.adleida.adleidaapp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.json.JSONObject;

import android.R.string;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Picture;
import android.util.Log;
import android.webkit.WebView;
import android.widget.RelativeLayout;;

public class AdView extends RelativeLayout {
	private PackageManager pm;
	private Context context;
	public AdView(Context context){
		super(context);
		this.context = context;
		//设置布局不可见	
		setVisibility(8);
	}
	public void Show()
	{
		WebView localView;
		try{
			//新建一个webview，名为localview
			localView = new WebView(this.context);
			//webview设置支持加载网页
			localView.setWebViewClient(new MyWebViewClient());
			//webview设置js交互
			localView.getSettings().setJavaScriptEnabled(true);
//			JSONObject data = new JSONObject();
			String requestJSONString = "{    'adunit': {        'type': 1,        'floor': 1.6,        'cid': '1101201',        'param': {            'count': 3        }     },    'device': {        'os': 'ANDROID',        'os_version': '4.4.4',        'resolution_w': 720,        'resolution_h': 1080,        'network_id': 70120,        'device_type': 2,        'device_id': '6C0590AFF652982CEB7B3F7D8214C508',        'device_id_enc': 1,        'delected_language': 'zh_CN',        'brand': 'xiaomi',        'model': 'm2'    },    'geo': {        'country': '�й�',        'city': '����',        'latitude': 102.153585,        'longtitude': 10.5544    },    'user_id': 'bangbang2015001',    'is_test': 1,    'cur': 'CNY',    'sdk': 'bangbang'}";
			String html = "<html>\n<body>\n<script type='text/javascript' language='javascript'>var data = " + requestJSONString + "</script>\n" +
					"<script type='text/javascript' language='javascript' src='http://123.57.70.242/js/ad.js'></script>\n</body>\n</html>";

			//			String html = "<html>\n<body>\n <script type='text/javascript' language='javascript' src='http://123.57.70.242/js/ad.js'></script>\n</body>\n</html>";

			Log.v("html", html);
			//webview加载html
			localView.loadData(html, "text/html", "utf-8");
			
			
			//自定义layoutparams，全屏宽，高300
			RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT,300);
			//在Adview上添加webview，全屏宽，高300，addview默认的属性为this.addview()
			addView(localView, localLayoutParams);
			//设置可见度 0 可见的， 4 不可见~占用原本布局空间 ， 8不可见，不占用布局空间
			setVisibility(0);
			
		}catch(Exception exception){
			
		}
	}
}






















