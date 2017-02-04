package com.gemantic.wealth.application.service.impl;

import lombok.extern.log4j.Log4j;

import java.util.List;

@Log4j
public class AppHotSaleServiceImpl implements AppHotSaleService {


	public Long insert(AppHotSale appHotSale) {
		return null;
	}

	public List<AppHotSale> insertList(List<AppHotSale> appHotSaleList){
		return null;
	}

	public boolean delete(Long id){
		log.info("delete(Long id) ");
		return false;
	}

	public boolean update(AppHotSale appHotSale){
		return false;
	}

	public boolean updateList(List<AppHotSale> appHotSaleList){
		return false;
	}

	public AppHotSale getObjectById(Long id) {
		log.info("getObjectById" + id);

		return null;
	}

	public List<AppHotSale> getObjectsByIds(List<Long> ids){
		return null;
	}

	public Long getAppHotSaleIdByOnline(String online){
		return null;
	}

	public List<Long> getIdsByOnline(String online, Integer start, Integer limit){
		return null;
	}

	public List<Long> getIdsByOnlineAndType(String online, Integer start, Integer limit, String type){
		return null;
	}

	public List<Long> getAppHotSaleIdsByTypeAndOnline(String type, String online, Integer start, Integer limit){
		return null;
	}
}
