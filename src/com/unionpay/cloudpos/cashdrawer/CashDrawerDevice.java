/*
 * CashDrawerDevice.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos.cashdrawer;

import com.unionpay.cloudpos.Device;
import com.unionpay.cloudpos.DeviceException;
/**
 * <b>CashDrawerDevice</b>定义了钱箱设备的接口。
 * <p>设备对象通过<code>POSTerminal</code>的对应方法获得，如下所示：
 * <pre>
 * CashDrawerDevice cashDrawerDevice =
 *         (CashDrawerDevice) POSTerminal.getInstance().getDevice("cloudpos.device.cashdrawer");
 * </pre>
 * 其中，"cloudpos.device.cashdrawer"是标识钱箱设备的字符串，由具体的实现定义。
 * <p>使用钱箱设备对象控制钱箱的弹开操作。
 * <p>为了正常访问钱箱设备，请在Android Manifest文件中设置钱箱访问权限，具体如下所示：
 * <pre> &lt;uses-permission android:name="android.permission.CLOUDPOS_MONEYBOX" /&gt;
 * </pre>
 * @see Device
 * @date August 10, 2015
 */
public interface CashDrawerDevice extends Device {
	
	/**
     * 打开某个逻辑ID的钱箱设备。
     * 
     * @param logicalID  钱箱设备逻辑ID。
     * @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档。
     *
     */
    void open(int logicalID) throws DeviceException;
    
    /**
     * 弹出钱箱。
     * 
     * @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档。
     *         <ul>
     *         <li>非法<code>logicalID</code></li>
     *         </ul>
     *
     */
    void kickOut()throws DeviceException;
	
    /**
     * 返回钱箱状态。
     * 
     * @return {@code 0} 钱箱开启， {@code 1} 钱箱关闭， {@code -1} 钱箱状态未知。
     * @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档。    
     *
     */
    int queryStatus() throws DeviceException;
}
