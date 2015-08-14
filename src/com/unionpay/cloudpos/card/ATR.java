/*
 * ATR.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos.card;

/**
 * 本类用于IC卡的ATR数据对象,通过ATR可以识别不同的卡类别等。
 * 
 * @date August 7, 2015
 */
public class ATR {
	private byte [] atr ;
	private byte [] histBytes ;
	
	public ATR(byte[] atr, byte[] histBytes){
		this.atr = atr;
		this.histBytes = histBytes;
	}

    /**
     * 取得所有ATR数据
     *
     * @return ATR数据buffer.
     */
    public byte[] getBytes(){
    	return atr;
    };

    /**
     * 取得包含发卡人、卡类型、操作系统等信息的TLV格式的数据,如果通讯协议不支持则返回null。
     * @return 数据buffer
     */
    public byte[] getHistoricalBytes(){
    	return histBytes;
    };

}
