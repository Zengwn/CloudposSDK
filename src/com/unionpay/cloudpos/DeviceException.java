/*
 * DeviceException.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos;

/**
 * 设备在操作过程中如果遇到错误会抛出异常。
 * <p>
 * 这是一个轻量级的类每次被使用时由接口实现者创建，使用后直接丢弃。
 * 不会被反复使用，所以所有的状态只在构造函数中设置。
 * <p>
 * 每一个异常通过code标识发生异常的原因。具体请看code常量的描述。
 * <p>
 * @date August 06, 2015
 */
public class DeviceException extends Exception {
    private static final long serialVersionUID = 4066743061223798736L;

    private int code; // identifies the cause of the exception

    /**
     * 设备device没有处于合适的状态，比如：
     * <ul>
     * <li>如果设备在已经open的情况下，使用者再次调用了<code>open()</code>方法。
     * <li>如果设备在没有open的情况下，使用者调用了设备任何一个设备操作方法。
     * <li>某些设备的一些方法，在不合适的情况下被调用了。具体看每个设备的方法定义。
     * </ul>
     */
    public static final int BAD_CONTROL_MODE = -1;

    /**
     * 设备不支持该功能的调用:
     * 
     */
    public static final int NO_IMPLEMENT = -2;
    /**
     * <ul>
     * <li>一个异步方法还在执行中，调用了非<code>cancelRequest</code>方法，<code>open()</code>方法除外（这种情况下应该是是BAD_CONTROL_MODE）。
     * </ul>
     */
    public static final int REQUEST_PENDING = -3;

    /**
     * 当用户调用<code>cancelRequest</code>的时候，没有异步方法正在被执行。
     */
    public static final int NO_REQUEST_PENDING = -4;

    /**
     * 用户没有权限调用这个方法。
     */
    public static final int NO_PERMISSION = -5;

    /**
     * 其他未定义的错误。可以通过message获得更多信息。
     */
    public static final int GENERAL_EXCEPTION = -6;
    
    /**
     * 方法参数错误。
     */    
    public static final int ARGUMENT_EXCEPTION = -7;

    /**
     * 构造一个<code>DeviceException</code>
     * <p>
     * 
     * @param code 是在<b>DeviceException</b>中定义的常量。
     */
    public DeviceException(int code) {
        this.code = code;
    }

    /**
     * 构造一个未定义错误。
     * @param message   错误信息
     */
    public DeviceException(String message) {
        super(message);
        this.code = GENERAL_EXCEPTION;
    }
    
    public DeviceException(int code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * 根据指定的原因和 (cause==null ? null : cause.toString()) 的详细消息构造新异常（它通常包含 cause 的类和详细消息）。。
     * @param throwable 原因（保存此原因，以便以后通过Throwable.getCause() 方法获取它）。
     */
    public DeviceException(Throwable throwable) {
        this(GENERAL_EXCEPTION,null,throwable);
    }
    /**
     * 构造一个包含合适code、详细消息和原因的新异常。
     * @param code 是在<b>DeviceException</b>中定义的常量。
     * @param message 错误信息
     * @param throwable 原因（保存此原因，以便以后通过Throwable.getCause() 方法获取它）。 
     */
    public DeviceException(int code, String message, Throwable throwable) {
        super(message, throwable);
        this.code = code;
    }

    /**
     * 返回异常code
     * 
     * @return 返回一个在<b>DeviceException</b>中定义的常量    
     */
    public final int getCode() {
        return code;
    }
    /**
     * 返回此异常的简短描述。
     */
    public String toString(){
        return "Code:"+code+" "+super.toString();
    }
}
