/*
 * IDCardReaderOperationResult.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos.idcardreader;

import com.unionpay.cloudpos.OperationResult;

/**
 * <code>IDCardReaderOperationResult</code>是被设备产生，用来返回身份证读取设备的操作结果。
 * <p>
 * {@link OperationResult#getResultCode() getResultCode()}方法继承至{@link OperationResult OperationResult}的对应方法。
 * <p>
 * 通过{@link OperationResult#getResultCode() getResultCode()}返回成功或失败，返回值参见<code>OperationResult</code>中定义。
 * 通过{@link #getIDCard()}返回身份证上的个人信息。
 * @date August 10, 2015
 */
public interface IDCardReaderOperationResult extends OperationResult {
    /**
     * 返回身份证对象。
     * @return IDCard
     */
    IDCard getIDCard();
}
