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
    String getManufacturer();

    String getModel();

    String getOSVersion();

    String getAPILevel();
    
    String getSerialNumber();
}
