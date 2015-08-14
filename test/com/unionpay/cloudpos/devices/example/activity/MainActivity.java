package com.unionpay.cloudpos.devices.example.activity;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.unionpay.cloudpos.R;


public class MainActivity extends Activity {
	
	static final String APP_TAG = "DevicesTest";
	
	/** 测试流程
	 *  分别会刷卡3次 开始是设定等待5000毫秒, IMMEDIATE， 以及FOREVER
	 *  
	 * */

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button btn1=  ResourceManager.getCallBackBtnFrom(this);
		Button btn2=  ResourceManager.getCallBackBtn2From(this);
		btn2.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
			}
			});
		}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return true;
	}

}
