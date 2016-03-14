/*
 * EMVTransListener.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */
package com.unionpay.cloudpos.emv;

import java.util.List;
/**
 * EMV交易监听器，应用通过监听器得到需要的数据，处理确认之后，通过返回值，告诉EMV流程进入下一步。
 * <p>
 * @date March 14th, 2016
 */
public interface EMVTransListener {
    /**
     * 等待应用选择，EMVSDK实现判断返回值，进入流程下一步。
     * @param appNameList EMV底层返回应用列表集合。
     * @param isFirstSelect 是否第一次选择应用。
     * @return >=0所选择的应用索引；-1（{@link EMVConstants#App_Confirm_Cancel}）： 取消； 
     * -2（{@link EMVConstants#App_Confirm_Failure}）：失败。
     *
     */
    int onWaitAppSelect(List<String> appNameList, boolean isFirstSelect);
    
    /**
     * 确认使用电子现金，由应用设置结果返回值，EMVSDK实现判断返回值，进入流程下一步。
     * @return 0（{@link EMVConstants#App_Confirm_OK}） 确认； -1（{@link EMVConstants#App_Confirm_Cancel}）：取消。
     *
     */
    int onConfirmEC();
    
    /**
     * 确认卡号，由应用设置结果返回值，EMVSDK实现判断返回值，进入流程下一步。
     * @param cardNO 待确认卡号。
     * @return 0（{@link EMVConstants#App_Confirm_OK}） 确认； -1（{@link EMVConstants#App_Confirm_Cancel}）：取消。
     *
     */
    int onConfirmCardNo(String cardNO);
    
    /**
     * 身份认证，由应用设置结果返回值，EMVSDK实现判断返回值，进入流程下一步。
     * @param certType 证件类型。
     * @param certValue 证件内容。
     * @return 0（{@link EMVConstants#App_Confirm_OK}） 确认； -1（{@link EMVConstants#App_Confirm_Cancel}）：取消。
     *
     */
    int onCertVerfiy(String certType, String certValue);
    
    /**
     * 输入密码，由应用设置结果及脱机密码返回，EMVSDK实现判断返回值，进入流程下一步。
     * @param isOnlinePin 是否联机交易。
     * @param offlinePinLeftTimes 脱机密码剩余次数。
     * @return PINResult。
     * @see PINResult
     */
    PINResult onCardHolderPwd(boolean isOnlinePin, int offlinePinLeftTimes);
    
    /**
     * 联机交易，由应用设置联机结果，EMVSDK实现判断联机结果，进入流程下一步。
     * @return OnlineResult。
     * @see OnlineResult
     */
    OnlineResult onOnlineProc();
    
    /**
     * 交易结果，应用获得交易的返回结果。
     * @param code 0（{@link EMVConstants#Process_Result_Approve}）：批准；1（{@link EMVConstants#Process_Result_Refuse}）：拒绝。
     * @param desc
     *
     */
    void onTransResult (int code, String desc);
}
