/*
 * CPUCard.java
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
 * CPU卡的接口，通过APDU命令和智能卡读卡器之间传递信息。
 * <p>CPU智能卡，是IC卡的一种，内有微处理器CPU、存储单元（包括随机存储器RAM、程序存储器ROM（FLASH）、用户数据存储器EEPROM）以及芯片操作系统COS，
 * 通常CPU卡内含有随机数发生器，硬件DES，3DES加密算法。
 * <p>CPU卡既有接触式也有非接触式的，接触式CPU卡主要采用两种通讯协议：T=0和T=1通讯协议。T=0是异步半双工字符传输协议，T=1是异步半双工块传输协议。
 * <p>通过接触式设备SmartCardReaderDevice对象或非接触式设备RFCardReaderDevice对象都有可能得到CPU卡对象。
 * @date August 7, 2015 
 */
public interface CPUCard extends Card {
	
    /**
     * 连接卡片，并返回卡片的ATR信息。
     * <p>
     * @return 卡片的ATR信息
     * @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档：
     */
    ATR connect() throws DeviceException;
    
    /**
     * 断开卡片。
     * <p>
     *
     * @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档：
     */
    void disconnect() throws DeviceException;
    
    /**
     * 在CPU卡和CPU卡读卡器之间传递信息。
     * <p> APDU--ApplicationProtocolDataUnit--应用协议数据单元,是智能卡与智能卡读卡器之间传送的信息单元.
     * <p> 如果在发送命令前，需要选卡、唤醒等操作，由底层自动实现。
     * <p> 如果与读卡器之间断开连接，不能执行APDU命令。
     * @param apdu APDU数据流
     * @return 返回的APDU数据
     * @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档：
     *             <li>如果<code>buffer</code>为空
     *             </ul>
     */
    byte[] transmit(byte[] apdu) throws DeviceException;
    

}
