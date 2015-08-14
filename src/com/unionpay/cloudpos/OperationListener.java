/*
 * OperationListener.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos;

/**
 * 异步方法的动作监听接口。
 * 设备调用本接口的handleResult方法返回异步操作的结果。
 * 每个应用程序必须实现自己的OperationListener，在调用设备对象的异步方法时，将自定义OperationListener作为参数传递给设备对象，设备对象会操作具体的设备。
 * @date August 06, 2015
 */
public interface OperationListener {
    /**
     * 当异步操作动作完成后，该方法被调用。
     *<p>异步操作的结果会设置到<code>OperationResult</code>中，应用程序根据回调函数中传递过来的<code>OperationResult</code>，判断结果数据。
     * @param result 异步操作动作的结果
     * @see OperationResult
     */
    void handleResult(OperationResult result);
}
