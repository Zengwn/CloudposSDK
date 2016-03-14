package com.unionpay.cloudpos.emv;
/**
 * EMV中常量。
 * 
 */
public interface EMVConstants {

    /* 通道类型：接触式*/
    public static final int Channel_Type_IC = 0;
    
    /* 通道类型：非接触式*/
    public static final int Channel_Type_RF = 1;
    
    /* Application Confirm*/
    public static final int App_Confirm_OK = 0;
    public static final int App_Confirm_Cancel = -1;
    public static final int App_Confirm_Failure = -2;
    
    /* PIN input result*/
    public static final int PIN_Input_Success = 0;
    public static final int PIN_Input_Bypass = 1;
    public static final int PIN_Input_Cancel = -1;
    public static final int PIN_Input_Failure = -2;
    public static final int PIN_Input_Timeout = -3;
    
    /* 交易结果*/
    public static final int Process_Result_Approve = 0;
    public static final int Process_Result_Refuse = 1;
    /* 交易货币代码，人民币*/
    public static final String Currency_Code_RMB = "156";
    
    /* 交易货币代码，积分*/
    public static final String Currency_Code_JIFEN = "999";
}
