package com.hcl.rest.model;


public class Stocks {
	private String stockName;
	private int stckprice;
	public String getStockName() {
		return stockName;
		
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public int getStckprice() {
		return stckprice;
	}
	public void setStckprice(int stckprice) {
		this.stckprice = stckprice;
	}
	
	@Override
	public String toString() {
		return "Stock [stockName=" + stockName + ", stckprice=" + stckprice + "]";
	}
	
	
}
