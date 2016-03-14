/*
 * OnlineResult.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */
package com.unionpay.cloudpos.emv;

public class OnlineResult {
    /* 联机交易结果值 0:成功；-1：取消；-2：失败*/
    private int resultCode;
    
    /* 55域内容*/
    private byte[] field55;
    
    /* 39域内容*/
    private byte[] Field39;
    
    /**
     * 获取联机交易结果值。
     * @return 联机交易结果值 。
     *
     */
    public int getResultCode() {
        return resultCode;
    }
    
    /**
     * 设置联机交易结果值。
     * @param resultCode 联机交易结果值 , 0（{@link EMVConstants#App_Confirm_OK}）:成功；-1（{@link EMVConstants#App_Confirm_Cancel}）：取消；
     * -2（{@link EMVConstants#App_Confirm_Failure}）：失败。
     *
     */
    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }
    
    /**
     * 获取55域内容。
     * @return 55域内容 。
     *
     */
    public byte[] getField55() {
        return field55;
    }
    
    /**
     * 设置55域内容。
     * @param field55 55域内容。
     *
     */
    public void setField55(byte[] field55) {
        this.field55 = field55;
    }
    
    /**
     * 获取39域内容。
     * @return 39域内容 。
     *
     */
    public byte[] getField39() {
        return Field39;
    }
    
    /**
     * 设置39域内容。
     * @param field39 39域内容。
     *
     */
    public void setField39(byte[] field39) {
        Field39 = field39;
    }

}
