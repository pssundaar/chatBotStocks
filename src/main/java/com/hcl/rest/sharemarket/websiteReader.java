package com.hcl.rest.sharemarket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class websiteReader
{
  public websiteReader() {}
  
  public String Intradayshares()
    throws IOException
  {
    String interday = null;
    StringBuffer sb = new StringBuffer();
    List<String> compnames = new ArrayList();
    List<String> tradevalue = new ArrayList();
    Document document = Jsoup.connect("http://www.investmentguruindia.com/intradaytips").get();
    



    Elements paragraphs = document.getElementsByClass("gepl_box").select("p");
    Elements paragraphs1 = document.getElementsByClass("gspl_right").select("h2");
    int count = 0;
    for (Element p : paragraphs) {
    	tradevalue.add(p.text());
      
      count++; }
 
    int count1 = 0;
    for (Element p : paragraphs1) {
      compnames.add(p.text());
      
      count1++;
    }
    
    sb.append(" 1. " + (String)compnames.get(0));
    sb.append(" " + (String)tradevalue.get(1) + " , ");
    sb.append(" 2. " + (String)compnames.get(1));
    sb.append(" " + (String)tradevalue.get(4) + " , ");
    sb.append(" 3. " + (String)compnames.get(2));
    sb.append(" " + (String)tradevalue.get(7) + " , ");
    sb.append(" 4. " + (String)compnames.get(3));
    sb.append(" " + (String)tradevalue.get(10) + " , ");
    sb.append(" 5. " + (String)compnames.get(4));
    sb.append(" " + (String)tradevalue.get(13) + " , ");
    













    return "" + sb;
  }
}