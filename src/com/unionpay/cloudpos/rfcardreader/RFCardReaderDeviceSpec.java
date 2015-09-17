/*
 * RFCardReaderDeviceSpec.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos.rfcardreader;

import com.unionpay.cloudpos.DeviceSpec;
/**
 * <b>RFCardReaderDeviceSpec</b>定义了对非接卡读卡器的详细描述。
 * <p>可以得到终端中关于非接触式IC卡阅读器定义的信息。
 * @date August 07, 2015
 */
public interface RFCardReaderDeviceSpec extends DeviceSpec {
	
	/**
	 *  是否支持等待卡片移除.	
	 *  @return {@code true} 支持，{@code false} 不支持.
	 * */
	boolean isRemovable();
	
	/**
	 *  返回非接卡模式。
	 *  模式定义见{@link RFCardReaderDevice RFCardReaderDevice}常量部分定义。
	 *  @return 返回模式，不支持返回null。
	 * */
	int [] getSupportedModes();
	
}
