/*
 * HSMDeviceSpec.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos.hsm;

import com.unionpay.cloudpos.DeviceSpec;
/**
 * <b>HSMDeviceSpec</b>定义了对安全模块的详细描述。
 * <p>通过调用{@link #getAlgorithms()}返回安全模块的算法。
 * @date August 10, 2015
 */
public interface HSMDeviceSpec extends DeviceSpec {
    
    
    /**
     *  返回安全模块中的支持的所有加密算法。
     *  @return 返回支持的所有加密算法，不支持返回null。
     * */
    int [] getAlgorithms();
}
