/*
 * EMVAIDParam.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos.emv;

import java.util.Map;

public class EMVAIDParam {

    private String AID;
    
    /* 选择标志（PART_MATCH 部分匹配FULL_MATCH 全匹配）
        0： PART_MATCH
        1： FULL_MATCH
     */
    private int selFlag;
    
    /* 终端联机PIN支持能力*/
    private boolean onlinePin;
    
    /* 电子现金终端交易限额*/
    private long ECTTLVal;

    /* 读卡器非接触CVM限额*/
    private long rdCVMLmt;

    /* 读卡器非接触交易限额*/
    private long rdClssTxnLmt;

    /* 读卡器非接触脱机最低限额*/
    private long rdClssFLmt;

    /* TTL存在?电子现金终端交易限额（EC Terminal Transaction Limit）*/
    private boolean ECTTLFlg;

    /* 是否存在读卡器非接触脱机最低限额*/
    private boolean rdClssFLmtFlg;

    /* 是否存在读卡器非接触交易限额*/
    private boolean rdClssTxnLmtFlg;

    /* 是否存在读卡器非接触CVM限额*/
    private boolean rdCVMLmtFlg;

    /* 目标百分比数*/
    private int targetPer;

    /* 最大目标百分比数*/
    private int maxTargetPer;

    /* 是否检查最低限额*/
    private boolean floorlimitCheck;

    /* 是否进行随机交易选择*/
    private boolean randTransSel;

    /* 是否进行频度检测*/
    private boolean velocityCheck;

    /* 最低限额*/
    private long floorLimit;

    /* 阀值*/
    private long threshold;

    /* 终端行为代码（拒绝）*/
    private String tacDenial;

    /* 终端行为代码（联机）*/
    private String tacOnline;

    /* 终端行为代码（缺省）*/
    private String tacDefault;

    /* 收单行标志*/
    private String acquierId;

    /* 终端缺省DDOL*/
    private String DDOL;

    /* 终端缺省TDOL*/
    private String TDOL;

    /* 应用版本*/
    private String version;

    /* 风险管理数据*/
    private String riskManageData;

    /* 扩展域*/
    private Map<String, Object> extField;

    /**
     * 获取AID。
     * @return AID 。
     *
     */
    public String getAID() {
        return AID;
    }
    
    /**
     * 设置AID。
     * @param aID AID。
     *
     */
    public void setAID(String aID) {
        AID = aID;
    }
    /**
     * 获取选择标志。
     * @return 选择标志 。
     *
     */
    public int getSelFlag() {
        return selFlag;
    } 
    
    /**
     * 设置选择标志。
     * @param selFlag 选择标志。
     *
     */
    public void setSelFlag(int selFlag) {
        this.selFlag = selFlag;
    }
    
    /**
     * 获取终端联机PIN支持能力。
     * @return 终端联机PIN支持能力 。
     *
     */
    public boolean isOnlinePin() {
        return onlinePin;
    }
    
    /**
     * 设置终端联机PIN支持能力。
     * @param onlinePin 终端联机PIN支持能力。
     *
     */
    public void setOnlinePin(boolean onlinePin) {
        this.onlinePin = onlinePin;
    }
    
    /**
     * 获取电子现金终端交易限额。
     * @return 电子现金终端交易限额 。
     *
     */
    public long getECTTLVal() {
        return ECTTLVal;
    }
    
    /**
     * 设置电子现金终端交易限额。
     * @param eCTTLVal 电子现金终端交易限额。
     *
     */
    public void setECTTLVal(long eCTTLVal) {
        ECTTLVal = eCTTLVal;
    }
    
    /**
     * 获取读卡器非接触CVM限额。
     * @return 读卡器非接触CVM限额 。
     *
     */
    public long getRdCVMLmt() {
        return rdCVMLmt;
    }
    
    /**
     * 设置读卡器非接触CVM限额。
     * @param rdCVMLmt 读卡器非接触CVM限额。
     *
     */
    public void setRdCVMLmt(long rdCVMLmt) {
        this.rdCVMLmt = rdCVMLmt;
    }
    
    /**
     * 获取读卡器非接触交易限额。
     * @return 读卡器非接触交易限额 。
     *
     */
    public long getRdClssTxnLmt() {
        return rdClssTxnLmt;
    }
    
    /**
     * 设置读卡器非接触交易限额。
     * @param rdClssTxnLmt 读卡器非接触交易限额。
     *
     */
    public void setRdClssTxnLmt(long rdClssTxnLmt) {
        this.rdClssTxnLmt = rdClssTxnLmt;
    }
    
    /**
     * 获取读卡器非接触脱机最低限额。
     * @return 读卡器非接触脱机最低限额 。
     *
     */
    public long getRdClssFLmt() {
        return rdClssFLmt;
    }
    
    /**
     * 设置读卡器非接触脱机最低限额。
     * @param rdClssFLmt 读卡器非接触脱机最低限额。
     *
     */
    public void setRdClssFLmt(long rdClssFLmt) {
        this.rdClssFLmt = rdClssFLmt;
    }
    
    /**
     * 获取TTL是否存在。
     * @return TTL是否存在 。
     *
     */
    public boolean isECTTLFlg() {
        return ECTTLFlg;
    }
    
    /**
     * 设置TTL是否存在。
     * @param eCTTLFlg TTL是否存在。
     *
     */
    public void setECTTLFlg(boolean eCTTLFlg) {
        ECTTLFlg = eCTTLFlg;
    }
    
    /**
     * 获取是否存在读卡器非接触脱机最低限额。
     * @return 是否存在读卡器非接触脱机最低限额 。
     *
     */
    public boolean isRdClssFLmtFlg() {
        return rdClssFLmtFlg;
    }
    
    /**
     * 设置是否存在读卡器非接触脱机最低限额。
     * @param rdClssFLmtFlg 是否存在读卡器非接触脱机最低限额。
     *
     */
    public void setRdClssFLmtFlg(boolean rdClssFLmtFlg) {
        this.rdClssFLmtFlg = rdClssFLmtFlg;
    }
    
    /**
     * 获取是否存在读卡器非接触交易限额。
     * @return 是否存在读卡器非接触交易限额 。
     *
     */
    public boolean isRdClssTxnLmtFlg() {
        return rdClssTxnLmtFlg;
    }
    
    /**
     * 设置是否存在读卡器非接触交易限额。
     * @param rdClssTxnLmtFlg 是否存在读卡器非接触交易限额。
     *
     */
    public void setRdClssTxnLmtFlg(boolean rdClssTxnLmtFlg) {
        this.rdClssTxnLmtFlg = rdClssTxnLmtFlg;
    }
    
    /**
     * 获取是否存在读卡器非接触CVM限额。
     * @return 是否存在读卡器非接触CVM限额 。
     *
     */
    public boolean isRdCVMLmtFlg() {
        return rdCVMLmtFlg;
    }
    
    /**
     * 设置是否存在读卡器非接触CVM限额。
     * @param rdCVMLmtFlg 是否存在读卡器非接触CVM限额。
     *
     */
    public void setRdCVMLmtFlg(boolean rdCVMLmtFlg) {
        this.rdCVMLmtFlg = rdCVMLmtFlg;
    }
    
    /**
     * 获取目标百分比数。
     * @return 目标百分比数 。
     *
     */
    public int getTargetPer() {
        return targetPer;
    }
    
    /**
     * 设置目标百分比数。
     * @param targetPer 目标百分比数。
     *
     */
    public void setTargetPer(int targetPer) {
        this.targetPer = targetPer;
    }
    
    /**
     * 获取最大目标百分比数。
     * @return 最大目标百分比数。
     *
     */
    public int getMaxTargetPer() {
        return maxTargetPer;
    }
    
    /**
     * 设置最大目标百分比数。
     * @param maxTargetPer 最大目标百分比数。
     *
     */
    public void setMaxTargetPer(int maxTargetPer) {
        this.maxTargetPer = maxTargetPer;
    }
    
    /**
     * 获取是否检查最低限额。
     * @return 是否检查最低限额 。
     *
     */
    public boolean isFloorlimitCheck() {
        return floorlimitCheck;
    }
    
    /**
     * 设置是否检查最低限额。
     * @param floorlimitCheck 是否检查最低限额。
     *
     */
    public void setFloorlimitCheck(boolean floorlimitCheck) {
        this.floorlimitCheck = floorlimitCheck;
    }
    
    /**
     * 获取是否进行随机交易选择。
     * @return 是否进行随机交易选择 。
     *
     */
    public boolean isRandTransSel() {
        return randTransSel;
    }
    
    /**
     * 设置是否进行随机交易选择。
     * @param randTransSel 是否进行随机交易选择。
     *
     */
    public void setRandTransSel(boolean randTransSel) {
        this.randTransSel = randTransSel;
    }
    
    /**
     * 获取是否进行频度检测。
     * @return 是否进行频度检测 。
     *
     */
    public boolean isVelocityCheck() {
        return velocityCheck;
    }
    
    /**
     * 设置是否进行频度检测。
     * @param velocityCheck 是否进行频度检测。
     *
     */
    public void setVelocityCheck(boolean velocityCheck) {
        this.velocityCheck = velocityCheck;
    }
    
    /**
     * 获取最低限额。
     * @return 最低限额 。
     *
     */
    public long getFloorLimit() {
        return floorLimit;
    }
    
    /**
     * 设置最低限额。
     * @param floorLimit 最低限额。
     *
     */
    public void setFloorLimit(long floorLimit) {
        this.floorLimit = floorLimit;
    }
    
    /**
     * 获取阀值。
     * @return 阀值 。
     *
     */
    public long getThreshold() {
        return threshold;
    }
    
    /**
     * 设置阀值。
     * @param threshold 阀值。
     *
     */
    public void setThreshold(long threshold) {
        this.threshold = threshold;
    }
    
    /**
     * 获取终端行为代码（拒绝）。
     * @return 终端行为代码（拒绝） 。
     *
     */
    public String getTacDenial() {
        return tacDenial;
    }
    
    /**
     * 设置获取终端行为代码（拒绝）。
     * @param tacDenial 获取终端行为代码（拒绝）。
     *
     */
    public void setTacDenial(String tacDenial) {
        this.tacDenial = tacDenial;
    }
    
    /**
     * 获取终端行为代码（联机）。
     * @return 终端行为代码（联机） 。
     *
     */
    public String getTacOnline() {
        return tacOnline;
    }
    
    /**
     * 设置终端行为代码（联机）。
     * @param tacOnline 终端行为代码（联机）。
     *
     */
    public void setTacOnline(String tacOnline) {
        this.tacOnline = tacOnline;
    }
    
    /**
     * 获取终端行为代码（缺省）。
     * @return 终端行为代码（缺省） 。
     *
     */
    public String getTacDefault() {
        return tacDefault;
    }
    
    /**
     * 设置终端行为代码（缺省）。
     * @param tacDefault 设置终端行为代码（缺省）。
     *
     */
    public void setTacDefault(String tacDefault) {
        this.tacDefault = tacDefault;
    }
    
    /**
     * 获取收单行标志。
     * @return 收单行标志 。
     *
     */
    public String getAcquierId() {
        return acquierId;
    }
    
    /**
     * 设置收单行标志。
     * @param acquierId 收单行标志。
     *
     */
    public void setAcquierId(String acquierId) {
        this.acquierId = acquierId;
    }
    
    /**
     * 获取终端缺省DDOL。
     * @return 终端缺省DDOL。
     *
     */
    public String getDDOL() {
        return DDOL;
    }
    
    /**
     * 设置终端缺省DDOL。
     * @param dDOL 终端缺省DDOL。
     *
     */
    public void setDDOL(String dDOL) {
        DDOL = dDOL;
    }
    
    /**
     * 获取终端缺省TDOL。
     * @return 终端缺省TDOL 。
     *
     */
    public String getTDOL() {
        return TDOL;
    }
    
    /**
     * 设置终端缺省TDOL。
     * @param tDOL 终端缺省TDOL。
     *
     */
    public void setTDOL(String tDOL) {
        TDOL = tDOL;
    }
    
    /**
     * 获取应用版本。
     * @return 应用版本 。
     *
     */
    public String getVersion() {
        return version;
    }
    
    /**
     * 设置应用版本。
     * @param version 应用版本。
     *
     */
    public void setVersion(String version) {
        this.version = version;
    }
    
    /**
     * 获取风险管理数据。
     * @return 风险管理数据 。
     *
     */
    public String getRiskManageData() {
        return riskManageData;
    }
    
    /**
     * 设置风险管理数据。
     * @param riskManageData 风险管理数据。
     *
     */
    public void setRiskManageData(String riskManageData) {
        this.riskManageData = riskManageData;
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
