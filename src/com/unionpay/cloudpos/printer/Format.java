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


/**
 * 打印格式根接口，程序定义的打印格式必须实现该接口。
 * @date August 06, 2015 
 */
public class Format {
	
	private HashMap<String, String> mMap;

    public Format() {
        mMap = new HashMap<String, String>();
    }
	
	/**
     * 以键-值对的方式设置打印格式.
     * <p>目前定义的键-值如下所示：
     * <ol><li>打印浓度（density）
     * <p>对应的值为：<code>light</code>(淡)，<code>medium</code>(中)，<code>dark</code>(深)。
     * <p>对字符，图形及条码打印都有效。
     * <li>加粗（bold）
     * <p>对应的值为：<code>true</code>(是)，<code>false</code>(否)。其中，<code>true</code>，<code>false</code>，不区分大小写。
     * <p>对字符打印有效。
     * <li>反白（reverse）
     * <p>对应的值为：<code>true</code>(是)，<code>false</code>(否)。其中，<code>true</code>，<code>false</code>，不区分大小写。
     * <p>对字符打印有效。
     * <li>上下倒置（inversion）
     * <p>对应的值为：<code>true</code>(是)，<code>false</code>(否)。其中，<code>true</code>，<code>false</code>，不区分大小写。
     * <p>对字符打印有效。
     * <li>删除线（line-through）
     * <p>对应的值为：<code>1</code>(连续的删除线)，<code>2</code>(断开的删除线)。
     * <p>对字符打印有效。
     * <li>大小（size）
     * <p>对应的值为：<code>extra-small</code>(特小)，<code>small</code>(小)，<code>medium</code>(中)，<code>large</code>(大)，<code>extra-large</code>(特大)。
     * <p>对字符打印有效。
     * <li>对齐方式（align）
     * <p>对应的值为：<code>left</code>(靠左)，<code>right</code>(靠右)，<code>center</code>(居中)。
     * <p>对字符及图形打印有效。
     * <li>斜体（italic）
     * <p>对应的值为：<code>true</code>(是)，<code>false</code>(否)。其中，<code>true</code>，<code>false</code>，不区分大小写。
     * <p>对字符打印有效。
     * <li>HRI字符的打印位置（HRI-location）
     * <p>对应的值为：<code>none</code>(不打印)，<code>up</code>(条码上方)，<code>down</code>(条码下方)，<code>up-down</code>(条码上下方)。
     * <p>对条码打印有效。
     * </ol>
     * @param key   打印格式主键
     * @param value 打印格式值
     */
    public void setParameter(String key, String value){
    	 if (key.indexOf('=') != -1 || key.indexOf(';') != -1) {
             return;
         }
         if (value.indexOf('=') != -1 || value.indexOf(';') != -1) {
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
