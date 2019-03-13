package com.hcl.rest.model;

import java.io.IOException;
import java.math.BigDecimal;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.quotes.stock.StockQuote;

public class test {
	
 public static void main(String[] args) throws IOException {
	 YahooFinance yahoofinance = new YahooFinance();
	 Stock  stock=yahoofinance.get("BABA");
	 StockQuote stockQuote = stock.getQuote();
	
	
	 System.out.println(stockQuote.getPrice() );
		
}
}
