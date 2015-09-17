/*
 * LEDDeviceSpec.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos.led;

import com.unionpay.cloudpos.DeviceSpec;
/**
 * <b>LEDDeviceSpec</b>定义了对LED的详细描述。
 * <p>可以得到终端中关于LED定义的信息。
 * <p>
 * @date August 10, 2015
 */
public interface LEDDeviceSpec extends DeviceSpec {
	
	byte RED = 0x01;
	byte YELLOW =0x02;
	byte GREEN = 0x04;
	byte BLUE = 0x08;
	byte WHITE = 0x10;
	/**
	 *  返回可以操作的LED灯数量。
	 *  <p>
	 * @return 返回LED灯的数量。不支持返回0.
	 * */
	int getCounts();
	
	/**
	*  返回LED设备的颜色。
     * <p>
     * @param logicalID  设备逻辑ID
	 * @return int 颜色，参数错误及不支持返回null.
	 * */
	byte[] getColors(int logicalID); 
	
	/**
	 *  是否支持快速闪烁。
	 *  <p>
	 *  500ms闪烁一次
	 *  @param logicalID  设备逻辑ID
	 *  @return {@code true} 支持， {@code false} 不支持，参数错误也返回false.
	 * */
	boolean canQuickBlink(int logicalID);

	/**
	 *  是否支持慢速闪烁。
	 *  <p>
	 *  1s闪烁一次
	 *  @param logicalID  设备逻辑ID
	 *  @return {@code true} 支持， {@code false} 不支持，参数错误也返回false.
	 * */
	boolean canSlowBlink(int logicalID);
}
