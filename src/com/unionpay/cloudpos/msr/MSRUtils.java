/*
 * MSRUtils.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos.msr;

import android.content.Context;

import com.unionpay.cloudpos.DeviceException;
import com.unionpay.cloudpos.POSTerminal;
import com.unionpay.cloudpos.TimeConstants;
/**
 * <b>MSRUtils</b> 
 * <p>
 * 集成了对磁条卡阅读器设备的使用，用户在不关心接口含义的情况下，可以调用waitForSwipe方法，然后继续刷卡操作就可以了。
 * <p> 
 * @date August 06, 2015
 */
public class MSRUtils {
	/**
     * 在方法中先调用{@link MSRDevice#open() open()}，然后调用{@link MSRDevice#waitForSwipe(int) waitForSwipe(int)}
     * 等待用户刷卡。
     * <p>
     * 只有当超时发生或者操作正常完成，本次调用才会返回。
     * <p>
     * 由于带有超时，本方法会响应{@link MSRDevice#cancelRequest() cancelRequest()}方法。
     * <p>
     * 如果超时发生，会返回null，同时关闭该设备。
     * 如果返回MSROperationResult，开发者后续自行关闭该设备。
     * 
     * @param timeout 最大等待时间，通过时间常量设定{@link TimeConstants#SECOND SECOND},{@link TimeConstants#MilliSECOND MilliSECOND},
     * {@link TimeConstants#FOREVER FOREVER},{@link TimeConstants#IMMEDIATE IMMEDIATE}。
     * @return 操作结果。
     * @throws DeviceException。
     */
   public MSROperationResult waitForSwipe(int timeout ,Context context) throws DeviceException {
        MSRDevice msrdevice = (MSRDevice) POSTerminal.getInstance(context).getDevice("cloudpos.device.msr");
        MSROperationResult res = null;
        msrdevice.open();
        try {
            res = msrdevice.waitForSwipe(timeout);
        } catch (DeviceException e) {
            throw e;
        } finally {
            msrdevice.close();
        }
        return res;
    }
}
