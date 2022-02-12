package com.example.test2.Service.PrimaryService;

public interface ConsoleRedisService {

    /**
     * 插入新的一天扫码统计
     * lazy插入
     * @return
     */
    public boolean insertNewScanQRTotal();

    public boolean isExistTodayScanQRTotal();

    /**
     * 今日扫码统计+1
     */
    public boolean incrementTodayScanQRTotal();

    public Long getTodayScanTotal();

    /**
     * 插入user数量
     * key : userTotal
     * value : total
     * @param total 数量
     * @return
     */
    public boolean insertUsersTotal(Long total);



    /**
     *
     *
     * key: placeForNormalTotal
     * value: total
     * @param total 数量
     * @return
     */
    public boolean setPlaceForNormalTotal(Long total);


    public boolean incrementPlaceForNormalTotal();

    public boolean decrementPlaceForNormalTotal();

    public Long getCurNormalPlaceTotal();

    /**
     *
     * key: riskPlaceTotal
     * 风险场所+1
     */
    public boolean incrementRiskPlaceTotal();

    /**
     * 风险场所-1
     */
    public boolean decrementRiskPlaceTotal();

    /**
     * 获取当前风险场所数量
     * key:
     */
    public Long getCurRiskPlaceTotal();



    public Long getCurCarPlaceTotal();

    /**
     * 获得注册人数
     * @return
     */
    public Long getRegisterTotal();

    public boolean incrementRegisterTotal();

    public boolean decrementRegisterTotal();


}
