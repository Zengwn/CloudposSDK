/*
 * PINResult.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos.emv;

public class PINResult {
    /* 结果值*/
    private int resultCode;
    
    /* 脱机密码*/
    private byte[] pindata;

    /**
     * 获取输入密码结果值。
     * @return 输入密码结果值 。
     *
     */
    public int getResultCode() {
        return resultCode;
    }

    /**
     * 设置输入密码结果值。
     * @param resultCode 输入密码结果值 , 0（{@link EMVConstants#PIN_Input_Success}）:输入成功；1（{@link EMVConstants#PIN_Input_Bypass}）：bypass；
     * -1（{@link EMVConstants#PIN_Input_Cancel}）：取消；-2（{@link EMVConstants#PIN_Input_Failure}）：失败；
     * -3（{@link EMVConstants#PIN_Input_Timeout}）：超时.
     *
     */
    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    /**
     * 获取脱机密码。
     * @return 脱机密码 。
     *
     */
    public byte[] getPindata() {
        return pindata;
    }

    /**
     * 设置脱机密码。
     * @param pindata 脱机密码。
     *
     */
    public void setPindata(byte[] pindata) {
        this.pindata = pindata;
    }
}
