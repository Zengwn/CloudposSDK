/*
 * EMVCardLog.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos.emv;

public class EMVCardLog {
    
    /* 交易金额存在标识*/
    private boolean isAmountExist;

    /* 交易金额*/
    private long amount;

    /* 其它金额存在标识*/
    private boolean isOtherAmountExist;

    /* 其它金额*/
    private long otherAmount;

    /* 交易日期（YYMMDD）存在标识*/
    private boolean isDateExist;

    /* 交易日期（YYMMDD）*/
    private String transDate;

    /* 交易时间存在标识*/
    private boolean isTimeExist;

    /* 交易时间*/
    private String transTime;

    /* 国家代码存在标识*/
    private boolean isCountryCodeExist;

    /* 国家代码（9F1A）*/
    private String countryCode;

    /* 货币代码存在标识*/
    private boolean isCurrencyExist;

    /* 货币代码（5F2A）*/
    private String currencyCode;

    /* 交易计数器存在标识*/
    private boolean isATCExist;

    /* 交易计数器（9F36）*/
    private String ATC;
    
    /* 交易类型存在标识*/
    private boolean isTransTypeExist;

    /* 交易类型（9C）*/
    private byte transType;

    /* 商户名称存在标识*/
    private boolean isMerchNameExist;

    /* 商户名称（9F4E）*/
    private String merchName;

    /* 本结构中未定义的其它数据元按照TLV 列表的格式保存在TLV中*/
    private String otherTLVLog;

    /**
     * 获取交易金额存在标识。
     * @return 交易金额存在标识 。
     *
     */
    public boolean isAmountExist() {
        return isAmountExist;
    }

    /**
     * 设置交易金额存在标识。
     * @param isAmountExist 交易金额存在标识。
     *
     */
    public void setAmountExist(boolean isAmountExist) {
        this.isAmountExist = isAmountExist;
    }

    /**
     * 获取交易金额。
     * @return 交易金额。
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
     * 获取其它金额存在标识。
     * @return 其它金额存在标识 。
     *
     */
    public boolean isOtherAmountExist() {
        return isOtherAmountExist;
    }

    /**
     * 设置其它金额存在标识。
     * @param isOtherAmountExist 其它金额存在标识。
     *
     */
    public void setOtherAmountExist(boolean isOtherAmountExist) {
        this.isOtherAmountExist = isOtherAmountExist;
    }

    /**
     * 获取其它金额。
     * @return 其它金额。
     *
     */
    public long getOtherAmount() {
        return otherAmount;
    }

    /**
     * 设置其它金额。
     * @param otherAmount 其它金额。
     *
     */
    public void setOtherAmount(long otherAmount) {
        this.otherAmount = otherAmount;
    }

    /**
     * 获取交易日期（YYMMDD）存在标识。
     * @return 获取交易日期（YYMMDD）存在标识 。
     *
     */
    public boolean isDateExist() {
        return isDateExist;
    }

    /**
     * 设置获取交易日期（YYMMDD）存在标识。
     * @param isDateExist 获取交易日期（YYMMDD）存在标识。
     *
     */
    public void setDateExist(boolean isDateExist) {
        this.isDateExist = isDateExist;
    }

    /**
     * 获取交易日期。
     * @return 交易日期。
     *
     */
    public String getTransDate() {
        return transDate;
    }

    /**
     * 设置交易日期。
     * @param transDate 交易日期。
     *
     */
    public void setTransDate(String transDate) {
        this.transDate = transDate;
    }

    /**
     * 获取交易时间存在标识。
     * @return 交易时间存在标识 。
     *
     */
    public boolean isTimeExist() {
        return isTimeExist;
    }

    /**
     * 设置交易时间存在标识。
     * @param isTimeExist 交易时间存在标识。
     *
     */
    public void setTimeExist(boolean isTimeExist) {
        this.isTimeExist = isTimeExist;
    }

    /**
     * 获取交易时间。
     * @return 交易时间 。
     *
     */
    public String getTransTime() {
        return transTime;
    }

    /**
     * 设置交易时间。
     * @param transTime 交易时间。
     *
     */
    public void setTransTime(String transTime) {
        this.transTime = transTime;
    }

    /**
     * 获取国家代码存在标识。
     * @return 国家代码存在标识 。
     *
     */
    public boolean isCountryCodeExist() {
        return isCountryCodeExist;
    }

    /**
     * 设置国家代码存在标识。
     * @param isCountryCodeExist 国家代码存在标识。
     *
     */
    public void setCountryCodeExist(boolean isCountryCodeExist) {
        this.isCountryCodeExist = isCountryCodeExist;
    }

    /**
     * 获取国家代码（9F1A）。
     * @return 国家代码（9F1A） 。
     *
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * 设置国家代码（9F1A）。
     * @param countryCode 国家代码（9F1A）。
     *
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * 获取货币代码存在标识。
     * @return 货币代码存在标识 。
     *
     */
    public boolean isCurrencyExist() {
        return isCurrencyExist;
    }

    /**
     * 设置货币代码存在标识。
     * @param isCurrencyExist 货币代码存在标识。
     *
     */
    public void setCurrencyExist(boolean isCurrencyExist) {
        this.isCurrencyExist = isCurrencyExist;
    }

    /**
     * 获取货币代码（5F2A）。
     * @return 货币代码（5F2A） 。
     *
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * 设置货币代码（5F2A）。
     * @param currencyCode 货币代码（5F2A）。
     *
     */
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    /**
     * 获取交易计数器存在标识。
     * @return 交易计数器存在标识 。
     *
     */
    public boolean isATCExist() {
        return isATCExist;
    }

    /**
     * 设置交易计数器存在标识。
     * @param isATCExist 交易计数器存在标识。
     *
     */
    public void setATCExist(boolean isATCExist) {
        this.isATCExist = isATCExist;
    }

    /**
     * 获取交易计数器（9F36）。
     * @return 交易计数器（9F36）。
     *
     */
    public String getATC() {
        return ATC;
    }

    /**
     * 设置交易计数器（9F36）。
     * @param aTC 交易计数器（9F36）。
     *
     */
    public void setATC(String aTC) {
        ATC = aTC;
    }

    /**
     * 获取交易类型存在标识。
     * @return 交易类型存在标识。
     *
     */
    public boolean isTransTypeExist() {
        return isTransTypeExist;
    }

    /**
     * 设置交易类型存在标识。
     * @param isTransTypeExist 交易类型存在标识。
     *
     */
    public void setTransTypeExist(boolean isTransTypeExist) {
        this.isTransTypeExist = isTransTypeExist;
    }

    /**
     * 获取交易类型（9C）。
     * @return 交易类型（9C） 。
     *
     */
    public byte getTransType() {
        return transType;
    }

    /**
     * 设置交易类型（9C）。
     * @param transType 交易类型（9C）。
     *
     */
    public void setTransType(byte transType) {
        this.transType = transType;
    }

    /**
     * 获取商户名称存在标识。
     * @return 商户名称存在标识 。
     *
     */
    public boolean isMerchNameExist() {
        return isMerchNameExist;
    }

    /**
     * 设置商户名称存在标识。
     * @param isMerchNameExist 商户名称存在标识。
     *
     */
    public void setMerchNameExist(boolean isMerchNameExist) {
        this.isMerchNameExist = isMerchNameExist;
    }

    /**
     * 获取商户名称（9F4E）。
     * @return 商户名称（9F4E） 。
     *
     */
    public String getMerchName() {
        return merchName;
    }

    /**
     * 设置商户名称（9F4E）。
     * @param merchName 商户名称（9F4E）。
     *
     */
    public void setMerchName(String merchName) {
        this.merchName = merchName;
    }

    /**
     * 获取本结构中未定义的其它数据元按照TLV 列表的格式保存在TLV中。
     * @return 本结构中未定义的其它数据元按照TLV 列表的格式保存在TLV中 。
     *
     */
    public String getOtherTLVLog() {
        return otherTLVLog;
    }

    /**
     * 设置本结构中未定义的其它数据元按照TLV 列表的格式保存在TLV中。
     * @param otherTLVLog 本结构中未定义的其它数据元按照TLV 列表的格式保存在TLV中
     *
     */
    public void setOtherTLVLog(String otherTLVLog) {
        this.otherTLVLog = otherTLVLog;
    }

    
}
