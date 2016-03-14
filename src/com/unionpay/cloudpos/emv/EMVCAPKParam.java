/*
 * EMVCAPKParam.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos.emv;

import java.util.Map;

public class EMVCAPKParam {

    /* 应用注册服务ID*/
    private String RID;
    
    /* 密钥索引*/
    private int keyID;
    
    /* HASH算法标志,SM算法时，值为07*/
    private int hashInd;
    
    /* RSA算法标志，SM算法时，值为04*/
    private int arithInd;

    /* 模，SM算法时，为公钥值*/
    private String modul;

    /* 指数，SM算法时，为0，不检查此数据项*/
    private String exponent;

    /* 有效期（YYMMDD）*/
    private String expDate;

    /* 密钥校验和*/
    private String checkSum;

    /* 扩展域*/
    private Map<String,Object> extField;
    

    /**
     * 获取应用注册服务ID。
     * @return 应用注册服务ID 。
     *
     */
    public String getRID() {
        return RID;
    }

    /**
     * 设置应用注册服务ID。
     * @param rID 应用注册服务ID。
     *
     */
    public void setRID(String rID) {
        RID = rID;
    }

    /**
     * 获取密钥索引。
     * @return 密钥索引 。
     *
     */
    public int getKeyID() {
        return keyID;
    }

    /**
     * 设置密钥索引。
     * @param keyID 密钥索引。
     *
     */
    public void setKeyID(int keyID) {
        this.keyID = keyID;
    }

    /**
     * 获取HASH算法标志。
     * @return HASH算法标志 。
     *
     */
    public int getHashInd() {
        return hashInd;
    }

    /**
     * 设置HASH算法标志。
     * @param hashInd HASH算法标志。
     *
     */
    public void setHashInd(int hashInd) {
        this.hashInd = hashInd;
    }

    /**
     * 获取RSA算法标志。
     * @return RSA算法标志 。
     *
     */
    public int getArithInd() {
        return arithInd;
    }

    /**
     * 设置RSA算法标志。
     * @param arithInd RSA算法标志。
     *
     */
    public void setArithInd(int arithInd) {
        this.arithInd = arithInd;
    }

    /**
     * 获取模。
     * @return 模 。
     *
     */
    public String getModul() {
        return modul;
    }

    /**
     * 设置模。
     * @param modul 模。
     *
     */
    public void setModul(String modul) {
        this.modul = modul;
    }

    /**
     * 获取指数。
     * @return 指数。
     *
     */
    public String getExponent() {
        return exponent;
    }

    /**
     * 设置指数。
     * @param exponent 指数。
     *
     */
    public void setExponent(String exponent) {
        this.exponent = exponent;
    }

    /**
     * 获取有效期。
     * @return 有效期。
     *
     */
    public String getExpDate() {
        return expDate;
    }

    /**
     * 设置有效期。
     * @param expDate 有效期。
     *
     */
    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    /**
     * 获取密钥校验和。
     * @return 密钥校验和 。
     *
     */
    public String getCheckSum() {
        return checkSum;
    }

    /**
     * 设置密钥校验和。
     * @param checkSum 密钥校验和。
     *
     */
    public void setCheckSum(String checkSum) {
        this.checkSum = checkSum;
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
