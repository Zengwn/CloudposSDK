/*
 * MifareCard.java
 *
 * Copyright (c) 2013 - 2020 UnionPay. All rights reserved.
 *
 *
 * UNIONPAY PROPRIETARY/CONFIDENTIAL.
 *
 */

package com.unionpay.cloudpos.card;

import com.unionpay.cloudpos.DeviceException;

/**
 * 非接触式Mifare卡的接口定义。符合MIFAREI国际标准，容量为8K位.是memory卡的一种。
 * 
 * 
 * @date August 7, 2015
 */
public interface MifareCard extends MemoryCard {
 
    /**
     * 验证给定分区的Key A
     * <p>
     * 无论验证失败还是成功，前面卡片被打开的分区均会被关闭。
     * <p>
     * 
     * @param sectorIndex   Mifare卡的分区号
     * @param key           6个字节的key
     * @return  true成功，false失败
     * @throws DeviceException
     */
    boolean verifyKeyA(int sectorIndex, byte[] key) throws DeviceException;
    /**
     * 验证给定分区的Key B
     * <p>
     * 无论验证失败还是成功，前面卡片被打开的分区均会被关闭。
     * <p>
     * 
     * @param sectorIndex   Mifare卡的分区号
     * @param key           6个字节的key
     * @return  true成功，false失败
     * @throws DeviceException
     */
    boolean verifyKeyB(int sectorIndex, byte[] key) throws DeviceException;
    
    /**
     * 读取分区中某个block的数据
     * 
     * @param sectorIndex      分区ID
     * @param blockOfSector    block索引号
     * @return  the data buffer block的数据
     * @throws DeviceException
     */
    byte[] readBlock(int sectorIndex, int blockOfSector) throws DeviceException;
    
    /**
     * 写某个分区的某个block
     * <p>
     * @param sectorIndex 分区号
     * @param blockOfSector block索引号
     * @param buffer 数据流
     * @throws DeviceException
     */
    void writeBlock(int sectorIndex, int blockOfSector, byte[] buffer) throws DeviceException;
    
    /**
     *  往电子钱包里面写入钱包数据和用户数据
     *  <p>
     *  @param sectorIndex 分区号
     *  @param blockOfSector block索引号
     *  @param value 钱包数据
     *  @param pAddrData 用户数据
     *  @throws DeviceException
     *  TODO 术语 参数命名
     * */
    void writeValue(int sectorIndex, int blockOfSector, MoneyValue value) throws DeviceException;
    
    /**
     *  从电子钱包中读取钱包数据和用户数据
     *  <p>
     *  @param sectorIndex 分区号
     *  @param blockOfSector block索引号
     *  @return Map[0] 为钱包数据。Map[1]为用户数据
     *  TODO 术语 参数命名
     * */
    MoneyValue readValue(int sectorIndex, int blockOfSector) throws DeviceException;
    
    /**
     * 电子钱包的数据值加一。
     *  @param sectorIndex 分区号
     *  @param blockOfSector block索引号
     *  @param value 钱包数据
     *  @return  true成功，false失败
     * */
    boolean increaseValue(int sectorIndex, int blockOfSector, int value) throws DeviceException;
    
    /**
     * 电子钱包的数据值减一。
     *  @param sectorIndex 分区号
     *  @param blockOfSector block索引号
     *  @param value 钱包数据
     *  @return  true成功，false失败
     * */
    boolean decreaseValue(int sectorIndex, int blockOfSector, int value) throws DeviceException;
}
