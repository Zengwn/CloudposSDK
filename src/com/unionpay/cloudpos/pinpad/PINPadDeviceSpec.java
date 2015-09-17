/*
 * PINPadDeviceSpec.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos.pinpad;

import com.unionpay.cloudpos.DeviceSpec;
/**
 * <b>PINPadDeviceSpec</b>定义了对PIN输入设备的详细描述。
 * <p>可以得到终端中关于PINPad的定义的信息。
 * @date August 10, 2015
 */
public interface PINPadDeviceSpec extends DeviceSpec {
	
	/**
	 *  可支持的最大PIN输入设备数量。
	 *  <p>
	 *  @return 返回支持的数量，不支持返回0
	 * */
	int getCounts();
	
	/**
	 *  是否是内置PIN输入设备。
	 *  <p>如果是内置，那么系统提供密码输入界面。
     * @param logicalID 设备逻辑ID，默认1
     * @return {@code true} 内置PIN输入设备， {@code false} 外置PIN输入设备，参数错误及不支持也返回false.
	 * */
	boolean isInternal(int logicalID);
	
	/**
	 *  是否支持获取随机数。
	 *  <p>
     *  @param logicalID 设备逻辑ID，默认1
	 *  @return {@code true} 支持取随机数， {@code false} 不支持取随机数，参数错误也返回false.
	 * */    
	boolean canGetRandom(int logicalID);
	
	/**
	 *  是否支持显示文本。
	 *  <p>
     *  @param logicalID 设备逻辑ID，默认1
	 *  @return {@code true} 支持， {@code false} 不支持，参数错误也返回false.
	 * */
	boolean canShowText(int logicalID);
}
