/*
 * MoneyValue.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos.card;

/**
 * 电子钱包数据结构。
 * @date August 7, 2015 
 */
public class MoneyValue {
	
	private byte[] userData;
	private int money;
	/**
     * 电子钱包构造函数。
     * @param userData
     * @param money
     */
	public MoneyValue(byte[] userData,int money) {
		this.userData = userData;
		this.money = money;
	}
	/**
     * 返回userdata。
     * @return userdata
     */
	public byte[] getUserData() {
		return userData;
	}
	/**
     * 返回money。
     * @return money
     */
	public int getMoney(){
		return money;
	}
}
