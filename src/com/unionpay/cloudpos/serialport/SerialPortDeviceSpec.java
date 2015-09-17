/*
 * SerialPortDeviceSpec.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos.serialport;

import com.unionpay.cloudpos.DeviceSpec;
/**
 * <b>SerialPortDeviceSpec</b>定义了对串口设备的详细描述。
 * <p>可以得到终端中关于串口设备定义的信息。
 * @date August 10, 2015
 */
public interface SerialPortDeviceSpec extends DeviceSpec {
	
	/**
	 *  返回串口数量。
	 *  @return 终端中串口数量，不支持返回0
	 * */
	int getCounts();

}
