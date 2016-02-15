/*
 * IDCardReaderDevice.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos.idcardreader;

import com.unionpay.cloudpos.Device;
import com.unionpay.cloudpos.DeviceException;
import com.unionpay.cloudpos.OperationListener;
import com.unionpay.cloudpos.OperationResult;
import com.unionpay.cloudpos.TimeConstants;

/**
 * <b>IDCardReaderDevice</b>定义了所有身份证读取身份证的接口。
 * <p>设备对象通过<code>POSTerminal</code>的对应方法获得，如下所示：
 * <pre>
 * IDCardReaderDevice idCardReaderDevice =
 *         (IDCardReaderDevice) POSTerminal.getInstance().getDevice("cloudpos.device.idcardreader");
 * </pre>
 * 其中，"cloudpos.device.idcard"是标识身份证设备的字符串，由具体的实现定义。
 * <p>身份读取设备对象主要进行身份证卡读取操作。其中等卡都包括同步和异步两种方式。同步方式会将主线程锁定，直到有结果返回，超时或者被取消。
 * 异步方式不会锁定主线程，当有结果时，会回调监听者{@link OperationListener#handleResult(OperationResult) handleResult()}方法。
 * <p>
 * 为了正常访问身份证读取设备，请在Android Manifest文件中设置身份证读取设备访问权限，具体如下所示：
 * <pre> &lt;uses-permission android:name="android.permission.CLOUDPOS_IDCard"/>
 * </pre>
 * @see Device
 * @date August 07, 2015
 */
public interface IDCardReaderDevice extends Device {
    /**
     * 打开某个逻辑ID的身份证读取设备。
     * <p>
     * 
     * @param logicalID 模块的逻辑ID
     * @throws DeviceException  具体定义参考{@link DeviceException DeviceException}的文档。
     */
    void open(int logicalID) throws DeviceException;

    /**
     * 启动一次扫描身份证的过程。    
     * 一次只能查找一张身份证。
     * <p>
     * 本方法会正确响应
     * {@link #cancelRequest()}方法来取消操作。
     * <p>本操作是个异步调用。当找到身份证后，结果通过操作监听者{@link OperationListener#handleResult(OperationResult) handleResult()}方法
     * 返回。
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
     * <p>如果timeout时间到了，但还没有扫描到卡，也会回调函数handleResult()。此时
     * OperationResult会返回错误：{@link OperationResult#ERR_TIMEOUT ERR_TIMEOUT}，同时没有任何卡片返回
     * <p>如果timeout是{@link TimeConstants#FOREVER FOREVER}，方法会一直等待卡，直到扫描到卡或取消。
     * <p>如果timeout是{@link TimeConstants#IMMEDIATE IMMEDIATE}，方法会马上返回。
     * 
     * @param listener 操作监听者。
     * @param timeout 最大扫描时间，通过时间常量设定{@link TimeConstants#SECOND SECOND},{@link TimeConstants#MilliSECOND MilliSECOND},
     * {@link TimeConstants#FOREVER FOREVER},{@link TimeConstants#IMMEDIATE IMMEDIATE}。
     * 
     * @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档。
     */
    void listenForCardPresent(OperationListener listener, int timeout) throws DeviceException;

    /**
     * 本方法是上述对应的
     * {@link #listenForCardPresent(OperationListener, int)}方法的同步版本。
     * <p>
     * 只有当超时发生或者操作正常完成，本次调用才会返回。
     * <p>
     * 由于带有超时，本方法会响应{@link #cancelRequest()}方法。
     * <p>
     * 如果超时发生，会返回这个操作结果：
     * {@link OperationResult#ERR_TIMEOUT ERR_TIMEOUT}，同时没有任何卡片返回。
     * 
     * @param timeout 最大扫描时间，通过时间常量设定。
     * @return 操作结果
     * @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档。
     */
    IDCardReaderOperationResult waitForCardPresent(int timeout) throws DeviceException;
}
