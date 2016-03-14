/*
 * MSROperationResult.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos.msr;

import com.unionpay.cloudpos.OperationResult;

/**
 * <code>MSROperationResult</code>是被磁条卡阅读器设备产生，用来返回磁条卡的操作结果。
 * <p>
 * {@link OperationResult#getResultCode() getResultCode()}方法继承至{@link OperationResult}的对应方法。
 * <p>
 * 这里通过"ERR_"设置了本设备相关的自定义错误，可以在{@link OperationResult#getResultCode() getResultCode()}返回，
 * 通过{@link MSROperationResult#getMSRTrackData() getMSTrackData()}返回磁条卡数据对象。
 * @date August 06, 2015
 */
public interface MSROperationResult extends OperationResult {
    /**
     * 检查到磁条卡数据编码错误
     */
    int ERR_READFAIL = ERR_DEVICE_BASE-1;

    /**
     * 磁条卡数据无法读取
     */
    int ERR_INVALIDMEDIA = ERR_DEVICE_BASE -2;

    /**
     * 没有检测到磁条卡信息
     */
    int ERR_NOMEDIA = ERR_DEVICE_BASE -3;

    /**
     * 返回磁条卡数据。
     * 
     * @return 磁条卡数据对象。
     * @see MSRTrackData
     */
    public MSRTrackData getMSRTrackData();
}
