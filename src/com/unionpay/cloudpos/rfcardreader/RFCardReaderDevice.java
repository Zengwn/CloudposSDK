/*
 * RFCardReaderDevice.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos.rfcardreader;

import com.unionpay.cloudpos.Device;
import com.unionpay.cloudpos.DeviceException;
import com.unionpay.cloudpos.OperationListener;
import com.unionpay.cloudpos.OperationResult;
import com.unionpay.cloudpos.TimeConstants;

/**
 * <b>RFCardReaderDevice</b>定义了所有非接触式IC卡阅读器的接口。
 * <p>设备对象通过<code>POSTerminal</code>的对应方法获得，如下所示：
 * <pre>
 * RFCardReaderDevice rFCardReaderDevice =
 *         (RFCardReaderDevice) POSTerminal.getInstance().getDevice("cloudpos.device.rfcardreader");
 * </pre>
 * 其中，"cloudpos.device.contactlesscard"是标识非接读卡器的字符串，由具体的实现定义。
 * <p>非接触式IC卡阅读器对象主要进行非接卡读卡操作。其中等卡及移卡都包括同步和异步两种方式。同步方式会将主线程锁定，直到有结果返回，超时或者被取消。
 * 异步方式不会锁定主线程，当有结果时，会回调监听者{@link OperationListener#handleResult(OperationResult) handleResult()}方法。 
 * <p>
 * 为了正常访问非接触式IC卡阅读器，请在Android Manifest文件中设置非接触式IC卡阅读器访问权限，具体如下所示：
 * <pre> &lt;uses-permission android:name="android.permission.CLOUDPOS_CONTACTLESS_CARD"/>
 * </pre> 
 * @see Device
 * @date August 07, 2015
 */
public interface RFCardReaderDevice extends Device, TimeConstants {
    /** 自动模式 */
    int MODE_AUTO = 0;

    /** NFC 被动通讯模式: ISO/IEC 18092 (ECMA 340: NFCIP-1) */
    int MODE_NFC_PASSIVE = 1;

    /** NFC 主动通讯模式: ISO/IEC 18092 (ECMA 340: NFCIP-1) */
    int MODE_NFC_ACTIVE = 2;

    /** 14443卡TYPE A模式: ISO/IEC 14443 Type A compliant */
    int MODE_ISO14443_TYPE_A = 3;

    /** 14443卡TYP B模式: ISO/IEC 14443 Type B compliant */
    int MODE_ISO14443_TYPE_B = 4;

    /** 15693通讯模式: ISO/IEC 15693 compliant */
    int MODE_ISO15693 = 5;

    /** Mifare卡通讯模式: MIFARE&reg; */
    int MODE_MIFARE = 6;

    /** Felica通讯模式: FeliCa&reg; */
    int MODE_FELICA = 7;

    /**
     * 通讯速率
     * 
     */
    int PARAM_SPEED = 0;

    /**
     * 放碰撞卡槽号
     * 
     */
    int PARAM_NB_SLOT = 1;

    /** 106 kbps 通讯速率，用于{@link #PARAM_SPEED PARAM_SPEED} */
    int RATE_106K = 1;

    /** 212 kbps 通讯速率，用于{@link #PARAM_SPEED PARAM_SPEED} */
    int RATE_212K = 2;

    /** 424 kbps 通讯速率，用于 {@link #PARAM_SPEED PARAM_SPEED} */
    int RATE_424K = 4;

    /**
     * 848 kbps 通讯速率，用于 {@link #PARAM_SPEED
     * PARAM_SPEED}
     */
    int RATE_848K = 8;

    /**
     * 1667 kbps 通讯速率，用于{@link #PARAM_SPEED
     * PARAM_SPEED}
     */
    int RATE_1667K = 16;

    /**
     * 3390 kbps 通讯速率，用于{@link #PARAM_SPEED
     * PARAM_SPEED}
     */
    int RATE_3390K = 32;

    /**
     * 6670 kbps 通讯速率，用于{@link #PARAM_SPEED
     * PARAM_SPEED}
     */
    int RATE_6670K = 64;

    /**
     * 打开某个逻辑ID的非接触式IC卡阅读器，并指定模式。只有符合模式的卡会被发现。
     * <p>
     * 
     * @param logicalID 读卡器逻辑ID
     * @param mode 通讯模式
     * @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档。
     */
    void open(int logicalID, int mode) throws DeviceException;

    /**
     * 返回当前通讯模式。
     * 
     * @return 以下常量：
     *         <dl>
     *         <dd>{@link #MODE_AUTO MODE_AUTO}
     *         <dd>{@link #MODE_NFC_PASSIVE MODE_NFC_PASSIVE}
     *         <dd>{@link #MODE_NFC_ACTIVE MODE_NFC_ACTIVE}
     *         <dd>{@link #MODE_ISO14443_TYPE_A MODE_ISO14443_TYPE_A}
     *         <dd>{@link #MODE_ISO14443_TYPE_B MODE_ISO14443_TYPE_B}
     *         <dd>{@link #MODE_ISO15693 MODE_ISO15693}
     *         <dd>{@link #MODE_MIFARE MODE_MIFARE}
     *         <dd>{@link #MODE_FELICA MODE_FELICA}
     *         </dl>
     * @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档。
     */
    int getMode() throws DeviceException;

    /**
     * 设置通讯速率参数：
     */
    void setSpeed(int value)throws DeviceException;

    /**
     * 返回通讯速率参数：
     */
    int getSpeed()throws DeviceException;

    /**
     * 按照非接卡的通讯参数设定和模式设定，启动一次扫描非接卡的过程。
     * <p>
     * 本操作是个异步调用。当找到非接卡后，结果通过操作监听者{@link OperationListener#handleResult(OperationResult) handleResult()}方法
     * 返回。
     * <p>
     * 根据底层定义只能返回一张卡片。结果可以通过
     * {@link RFCardReaderOperationResult#getCard()}获得。
     * 如果读卡设备上放入多张卡片，返回错误：{@link RFCardReaderOperationResult#ERR_MULTI_CARD ERR_MULTI_CARD}，不返回任何卡片。
     * 本方法会按照{@link #setSpeed(int) setSpeed(int)}定义的参数扫描卡片。如果没有定义，本方法会按照读卡器默认参数扫描。
     * <p>
     * 本方法会正确响应
     * {@link #cancelRequest()}方法来取消操作。
     *<p> 通常程序必须定义自己的OperationListener，在回调函数handleResult()中对返回结果进行处理。如下所示：
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
     * <p>如果timeout是{@link TimeConstants#FOREVER FOREVER}，方法会一直等待，直到扫描到卡或取消。
     * <p>如果timeout是{@link TimeConstants#IMMEDIATE IMMEDIATE}，方法会马上返回。
     * 
     * @param listener 操作监听者。
     * @param timeout 最大等待时间，通过时间常量设定{@link TimeConstants#SECOND SECOND},{@link TimeConstants#MilliSECOND MilliSECOND},
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
     * 由于带有超时，本方法会响应{@link #cancelRequest()}方法
     * <p>
     * 如果超时发生，会返回操作结果为
     * {@link OperationResult#ERR_TIMEOUT ERR_TIMEOUT}，同时没有任何卡片返回。
     * 
     * @param timeout 最大扫描时间，通过时间常量设定。
     * @return 操作结果
     * @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档。
     */
    RFCardReaderOperationResult waitForCardPresent(int timeout) throws DeviceException;
    /**
     * 监听卡片移除动作。
     * <p>
     * 本操作是个异步调用。当用户移除卡发生后，结果通过操作监听者{@link OperationListener#handleResult(OperationResult) handleResult()}方法
     * 返回。
     * <p>
     * 本方法会正确响应
     * {@link #cancelRequest()}方法来取消操作。
     *<p> 通常程序必须定义自己的OperationListener，在回调函数handleResult()中对返回结果进行处理。如下所示：
     * <pre>
     * OperationListener operationListener = new OperationListener(){
     *     &#064;Override
     *     public void handleResult(OperationResult result) {
     *         // handleResult
     *     }
     * });
     * </pre>
     * <p>方法通过设置timeout来决定最多等待多长时间。请求开始执行的时候timeout开始计时。
     * <p>如果timeout时间到了，但用户还没有移除卡，也会回调函数handleResult()。此时
     * OperationResult会返回错误：{@link OperationResult#ERR_TIMEOUT ERR_TIMEOUT}，同时没有任何卡片返回
     * <p>如果timeout是{@link TimeConstants#FOREVER FOREVER}，方法会一直等待移除卡，直到移除卡或取消。
     * <p>如果timeout是{@link TimeConstants#IMMEDIATE IMMEDIATE}，方法会马上返回。
     * 
     * @param listener 操作监听者。
     * @param timeout 最大等待时间，通过时间常量设定{@link TimeConstants#SECOND SECOND},{@link TimeConstants#MilliSECOND MilliSECOND},
     * {@link TimeConstants#FOREVER FOREVER},{@link TimeConstants#IMMEDIATE IMMEDIATE}。
     * 
     * @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档。
     */
    void listenForCardAbsent(OperationListener listener, int timeout) throws DeviceException;

    /**
     * 本方法是上述对应的
     * {@link #listenForCardAbsent(OperationListener, int)}方法的同步版本。
     * <p>
     * 只有当超时发生或者操作正常完成，本次调用才会返回。
     * <p>
     * 由于带有超时，本方法会响应{@link #cancelRequest()}方法。
     * <p>
     * 如果超时发生，会返回这个操作结果：
     * {@link OperationResult#ERR_TIMEOUT ERR_TIMEOUT}，同时没有任何卡片返回。
     * 
     * @param timeout 最大等待时间，通过时间常量设定。
     * @return 操作结果
     * @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档。
   */
    RFCardReaderOperationResult waitForCardAbsent(int timeout) throws DeviceException;

}
