/*
 * AlgorithmConstants.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */
package com.unionpay.cloudpos;
/**
 * 应用于安全运算的算法常量。
 * 
 * @date August 06, 2015
 */
public interface AlgorithmConstants {
	/**
	 * RSA公钥加密算法 
	 */
	int ALG_RSA = 1;

	/**
	 * MAC算法类型X9。9
	 */
	int ALG_MAC_METHOD_X99 = 2;
	/**
	 * MAC算法类型ECB
	 */
	int ALG_MAC_METHOD_ECB = 3;

	/**
	 * DES加密算法
	 */
	int ALG_DES = 4;

	/**
	 * 三重DES加密算法
	 */
	int ALG_3DES = 5;
	/**
	 * 国密非对称加密算法
	 * */
	int ALG_SM2 = 6;
	/**
	 * 国密Hash算法
	 * */
	int ALG_SM3 = 7;
	/**
	 * 国密对称加密算法
	 * */
	int ALG_SM4 = 8;
	
	/**
	 * X9.19 算法 ,后补 80
	 */
	int ALG_MAC_METHOD_X919_80 =9;
	/**
	 * X9.19算法 (不足后补 0x00)；移动支付项目使用
	 */
	int ALG_MAC_METHOD_X919_X00 =10;
	/**
	 *  中总行扩展算法
	 */
	int ALG_MAC_METHOD_BOCE =11;
	/**
	 * X9.19算法 ,后补 00
	 */
	int ALG_MAC_METHOD_X919_00 =12;
	/**
	 * 异或后 3DES
	 */
	int ALG_MAC_METHOD_XOR_3DES =13;

}
