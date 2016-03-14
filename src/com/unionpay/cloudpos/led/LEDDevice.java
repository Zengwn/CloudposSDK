/*
 * LEDDevice.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos.led;

import com.unionpay.cloudpos.Device;
import com.unionpay.cloudpos.DeviceException;

/**
 * <b>LEDDevice</b>定义了LED设备的接口。
 * <p>设备对象通过<code>POSTerminal</code>的对应方法获得，如下所示：
 * <pre>
 * LEDDevice lEDDevice =
 *         (LEDDevice) POSTerminal.getInstance().getDevice("cloudpos.device.led");
 * </pre>
 * 其中，"cloudpos.device.led"是标识LED设备的字符串，由具体的实现定义。
 * <p>可以通过以下步骤对LED设备对象进行操作:</p>
 * <ol>
 * <li>通过前面的介绍，得到LED设备对象。
 * <li>调用{@link #open(int)},打开成功后，和对应的LED设备建立了连接。
 * <li>调用{@link #turnOn()},可以点亮该LED设备，直到程序调用了{@link #turnOff()},灭掉该LED设备，或者调用{@link #close()},关闭某个LED设备 。
 * <li>有两种方法可以让某个LED灯闪烁，一为同步方法：<code>blink</code>,一为异步方法<code>startBlink</code>,程序可以自行选择闪烁方式。
 * 	值得注意的是，如果选择异步方法，可以通过调用{@link #cancelBlink()}来取消闪烁。同步方法不能取消，会按照设定的开关时间及频次闪烁下去。 
 * <li>调用{@link #close()},关闭某个LED设备 。
 * <li>父类接口{@link #cancelRequest()},在这里是没有效果的。由于闪烁的异步方法不带有超时概念，和其他设备的异步监听响应机制不同。这里用{@link #cancelBlink()}来取消异步闪烁。
 * </ol>
 * 为了正常访问LED设备，请在Android Manifest文件中设置LED访问权限，具体如下所示：
 * <pre> &lt;uses-permission android:name="android.permission.CLOUDPOS_LED" /></pre>
 * 
 * @see Device
 * @date August 10, 2015
 */
public interface LEDDevice extends Device {
    /**
     * 关闭状态
     */
    int STATUS_OFF=0;
    /**
     * 点亮状态
     */
    int STATUS_ON=1;

    /**
     * 打开LED设备,和对应的LED设备建立连接。
     * <p>
     * @param logicalID  设备逻辑ID。
     *
     * @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档。
     *
     */
    void open(int logicalID) throws DeviceException;
    
    /**
     * 返回正在使用的 logicalID。
     * <p>
     * @return logicalID  设备逻辑ID。
     *						-1 未打开任何led灯。
     * @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档。
     * 
     */
    int getLogicalID() throws DeviceException;
   
    /**
     *  使某个led灯进行闪烁，异步方法，可以被取消。
     * @param delayTurnOn 指定Led灯所需要打开的时间。单位ms。
     * @param delayTurnOff 指定Led灯所需要关闭的时间。单位ms。
     * @param counts 周期，持续次数。
     * @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档。
     * */
    void startBlink(long delayTurnOn, long delayTurnOff, int counts)  throws DeviceException;
    
    /**
     *  使某个led灯进行闪烁，异步方法，可以被取消。Led灯的颜色参见{@link LEDDeviceSpec LEDDeviceSpec}颜色定义。
     * @param color 指定Led灯的颜色。
     * @param delayTurnOn 指定Led灯所需要打开的时间。单位ms。
     * @param delayTurnOff 指定Led灯所需要关闭的时间。单位ms。
     * @param counts 周期，持续次数。
     * @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档。
     * */    
    void startBlink(byte color, long delayTurnOn, long delayTurnOff, int counts)  throws DeviceException;
    
    /**
     *  使某个led灯进行闪烁，异步方法，可以被取消。
     *  @param delayTurnOn 指定Led灯所需要打开的时间。单位ms。
     *  @param delayTurnOff 指定Led灯所需要关闭的时间。单位ms。
     *  @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档。
     * */  
    void startBlink(long delayTurnOn, long delayTurnOff)  throws DeviceException;
    
    /**
     * 取消LED设备闪烁，调用该方法，当前闪烁的LED设备会停止闪烁。
     * @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档。
     *  
     * */
    void cancelBlink() throws DeviceException;
    
    /**
     *  使某个led灯进行闪烁，同步方法，不能被取消。 
     *   @param delayTurnOn 指定Led灯所需要打开的时间。单位ms。
     *   @param delayTurnOff 指定Led灯所需要关闭的时间。单位ms。
     *   @param counts 周期，持续次数。
     *   @throws DeviceException  具体定义参考{@link DeviceException DeviceException}的文档。
     * */
    void blink(long delayTurnOn, long delayTurnOff, int counts) throws DeviceException;
    
    /**
     *  使某个led灯进行闪烁，同步方法，不能被取消。 Led灯的颜色参见{@link LEDDeviceSpec LEDDeviceSpec}颜色定义。
     *  @param color 指定Led灯的颜色。
     *  @param delayTurnOn 指定Led灯所需要打开的时间。单位ms。
     *  @param delayTurnOff 指定Led灯所需要关闭的时间。单位ms。
     *  @param counts 周期，持续次数。
     *  @throws DeviceException  具体定义参考{@link DeviceException DeviceException}的文档。
     * */    
    void blink(byte color , long delayTurnOn, long delayTurnOff, int counts) throws DeviceException;
    
    /**
     * 返回LED的当前状态。
     * @return 状态常量：{@link #STATUS_OFF} 或者 {@link #STATUS_ON}。
     * @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档。
     */
    int getStatus() throws DeviceException;    
    
    /**
     *  打开led灯。
     *  <p>LED灯会一直亮下去，直到调用{@link #turnOff()}或{@link #close()}
     *  @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档。
     * */
    void turnOn() throws DeviceException;
    /**
     *  关闭led灯.
     *  <p>Led灯会灭掉。
     *  @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档。
     * */
    void turnOff() throws DeviceException;
    
}
