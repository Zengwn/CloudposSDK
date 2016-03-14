/*
 * PrinterDevice.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos.printer;

import android.graphics.Bitmap;

import com.unionpay.cloudpos.Device;
import com.unionpay.cloudpos.DeviceException;
import com.unionpay.cloudpos.TimeConstants;


/**
 * <b>PrinterDevice</b>定义了对打印机的操作方法。任何具体的实现都必须实现这个接口。
 * <p>设备对象通过<code>POSTerminal</code>的对应方法获得，如下所示：
 * <pre>
 * PrinterDevice printerDevice =
 *         (PrinterDevice) POSTerminal.getInstance().getDevice("cloudpos.device.printer");
 * </pre>
 * 其中，"cloudpos.device.printer"是标识磁条卡读卡器的字符串，由具体的实现定义。
 * <p>使用打印机设备对象可以打印文本，图片，条码，并且可以发送ESC指令。 
 * <p>为了正常访问打印机设备，请在Android Manifest文件中设置打印机访问权限，具体如下所示：
 * <pre> &lt;uses-permission android:name="android.permission.CLOUDPOS_PRINTER"/>
 * </pre> 
 * @date August 06, 2015
 * @see Device
 */
public interface PrinterDevice extends Device, TimeConstants
{
    /**
     * 下述条码常量主要针对某些可以直接打印条码的打印机。
     * <p>
     * UPC-A条形码。
     */
	public static final int BARCODE_UPC_A = 0;
	
    /**
     * UPC-E条形码。
     */
	public static final int BARCODE_UPC_E = 1;
	
    /**
     * JAN13条形码。
     */
	public static final int BARCODE_JAN13 = 2;
	
    /**
     * JAN8条形码。
     */
	public static final int BARCODE_JAN8 = 3;
	
    /**
     * CODE39码。
     */
	public static final int BARCODE_CODE39 = 4;
	
    /**
     * TIF码。
     */
	public static final int BARCODE_ITF = 5;
	
    /**
     * CODABAR。
     */
	public static final int BARCODE_CODABAR = 6;
	
    /**
     * CODE93。
     */
	public static final int BARCODE_CODE93 = 72;
	
    /**
     * CODE128。
     */
	public static final int BARCODE_CODE128 = 73;

	/**
	 * 没有HRI字符。
	 */
    int BARCODE_HRI_POS_NONE = 0;

    /**
     * HRI在条码上面。
     */
    int BARCODE_HRI_POS_ABOVE = 1;

    /**
     * HRI字符在条码下面。
     */
    int BARCODE_HRI_POS_BELOW = 2;

    /**
     * HRI字符在条码上下都有。
     */
    int BARCODE_HRI_POS_BOTH = 3;
    
    /**
     * 缺少打印纸张。
     * */
    public static final int STATUS_OUT_OF_PAPER = -101;
    /**
     * 打印机中已存在纸张。
     * */
    public static final int STATUS_PAPER_EXIST = 1;
   /**
    * 打开某个逻辑ID的打印机。
    * <p>打开成功，设备对象就和相应的逻辑ID的打印机建立了连接。此后可以进行后面的各项操作。
    * <p>设备对象去打开某个已经打开（被当前设备对象或其他设备对象）的逻辑ID的打印机会抛出异常{@link DeviceException#BAD_CONTROL_MODE BAD_CONTROL_MODE}。
    * <p>设备对象打开某个逻辑ID的打印机，再打开另外一个逻辑ID的打印机，会抛出异常{@link DeviceException#BAD_CONTROL_MODE BAD_CONTROL_MODE}。
    * 
    * @param logicalID  打印机逻辑ID，
    * @throws DeviceException 参考{@link DeviceException DeviceException}中的定义。
    */
    void open(int logicalID) throws DeviceException;

   /**
    * 打印字符串。
    * 
    * @param  message 打印的字符串数据。
    * @throws DeviceException 参考{@link DeviceException DeviceException}中的定义。
    */
   void printText(String message) throws DeviceException;
   
   /**
    * 打印字符串。
    * <p>通过format对象来控制打印字符串的格式。如果通过这个接口传入了format对象，那么打印机后续的打印也按照这个format对象所包含的格式来执行。
    * <p>如果有新的带有format对象的接口被调用，那么会合并新的格式。打印机后续的打印也按照新的合并后的格式执行。
    * <p>合并的原则是：新的format对象中存在旧的format对象中不存在的格式，那么该格式会包含进去；新旧format中都存在的，用新的格式替换旧的。
    * 
    * @param format 用于控制字符串格式。
    * @param  message 打印的字符串数据。
    * @throws DeviceException 参考{@link DeviceException DeviceException}中的定义。
    */
   void printText(Format format, String message) throws DeviceException;
   /**
    * 打印图片。
    * 
    * @param bitmap 
    * @throws DeviceException 参考{@link DeviceException DeviceException}中的定义。
    */
   void printBitmap(Bitmap bitmap) throws DeviceException;
   /**
    * 打印图片。
    * <p>通过format对象来控制打印图片的格式。如果通过这个接口传入了format对象，那么打印机后续的打印也按照这个format对象所包含的格式来执行。
    * <p>如果有新的带有format对象的接口被调用，那么会合并新的格式。打印机后续的打印也按照新的合并后的格式执行。
    * <p>合并的原则是：新的format对象中存在旧的format对象中不存在的格式，那么该格式会包含进去；新旧format中都存在的，用新的格式替换旧的。
    * @param bitmap 
    * @param format 参考{@link Format Format}中的定义。
    * @throws DeviceException 参考{@link DeviceException DeviceException}中的定义。
    */
   void printBitmap(Format format,Bitmap bitmap) throws DeviceException;
   /**
    * 打印条码。
    * <p>通过format对象来控制打印条码的格式。如果通过这个接口传入了format对象，那么打印机后续的打印也按照这个format对象所包含的格式来执行。
    * <p>如果有新的带有format对象的接口被调用，那么会合并新的格式。打印机后续的打印也按照新的合并后的格式执行。
    * <p>合并的原则是：新的format对象中存在旧的format对象中不存在的格式，那么该格式会包含进去；新旧format中都存在的，用新的格式替换旧的。
    * @param format 条码格式，参考{@link Format Format}中的定义。
    * @param barcodeType 见本接口定义的常量。
    * @param barcode 条码内容。
    * @throws DeviceException 参考{@link DeviceException DeviceException}中的定义。
    */
   void printBarcode(Format format, int barcodeType, String barcode) throws DeviceException;
   
   /**
    * 通用发送ESC指令，并获得可能的返回结果。
    * <p>打印指令的详细定义由厂商给出。
    * 
    * @param esc ESC指令数据
    * @return 发送结果返回值
    * @throws DeviceException 参考{@link DeviceException DeviceException}中的定义。
    */
   int sendESCCommand(byte[] esc) throws DeviceException;
   
   /**
    *  切纸，但仅仅是支持的打印机才会有此功能。
    *  
    *  @throws DeviceException 参考{@link DeviceException DeviceException}中的定义。
    * */
   void cutPaper()  throws DeviceException;
   
   /**
    *  查询打印机纸张状态
    *  
    *  @return {@code -101} 缺纸 ,{@code 1}打印机状态正常 ,{@code -102} 打印机异常 .    
    * */
   int queryStatus() throws DeviceException;
   
   /**
    * 返回默认的打印格式。    
    * 
    * @return 打印格式。
    * @throws DeviceException 参考{@link DeviceException DeviceException}中的定义。
    */
   Format getDefaultParameters() throws DeviceException;
   
}
