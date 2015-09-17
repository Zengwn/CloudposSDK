/*
 * MSRTrackData.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos.msr;


/**
 * 磁道数据对象。
 * 
 * @date August 06, 2015
 */
public interface MSRTrackData {
    /**
     * 没有错误。
     * <p>
     * 该常量通过<code>getTrackError()</code>返回。
     */
    int NO_ERROR            = 1;

    /**
     * 不明原因错误。
     * <p>
     * 该常量通过<code>getTrackError()</code>返回。
     */
    int NON_SPECIFIC_ERROR  = 2;

    /**
     * 不支持的磁道。
     * <p>
     * 该常量通过<code>getTrackError()</code>返回。
     */
    int TRACK_NOT_SUPPORTED = 3;

    /**
     * 本磁道读错误。
     * <p>
     * 该常量通过<code>getTrackError()</code>返回。
     */
    int READ_ERROR          = 4;

    /**
     * 本磁道奇偶校验错误。
     * <p>
     * 该常量通过<code>getTrackError()</code>返回。
     */
    int PARITY_ERROR        = 5;

    /**
     * 本磁道LRC错误。
     * <p>
     * 该常量通过<code>getTrackError()</code>返回。
     */
    int LRC_ERROR           = 6;

    /**
     * 本磁道没有数据信息体，只有起始位。
     * <p>
     * 该常量通过<code>getTrackError()</code>返回。
     */
    int NO_DATA             = 7;

    /**
     * 本磁道没有任何数据，包括起始位。
     * <p>
     * 该常量通过<code>getTrackError()</code>返回     。
     */
    int NO_STRIPE           = 8;
    
    /**
     * 返回磁道信息。
     * <p>
     * <i>磁道信息参考：ISO 7811-2 and JIS X 6302.</i>
     * <p>
     * @return   磁道信息数据。
     */
    byte[] getTrackData(int trackNo);
    /**
     * 返回本磁道的错误标识。
     * <p>
     * @return  上述定义的磁道错误常量。
     * @see  #NO_ERROR
     * @see  #NON_SPECIFIC_ERROR
     * @see  #TRACK_NOT_SUPPORTED
     * @see  #READ_ERROR
     * @see  #PARITY_ERROR
     * @see  #LRC_ERROR
     * @see  #NO_DATA
     * @see  #NO_STRIPE
     */
    int getTrackError(int trackNo);
}
