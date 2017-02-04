package com.gemantic.wealth.application.service.impl;

import org.osoa.sca.annotations.Remotable;

import java.util.List;

@Remotable
public interface AppHotSaleService {


    public Long insert(AppHotSale appHotSale) ;


    public List<AppHotSale> insertList(List<AppHotSale> appHotSaleList) ;


    public boolean delete(Long id) ;


    public boolean update(AppHotSale appHotSale) ;


    public boolean updateList(List<AppHotSale> appHotSaleList) ;


    public AppHotSale getObjectById(Long id) ;


    public List<AppHotSale> getObjectsByIds(List<Long> ids) ;


    /**
     * @param
     * @return
     */
    public Long getAppHotSaleIdByOnline(String online);

    public List<Long> getIdsByOnline(String online, Integer start, Integer limit) ;


    public List<Long> getIdsByOnlineAndType(String online, Integer start, Integer limit, String type) ;


    /**
     * 根据类型和是否上线查询手机端热销产品信息
     *
     * @param type
     * @param online
     * @return
     */
    public List<Long> getAppHotSaleIdsByTypeAndOnline(String type, String online, Integer start, Integer limit);

}

