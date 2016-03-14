/*
 * TimeConstants.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos;

/**
 * 时间常量
 * 
 * @date August 06, 2015
 */
public interface TimeConstants {
    /**
     * 秒，比如等待3秒：
     * <code>wait( 3 * SECOND )</code>
     */
    int SECOND = 1000;

    /**
     * 毫秒，比如等待3毫秒：
     * <code>wait( 3 * MilliSECOND )</code>
     */
    int MilliSECOND = 1;

    /** 永远 */
    int FOREVER = -1;

    /** 立即 */
    int IMMEDIATE = 0;
}
