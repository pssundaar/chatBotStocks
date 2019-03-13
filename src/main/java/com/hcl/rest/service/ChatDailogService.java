package com.hcl.rest.service;

import com.hcl.rest.Database.DatabaseConnector;
import com.hcl.rest.conversation.BotResponse;
import com.hcl.rest.model.BotRequest;
import com.hcl.rest.model.Data;
import com.hcl.rest.model.Parameters;
import com.hcl.rest.model.Stocks;
import com.hcl.rest.model.User;
import com.hcl.rest.sharemarket.Demo;
import com.hcl.rest.sharemarket.websiteReader;
import com.sun.jersey.api.client.ClientResponse;
import javax.ws.rs.GET;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.quotes.stock.StockQuote;

import java.io.IOException;

import java.math.BigDecimal;

import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;


@Path("/json/chat")
public class ChatDailogService
{
                 public ChatDailogService() {}
  
  
  
  
  Logger logger = LoggerFactory.getLogger(ChatDailogService.class);
  
  @GET
  @Path("/post")
  @Consumes({"application/json"})
  
  public Response createTrackInJSON(BotRequest request) {
    final Connection con = DatabaseConnector.getMySqlConnection();
    ObjectMapper mapper = new ObjectMapper();
    
    
    try
    {
      logger.error("request: error: " + mapper.writeValueAsString(request));
      logger.debug("request: debug: " + mapper.writeValueAsString(request));
      logger.info("request: info: " + mapper.writeValueAsString(request));
     
      String speech = "";
      try
      {
        Parameters params = request.getQueryResult().getParameters();
     // User data= request.getOriginalRequest().getData().getUser();
     User data=request.getOriginalDetectIntentRequest().getPayload().getData().getUser();
     String text=request.getOriginalDetectIntentRequest().getPayload().getData().getText();
    		 System.out.println("text queryyyyyyyyyyyyyyyyyyyyyyyyyy..........................."+text);
    
        final Map<String, Object> properties = params.getAdditionalProperties();
      final Map<String, Object> properties_username= data.getAdditionalProperties();
        	
     
        String action = request.getQueryResult().getAction();
        
        if (action.equalsIgnoreCase("getStocks"))
        {
          speech = getStocks(con, properties);
        }
        
      }
 
      catch (Exception e)
      {
        e.printStackTrace();
        logger.error(e.getMessage());
        speech = "Sorry for the inconvenience, Please try after some time. Type 'HELP' for sample use cases.";
      }
      
      mapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
      
      BotResponse response = new BotResponse();
     
    // response.setSpeech(speech);
      response.setFulfillmentText(speech);
      //response.setDisplayText(speech);
      

      String jsonInString = mapper.writeValueAsString(response);


      


      
      System.out.println("final output"+jsonInString);
      System.out.println("final output1"+Response.status(201).entity(jsonInString).build());
      return Response.status(201).entity(jsonInString).build();
    } catch (JsonGenerationException e) {
      e.printStackTrace();
      return Response.status(500).entity(e.toString()).build();
    }
    catch (JsonMappingException e) {
      e.printStackTrace();
      return Response.status(500).entity(e.toString()).build();
    } catch (IOException e) {
      e.printStackTrace();
      return Response.status(500).entity(e.toString()).build();
    }
  }
  
  
  

//--------------------------VISITORASSIST---------------------
  private String getStocks(Connection con, Map<String, Object> properties) throws SQLException, IOException {
//                  String userid =(String)properties.get("userid");
//                  String stationery =(String)properties.get("Stationery");
//                  String water =(String)properties.get("water");
//                                String stat=stationery;
//                                
	  StringBuffer sb = new StringBuffer();
	  YahooFinance yahoofinance = new YahooFinance();
		 Stock  stock=yahoofinance.get("BABA");
		 StockQuote stockQuote = stock.getQuote();
		  sb.append(stockQuote.getPrice().intValue()+"");
		
		
                return " "+sb;
                }



}

