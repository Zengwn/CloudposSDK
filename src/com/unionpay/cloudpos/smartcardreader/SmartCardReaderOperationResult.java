/*
 * SmartCardReaderOperationResult.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos.smartcardreader;
import com.unionpay.cloudpos.DeviceException;
import com.unionpay.cloudpos.OperationResult;
import com.unionpay.cloudpos.card.CPUCard;
import com.unionpay.cloudpos.card.Card;
import com.unionpay.cloudpos.card.SLE4442Card;
/**
 * <code>SmartCardReaderOperationResult</code>是被SmartCard读卡设备产生，用来返回得到的卡对象。
 * <p>
 * {@link OperationResult#getResultCode() getResultCode()}方法继承至{@link OperationResult}的对应方法。
 * <p>
 * 这里通过"ERR_"设置了本设备相关的自定义错误，可以在{@link OperationResult#getResultCode() getResultCode（）}返回错误或正确的操作结果。
 * 通过{@link SmartCardReaderOperationResult#getCard() getCard()}返回SmartCard卡数据对象。
 * 得到卡对象后，应用程序可以自行区分不同类别的卡，进行卡的后续操作。
 * 一般返回的卡类型为{@link CPUCard CPUCard}或者{@link SLE4442Card SLE4442Card}两种。
 * @date August 07, 2015
 */
public interface SmartCardReaderOperationResult extends OperationResult{
	/**
     * 返回卡。
     * 
     * @return 卡对象。     
     * @throws DeviceException 具体定义参考{@link DeviceException DeviceException}的文档。
     * @see CPUCard
     * @see SLE4442Card
     */
    Card getCard();
}
