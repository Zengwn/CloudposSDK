/*
 * PINPadDevice.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos.pinpad;

import com.unionpay.cloudpos.Device;
import com.unionpay.cloudpos.DeviceException;
import com.unionpay.cloudpos.OperationListener;
import com.unionpay.cloudpos.OperationResult;
import com.unionpay.cloudpos.TimeConstants;

/**
 * <b>PINPadDevice</b>定义了PIN输入设备的接口。
 * <p>PIN输入设备是智能销售点终端的核心组件之一，用于加密持卡人的PIN、计算交易报文MAC，加解密数据等，可做为共享资源供终端上所有应用使用。
 * 为了唯一标识PIN输入设备中的终端主密钥，PIN输入设备为每一套终端主密钥分配了一个密钥索引号。PIN输入设备的详细描述参考《银联卡受理终端安全规范-第8部分-智能销售点终端安全规范》
 * <p>设备对象通过<code>POSTerminal</code>的对应方法获得，如下所示：
 * <pre>
 * PINPadDevice pinPadDevice =
 *         (PINPadDevice) POSTerminal.getInstance().getDevice("cloudpos.device.pinpad");
 * </pre>
 * 其中，"cloudpos.device.pinpad"是标识PIN输入设备的字符串，由具体的实现定义。
 * <p>使用PIN输入设备对象，可以在PIN输入设备上显示文本，修改用户密钥，对数据加密，计算MAC，返回随机数。PIN输入设备输入PIN的操作有两种方式，一种是同步，一种是异步。同步方式会将主线程锁定，直到有结果返回，超时或者被取消。
 * 异步方式不会锁定主线程，当有结果时，会回调监听者{@link OperationListener#handleResult(OperationResult) handleResult()}方法。
 * <p>为了正常访问PIN输入设备，请在Android Manifest文件中设置PIN输入设备访问权限，具体如下所示：
 * <ol> <li>&lt;uses-permission android:name="android.permission.CLOUDPOS_PIN_GET_PIN_BLOCK"/>
 * 应用程序声明这个权限，可以调用{@link #listenForPinBlock(KeyInfo,  String, boolean,  OperationListener,  int)}及{@link #waitForPinBlock(KeyInfo, String, boolean,  int)}方法。
 * <li>&lt;uses-permission android:name="android.permission.CLOUDPOS_PIN_MAC"/>
 * 应用程序声明这个权限，可以调用{@link #calculateMac(KeyInfo, int, byte[])}方法。
 * <li>&lt;uses-permission android:name="android.permission.CLOUDPOS_PIN_ENCRYPT_DATA"/>，
 * 应用程序声明这个权限，可以调用{@link #encryptData(KeyInfo, byte[])}方法。
 * <li>&lt;uses-permission android:name="android.permission.CLOUDPOS_PIN_UPDATE_USER_KEY"/>，
 * 应用程序声明这个权限，可以调用{@link #updateUserKey(int, int, byte[],int, byte[])}及{@link #updateUserKey(int, int, byte[])}方法。
 * </ol>
 * <p>PIN输入设备可以是外接的，也可以是内置的。对于内置的情况，终端系统提供密码输入界面。
 * @see Device
 * @date August 10, 2015
 */
public interface PINPadDevice extends Device {
    /**
     * 密钥类型：DUKPT
     */
    int KEY_TYPE_DUKPT = 0;

    /**
     * 密钥类型：TDUKPT，三重DES的DUKPT
     */
    int KEY_TYPE_TDUKPT = 1;

    /**
     * 密钥类型：主密钥/会话密钥
     */
    int KEY_TYPE_MK_SK = 2;  

    /**
     * 密钥类型：固定密钥
     */
    int KEY_TYPE_FIX = 5;

    /**
     * PIN加密密钥
     */
    int USER_KEY_ID_PIN = 0;

    /**
     * MAC计算密钥
     */
    int USER_KEY_ID_MAC = 1;
    
    /**
     *  加密数据
     * */
    int USER_KEY_ID_DATA = 2;

    
    /**
     *  校验位的校验方式之一，无校验位验证。
     *  <p>
     *  用于更新工作密钥时使用。
     * */
    int CHECK_TYPE_NONE = 0; 
    
    /**
     *  校验位的校验方式之一，无校验位验证。
     *  <p>
     *  用于更新工作密钥时使用。
     *  用PIN key 对校验数据的8个字节进行计算，取头四个字节进行校验。
     * */
    int CHECK_TYPE_CUP = 0; 
    

    /**
     * 打开某个逻辑ID的PIN输入设备。
     * <p>
     * 
     * @param logicalID 设备逻辑ID，
     * @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档。
     */
    void open(int logicalID) throws DeviceException;

    /**
     * 在PIN输入设备上显示文本。
     * 
     * @param lineIndex 行号。
     * @param message 本行显示的信息。
     * @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档。
     * 或者以下原因：
     *             <ul>
     *             <li><code>message</code>太长</li>
     *             </ul>
     */
    void showText(int lineIndex, String message) throws DeviceException;
    
    /**
     * 在PIN输入设备上显示文本。
     * 
     * @param lineIndex 行号。
     * @param message 本行显示的信息。
     * @param voicePrompt 是否提示声音。
     * @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档。
     * 或者以下原因：
     *             <ul>
     *             <li><code>message</code>太长</li>
     *             </ul>
     */
    void showText(int lineIndex, String message, boolean voicePrompt) throws DeviceException;
    
    /**
     *  清空文本显示。
     *  
     *  @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档。
     * */
    void clearText() throws DeviceException;

    /**
     * 修改用户密钥，一般用于主密钥/会话密钥算法。
     * <p>用来更新的用户密钥数据是密文，是由给定的主密钥加密，因此更新时需要指定所使用的主密钥索引。
     * 用户密钥约定使用的是3des算法。
     * @param masterKeyID 用来解密的主密钥索引。
     * @param userKeyType    需要更新的用户密钥类型。
     * @param cipherNewUserKey   被主密钥加过密的用户密钥数据。
     * @param checkType	校验位校验类型：{@link #CHECK_TYPE_NONE}, {@link #CHECK_TYPE_CUP  }。
     * @param checkValue	校验pinpad。
     * @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档。
     */
    void updateUserKey(int masterKeyID, int userKeyType , byte[] cipherNewUserKey,int checkType , byte[] checkValue)  throws DeviceException;
   
    /**
     * 修改用户密钥，一般用于主密钥/会话密钥算法。
     * <p>
     * 用来更新的用户密钥数据是密文，是由给定的主密钥加密，因此更新时需要指定所使用的主密钥索引。
     * 用户密钥约定使用的是3des算法。
     * @param masterKeyID 用来解密的主密钥索引。
     * @param userKeyType    需要更新的用户密钥类型。
     * @param cipherNewUserKey   被主密钥加过密的用户密钥数据    。
     * @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档。
     */
    void updateUserKey(int masterKeyID, int userKeyType , byte[] cipherNewUserKey)  throws DeviceException;
   
    /**
     * 按照KeyInfo中选定的密钥进行数据加密，通常用于计算用户数据等操作。
     * 
     * @param keyInfo : 设置加密配置信息。
     * @param plain : 需要加密的明文。
     * @return 加完密的密文。
     * @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档。
     */
    byte[] encryptData(KeyInfo keyInfo, byte[] plain) throws DeviceException;

    /**
     * 让用户输入PIN，并且按照KeyInfo中选定的密钥进行PIN block的加密。最后返回加密结果。          
     *<p>本方法是一个异步方法，应用程序等待PIN输入设备输入命令后，终端通过操作监听者{@link OperationListener#handleResult(OperationResult) handleResult()}方法返回结果。
     * 每个应用程序必须定义自己的OperationListener，在回调函数handleResult()中对返回结果进行处理。如下所示：
     * <pre>
     * OperationListener operationListener = new OperationListener(){
     *     &#064;Override
     *     public void handleResult(OperationResult result) {
     *         // handleResult
     *     }
     * });
     * </pre>
     * <p>方法通过设置timeout来决定最多等待多长时间。请求开始执行的时候timeout开始计时。
     * <p>如果timeout时间到了，但还没有任何输入，也会回调函数handleResult()。此时
     * OperationResult会返回错误：{@link OperationResult#ERR_TIMEOUT ERR_TIMEOUT}，同时没有任何数据返回。
     * <p>如果timeout是{@link TimeConstants#FOREVER FOREVER}，方法的等待时间为PinPad的超时时间，在超时时间内会有数据返回或取消。如果到了PinPad的超时时间，没有任何输入，按timeout超时处理。
     * <p>如果timeout是{@link TimeConstants#IMMEDIATE IMMEDIATE}，方法会马上返回。
     * <p>本方法会正确响应
     * {@link #cancelRequest()}方法来取消操作。
     * <p>
     * @param keyInfo 密钥和算法配置信息。
     * @param pan 用户卡号的ASCII字符串。
     * @param voicePrompt 是否语音提示用户。
     * @param listener 本操作的动作监听者。
     * @param timeout 等待用户输入的时间。
     * @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档。  
     */
    
    void listenForPinBlock(KeyInfo keyInfo,  String pan, boolean voicePrompt,  OperationListener listener,  int timeout) throws DeviceException;
    /**
     * 本方法是上述对应的
     * {@link #listenForPinBlock(KeyInfo,  String, boolean,  OperationListener,  int)}方法的同步版本。
     * <p>
     * 只有当超时发生或者操作正常完成，本次调用才会返回。
     * <p>
     * 由于带有超时，本方法会响应{@link #cancelRequest()}方法。
     * <p>
     * 如果超时发生，会返回这个操作结果：
     * {@link OperationResult#ERR_TIMEOUT ERR_TIMEOUT}，同时没有任何数据返回。
     * 
     * @param keyInfo 密钥和算法配置信息。
     * @param pan 用户卡号的ASCII字符串。
     * @param voicePrompt 是否语音提示用户。
     * @param timeout 等待用户输入PIN的时间。
     * @return PIN block的密文。
     */
    PINPadOperationResult waitForPinBlock(KeyInfo keyInfo, String pan, boolean voicePrompt,  int timeout) throws DeviceException;

    /**
     * 按照KeyInfo中指定的密钥进行计算MAC。
     * <p>这里KeyInfo中，algorithm一般不需要指定。具体的MAC算法由macFlag参数指定。    
     * @param keyInfo 指定计算MAC的密钥。
     * @param macFlag  计算MAC的算法。如下所示：
     * <ol>
     * <li>X9.19 算法 ,后补 80：{@link AlgorithmConstants#ALG_MAC_METHOD_X919_80 ALG_MAC_METHOD_X919_80}
     * <li>银联 ECB 算法：{@link AlgorithmConstants#ALG_MAC_METHOD_ECB ALG_MAC_METHOD_ECB}。
     * <li>X9.19算法 (不足后补 0x00)：{@link AlgorithmConstants#ALG_MAC_METHOD_X919_X00 ALG_MAC_METHOD_X919_X00}移动支付项目使用。
     * <li> 中总行扩展算法：{@link AlgorithmConstants#ALG_MAC_METHOD_BOCE ALG_MAC_METHOD_BOCE}。
     * <li>X9.19算法 ,后补 00：{@link AlgorithmConstants#ALG_MAC_METHOD_X919_00 ALG_MAC_METHOD_X919_00}。
     * <li>异或后 3DES：{@link AlgorithmConstants#ALG_MAC_METHOD_XOR_3DES ALG_MAC_METHOD_XOR_3DES}。
     * <li>X9.9：{@link AlgorithmConstants#ALG_MAC_METHOD_X99 ALG_MAC_METHOD_X99}。
     * </ol>
     * @param plain 数据明文。
     * @return MAC。
     */
    byte[] calculateMac(KeyInfo keyInfo, int macFlag, byte[] plain) throws DeviceException;

    /**
     * 设置可输入PIN的长度限制。
     * 
     * @param minLen 最短有效PIN长度。
     * @param maxLen 最长有效PIN长度。
     */
    void setPINLength(int minLen, int maxLen) throws DeviceException;

    
    /**
     *  返回PINPad序列号。
     *  
     *  @return PINPad序列号。
     * */
    String getSN() throws DeviceException;
    
    /**
     *  返回随机数。
     *  
     *  @param length 随机数的长度。
     *  @return 随机数buffer流。
     * */
    byte[] getRandom(int length)  throws DeviceException;
}
