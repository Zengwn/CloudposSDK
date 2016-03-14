/*
 * TerminalSpec.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos;
/**
 * 终端详细描述。 
 * @date August 06, 2015
 */
public interface TerminalSpec {
    /**
     * 返回厂商
     * @return 厂商
     */
	String getManufacturer();
	
    /**
     * 返回终端型号
     * @return 手持，pad或台式
     */
    String getModel();
    
    /**
     * 返回终端操作系统版本。
     * @return 版本
     */
    String getOSVersion();
    
    /**
     * 返回API版本。
     * @return API版本
     */
    String getAPILevel();
    /**
     * 返回终端序列号。
     * @return 序列号
     */
    String getSerialNumber();
}
