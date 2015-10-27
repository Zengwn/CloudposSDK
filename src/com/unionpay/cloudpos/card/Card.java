/*
 * Card.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos.card;

import com.unionpay.cloudpos.DeviceException;


/**
 * <b>Card</b>接口提供了一些卡片服务的通用的定义。
 * <p>通过这个接口，可以实现卡片和读卡设备之间的连接或断开操作，并且获得卡片的ATR，ID和状态等基本信息。
 * @date August 7, 2015 
 */
public interface Card {
	/**
     * ISO14443 TYPE A。
     */
	int PROTOCOL_RFCARD_TYPE_A = 0;
	/**
     * ISO14443 TYPE B。
     */
	int PROTOCOL_RFCARD_TYPE_B = 1;
	/**
     * 异步半双工字符传输协议。
     */
	int PROTOCOL_T_0 = 10;
	/**
     * 异步半双工块传输协议。
     */
	int PROTOCOL_T_1 = 11;
	/**
     * 未知的协议。
     */
	int PROTOCOL_UNKNOWN = 12;
	/**
     * 当前卡槽处于<b>connected</b>状态。通过<code>getCardStatus()</code>方法返回。
     */
	public static final int STATUS_CONNECTED = 0;
	/**
     * 当前卡槽处于<b>disconnected</b>状态。通过<code>getCardStatus()</code>方法返回。
     */
	public static final int STATUS_DISCONNECTED = 1;
	/**
     * 当前卡槽处于<b>removed</b>状态。通过<code>getCardStatus()</code>方法返回。
     */
	public static final int STATUS_ABSENT = 2;
	
	
    /**
     * 返回卡片的ID。
     * <p>
     *
     * @return 卡片ID的字节流
     *
     */
    byte[] getID() throws DeviceException;
    
     /**
     * 返回表达当前卡槽和卡片通讯协议的常量。
     * <p>
     * 本方法是个同步方法。当卡槽中有卡片存在，并且成功open,并得到了卡对象，可以被随时读取。
     * <p>    
     * @return 卡片通讯协议的常量：
     *         <dl>
     *         <dd>{@link #PROTOCOL_RFCARD_TYPE_A} <dd>{@link #PROTOCOL_RFCARD_TYPE_B} <dd>
     *         {@link #PROTOCOL_T_0} <dd>{@link #PROTOCOL_T_1} <dd>{@link #PROTOCOL_UNKNOWN}
     *         </dl>
     * @throws DeviceException 参考{@link DeviceException DeviceException}
     *             中的定义，同时还包括:
     *             <ul>
     *             <li>BAD_CONTROL_MODE - 如果卡片没有open
     *             </ul>     
     */
    int getProtocol() throws DeviceException;
    
    /**
     * 返回卡操作结果对象的状态。
     * @return 结果
     * 
     */
    public int getCardStatus() throws DeviceException;
    
}
