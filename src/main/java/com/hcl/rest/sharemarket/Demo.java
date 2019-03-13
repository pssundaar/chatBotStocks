package com.hcl.rest.sharemarket;

import java.io.IOException;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.quotes.stock.StockQuote;





public class Demo
{
  public Demo() {}
  
  public BigDecimal stock(String compy)
    throws IOException
  {
    YahooFinance yahoo = new YahooFinance();
    Stock stock = YahooFinance.get(compy + ".NS");
    StockQuote sq = stock.getQuote();
    
    System.out.println("Symbol: " + sq.getSymbol());
    System.out.println("Price: " + sq.getPrice());
    BigDecimal price = sq.getPrice();
    System.out.println("Date: " + sq.getLastTradeTime().getTime());
    System.out.println("year high" + sq.getYearHigh());
    System.out.println(sq.getChangeInPercent());
    
    Stock stockNIfty = YahooFinance.get("^NSEBANK");
    StockQuote sq1 = stock.getQuote();
    System.out.println("Symbol: " + sq1.getSymbol());
    System.out.println("Price: " + sq1.getPrice());
    BigDecimal price1 = sq.getPrice();
    System.out.println("year high" + sq.getYearHigh());
    System.out.println(sq.getChangeInPercent());
    return price;
  }
  

  public List market(String compy)
    throws IOException
  {
    YahooFinance yahoo = new YahooFinance();
    
    Stock stock = YahooFinance.get(compy + ".NS");
    StockQuote sq = stock.getQuote();
    BigDecimal price = sq.getPrice();
    

    Stock stockNIfty = YahooFinance.get("^NSEBANK");
    StockQuote sq1 = stockNIfty.getQuote();
    BigDecimal price1 = sq.getPrice();
    List<String> list = new ArrayList();
    

    list.add("SYMBOL : NIFTY");
    list.add("LIVE NIFTY PRICE : " + sq1.getPrice().toString());
    list.add("YEAR HIGH :  " + sq1.getYearHigh().toString());
    list.add("CHANGE IN PERCENTAGE " + sq1.getChangeInPercent().toString() + "%");
    

    list.add("SYMBOL : " + sq.getSymbol());
    list.add("LIVE MARKET PRICE : " + sq.getPrice().toString());
    list.add("PREVIOUS DAY CLOSE : " + sq.getPreviousClose());
    
    list.add("YEAR HIGH  : " + sq.getYearHigh().toString());
    list.add("CHANGE IN PERCENTAGE " + sq.getChangeInPercent().toString() + "%");
    




    return list;
  }
}