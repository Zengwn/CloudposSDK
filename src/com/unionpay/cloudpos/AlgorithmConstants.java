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
	 * MAC算法类型X99
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

}
