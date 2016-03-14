/*
 * EMVTransData.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos.emv;

import java.util.Map;

public class EMVTransData {
    
    /* 交易金额*/
    private long amount;    

    /* 其他金额*/
    private long otherAmount;

    /* 交易类型*/
    private byte transType;

    /* 交易日期，YYYYMMDD*/
    private String transDate;

    /* 交易时间，HHMMSS*/
    private String transTime;

    /* 交易序号*/
    private String traceNo;

    /* 是否支持国密*/
    private boolean isSupportSM;

    /* 是否执行脱机数据认证*/
    private boolean isCardAuth;

    /* 是否强制联机*/
    private boolean isForceOnline;

    /* 是否电子现金交易*/
    private boolean isSupportEC;

    /* 是否执行CVM*/
    private boolean isSupportCVM;

    /* 流程类型，0x01：标准的授权过程；0x02：简易流程；0x03：qPBOC流程*/
    private int flow;

    /* 通道类型，0：接触式 ；1：非接触式*/
    private int channelType;

    /* 扩展域*/
    private Map<String,Object> extField;
    
    /**
     * 获取交易金额。
     * @return 交易金额 。
     *
     */
    public long getAmount() {
        return amount;
    }
    
    /**
     * 设置交易金额。
     * @param amount 交易金额。
     *
     */
    public void setAmount(long amount) {
        this.amount = amount;
    }
    
    /**
     * 获取其他金额。
     * @return 其他金额 。
     *
     */
    public long getOtherAmount() {
        return otherAmount;
    }
    
    /**
     * 设置其他金额。
     * @param otherAmount 其他金额。
     *
     */
    public void setOtherAmount(long otherAmount) {
        this.otherAmount = otherAmount;
    }
    
    /**
     * 获取交易类型。
     * @return 交易类型 。
     *
     */
    public byte getTransType() {
        return transType;
    }
    
    /**
     * 设置交易类型。
     * @param transType 交易类型。
     *
     */
    public void setTransType(byte transType) {
        this.transType = transType;
    }
    
    /**
     * 获取交易日期，YYYYMMDD。
     * @return 交易日期 。
     *
     */
    public String getTransDate() {
        return transDate;
    }
    
    /**
     * 设置交易日期，YYYYMMDD。
     * @param transDate 交易日期，YYYYMMDD
     *
     */
    public void setTransDate(String transDate) {
        this.transDate = transDate;
    }
    
    /**
     * 获取交易时间，HHMMSS。
     * @return 交易时间，HHMMSS 。
     *
     */
    public String getTransTime() {
        return transTime;
    }
    
    /**
     * 设置交易时间，HHMMSS。
     * @param transTime 交易时间，HHMMSS。
     *
     */
    public void setTransTime(String transTime) {
        this.transTime = transTime;
    }
    
    /**
     * 获取交易序号。
     * @return 交易序号 。
     *
     */
    public String getTraceNo() {
        return traceNo;
    }
    
    /**
     * 设置交易序号。
     * @param traceNo 交易序号。
     *
     */
    public void setTraceNo(String traceNo) {
        this.traceNo = traceNo;
    }
    
    /**
     * 获取是否支持国密。
     * @return 是否支持国密 。
     *
     */
    public boolean isSupportSM() {
        return isSupportSM;
    }
    
    /**
     * 设置是否支持国密。
     * @param isSupportSM 是否支持国密。
     *
     */
    public void setSupportSM(boolean isSupportSM) {
        this.isSupportSM = isSupportSM;
    }
    
    /**
     * 获取是否执行脱机数据认证。
     * @return 是否执行脱机数据认证 。
     *
     */
    public boolean isCardAuth() {
        return isCardAuth;
    }
    
    /**
     * 设置是否执行脱机数据认证。
     * @param isCardAuth 是否执行脱机数据认证。
     *
     */
    public void setCardAuth(boolean isCardAuth) {
        this.isCardAuth = isCardAuth;
    }
    
    /**
     * 获取是否强制联机。
     * @return 是否强制联机 。
     *
     */
    public boolean isForceOnline() {
        return isForceOnline;
    }
    
    /**
     * 设置是否强制联机。
     * @param isForceOnline 是否强制联机。
     *
     */
    public void setForceOnline(boolean isForceOnline) {
        this.isForceOnline = isForceOnline;
    }
    
    /**
     * 获取是否电子现金交易。
     * @return 是否电子现金交易 。
     *
     */
    public boolean isSupportEC() {
        return isSupportEC;
    }
    
    /**
     * 设置是否电子现金交易。
     * @param isSupportEC 是否电子现金交易。
     *
     */
    public void setSupportEC(boolean isSupportEC) {
        this.isSupportEC = isSupportEC;
    }
    
    /**
     * 获取是否执行CVM。
     * @return 是否执行CVM 。
     *
     */
    public boolean isSupportCVM() {
        return isSupportCVM;
    }
    
    /**
     * 设置是否执行CVM。
     * @param isSupportCVM 是否执行CVM。
     *
     */
    public void setSupportCVM(boolean isSupportCVM) {
        this.isSupportCVM = isSupportCVM;
    }
    
    /**
     * 获取流程类型。
     * @return 流程类型。
     *
     */
    public int getFlow() {
        return flow;
    }
    
    /**
     * 设置流程类型。
     * @param flow 流程类型，0x01：标准的授权过程；0x02：简易流程；0x03：qPBOC流程。
     *
     */
    public void setFlow(int flow) {
        this.flow = flow;
    }
    
    /**
     * 获取通道类型。
     * @return 通道类型 。
     *
     */
    public int getChannelType() {
        return channelType;
    }
    
    /**
     * 设置通道类型。
     * @param channelType 通道类型，0：接触式 ；1：非接触式。
     *
     */
    public void setChannelType(int channelType) {
        this.channelType = channelType;
    }
    
    /**
     * 获取扩展域。
     * @return 扩展域 。
     *
     */
    public Map<String, Object> getExtField() {
        return extField;
    }
    
    /**
     * 设置扩展域。
     * @param extField 扩展域。
     *
     */
    public void setExtField(Map<String, Object> extField) {
        this.extField = extField;
    }
}
