/*
 * POSTerminal.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos;

import java.io.File;

import dalvik.system.DexClassLoader;
import android.content.Context;


/**
 * 设备管理器<b>POSTerminal</b> 是获得每个设备的入口。
 * <p>
 * 获取该对象不能使用new方法，可以通过getInstance方法获得。
 *
 * @date August 06, 2015
 */
public abstract class POSTerminal {
	
//	  public static final String DEVICE_NAME_MSR = "cloudpos.device.msr";
//
//    public static final String DEVICE_NAME_HSM = "cloudpos.device.hsm";
//
//    public static final String DEVICE_NAME_RF_CARD_READER = "cloudpos.device.rfcardreader";
//
//    public static final String DEVICE_NAME_IDCARD_READER = "cloudpos.device.idcardreader";
//
//    public static final String DEVICE_NAME_PRINTER = "cloudpos.device.printer";
//
//    public static final String DEVICE_NAME_PINPAD = "cloudpos.device.pinpad";
//
//    public static final String DEVICE_NAME_SMARTCARD_READER = "cloudpos.device.smartcardreader";
//
//    public static final String DEVICE_NAME_SERIALPORT = "cloudpos.device.serialport";
//
//	  public static final String DEVICE_NAME_LED = "cloudpos.device.led";
//
//    public static final String DEVICE_NAME_CASH_DRAWER = "cloudpos.device.cashdrawer";
//
//    public static final String DEVICE_NAME_SECONDARY_DISPLAY = "cloudpos.device.secondarydisplay";

	/**
	 *  系统属性
	 * */
	public static final String POS_TERMINAL_CLASS = "cloudpos.terminal.class";
    private static POSTerminal self = null;
    
    /**
     *  SDK实现jar包的路径。
     * */
    private static final String LOAD_JAR_PATH = "/data/cloudpossdk/cloudpossdkimpl.jar";
    
    protected static Context androidContext = null;
     

    /**
     * 返回设备管理器的实例对象。终端系统默认的className是：“com.unionpay.cloudpos.impl.POSTerminalImpl”
     * <p>可以通过System.setProperty(POSTerminal.POS_TERMINAL_CLASS, "com.unionpay.cloudpos.impl.POSTerminalImpl")设置系统属性。
     * <p>如果未设置，将取默认名称。
     *
     * 
     * @return 设备管理器
     */
    public static synchronized POSTerminal getInstance(Context context) {
        androidContext = context;
        if (self == null) {
            Object terminalObj = null;
            String className = System.getProperty(POS_TERMINAL_CLASS);
            if(className==null){
                className = "com.unionpay.cloudpos.impl.POSTerminalImpl";
            }
            try {
            	//从系统指定路径中加载sdk实现。
            	File dexOutputDir = context.getDir("dex", Context.MODE_PRIVATE);
            	DexClassLoader dexClassLoader = new DexClassLoader(LOAD_JAR_PATH, dexOutputDir.getAbsolutePath(), null,  POSTerminal.class.getClassLoader());// success
            	Class<?>  clazz = dexClassLoader.loadClass(className);
    			// return the real implementation
    			terminalObj = clazz.newInstance();
    			if(terminalObj instanceof POSTerminal){
    				self = (POSTerminal)terminalObj;
    			}
    		} catch (Exception e) {
    			//无法从指定目录获得sdk对象。
    			e.printStackTrace();
    		}
            
            if(self == null){
//            	从系统中加载默认的sdk实现地址。
            	 
                 try {
     				Class<?> clazz = Class.forName(className);
     				// return the real implementation :cloudpos.terminal.class.
     				terminalObj = clazz.newInstance();
     				if(terminalObj instanceof POSTerminal){
     					self = (POSTerminal)terminalObj;
     				}
     			} catch (ClassNotFoundException e) {
     				e.printStackTrace();
     			}catch (InstantiationException e) {
     				e.printStackTrace();
     			} catch (IllegalAccessException e) {
     				e.printStackTrace();
     			}
            }
        }
        return self;
    }
       
    /**
     * 返回终端的详细描述。
     * 
     * @return TerminalSpec
     * @see TerminalSpec
     */
    abstract public TerminalSpec getTerminalSpec();
    
    /**
     * 列出所有设备名称标识。
     * 
     * @return String[]
     */
    abstract public String[] listDevices();

    /**
     * 判断设备是否存在。
     * @param deviceName
     * @return boolean
     */
    abstract public boolean isDeviceExist(String deviceName);

    /**
     * 返回设备对象。
     * @param deviceName
     * @return Device 设备对象
     */
    abstract public Device getDevice(String deviceName);
    
    /**
     * 返回设备详细描述
     * 
     * @return DeviceSpec 设备详细描述
     */
    abstract public DeviceSpec getDeviceSpec(String deviceName);
    
}
