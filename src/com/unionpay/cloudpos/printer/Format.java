/*
 * Format.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos.printer;

import java.util.HashMap;

import android.util.Log;



/**
 * 打印格式根接口，程序定义的打印格式必须实现该接口。
 * @date August 06, 2015 
 */
public class Format {
	private static final String TAG = "Format";
	
	private HashMap<String, String> mMap;

    private Format() {
        mMap = new HashMap<String, String>();
    }
	
	/**
     * 以键-值对的方式设置打印格式.
     *
     * @param key   打印格式主键
     * @param value 打印格式值
     */
    public void setParameter(String key, String value){
    	 if (key.indexOf('=') != -1 || key.indexOf(';') != -1) {
             Log.e(TAG, "Key \"" + key + "\" contains invalid character (= or ;)");
             return;
         }
         if (value.indexOf('=') != -1 || value.indexOf(';') != -1) {
             Log.e(TAG, "Value \"" + value + "\" contains invalid character (= or ;)");
             return;
         }
         mMap.put(key, value);
    };


    /**
     * 返回打印格式.
     *
     * @param key 传入主键
     * @return 打印格式
     */
    public String getParameter(String key){
    	
    	return mMap.get(key);
    };
    
    /**
     * 移除某一个参数
     *
     * @param key 传入主键
     * 
     */
    public void remove(String key) {
        mMap.remove(key);
    }
    /**
     * 清除所有打印格式.
     *
     */
    public void clear(){
    	mMap.clear();
    };

    
}
