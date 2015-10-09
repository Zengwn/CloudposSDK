/*
 * OperationResult.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos;

/**
 * 操作结果是由设备接口的实现者创建，用来通知操作调用者/监听者这次操作的结果。
 * <p>
 * <b>OperationResult</b>是所有设备操作结果的基类，定义了通用的获得结果的方法。
 * 针对每个具体设备可能会有自己特殊的子类返回该设备特有的结果对象。
 * <p>
 * 本类中的<code>getResultCode</code>方法用于让应用程序判断操作是否成功。
 * @date August 10, 2015
 */
public interface OperationResult {
    /**
     * 默认初始状态
     */
    int NONE = 0;

    /**
     * 成功
     */
    int SUCCESS = 1;

    /**
     * 取消
     */
    int CANCEL = 2;

    /**
     * 严重错误
     */
    int ERR_GENERAL_ERROR = -1;

    /**
     * 执行权限错误，包含：
     * <ul>
     * <li>操作没有被Control支持。
     * <li>执行时机不对，目前无法执行这个操作。
     * </ul>
     */
    int ERR_NO_PERMISSION = -2;

    /**
     * 无法定位具体原因的错误，需要具体看每个Control的实现
     */
    int ERR_NO_INFO = -3;

    /**
     * 超时
     */
    int ERR_TIMEOUT = -4;
    
    
    /**
     *  设备错误起始值
     * */
    int ERR_DEVICE_BASE = -100;

    /**
     * 返回操作状态
     * @return 上述的常量值
     */
    int getResultCode();
    
}
