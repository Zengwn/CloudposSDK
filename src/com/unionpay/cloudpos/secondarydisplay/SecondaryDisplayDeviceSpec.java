/*
 * SecondaryDisplayDeviceSpec.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos.secondarydisplay;

import com.unionpay.cloudpos.DeviceSpec;
/**
 * <b>SecondaryDisplayDeviceSpec</b>定义了对客显设备的详细描述。
 * <p>可以得到终端中关于客显定义的信息。
 * @date August 10, 2015
 */
public interface SecondaryDisplayDeviceSpec extends DeviceSpec {
	
	/**
	 *  返回客显屏幕的宽度。	 
     * @return 宽度，不支持返回0.
	 * */
	int getWidth();
	
	/**
	 *  返回客显屏幕的高度。	 
     * @return 高度，不支持返回0.
	 * */
	int getHeight();
	
	
}
