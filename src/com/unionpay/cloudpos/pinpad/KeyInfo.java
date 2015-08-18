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
 * <p>
 * @param keyType : 密钥类型：{@link #KEY_TYPE_DUKPT},
 *            {@link #KEY_TYPE_TDUKPT}, {@link #KEY_TYPE_MK_SK},
 *            {@link #KEY_TYPE_PUBLIC}, {@link #KEY_TYPE_FIX}
 * @param masterKeyID : 主密钥索引[0x00, ..., 0x09]，仅在密钥类型是主密钥/会话密钥{@link #KEY_TYPE_MK_SK}的前提下有效
 * @param userKeyID : 会话密钥类型，仅在密钥类型是主密钥/会话密钥前提下有效。只能使用以下常量：{@link #USER_KEY_ID_PIN},
 *            {@link #USER_KEY_ID_MAC}
 * @param 算法：algorithm 具体定义参考{@link AlgorithmConstants #ALG_DES} or {@link AlgorithmConstants #ALG_3DES}
 * @date August 06, 2015
 */
public class KeyInfo {
	public int keyType;
	public int masterKeyID;
	public int userKeyID;
	public int algorithm;
}
