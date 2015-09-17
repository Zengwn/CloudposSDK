/*
 * PrinterDeviceSpec.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos.printer;

import com.unionpay.cloudpos.DeviceSpec;
/**
 * <b>PrinterDeviceSpec</b>定义了对打印机的详细描述。
 * <p>可以得到终端中关于打印机定义的信息。
 * @date August 06, 2015
 */
public interface PrinterDeviceSpec extends DeviceSpec {
	
	/**
	 * 返回当前终端有几个打印机。
	 * @return 终端中打印机个数，不支持返回0.
	 * */
	int getCounts();
	
	/**
	 * 是否支持打印浓度的设定。
	 * @param logicalID  打印机逻辑ID，默认为0
	 * @return {@code true} 支持，{@code false}不支持，参数错误也返回false.
	 * */
	boolean canSetDensity(int logicalID);
	
	/**
	 * 返回标准字体的点数高度。
	 * @param logicalID  打印机逻辑ID，默认为0
	 * @return 打印机的标准字体的高度，参数错误及不支持返回0.
	 * */
	int getBaseFontHeight(int logicalID);
	
	/**
	 * 返回可打印的最大宽度。
	 * @param logicalID  打印机逻辑ID，默认为0
	 * @return 打印机的最大显示宽度	，参数错误及不支持返回0.
	 * */
	int getWidth(int logicalID);
	
	/**
	 * 返回可打印barcode的格式。
	 * @param logicalID  打印机逻辑ID，默认为0
	 * @return 可打印条码的格式，参数错误及不支持返回null.
	 * */
	String [] getBarCodeFormat(int logicalID);
	
	/**
	 *  打印机是否能切纸。
	 *  @param logicalID  打印机逻辑ID，默认为0
	 *  @return {@code true} 支持，{@code false} 不支持，参数错误也返回false.
	 * */
	boolean canCutPaper(int logicalID);
}
