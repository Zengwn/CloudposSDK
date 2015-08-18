/*
 * PINPadOperationResult.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos.pinpad;

import com.unionpay.cloudpos.OperationResult;

/**
 * PIN输入设备的操作结果对象
 * <p>{@link OperationResult#getResultCode() getResultCode()}方法继承至{@link OperationResult}的对应方法。
 * <p>通过{@link OperationResult#getResultCode() getResultCode()}返回PIN输入设备的结果状态 ，
 * 通过{@link PINPadOperationResult#getEncryptedPINBlock() getEncryptedPINBlock()}返回加过密的PIN Block。
 * @date August 10, 2015 
 */
public interface PINPadOperationResult extends OperationResult {
    /**
     * 返回加过密的PIN Block。
     * 
     * @return 结果buffer流。
     */
    byte[] getEncryptedPINBlock();
}
