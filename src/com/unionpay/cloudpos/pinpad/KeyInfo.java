/*
 * KeyInfo.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos.pinpad;

import com.unionpay.cloudpos.AlgorithmConstants;

/**
 * 为后续的加密操作选择密钥和算法。
 * @date August 06, 2015
 */
public class KeyInfo {
	
	/**
	 *  密钥类型：{@link PINPadDevice KEY_TYPE_DUKPT},
	 *            {@link PINPadDevice KEY_TYPE_TDUKPT}, {@link PINPadDevice KEY_TYPE_MK_SK},
	 *            {@link PINPadDevice KEY_TYPE_FIX}
	 */
	public int keyType;
	
	/**
	 * 主密钥索引[0x00, ..., 0x09]，仅在密钥类型是主密钥/会话密钥{@link PINPadDevice  KEY_TYPE_MK_SK}的前提下有效
	 */
	public int masterKeyID;
	
	/**
	 *  密钥索引。
	 * <p>如果在密钥类型是主密钥/会话密钥{@link PINPadDevice  KEY_TYPE_MK_SK}情况下，只能使用以下常量：{@link PINPadDevice  USER_KEY_ID_PIN},
	 * {@link PINPadDevice  USER_KEY_ID_MAC}，{@link PINPadDevice  USER_KEY_ID_DATA}
	 * <p>如果密钥类型是其他三种，表示选定的密钥索引。
	 */
	public int keyID;
	
	/**
	 * 算法：algorithm 具体定义参考{@link AlgorithmConstants  ALG_DES} or {@link AlgorithmConstants  ALG_3DES}
	 */
	public int algorithm;
	
	public KeyInfo(int keyType, int masterKeyID, int keyID, int algorithm){
		this.keyType = keyType;
		this.masterKeyID = masterKeyID;
		this.keyID = keyID;
		this.algorithm = algorithm;
	}
}
