/*
 * EMVTermConfig.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos.emv;

import java.util.Map;

import com.unionpay.cloudpos.OperationResult;

public class EMVTermConfig {
    
    /* 参考货币代码和交易代码的转换系数（交易货币对参考货币的汇率*1000）*/
    private long referCurrCon;

    /* 商户名*/
    private String merchName;

    /* 商户类别码（没要求可不设置）*/
    private String merchCateCode;

    /* 商户标志（商户号）*/
    private String merchId;

    /* 终端标志（POS号）*/
    private String termId;

    /* 终端类型，表明终端环境、通讯能力和操作控制，9F35（tag）（参考PBOC规范）*/
    private int termType;

    /* 终端性能，表示终端的卡片数据输入，CVM和安全能力，9F33（tag）（参考PBOC规范）*/
    private String capability;

    /* 附加终端性能，表明终端的数据输入输出能力（参考PBOC规范）*/
    private String extCapability;
    
    /* 交易货币代码，表示根据ISO 4217规定的交易货币代码*/
    private String transCurrCode;
    
    /* 交易货币指数，表示根据ISO 4217规定的从交易金额右起的隐含小数点位置*/
    private int transCurrExp;

    /* 参考货币代码*/
    private String referCurrCode;

    /* 参考货币指数*/
    private int referCurrExp;

    /* 终端国家代码，标识根据ISO3166表示的终端国家代码，9F1A（tag）*/
    private String countryCode;

    /* 扩展域*/
    private Map<String,Object> extField;
    
    /**
     * 获取参考货币代码和交易代码的转换系数。
     * @return 参考货币代码和交易代码的转换系数 。
     *
     */
    public long getReferCurrCon() {
        return referCurrCon;
    }
    
    /**
     * 设置参考货币代码和交易代码的转换系数。
     * @param referCurrCon 参考货币代码和交易代码的转换系数。
     *
     */
    public void setReferCurrCon(long referCurrCon) {
        this.referCurrCon = referCurrCon;
    }
    
    /**
     * 获取商户名。
     * @return 商户名 。
     *
     */
    public String getMerchName() {
        return merchName;
    }
    
    /**
     * 设置商户名。
     * @param merchName 商户名。
     *
     */
    public void setMerchName(String merchName) {
        this.merchName = merchName;
    }
    
    /**
     * 获取商户类别码。
     * @return 商户类别码 。
     *
     */
    public String getMerchCateCode() {
        return merchCateCode;
    }
    
    /**
     * 设置商户类别码。
     * @param merchCateCode 商户类别码。
     *
     */
    public void setMerchCateCode(String merchCateCode) {
        this.merchCateCode = merchCateCode;
    }
    
    /**
     * 获取商户标志（商户号）。
     * @return 商户标志（商户号） 。
     *
     */
    public String getMerchId() {
        return merchId;
    }
    
    /**
     * 设置商户标志（商户号）。
     * @param merchId 商户标志（商户号）。
     *
     */
    public void setMerchId(String merchId) {
        this.merchId = merchId;
    }
    
    /**
     * 获取终端标志（POS号）。
     * @return 终端标志（POS号） 。
     *
     */
    public String getTermId() {
        return termId;
    }
    
    /**
     * 设置终端标志（POS号）。
     * @param termId 终端标志（POS号）。
     *
     */
    public void setTermId(String termId) {
        this.termId = termId;
    }
    
    /**
     * 获取终端类型。
     * @return 终端类型 。
     *
     */
    public int getTermType() {
        return termType;
    }
    
    /**
     * 设置终端类型（参考PBOC规范）。
     * @param termType 终端类型。
     *
     */
    public void setTermType(int termType) {
        this.termType = termType;
    }
    
    /**
     * 获取终端性能。
     * @return 终端性能 。
     *
     */
    public String getCapability() {
        return capability;
    }
    
    /**
     * 设置终端性能（参考PBOC规范）。
     * @param capability 终端性能。
     *
     */
    public void setCapability(String capability) {
        this.capability = capability;
    }
    
    /**
     * 获取附加终端性能。
     * @return 附加终端性能 。
     *
     */
    public String getExtCapability() {
        return extCapability;
    }
    
    /**
     * 设置附加终端性能（参考PBOC规范）。
     * @param extCapability 附加终端性能。
     *
     */
    public void setExtCapability(String extCapability) {
        this.extCapability = extCapability;
    }
    
    /**
     * 获取交易货币代码指数。
     * @return 交易货币代码指数 。
     *
     */
    public int getTransCurrExp() {
        return transCurrExp;
    }
    
    /**
     * 设置交易货币代码指数。
     * @param transCurrExp 交易货币代码指数。
     *
     */
    public void setTransCurrExp(int transCurrExp) {
        this.transCurrExp = transCurrExp;
    }
    
    /**
     * 获取参考货币指数。
     * @return 参考货币指数。
     *
     */
    public int getReferCurrExp() {
        return referCurrExp;
    }
    
    /**
     * 设置参考货币指数。
     * @param referCurrExp 参考货币指数。
     *
     */
    public void setReferCurrExp(int referCurrExp) {
        this.referCurrExp = referCurrExp;
    }
    
    /**
     * 获取参考货币代码。
     * @return 参考货币代码。
     *
     */
    public String getReferCurrCode() {
        return referCurrCode;
    }
    
    /**
     * 设置参考货币代码。
     * @param referCurrCode 参考货币代码。
     *
     */
    public void setReferCurrCode(String referCurrCode) {
        this.referCurrCode = referCurrCode;
    }
    
    /**
     * 获取国家代码。
     * @return 国家代码 。
     *
     */
    public String getCountryCode() {
        return countryCode;
    }
    
    /**
     * 设置国家代码。
     * @param countryCode 国家代码。
     *
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    
    /**
     * 获取交易货币代码。
     * @return 交易货币代码。
     *
     */
    public String getTransCurrCode() {
        return transCurrCode;
    }
    
    /**
     * 设置交易货币代码。
     * @param transCurrCode 交易货币代码，若为人民币账户，{@link EMVConstants#Currency_Code_RMB}；
     * 若为积分账户，{@link EMVConstants#Currency_Code_JIFEN}；若为其他币种，根据ISO货币代码填写。
     *
     */
    public void setTransCurrCode(String transCurrCode) {
        this.transCurrCode = transCurrCode;
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
