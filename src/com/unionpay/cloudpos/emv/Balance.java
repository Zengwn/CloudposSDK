/*
 * Balance.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos.emv;

public class Balance {
    /* 第一货币代码  */
    private String firstCurrencyCode;
    /* 第一余额 */
    private long firstCurrencyBalance;
    /* 第二货币代码  */
    private String secondCurrencyCode;
    /* 第二余额 */
    private long secondCurrencyBalance;

    /**
     * 获取第一货币代码。
     * @return 第一货币代码。
     *
     */
    public String getFirstCurrencyCode() {
        return firstCurrencyCode;
    }

    /**
     * 设置第一货币代码。
     * @param firstCurrencyCode 第一货币代码。
     *
     */
    public void setFirstCurrencyCode(String firstCurrencyCode) {
        this.firstCurrencyCode = firstCurrencyCode;
    }
    /**
     * 获取第一余额  。
     * @return 第一余额  。
     *
     */
    public long getFirstCurrencyBalance() {
        return firstCurrencyBalance;
    }

    /**
     * 设置第一余额  。
     * @param firstCurrencyBalance 第一余额  。
     *
     */
    public void setFirstCurrencyBalance(long firstCurrencyBalance) {
        this.firstCurrencyBalance = firstCurrencyBalance;
    }
    
    /**
     * 获取第二货币代码  。
     * @return 第二货币代码  。
     *
     */
    public String getSecondCurrencyCode() {
        return secondCurrencyCode;
    }

    /**
     * 设置第二货币代码  。
     * @param secondCurrencyCode 第二货币代码  。
     *
     */
    public void setSecondCurrencyCode(String secondCurrencyCode) {
        this.secondCurrencyCode = secondCurrencyCode;
    }

    /**
     * 获取第二余额 。
     * @return 第二余额 。
     *
     */
    public long getSecondCurrencyBalance() {
        return secondCurrencyBalance;
    }

    /**
     * 设置第二余额  。
     * @param secondCurrencyBalance 第二余额 。
     *
     */
    public void setSecondCurrencyBalance(long secondCurrencyBalance) {
        this.secondCurrencyBalance = secondCurrencyBalance;
    }
}
