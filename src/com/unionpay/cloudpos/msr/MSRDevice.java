/*
 * MSRDevice.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos.msr;

import com.unionpay.cloudpos.Device;
import com.unionpay.cloudpos.DeviceException;
import com.unionpay.cloudpos.OperationListener;
import com.unionpay.cloudpos.OperationResult;
import com.unionpay.cloudpos.TimeConstants;

/**
 * <b>MSRDevice</b>定义了对磁条卡阅读器的操作方法。任何具体的实现都必须实现这个接口。
 * <p>设备对象通过<code>POSTerminal</code>的对应方法获得，如下所示：
 * <pre>
 * MSRDevice msrDevice =
 *         (MSRDevice) POSTerminal.getInstance().getDevice("cloudpos.device.msr");
 * </pre>
 * 其中，"cloudpos.device.msr"是标识磁条卡阅读器的字符串，由具体的实现定义。
 * <p>磁条卡阅读器设备对象主要进行刷卡操作。其中等待刷卡包括同步和异步两种方式。同步方式会将主线程锁定，直到有结果返回，超时或者被取消。
 * 异步方式不会锁定主线程，当有结果时，会回调监听者{@link OperationListener#handleResult(OperationResult) handleResult()}方法。
 * <p>
 * 为了正常访问磁条卡阅读器，请在Android Manifest文件中设置磁条卡阅读器访问权限，具体如下所示：
 * <pre> &lt;uses-permission android:name="android.permission.CLOUDPOS_MSR"/>
 * </pre>
 * @date August 06, 2015
 */
public interface MSRDevice extends Device, TimeConstants {
    /**
     * 打开磁条卡阅读器的指定卡槽 。
     * <p>打开成功，设备对象就和相应的磁条卡阅读器的卡槽建立了连接。此后可以进行后面的各项操作。
     * <p>设备对象去打开某个已经打开（被当前设备对象或其他设备对象）的磁条卡阅读器的卡槽会抛出异常{@link DeviceException#BAD_CONTROL_MODE BAD_CONTROL_MODE}。
     * <p>设备对象打开磁条卡阅读器的某个卡槽，再打开该磁条卡阅读器的另外一个卡槽，会抛出异常{@link DeviceException#BAD_CONTROL_MODE BAD_CONTROL_MODE}。
     * @param logicalID 读卡器逻辑ID（卡槽ID），
     * @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档。
     */
    void open(int logicalID) throws DeviceException;


    /**
     * 等待用户刷卡。
     * <p>
     * 本操作是个异步调用，调用后立即返回。当用户刷卡发生后，结果通过操作监听者{@link OperationListener#handleResult(OperationResult) handleResult()}方法返回。
     * <p>
     * 本方法会正确响应
     * {@link #cancelRequest()}方法来取消操作。
     * <p>
     * 通常程序必须定义自己的OperationListener，在回调函数handleResult()中对返回结果进行处理。如下所示：
     * <pre>
     * OperationListener operationListener = new OperationListener(){
     *     &#064;Override
     *     public void handleResult(OperationResult result) {
     *         // handleResult
     *     }
     * });
     * </pre>
     * <p>方法通过设置timeout来决定最多等待多长时间。请求开始执行的时候timeout开始计时。
     * <p>如果timeout时间到了，但用户还没有刷卡，也会回调函数handleResult()。此时
     * OperationResult会返回错误：{@link OperationResult#ERR_TIMEOUT ERR_TIMEOUT}，同时没有任何卡片返回
     * <p>如果timeout是{@link TimeConstants#FOREVER FOREVER}，方法会一直等待刷卡，直到刷卡或取消。
     * <p>如果timeout是{@link TimeConstants#IMMEDIATE IMMEDIATE}，方法会马上返回。
     * @param listener 操作监听者。
     * @param timeout 最大等待时间，通过时间常量设定{@link TimeConstants#SECOND SECOND},{@link TimeConstants#MilliSECOND MilliSECOND},
     * {@link TimeConstants#FOREVER FOREVER},{@link TimeConstants#IMMEDIATE IMMEDIATE}。
     * @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档。
     * 
     * @see OperationListener#handleResult
     * @see MSROperationResult
     * @see MSRTrackData
     */
    void listenForSwipe(OperationListener listener ,int timeout) throws DeviceException;

    /**
     * 本方法是上述对应的
     * {@link #listenForSwipe(OperationListener,int)}方法的同步版本。
     * <p>
     * 只有当超时发生或者操作正常完成，本次调用才会返回。
     * <p>
     * 由于带有超时，本方法会响应{@link #cancelRequest()}方法。
     * <p>
     * 如果超时发生，会返回这个操作结果：信息为
     * {@link OperationResult#ERR_TIMEOUT ERR_TIMEOUT}，同时没有任何卡片返回。
     * 
     * @param timeout 最大等待时间，通过时间常量设定{@link TimeConstants#SECOND SECOND},{@link TimeConstants#MilliSECOND MilliSECOND},
     * {@link TimeConstants#FOREVER FOREVER},{@link TimeConstants#IMMEDIATE IMMEDIATE}。
     * @return 操作结果。
     * @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档。
     */
    MSROperationResult waitForSwipe(int timeout) throws DeviceException;
}
