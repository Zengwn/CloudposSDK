/*
 * SerialPortDevice.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos.serialport;

import com.unionpay.cloudpos.Device;
import com.unionpay.cloudpos.DeviceException;
import com.unionpay.cloudpos.OperationListener;
import com.unionpay.cloudpos.OperationResult;
import com.unionpay.cloudpos.TimeConstants;

/**
 * <b>SerialPortDevice</b>定义了串口设备的接口。
 * <p>设备对象通过<code>POSTerminal</code>的对应方法获得，如下所示：
 * <pre>
 * SerialPortDevice serialPortDevice =
 *         (SerialPortDevice) POSTerminal.getInstance().getDevice("cloudpos.device.serialport");
 * </pre>
 * 其中，"cloudpos.device.serialport"是标识串口设备的字符串，由具体的实现定义。
 * <p>可以通过以下步骤对串口设备对象进行操作:</p>
 * <ol>
 * <li>通过前面的介绍，得到串口设备对象。
 * <li>调用{@link #open(int)},打开成功后，和对应的串口设备建立了连接。
 * <li>调用{@link #write(byte[], int, int)},可以将数据buffer流通过该打开的串口设备写到连接到该串口的某个设备中 。
 * <li>有两种方法可以读取串口中传过来数据，一为同步方法：{@link #waitForRead(int, int)},一为异步方法{@link #listenForRead(int, OperationListener, int)},程序可以根据自身的业务逻辑自己选择哪种方式。
 * 	值得注意的是，如果选择异步方法，可以通过调用{@link #cancelRequest()}来取消。同步方法不能取消。这两种方法都定义了超时，因此即使不取消，在超时到来时，不管有没有数据过来，都会返回结果。 
 * <li>调用{@link #close()},关闭某个串口设备 。 
 * </ol>
 * 为了正常访问串口设备，请在Android Manifest文件中设置串口访问权限，具体如下所示：
 * <pre> &lt;uses-permission android:name="android.permission.CLOUDPOS_SERIAL"/>
 * </pre>
 * @see Device
 * @date August 10, 2015
 */
public interface SerialPortDevice extends Device {
    /** 数据位 5 */
    int DATABITS_5 = 0;

    /** 数据位 6 */
    int DATABITS_6 = 1;

    /** 数据位 7*/
    int DATABITS_7 = 2;

    /** 数据位 8 */
    int DATABITS_8 = 3;

    /** 停止位 1 */
    int STOPBITS_1 = 0;

    /** 停止位 2 */
    int STOPBITS_2 = 1;

    /**
     * 1-1/2 停止位
     */
    int STOPBITS_1_5 = 2;

    /** 无奇偶校验 */
    int PARITY_NONE = 0;

    /**
     * 奇校验
     */
    int PARITY_ODD = 1;

    /**
     * 偶校验
     */
    int PARITY_EVEN = 2;

    /** 无流控 */
    int FLOWCONTROL_NONE = 0;

    /** RTS/CTS 输入流控 */
    int FLOWCONTROL_RTSCTS_IN = 1;

    /** RTS/CTS 输出流控 */
    int FLOWCONTROL_RTSCTS_OUT = 2;

    /** RTS/CTS 输入/输出流控 */
    int FLOWCONTROL_RTSCTS_IN_OUT = 3;

    /** XON/XOFF 输入软流控 */
    int FLOWCONTROL_XONXOFF_IN = 4;

    /** XON/XOFF 输出软流控 */
    int FLOWCONTROL_XONXOFF_OUT = 5;

    /** XON/XOFF 输入/输出软流控 */
    int FLOWCONTROL_XONXOFF_IN_OUT = 6;

    /**
     * 打开某个逻辑ID的串口设备
     * <p>
     * 
     * @param logicID 串口设备逻辑ID
     * @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档。
     */
    void open(int logicID) throws DeviceException;

    /**
     * 返回串口波特率
     * <p>
     * 
     * @return integer 波特率
     * @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档。
     */
    int getBaudRate() throws DeviceException;

    /**
     * 返回当前数据位。
     * <p>
     * 
     * @return <b>SerialPortDevice</b>中定义的如下常量：DATABITS_5,
     *         DATABITS_6, DATABITS_7, or DATABITS_8
     * @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档。
     */
    int getDataBits() throws DeviceException;

    /**
     * 返回停止位。
     * <p>
     * 
     * @return 停止位是以下常量：STOPBITS_1,
     *         STOPBITS_2, or STOPBITS_1_5
     * @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档。
     */
    int getStopBits() throws DeviceException;

    /**
     * 返回奇偶校验位
     * <p>
     * 
     * @return 如下常量： PARITY_NONE,
     *         PARITY_ODD, or PARITY_EVEN
     * @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档。
     */
    int getParity() throws DeviceException;

    /**
     * 设置RTS
     * <p>
     * 
     * @param rts <code>true</code>设置RTS, <code>false</code>清除RTS
     * @throws DeviceException  具体定义参考{@link DeviceException DeviceException}的文档。
     */
    void changeRTS(boolean rts) throws DeviceException;

    /**
     * 返回当前RTS状态
     * <p>
     * 
     * @return true, RTS已经被设置<br>
     *         false, RTS已被清除
     * @throws DeviceException  具体定义参考{@link DeviceException DeviceException}的文档。
     */
    boolean retrieveRTS() throws DeviceException;

    /**
     * 返回CTS状态
     * <p>
     * 
     * @return true, CTS已经被设置，false, CTS已经被清除
     * @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档。
     */
    boolean retrieveCTS() throws DeviceException;

    /**
     * 设置流控
     * <p>
     * 
     * @param flowControl 在<b>SerialPortDevice</b>中定义的常量：
     *            <ul>
     *            <li>FLOWCONTROL_NONE - 没有流控<li>
     *            FLOWCONTROL_RTSCTS_IN - RTS/CTS 输入硬件流控
     *            <li>FLOWCONTROL_RTSCTS_OUT - RTS/CTS 输出 硬件流控
     *            <li>FLOWCONTROL_RTSCTS_IN_OUT - RTS/CTS
     *            双向硬件流控<li>
     *            FLOWCONTROL_XONXOFF_IN - XON/XOFF 输入软流控
     *             <li>FLOWCONTROL_XONXOFF_OUT - XON/XOFF 输出软流控
     *             <li>FLOWCONTROL_XONXOFF_IN_OUT - XON/XOFF输入/输出 软流控
     *            </ul>
     * @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档。
     */
    void changeFlowControlMode(int flowControl) throws DeviceException;

    /**
     * 返回当前的流控设置
     * <p>
     * 
     * @return 返回<b>SerialPortDevice</b>中定义的常量：
     *            <ul>
     *            <li>FLOWCONTROL_NONE - 没有流控<li>
     *            FLOWCONTROL_RTSCTS_IN - RTS/CTS 输入硬件流控
     *            <li>FLOWCONTROL_RTSCTS_OUT - RTS/CTS 输出 硬件流控
     *            <li>FLOWCONTROL_RTSCTS_IN_OUT - RTS/CTS
     *            双向硬件流控<li>
     *            FLOWCONTROL_XONXOFF_IN - XON/XOFF 输入软流控
     *             <li>FLOWCONTROL_XONXOFF_OUT - XON/XOFF 输出软流控
     *             <li>FLOWCONTROL_XONXOFF_IN_OUT - XON/XOFF输入/输出 软流控
     *            </ul>
     * @throws DeviceException  具体定义参考{@link DeviceException DeviceException}的文档。
     */
    int getFlowControlMode() throws DeviceException;

    /**
     * 修改串口参数。
     * <p>
     * 
     * @param baudrate 波特率
     * @param dataBits 数据位<ul>
     *            <li>DATABITS_5 - 5 bits <li>DATABITS_6 - 6 bits <li>DATABITS_7
     *            - 7 bits <li>DATABITS_8 - 8 bits
     *            </ul>
     * @param stopBits 停止位<ul>
     *            <li>STOPBITS_1 - 1 stop bit <li>STOPBITS_2 - 2 stop bits <li>
     *            STOPBITS_1_5 - 1.5 stop bits
     *            </ul>
     * @param parity 奇偶校验位<ul>
     *            <li>PARITY_NONE - no parity <li>PARITY_ODD - odd parity <li>
     *            PARITY_EVEN - even parity
     *            </ul>
     * @throws DeviceException  具体定义参考{@link DeviceException DeviceException}的文档。
     */
    void changeSerialPortParams(int baudrate, int dataBits, int stopBits, int parity)
            throws DeviceException;

    /**
     * 将指定<code>data</code>数组中从偏移量<code>offset</code> 开始的<code>len</code>个字节写入串口。 
     * <p>
     * 
     * @param data 数据
     * @param offset 数据中的起始偏移量。
     * @param len 要写入的字节数。
     * @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档。
     */
    void write(byte[] data, int offset, int len) throws DeviceException;

    /**
     * 从包含的输入流中将最多<code>len</code>个字节读入一个<code>data</code> 数组中。
     * 尽量读取<code>len</code>个字节，但读取的字节数可能少于<code>len</code>个，也可能为零。以整数形式返回实际读取的字节数。
     * 如果<code>len</code>为零，则不读取任何字节并返回 0；否则，尝试读取至少一个字节。如果因为流位于文件未尾而没有字节可用，则返回值 -1；否则，至少读取一个字节并将其存储到<code>data</code>中。
     * <p>
     * 将读取的第一个字节存储到元素<code>data[offset]</code> 中，将下一个字节存储到<code>data[offset+1]</code>中，
     * 依此类推。读取的字节数至多等于<code>len</code>。
     * 设 k 为实际读取的字节数；这些字节将存储在<code>data[offset]</code>到<code>data[offset+k-1]</code>的元素中，<code>data[offset+k]</code>到<code>data[offset+len-1]</code>的元素不受影响。
     * 在所有情况下，<code>data[0]</code>到<code>data[offset]</code>的元素和<code>data[offset+len]</code>到<code>data[data.length-1]</code>的元素都不受影响。
     * <p>
     * 本方法会正确响应
     * {@link #cancelRequest()}方法来取消操作。
     *<p>本方法是一个异步方法，应用程序发出读取命令后，终端通过操作监听者{@link OperationListener#handleResult(OperationResult) handleResult()}方法返回结果。
     *每个应用程序必须定义自己的OperationListener，在回调函数handleResult()中对返回结果进行处理。如下所示：
     * <pre>
     * OperationListener operationListener = new OperationListener(){
     *     &#064;Override
     *     public void handleResult(OperationResult result) {
     *         // handleResult
     *     }
     * });
     * </pre>
     * <p>方法通过设置timeout来决定最多等待多长时间。请求开始执行的时候timeout开始计时。
     * <p>如果timeout时间到了，但还没有数据读到，也会回调函数handleResult()。此时
     * OperationResult会返回错误：{@link OperationResult#ERR_TIMEOUT ERR_TIMEOUT}，同时没有任何数据返回
     * <p>如果timeout是{@link TimeConstants#FOREVER FOREVER}，方法会一直等待，直到有数据返回或取消。
     * <p>如果timeout是{@link TimeConstants#IMMEDIATE IMMEDIATE}，方法会马上返回。
     * 
     * @param len 需要读取的最大长度
     * @param listener 操作监听者。
     * @param timeout 最大等待时间，通过时间常量设定{@link TimeConstants#SECOND SECOND},{@link TimeConstants#MilliSECOND MilliSECOND},
     * {@link TimeConstants#FOREVER FOREVER},{@link TimeConstants#IMMEDIATE IMMEDIATE}。
     * 
     * @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档。  
     * @see OperationListener#handleResult
     * @see SerialPortOperationResult
     * @see TimeConstants#FOREVER
     * @see TimeConstants#IMMEDIATE
     */
    void listenForRead(int len, OperationListener listener , int timeout) throws DeviceException;

    /**
     * 本方法是上述对应的
     * {@link #listenForRead(int, OperationListener, int)}方法的同步版本。
     * <p>
     * 只有当超时发生或者操作正常完成，本次调用才会返回。
     * <p>
     * 由于带有超时，本方法会响应{@link #cancelRequest()}方法。
     * <p>
     * 如果超时发生，会返回这个操作结果：
     * {@link OperationResult#ERR_TIMEOUT ERR_TIMEOUT}。
     * 
     * @param len 需要读取的最大长度
     * @param timeout 超时
     * @return 操作结果<code>SerialPortOperationResult</code>
     * @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档。  
     * @see SerialPortOperationResult
     * @see TimeConstants#FOREVER
     * @see TimeConstants#IMMEDIATE
     */
    SerialPortOperationResult waitForRead(int len, int timeout) throws DeviceException;
}
