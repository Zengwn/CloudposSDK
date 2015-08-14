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
 * <b>PINPadDeviceSpec</b>定义了对密码键盘的详细描述。
 * <p>可以得到终端中关于PINPad的定义的信息。
 * @date August 10, 2015
 */
public interface PINPadDeviceSpec extends DeviceSpec {
	
	/**
	 *  可支持的最大密码键盘数量
	 *  <p>
	 * */
	int getCounts();
	
	/**
	 *  是否是内置密码键盘
	 *  <p>
     * @param logicalID 设备逻辑ID，默认1
     * @return 内置密码键盘／外置密码键盘
	 * */
	boolean isInternal(int logicalID);
	
	/**
	 *  是否支持获取随机数
	 *  <p>
     *  @param logicalID 设备逻辑ID，默认1
	 *  @return 支持取随机数/不支持取随机数
	 * */    
	boolean canGetRandom(int logicalID);
	
	/**
	 *  是否支持显示文本
	 *  <p>
     *  @param logicalID 设备逻辑ID，默认1
	 *  @return 支持/不支持
	 * */
	boolean canShowText(int logicalID);
}
