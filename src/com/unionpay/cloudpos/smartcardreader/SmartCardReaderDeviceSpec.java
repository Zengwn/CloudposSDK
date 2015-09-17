/*
 * SmartCardReaderDeviceSpec.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos.smartcardreader;

import com.unionpay.cloudpos.DeviceSpec;
/**
 * <b>SmartCardReaderDeviceSpec</b>定义了对SmartCard读卡器的详细描述。
 * <p>可以得到终端中关于接触式IC卡阅读器设备定义的信息。
 * @date August 07, 2015
 */
public interface SmartCardReaderDeviceSpec extends DeviceSpec {
	
	/**
	 *  返回有多少个卡槽。
	 *  <p>
	 *  @return 卡槽数量，不支持返回0
	 * */
	int getCounts();
	
	/**
	 *  是否支持中断插入和移除卡片操作。
	 *  <p>
	 *  @param logicalID 打开IC卡读卡器的设备编号，0对应底部的插槽，1、2、3对应终端背面的PSAM卡槽
	 *  @return {@code true} 支持,{@code false} 不支持，参数错误也返回false.
	 * */
	boolean canRemovable(int logicalID);
	
}
