/*
 * IDCard.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos.idcardreader;

import android.graphics.Bitmap;

/**
 * 本接口主要用于表示身份证
 * 
 * @date August 10, 2015
 */
public class IDCard {
    public IDCard(String name, String sex, String nation, String birthday, String address, String idcardno, String grantdept, String validFromDate, String validToDate, String reserved, Bitmap bitmap) {
        this.name = name;
        this.sex = sex;
        this.nation = nation;
        this.birthday = birthday;
        this.address = address;
        this.idcardno = idcardno;
        this.grantdept = grantdept;
        this.validFromDate = validFromDate;
        this.validToDate = validToDate;
        this.reserved = reserved;
        this.bitmap = bitmap;
    }
    private String name;
    private String sex;
    private String nation;
    private String birthday;
    private String address;
    private String idcardno;
    private String grantdept;
    private String validFromDate;
    private String validToDate;
    private String reserved;
    private Bitmap bitmap;
    private final String[] nations = {
            "解码错",          // 00
            "汉",            // 01
            "蒙古",           // 02
            "回",            // 03
            "藏",            // 04
            "维吾尔",          // 05
            "苗",            // 06
            "彝",            // 07
            "壮",            // 08
            "布依",           // 09
            "朝鲜",           // 10
            "满",            // 11
            "侗",            // 12
            "瑶",            // 13
            "白",            // 14
            "土家",           // 15
            "哈尼",           // 16
            "哈萨克",          // 17
            "傣",            // 18
            "黎",            // 19
            "傈僳",           // 20
            "佤",            // 21
            "畲",            // 22
            "高山",           // 23
            "拉祜",           // 24
            "水",            // 25
            "东乡",           // 26
            "纳西",           // 27
            "景颇",           // 28
            "柯尔克孜",     // 29
            "土",            // 30
            "达斡尔",          // 31
            "仫佬",           // 32
            "羌",            // 33
            "布朗",           // 34
            "撒拉",           // 35
            "毛南",           // 36
            "仡佬",           // 37
            "锡伯",           // 38
            "阿昌",           // 39
            "普米",           // 40
            "塔吉克",          // 41
            "怒",            // 42
            "乌孜别克",     // 43
            "俄罗斯",          // 44
            "鄂温克",          // 45
            "德昴",           // 46
            "保安",           // 47
            "裕固",           // 48
            "京",            // 49
            "塔塔尔",          // 50
            "独龙",           // 51
            "鄂伦春",          // 52
            "赫哲",           // 53
            "门巴",           // 54
            "珞巴",           // 55
            "基诺",           // 56
            "编码错",          // 57
            "其他",           // 97
            "外国血统"          // 98
    };
    /**
     * 获取姓名
     * @return 姓名
     */
    public String getName(){
        return name;
    };

    /**
     * 获取性别
     * @return 性别
     */
    public String getSex(){
        return sex;
    };

    /**
     * 获取国籍
     * @return 国籍
     */
    public String getNation(){
        int nationcode = Integer.parseInt(nation);
        if (nationcode>=1 && nationcode<=56) {
            this.nation = nations[nationcode];          
        } else if (nationcode == 97) {
            this.nation = "其他";
        } else if (nationcode == 98) {
            this.nation = "外国血统";
        } else {
            this.nation = "编码错";
        }
        return nation;
    };

    /**
     * 获取出生日期
     * @return 出生日期
     */
    public String getBorn(){
        return birthday;
    };

    /**
     * 获取地址
     * @return 地址
     */
    public String getAddress(){
        return address;
    };

    /**
     * 获取身份证号
     * @return 身份证号
     */
    public String getIDCardNo(){
        return idcardno;
    };

    /**
     * 获取颁发部门
     * @return 颁发部门
     */
    public String getGrantDept(){
        return grantdept;
    };

    /**
     * 获取有效期开始日期
     * @return 有效期开始日期
     */
    public String getValidFromDate(){
        return validFromDate;
    };
    /**
     * 获取有效期结束日期
     * @return 有效期结束日期
     */
    public String getValidToDate(){
        return validToDate;
    };

    /**
     * 获取其他保留信息
     * @return 其他保留信息
     */
    public String getReserved(){
        return reserved;
    };

    /**
     * 获取对加密数据解密后的身份证相片
     * @return 对加密数据解密后的身份证相片
     */
    public Bitmap getPicture(){
        
        return bitmap;
    };

}
