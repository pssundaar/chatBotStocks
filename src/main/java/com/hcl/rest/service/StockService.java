package com.hcl.rest.service;

import java.util.List;

import com.hcl.rest.model.PurchasedStock;
import com.hcl.rest.model.Stocks;

public interface StockService {
	
	List<Stocks> getListOfStockInformation();
	PurchasedStock buyStock(int balance, String stockName);
	List<PurchasedStock> getAllBuyInfo();
	PurchasedStock sellStock(String stockName);
	String liveStatus(String stockName);

}
