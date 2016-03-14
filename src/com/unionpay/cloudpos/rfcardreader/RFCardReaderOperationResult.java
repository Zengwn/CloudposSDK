/*
 * RFCardReaderOperationResult.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos.rfcardreader;

import com.unionpay.cloudpos.OperationResult;
import com.unionpay.cloudpos.card.CPUCard;
import com.unionpay.cloudpos.card.Card;
import com.unionpay.cloudpos.card.MifareCard;
import com.unionpay.cloudpos.card.MifareUltralightCard;

/**
 * <code>RFCardReaderOperationResult</code>是被非接卡读卡设备产生，用来返回非接卡的操作结果
 * <p>
 * {@link OperationResult#getResultCode() getResultCode()}方法继承至{@link OperationResult OperationResult}的对应方法。
 * <p>
 * 这里通过"ERR_"设置了本设备相关的自定义错误，可以在{@link OperationResult#getResultCode() getResultCode（）}返回。
 * 通过{@link RFCardReaderOperationResult#getCard() getCard()}返回非接卡数据对象。
 * 得到卡对象后，应用程序可以自行区分不同类别的卡，进行卡的后续操作。
 * 一般返回的卡类型为{@link CPUCard CPUCard},{@link MifareCard MifareCard},{@link MifareUltralightCard MifareUltralightCard},
 * 其中后两种属于<code>MemoryCard</code>
 * @date August 07, 2015
 */
public interface RFCardReaderOperationResult extends OperationResult
{
   /**
    * 发生通讯错误
    */
   int ERR_COMMUNICATION      = ERR_DEVICE_BASE - 1;

   /**
    * 通讯协议错误
    */
   int ERR_PROTOCOL           =  ERR_DEVICE_BASE - 2;

   /**
    * 卡无法通讯
    */
   int ERR_CARD_UNREACHABLE = ERR_DEVICE_BASE - 3;
   
   /**
    * 多张卡片被放入非接触式IC卡阅读器
    * */
   int ERR_MULTI_CARD = ERR_DEVICE_BASE - 4;

   /**
    * 返回扫描到的卡片。
    * <p>
    *
    * @return 扫描到的非接卡片
    * @see MifareCard
    * @see MifareUltralightCard
    * @see CPUCard
    */
   Card getCard();

}
