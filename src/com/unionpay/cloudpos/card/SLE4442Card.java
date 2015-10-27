/*
 * SLE4442Card.java
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
 * 接触式IC卡的一种。有三项安全机制用户密码，唯一代码， 固化写入。密码若未核对正确，则无法写入数据。写入的数据一经写保护则无法再更改，
 * 采用唯一代码作为系统所使用IC卡的标识，可避免相同型号的假冒卡闯入系统。
 * 属于memory card的一种.
 * 
 * @date August 7, 2015
 */
public interface SLE4442Card extends MemoryCard {
	
	
	/**
     * Memory卡的主数据区
     */
    int MEMORY_CARD_AREA_MAIN =0;
    /**
     * Memory卡的厂商数据库，只读。 
     */
    int MEMORY_CARD_AREA_PROTECTED =1;
    /**
     * Memory卡的安全数据库。
     */
    int MEMORY_CARD_AREA_SECURITY =2;
	
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
     * 使用给定的密钥，验证memory卡。
     * 
     * @param key
     * @return {@code true} 成功,{@code false} 失败。
     * @throws Exception 具体定义参考{@link DeviceException DeviceException}的文档。
     */
    boolean verify(byte[] key) throws DeviceException;
    /**
     * 读取内存卡的数据。
     * 
     * @param area 读取的区域标志，包括以下常量：
     *            <dl>
     *            <dd>{@link #MEMORY_CARD_AREA_MAIN} <dd>{@link #MEMORY_CARD_AREA_PROTECTED} <dd>
     *            {@link #MEMORY_CARD_AREA_SECURITY}
     *            </dl>
     * @param address 地址，由0开始。
     * @param length 读取数据的长度
     * @return 读取数据的内容，长度为length指定长度。
     * @throws Exception 具体定义参考{@link DeviceException DeviceException}的文档。
     */
    byte[] read(int area, int address, int length) throws DeviceException;
    
    /**
     * 向内存卡写入数据。
     * 
     * @param area 目标的区域标志，包括以下常量：
     *            <dl>
     *            <dd>{@link #MEMORY_CARD_AREA_MAIN} <dd>{@link #MEMORY_CARD_AREA_PROTECTED} <dd>
     *            {@link #MEMORY_CARD_AREA_SECURITY}
     *            </dl>
     * @param address 地址，由0开始。
     * @param data 写入的数据
     * @throws Exception 具体定义参考{@link DeviceException DeviceException}的文档。
     */
    void write(int area, int address, byte[] data) throws DeviceException;

}
