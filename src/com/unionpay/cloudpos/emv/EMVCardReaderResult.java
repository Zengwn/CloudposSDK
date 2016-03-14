/*
 * EMVCardReaderResult.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos.emv;

import com.unionpay.cloudpos.OperationResult;

/**
 * <code>EMVCardReaderResult</code>是被设备产生，用来返回检卡操作结果。
 * <p>
 * {@link OperationResult#getResultCode() getResultCode()}方法继承至{@link OperationResult OperationResult}的对应方法。
 * <p>
 * 通过{@link OperationResult#getResultCode() getResultCode()}返回成功或失败，返回值参见<code>OperationResult</code>中定义。
 * 通过{@link #getChannelType()}返回卡类型。
 * @date March 14th, 2016
 */
public interface EMVCardReaderResult extends OperationResult{
    
    /**
     * 获取卡类型。
     * @return 卡类型 0（{@link EMVConstants#Channel_Type_IC}）：接触式；1（{@link EMVConstants#Channel_Type_RF}）：非接触式；-1：失败。
     *
     */
    public int getChannelType();
}
