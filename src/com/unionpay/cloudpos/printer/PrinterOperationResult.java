/*
 * PrinterOperationResult.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos.printer;

import com.unionpay.cloudpos.OperationResult;

/**
 * 打印机的操作结果对象，暂时未使用。
 * @date August 06, 2015
 */
public interface PrinterOperationResult extends OperationResult {
	
	/**
     * Printer out of paper
     */
    int ERR_PAPER_OUT = ERR_DEVICE_BASE-1;

    /**
     * 打印机出现故障错误
     */
    int ERR_PRINTER = ERR_DEVICE_BASE-1;


}
