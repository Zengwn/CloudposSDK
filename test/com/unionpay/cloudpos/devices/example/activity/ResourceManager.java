package com.unionpay.cloudpos.devices.example.activity;



import android.app.Activity;
import android.widget.Button;

import com.unionpay.cloudpos.R;


/**对已有的activity中的控件进行总调度,方便资源的整体利用。
 * @author john.li
 */
public class ResourceManager {
	

	public static Button getCallBackBtnFrom(Activity host){
		Button btn1 = (Button)host.findViewById(R.id.btn1);//widget38
		return btn1;
	}
	
	public static Button getCallBackBtn2From(Activity host){
		Button btn2 = (Button)host.findViewById(R.id.btn2);//widget38
		return btn2;
	}
//	public static Button getPosInfoBtnFromMainActivity(Activity host){
//		Button btn3 = (Button)host.findViewById(R.id.btn3);//widget38
//		return btn3;
//	}
	
	
}