/*
 * SerialPortOperationResult.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos.serialport;

import com.unionpay.cloudpos.OperationResult;

/**
 * <code>SerialPortOperationResult</code>是被串口设备产生，用来返回串口的操作结果
 * <p>
 * {@link OperationResult#getResultCode() getResultCode()}方法继承至{@link OperationResult OperationResult}的对应方法。
 * <p>
 * 可以在{@link OperationResult#getResultCode() getResultCode()}返回操作结果是成功还是失败，
 * 通过{@link #getData()}返回通过串口读到的数据，通过{@link #getDataLength()}返回通过串口读到的数据长度。
 * @date August 10, 2015
 */
public interface SerialPortOperationResult extends OperationResult {
    /**
     * 返回读到的数据
     * 
     * @return 数据buffer
     */
    byte[] getData();
    /**
     * 返回数据长度
     * @return 长度
     */
    int getDataLength();
}
