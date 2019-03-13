package com.hcl.rest.service;



import java.io.File;
import java.io.IOException;
import java.io.NotActiveException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.omg.Messaging.SyncScopeHelper;




public class Finance {
                                ObjectMapper mapper = new ObjectMapper();
          
                                   
                                
                //Action Name-  YTDRevenue
                public static String YTDRevenueInfo(Connection con, Map<String, Object> properties, String rev, String ytd)
                          throws SQLException
                {
                	StringBuffer sb = new StringBuffer();
                    if((rev.equalsIgnoreCase("total revenue")))     
                	
                    {
                    	
                    	if(ytd.isEmpty()){
                    		ytd="FY 18-19";
                    		
                    	}
                    	
                	System.out.println("----------ytd-"+ytd);
                          Statement stmt = con.createStatement();
                          ResultSet rs = stmt.executeQuery("SELECT ceiling(sum(ubs_ytd_pp_report.Total_Revenue)) as result FROM banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='"+ytd+"'");
                          String s=null;
                             while (rs.next()) {
                                           s=rs.getString("result");
                                           sb.append(" ");
                             }
                               if(s== null)
                               {
                                               sb.append("Data not available for entered time period"); 
                               }
                               else{
                               sb.append("Total Revenue for "+ytd+" is : ");
                               sb.append( FinanceService.numberFormat(s));
                               sb.append(" ");
      }
                    }
                    else{
                    	 sb.append("Please enter a valid query. Type 'HELP' for sample use cases.");
                    }
                               
                                       return " " + sb;
                        }


                //Action Name-YTDGM
                public static String YTDGM(Connection con, Map<String, Object> properties, String ytd ,String gm)
                          throws SQLException
                  {
                	 StringBuffer sb = new StringBuffer();
                	 
                	 if((gm.equalsIgnoreCase("Grossmargin")))
                	    {
                		 if(ytd.isEmpty()){
                     		ytd="FY 18-19";
                     		
                     	}
                          Statement stmt = con.createStatement();
                          ResultSet rs = stmt.executeQuery("SELECT ceiling(sum(ubs_ytd_pp_report.Gross_Margin)) as result FROM banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='"+ytd+"'");
                         
                          String s=null;
                                          while (rs.next()) 
                                                             {  s=rs.getString("result");
                                                                               sb.append(" ");
                                                             }
                                             if(s==null)
                                                             {
                                                                sb.append("Data not available for entered time period"); 
                                                             }
                                             else{
                                                                sb.append(" For "+ytd+", GROSS MARGIN is : ");
                                                               
                                                                sb.append( FinanceService.numberFormat(s));
                                                                sb.append(" ");
                                               
                          ResultSet rs1 = stmt.executeQuery("select round((sum(ubs_ytd_pp_report.Gross_Margin)/sum(ubs_ytd_pp_report.Total_Revenue))*100,2)  as gmpercentage from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='"+ytd+"'");
              String s1=null; 
                                              while (rs1.next()) {
                                                               s1=   rs1.getString("gmpercentage");
                                                               sb.append(" ");
                                                       sb.append("& GROSS MARGIN % is : ");
                                                               sb.append(s1);
                                                               sb.append("% ");
                                                                       sb.append(" ");
                                             }
                                              }}
                	    else
                	    {	sb.append("Please enter a valid query. Type 'HELP' for sample use cases.");}
                                      return " " + sb;
}

                


 //Action Name-- ---------------- QMRevenue

  public static String revenueQMR(Connection con, Map<String, Object> properties, String mon, String month, String rev,String ytd)
                                throws SQLException, IOException
                {
	  StringBuffer sb = new StringBuffer();
	  if ( (month!=null)  && (rev.equalsIgnoreCase("total revenue"))){
		  
		  if(ytd.isEmpty()){
      		ytd="FY 18-19";
      		
      	}
	  
     // StringBuffer sb = new StringBuffer();
      			if(mon.equalsIgnoreCase("AMJ") || mon.equalsIgnoreCase("JAS") || mon.equalsIgnoreCase("OND") || mon.equalsIgnoreCase("JFM") )
      {
      				
      				
    	  ResultSet rs = con.createStatement().executeQuery("select ceiling(sum(ubs_ytd_pp_report.Total_Revenue)) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='"+ytd+"' and  ubs_ytd_pp_report.Quarter like '%"+mon+"%'");
    	  String s=null;
    	  while (rs.next()) {
      
    		  
          s=rs.getString("result");
    	  }
    	  
    	  
    	  if(s==null){
    		  sb.append("Data not available for entered time period");
    	  }
    	  else{
    		   sb.append("Total revenue for "+ytd+" "+ month.toUpperCase() +" quarter is : ");
          
    		   sb.append( FinanceService.numberFormat(s));
               sb.append(" ");
        }
      }
      			else if(mon.equalsIgnoreCase("hy1") || mon.equalsIgnoreCase("hy2")){
      				String Q1;String Q2;
      			if(mon.equalsIgnoreCase("hy1")){
      				Q1="amj";
      				Q2="jas";
      			}
      			else{
      				Q1="ond";
      				Q2="jfm";
      			}
      				
      				 ResultSet rs = con.createStatement().executeQuery("select ceiling(sum(ubs_ytd_pp_report.Total_Revenue)) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='"+ytd+"' and  (ubs_ytd_pp_report.Quarter like '%"+Q1+"%' or ubs_ytd_pp_report.Quarter like '%"+Q2+"%')");
      		    	  String s=null;
      		    	  while (rs.next()) {
      		      
      		    		  
      		          s=rs.getString("result");
      		    	  }
      		    	  
      		    	  
      		    	  if(s==null){
      		    		  sb.append("Data not available for entered time period");
      		    	  }
      		    	  else{
      		    		   sb.append("Total revenue for "+ytd+" "+ Q1.toUpperCase()+" & "+Q2.toUpperCase() +" Half Year is : ");
      		          
      		    		   sb.append( FinanceService.numberFormat(s));
      		               sb.append(" ");
      		        }
      		    	  
      		    	  
      				
      			}
      			else
                          {
                           Statement stmt = con.createStatement();
                           ResultSet rs = stmt.executeQuery("select  ceiling(sum(ubs_ytd_pp_report.Total_Revenue)) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='"+ytd+"' and ubs_ytd_pp_report.Month like '%"+mon+"%'");
                           String s =null;
                           while (rs.next()) 
        {
               s = rs.getString("result");
                sb.append(" ");
               }
               if( s==null)
                {
                     sb.append("Data not available for entered time period");
                }
                      else{
                    	  
              sb.append("Total revenue for "+ytd+" "+  month.toUpperCase() +" month is : ");
              
              sb.append( FinanceService.numberFormat(s));
              sb.append(" ");
         }
                          }
	  }
	  else{
		  
		  sb.append("Please enter a valid query. Type 'HELP' for sample use cases. ");
	  }
                  return " " + sb;
}
                

//Action Name--QMGrossMargin

public static String QMGrossMargin(Connection con, Map<String, Object> properties, String mon, String month, String gm,String ytd) throws SQLException {
                                StringBuffer sb = new StringBuffer();
           if(month!=null && gm.equalsIgnoreCase("Grossmargin"))                     
           {
        	   if(ytd.isEmpty()){
        		   ytd="FY 18-19";
        		}
        		   
                                if(mon.equalsIgnoreCase("AMJ") || mon.equalsIgnoreCase("JAS") || mon.equalsIgnoreCase("OND")|| mon.equalsIgnoreCase("JFM"))
                                {
                                                Statement stmt = con.createStatement();
                                                ResultSet rs = stmt.executeQuery("select ceiling(sum(ubs_ytd_pp_report.Gross_Margin)) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='"+ytd+"' and ubs_ytd_pp_report.Quarter like '%"+mon+"%'");
                                                String s=null;
                                                while (rs.next()) 
                                               
                                                    {   
                                                	s=rs.getString("result");
                                                    }
                                                if(s==null){
                                                	sb.append("Data not available for entered time period");
                                                }
                                                else{
                                                	sb.append("For  "+ytd+" "+month.toUpperCase()+" Quater, Gross Margin is : ");
                                                    
                                                	 sb.append( FinanceService.numberFormat(s));
                                                     sb.append(" ");
                                                    }
                                                ResultSet rs1 = stmt.executeQuery("select round((sum(ubs_ytd_pp_report.Gross_Margin)/sum(ubs_ytd_pp_report.Total_Revenue))*100,2) gm_per_monthly from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='"+ytd+"' and ubs_ytd_pp_report.Quarter like '%"+mon+"%'");
                                                while (rs1.next())
                                                {      sb.append(" & Gross Margin % is : ");
                                                        sb.append(rs1.getString("gm_per_monthly"));
                                                        sb.append("% ");
                                                        sb.append(" ");
                                                }
                               }
                                else if(mon.equalsIgnoreCase("hy1") || mon.equalsIgnoreCase("hy2")){
                                	String Q1;String Q2;
                          			if(mon.equalsIgnoreCase("hy1")){
                          				Q1="amj";
                          				Q2="jas";
                          			}
                          			else{
                          				Q1="ond";
                          				Q2="jfm";
                          			}
                                	
                                	   Statement stmt = con.createStatement();
                                       ResultSet rs = stmt.executeQuery("select ceiling(sum(ubs_ytd_pp_report.Gross_Margin)) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='"+ytd+"' and (ubs_ytd_pp_report.Quarter like '%"+Q1+"%' or ubs_ytd_pp_report.Quarter like '%"+Q2+"%')");
                                       String s=null;
                                       while (rs.next()) 
                                      
                                           {   
                                       	s=rs.getString("result");
                                           }
                                       if(s==null){
                                       	sb.append("Data not available for entered time period");
                                       }
                                       else{
                                       	sb.append("For "+ytd+" "+ Q1.toUpperCase()+" & "+Q2.toUpperCase()+" Half Year, Gross Margin is : ");
                                           
                                       	 sb.append( FinanceService.numberFormat(s));
                                            sb.append(" ");
                                           
                                       ResultSet rs1 = stmt.executeQuery("select round((sum(ubs_ytd_pp_report.Gross_Margin)/sum(ubs_ytd_pp_report.Total_Revenue))*100,2) gm_per_monthly from banker_app_schema.ubs_ytd_pp_report  where ubs_ytd_pp_report.Year='"+ytd+"' and ubs_ytd_pp_report.Quarter like '%"+Q1+"%' or ubs_ytd_pp_report.Quarter like '%"+Q2+"%'");
                                       while (rs1.next())
                                       {      sb.append(" & Gross Margin % is : ");
                                               sb.append(rs1.getString("gm_per_monthly"));
                                               sb.append("% ");
                                               sb.append(" ");
                                       }
                                }
                                }  
                                else 
                                {                                              Statement stmt = con.createStatement();
                              ResultSet rs = stmt.executeQuery("select ceiling(sum(ubs_ytd_pp_report.Gross_Margin)) as result from banker_app_schema.ubs_ytd_pp_report  where ubs_ytd_pp_report.Year='"+ytd+"' and ubs_ytd_pp_report.Month like '%"+mon+"%'");
                                                                                String s =null;
                   while (rs.next()) 
    {
        s = rs.getString("result");
        	sb.append(" ");
       }
                       if( s==null)
                     {   
                    	   sb.append("Data not available for entered time period");
                        }
                       else
                  {
                    	   sb.append("For "+ytd+" "+ month.toUpperCase() +"  , Gross Margin is : ");
                  
                  
                    	   sb.append( FinanceService.numberFormat(s));
                           sb.append(" ");
                 
                       
                ResultSet rs1 = stmt.executeQuery("select round((sum(ubs_ytd_pp_report.Gross_Margin)/sum(ubs_ytd_pp_report.Total_Revenue))*100,2) gm_per_monthly from banker_app_schema.ubs_ytd_pp_report  where ubs_ytd_pp_report.Year='"+ytd+"' and ubs_ytd_pp_report.Month like '%"+mon+"%'");
                                                                String s1 =null;
                                                                while (rs1.next()) 
                                                                 {                             s1 = rs1.getString("gm_per_monthly");
                                                                                                sb.append(" ");
                                                                                                sb.append(" & Gross Margin % is : ");
                                                                                                sb.append(s1);
                                                                                                sb.append("%");
                                                                                                sb.append(" ");
                                                                               }
                                                                
                }
           }
           }                    else{
                                	  sb.append("Please enter a valid query. Type 'HELP' for sample use cases.");
                                }
                return " " + sb;
}


//Action Name-- YTDRevenueLOB

public static String YTDrevenuelob(Connection con, Map<String, Object> properties, String lob ,String rev, String ytd) throws SQLException 
                { 
	StringBuffer sb = new StringBuffer();
	if(lob!=null && rev.equalsIgnoreCase("total revenue") )
	{
		if(ytd.isEmpty()){
      		ytd="FY 18-19";
      		
      	}
	
    Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery("select Ceiling(sum(ubs_ytd_pp_report.Total_Revenue)) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='"+ytd+"' and ubs_ytd_pp_report.LOB = '"+lob+"';");
         String s=null;
         while (rs.next()) 
               {        
        	 s=rs.getString("result");

        	 sb.append(" ");
               }
         if(s== null)
               {
           sb.append("Data not available for entered time period"); 
               }
         else
         sb.append("Total Revenue for "+ytd+" "+ lob.toUpperCase() +" YTD is : ");
                                              
         
         
         sb.append( FinanceService.numberFormat(s));
         sb.append(" ");
	}
         else{
        	 sb.append("Please enter a valid query. Type 'HELP' for sample use cases.");
         }
     return " " + sb;
     }
                
// ------------------------------------------------------------------------------------

//Action Name-- YTDGMLOB
public static String YTDgmlob(Connection con, Map<String, Object> properties, String lob, String ytd, String gm) throws SQLException 
     {
	StringBuffer sb = new StringBuffer();
	if(lob!=null && gm.equalsIgnoreCase("Grossmargin") )
	{
		if(ytd.isEmpty()){
      		ytd="FY 18-19";
      		
      	}
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select  ceiling(sum(ubs_ytd_pp_report.Gross_Margin)) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='"+ytd+"' and ubs_ytd_pp_report.LOB = '"+lob+"';");
             
             String s=null;
                             while (rs.next()) 
                                                {  
                            	 s=rs.getString("result");

                            	 sb.append(" ");
                                                }
                                if(s==null)
                                                {
                                                   sb.append("Data not available for entered time period"); 
                                                }
                                else{
                                                   sb.append(" For "+ytd+" " + lob.toUpperCase()+" , GROSS MARGIN YTD is : ");
                                                   
                                                   sb.append( FinanceService.numberFormat(s));
                                                   sb.append(" ");
                                
             ResultSet rs1 = stmt.executeQuery("select  round((sum(ubs_ytd_pp_report.Gross_Margin)/sum(ubs_ytd_pp_report.Total_Revenue))*100,2) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='"+ytd+"' and ubs_ytd_pp_report.LOB = '"+lob+"'");
 String s1=null; 
                                 while (rs1.next()) {
                                                  s1=   rs1.getString("result");
                                                  sb.append(" ");
                                     
                                                  sb.append(" & GROSS MARGIN % YTD is : ");
                                                  sb.append(s1);
                                                  sb.append("% ");
                                                  sb.append(" ");
                                                  } 
	}
    }
	else {
		sb.append(" Please enter a valid query. Type 'HELP' for sample use cases. ");
	}
                         return " " + sb;

}

//Action Name-- QmRevenuelob

public static String qmrevenuelob(Connection con, Map<String, Object> properties, String lob,String mon,String month,String rev,String ytd) throws SQLException {
	StringBuffer sb = new StringBuffer();
	if(lob!=null&& month!=null&&rev.equalsIgnoreCase("total revenue"))
	
{
		if(ytd.isEmpty()){
      		ytd="FY 18-19";
      		
      	}
		if(mon.equalsIgnoreCase("AMJ") || mon.equalsIgnoreCase("JAS") || mon.equalsIgnoreCase("OND") || mon.equalsIgnoreCase("JFM"))
{            
ResultSet rs = con.createStatement().executeQuery("select ceiling(sum(ubs_ytd_pp_report.Total_Revenue)) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='"+ytd+"' and ubs_ytd_pp_report.LOB='"+lob+"' and ubs_ytd_pp_report.Quarter like '%"+mon+"%'");
	String s=null;
while (rs.next()) {
	s=rs.getString("result");
}

	if(s==null)
	{
		sb.append("Data not available for entered time period");
	}
	else
		
	{
sb.append("Total revenue for "+ytd+" " + lob.toUpperCase() +" in "+ month.toUpperCase() +" quarter is : ");


sb.append( FinanceService.numberFormat(s));
sb.append(" ");
}
}
		else if(mon.equalsIgnoreCase("hy1") || mon.equalsIgnoreCase("hy2")){
				String Q1;String Q2;
			if(mon.equalsIgnoreCase("hy1")){
				Q1="amj";
				Q2="jas";
			}
			else{
				Q1="ond";
				Q2="jfm";
			}
				
				 ResultSet rs = con.createStatement().executeQuery("select ceiling(sum(ubs_ytd_pp_report.Total_Revenue)) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='"+ytd+"' and ubs_ytd_pp_report.LOB='"+lob+"' and (ubs_ytd_pp_report.Quarter like '%"+Q1+"%' or ubs_ytd_pp_report.Quarter like '%"+Q2+"%')");
		    	  String s=null;
		    	  while (rs.next()) {
		      
		    		  
		          s=rs.getString("result");
		    	  }
		    	  
		    	  
		    	  if(s==null){
		    		  sb.append("Data not available for entered time period");
		    	  }
		    	  else{
		    		   sb.append("Total revenue for "+ytd+" " + lob.toUpperCase() +" in "+ Q1.toUpperCase()+" & "+Q2.toUpperCase() +" Half Year is : ");
		          
		    		   sb.append( FinanceService.numberFormat(s));
		               sb.append(" ");
		        }
		    	  
		    	  
				
			}
			else 
               {
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select ceiling(sum(ubs_ytd_pp_report.Total_Revenue)) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='"+ytd+"' and ubs_ytd_pp_report.LOB='"+lob+"' and ubs_ytd_pp_report.Month like '%"+mon+"%'");
                String s =null;
                while (rs.next()) 
{
    s = rs.getString("result");
     sb.append(" ");
    }
    if( s==null)
     {
          sb.append("Data not available for entered time period");
     }
           else{
   sb.append("Total revenue for "+ytd+" " + lob.toUpperCase() +" in "+ month.toUpperCase() +" month is : ");
   sb.append( FinanceService.numberFormat(s));
   sb.append(" ");
}
               }
}

else{
	 sb.append("Please enter a valid query. Type 'HELP' for sample use cases.");
}
       return " " + sb;
}

//Action Name-- QMGMLOB-------------------------------------------------------------

public static String qmgmlob(Connection con, Map<String, Object> properties, String lob, String mon,String month ,String gm,String ytd ) throws SQLException {
	 StringBuffer sb = new StringBuffer();
	 if(gm.equalsIgnoreCase("GrossMargin")&&month!=null&&lob!=null)
	 {
		 if(ytd.isEmpty()){
	      		ytd="FY 18-19";
	      	}
     if(mon.equalsIgnoreCase("AMJ") || mon.equalsIgnoreCase("JAS") || mon.equalsIgnoreCase("OND")|| mon.equalsIgnoreCase("JFM"))
     {
                     Statement stmt = con.createStatement();
                     ResultSet rs = stmt.executeQuery("select ceiling(sum(ubs_ytd_pp_report.Gross_Margin)) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='"+ytd+"' and ubs_ytd_pp_report.LOB='"+lob+"' and ubs_ytd_pp_report.Quarter like '%"+mon+"%'");
                     String s=null;
                     while (rs.next()) 
                         { 
                    	 s=rs.getString("result");
                    	 
                         }
                     if(s==null)
                     {
                    	 sb.append("Data not available for entered time period");
                     }
                     else
                     {
                    	 sb.append(" For "+ytd+" " + lob.toUpperCase()+" in "+month.toUpperCase()+" Quarter, Gross Margin is : ");
                        
                    	 sb.append( FinanceService.numberFormat(s));
                         sb.append(" ");
                     ResultSet rs1 = stmt.executeQuery("select round((sum(ubs_ytd_pp_report.Gross_Margin)/sum(ubs_ytd_pp_report.Total_Revenue))*100,2) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='"+ytd+"' and ubs_ytd_pp_report.LOB='"+lob+"' and ubs_ytd_pp_report.Quarter like '%"+mon+"%'");
                     while (rs1.next())
                     {      sb.append(" & Gross Margin % is : ");
                             sb.append(rs1.getString("result"));
                             sb.append("% ");
                             sb.append(" ");
                     }
                     }
    }
     
     else if(mon.equalsIgnoreCase("hy1") || mon.equalsIgnoreCase("hy2")){
     	String Q1;String Q2;
			if(mon.equalsIgnoreCase("hy1")){
				Q1="amj";
				Q2="jas";
			}
			else{
				Q1="ond";
				Q2="jfm";
			}
     	
     	   Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select ceiling(sum(ubs_ytd_pp_report.Gross_Margin)) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='"+ytd+"' and ubs_ytd_pp_report.LOB='"+lob+"' and (ubs_ytd_pp_report.Quarter like '%"+Q1+"%' or ubs_ytd_pp_report.Quarter like '%"+Q2+"%');");
            String s=null;
            while (rs.next()) 
           
                {   
            	s=rs.getString("result");
                }
            if(s==null){
            	sb.append("Data not available for entered time period");
            }
            else{
            	sb.append("For "+ytd+" " + Q1.toUpperCase()+" & "+Q2.toUpperCase()+" Half Year, Gross Margin is : ");
                
            	 sb.append( FinanceService.numberFormat(s));
                 sb.append(" ");
                
            ResultSet rs1 = stmt.executeQuery("select round((sum(ubs_ytd_pp_report.Gross_Margin)/sum(ubs_ytd_pp_report.Total_Revenue))*100,2) gm_per_monthly from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='"+ytd+"' and ubs_ytd_pp_report.LOB='"+lob+"' and (ubs_ytd_pp_report.Quarter like '%"+Q1+"%' or ubs_ytd_pp_report.Quarter like '%"+Q2+"%');");
            while (rs1.next())
            {      sb.append(" & Gross Margin % is : ");
                    sb.append(rs1.getString("gm_per_monthly"));
                    sb.append("% ");
                    sb.append(" ");
            }
     }
     }  
     else 
     { 
    	 Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery("select  ceiling(sum(ubs_ytd_pp_report.Gross_Margin))  as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='"+ytd+"' and ubs_ytd_pp_report.LOB='"+lob+ "' and ubs_ytd_pp_report.month like  '%"+mon+"%'");
                                                     String s =null;
                                                     while (rs.next()) 
                                                                     { 
                                                    	 s = rs.getString("result");
                                                        sb.append(" ");
                                                                     }
                                                                     if( s==null)
                                                                   {   sb.append("Data not available for entered time period");
                                                                                     }
                                                                     else
                                                             {   sb.append("For "+ lob.toUpperCase()+" in "+ month.toUpperCase() +" , Gross Margin is : ");
                                                             sb.append( FinanceService.numberFormat(s));
                                                             sb.append(" ");                                                                  
                                                                                     
ResultSet rs1 = stmt.executeQuery("select round((sum(ubs_ytd_pp_report.Gross_Margin)/sum(ubs_ytd_pp_report.Total_Revenue))*100,2) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='"+ytd+"' and ubs_ytd_pp_report.LOB='"+lob+"' and ubs_ytd_pp_report.Month like '%"+mon+"%'");
                                     String s1 =null;
                                     while (rs1.next()) 
                                      {    s1 = rs1.getString("result");
                                        sb.append(" & Gross Margin % is : ");
                                                                     sb.append(s1);
                                                                     sb.append("%");
                                                                     sb.append(" ");
                                                    }
}}}
	 
	 else{
		   sb.append("Please enter a valid query. Type 'HELP' for sample use cases.");
	 }
return " " + sb;
}


//Action Name-- DUHEADRevenueytd

public static String duheadrevytd(Connection con, Map<String, Object> properties, String du_head, String rev, String ytd) throws SQLException {
	
	
	
	StringBuffer sb = new StringBuffer();
	
	if(du_head != null && rev.equalsIgnoreCase("total revenue"))
	{
		 if(ytd.isEmpty()){
	      		ytd="FY 18-19";
	      	}
       ResultSet rs = con.createStatement().executeQuery("select ceiling(sum(ubs_ytd_pp_report.Total_Revenue)) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='"+ytd+"' and ubs_ytd_pp_report.DU_Head='"+du_head+"';");
         String s=null;
         while (rs.next()) 
               {           s=rs.getString("result");
                           sb.append(" ");
               }
         if(s== null)
               {
                                               sb.append("Data not available for entered time period"); 
               }
         else
                                             sb.append("Total Revenue for "+ytd+" " + du_head.toUpperCase() + " as DU head is : ");
                                            
         sb.append( FinanceService.numberFormat(s));
         sb.append(" ");
	}
	else{
		sb.append("Please enter a valid query. Type 'HELP' for sample use cases. ");
	}

	return " " + sb ;
}

//Action Name-- DUheadgmytd

public static String duheadgmytd(Connection con, Map<String, Object> properties, String du_head, String ytd, String gm) throws SQLException {
	 StringBuffer sb = new StringBuffer();
	  if(du_head != null && gm.equalsIgnoreCase("Grossmargin") )
	  {
		  if(ytd.isEmpty()){
	      		ytd="FY 18-19";
	      	}
		  Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select ceiling(sum(ubs_ytd_pp_report.Gross_Margin)) as result from banker_app_schema.ubs_ytd_pp_report  where ubs_ytd_pp_report.Year='"+ytd+"' and ubs_ytd_pp_report.DU_Head='"+du_head+"';");
     
      String s=null;
                      while (rs.next()) 
                                         {  
                    	  	s=rs.getString("result");
                          sb.append(" ");
                                         }
                         if(s==null)
                                         {
                                            sb.append("Data not available for entered time period"); 
                                         }
                         else{
                                            sb.append(" For "+ytd+" " + du_head.toUpperCase()+" as DU head , GROSS MARGIN is : ");
                                            sb.append( FinanceService.numberFormat(s));
                                            sb.append(" ");
                           
      ResultSet rs1 = stmt.executeQuery("select round((sum(ubs_ytd_pp_report.Gross_Margin)/sum(ubs_ytd_pp_report.Total_Revenue))*100,2) as result from banker_app_schema.ubs_ytd_pp_report  where ubs_ytd_pp_report.Year='"+ytd+"' and ubs_ytd_pp_report.DU_Head='"+du_head+"';");
String s1=null; 
                          while (rs1.next()) {
                                           s1=   rs1.getString("result");
                                           sb.append(" ");
                                     sb.append(" & GROSS MARGIN % is : ");
                                           sb.append(s1);
                                           sb.append("% ");
                                           sb.append(" ");
                                           }  
	  }}
	  else{
		  sb.append(" Please enter a valid query. Type 'HELP' for sample use cases. ");
	  }
                  return " " + sb;

}


//Action Name-- QmDuheadrevenue

public static String qmduheadrevenue(Connection con, Map<String, Object> properties, String du_head,String mon,String month, String rev, String ytd) throws SQLException {

{
StringBuffer sb = new StringBuffer();

if(du_head != null  && month != null && rev.equalsIgnoreCase("total revenue")){
	
	 if(ytd.isEmpty()){
   		ytd="FY 18-19";
   	}
		if(mon.equalsIgnoreCase("AMJ") || mon.equalsIgnoreCase("JAS") || mon.equalsIgnoreCase("OND") || mon.equalsIgnoreCase("JFM"))
{            
ResultSet rs = con.createStatement().executeQuery("select ceiling(sum(ubs_ytd_pp_report.total_revenue)) as result from banker_app_schema.ubs_ytd_pp_report  where ubs_ytd_pp_report.Year='"+ytd+"' and ubs_ytd_pp_report.DU_Head='"+du_head+"' and ubs_ytd_pp_report.Quarter like '%"+mon+"%'");

String s=null;
while (rs.next()) {
	s=rs.getString("result");
	
	if(s==null){
		sb.append("Data not available for entered time period");
	}
	else
	{
sb.append("Total revenue for "+ytd+" " + du_head.toUpperCase() +" as DU head in "+ month.toUpperCase() +" quarter is : ");
sb.append( FinanceService.numberFormat(s));
sb.append(" ");
	}
}
}

		
		else if(mon.equalsIgnoreCase("hy1") || mon.equalsIgnoreCase("hy2")){
			String Q1;String Q2;
		if(mon.equalsIgnoreCase("hy1")){
			Q1="amj";
			Q2="jas";
		}
		else{
			Q1="ond";
			Q2="jfm";
		}
			
			 ResultSet rs = con.createStatement().executeQuery("select ceiling(sum(ubs_ytd_pp_report.total_revenue)) as result from banker_app_schema.ubs_ytd_pp_report  where ubs_ytd_pp_report.Year='"+ytd+"' and ubs_ytd_pp_report.DU_Head='"+du_head+"' and (ubs_ytd_pp_report.Quarter like '%"+Q1+"%' or ubs_ytd_pp_report.Quarter like '%"+Q2+"%')");
	    	  String s=null;
	    	  while (rs.next()) {
	      
	    		  
	          s=rs.getString("result");
	    	  }
	    	  
	    	  
	    	  if(s==null){
	    		  sb.append("Data not available for entered time period");
	    	  }
	    	  else{
	    		   sb.append("Total revenue for "+ytd+" " + du_head.toUpperCase() +" in "+ Q1.toUpperCase()+" & "+Q2.toUpperCase() +" Half Year is : ");
	          
	    		   sb.append( FinanceService.numberFormat(s));
	               sb.append(" ");
	        }
	    	  
	    	  
			
		}
			else 
             {
              Statement stmt = con.createStatement();
              ResultSet rs = stmt.executeQuery("select ceiling(sum(ubs_ytd_pp_report.total_revenue)) as result from banker_app_schema.ubs_ytd_pp_report  where ubs_ytd_pp_report.Year='"+ytd+"' and ubs_ytd_pp_report.DU_Head='"+du_head+"' and ubs_ytd_pp_report.Month like '%"+mon+"%'");
              String s =null;
              while (rs.next()) 
{
  s = rs.getString("result");
   sb.append(" ");
  }
  if( s==null)
   {
        sb.append("Data not available for entered time period");
   }
         else{
 sb.append("Total revenue for "+ytd+" " + du_head.toUpperCase() +" as DU head in  "+ month.toUpperCase() +" month is : ");
 
 sb.append( FinanceService.numberFormat(s));
 sb.append(" ");
}
             }
}

else
{
	sb.append(" Please enter a valid query. Type 'HELP' for sample use cases.");
}
     return " " + sb;
}
}


// Action Name-------DmheadYTDRevenue

public static String YTDrevenuedmhead(Connection con, Map<String, Object> properties, String dm_name, String ytd, String rev) throws SQLException 
{
	StringBuffer sb = new StringBuffer();
	if(dm_name!=null&& rev.equalsIgnoreCase("total revenue")){
		 if(ytd.isEmpty()){
	      		ytd="FY 18-19";
	      	}
    Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery("select ceiling(sum(ubs_ytd_pp_report.Total_Revenue)) as result from banker_app_schema.ubs_ytd_pp_report  where ubs_ytd_pp_report.Year='"+ytd+"' and ubs_ytd_pp_report.DM_Name='"+dm_name+"'");
         String s=null;					   
         while (rs.next()) 
               {                              s=rs.getString("result");
               								sb.append(" ");
               }
         if(s== null)
               {
                                               sb.append("Data not available for entered time period"); 
               }
         else{
                                                                sb.append("Total Revenue for "+ytd+" " + dm_name.toUpperCase() + " as DM is : ");
                                              
         
                                                                sb.append( FinanceService.numberFormat(s));
                                                                sb.append(" ");
         }
	}
	else
	{
		sb.append("Please enter a valid query. Type 'HELP' for sample use cases.");
	}
                                               return " " + sb;
     }

// Action name ---------DMHEADytdgm

public static String YTDgmdmhead(Connection con, Map<String, Object> properties, String dm_name, String gm,String ytd) throws SQLException {
   {
	     StringBuffer sb = new StringBuffer();
	     if(dm_name !=null && gm.equalsIgnoreCase("Grossmargin"))
	     {
	    	 if(ytd.isEmpty()){
		      		ytd="FY 18-19";
		      	}
           Statement stmt = con.createStatement();
           ResultSet rs = stmt.executeQuery("select ceiling(sum(ubs_ytd_pp_report.Gross_Margin)) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='"+ytd+"' and ubs_ytd_pp_report.DM_Name='"+dm_name+"';"); 
      
           String s=null;
                           while (rs.next()) 
                                              {  s=rs.getString("result");
                                                                sb.append(" ");
                                              }
                              if(s==null)
                                              {
                                                 sb.append("Data not available for entered time period"); 
                                              }
                              else{
                                                 sb.append(" For "+ytd+" " + dm_name.toUpperCase()+" as DM, GROSS MARGIN is : ");
                                                
                                                 
                                                 sb.append( FinanceService.numberFormat(s));
                                                 sb.append(" ");
                              
           ResultSet rs1 = stmt.executeQuery("select round((sum(ubs_ytd_pp_report.Gross_Margin)/sum(ubs_ytd_pp_report.Total_Revenue))*100,2) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='"+ytd+"' and ubs_ytd_pp_report.DM_Name='"+dm_name+"';");
String s1=null; 
                               while (rs1.next()) {
                                                s1=   rs1.getString("result");
                                                sb.append(" ");
                                           sb.append(" & GROSS MARGIN % is : ");
                                                sb.append(s1);
                                                sb.append("% ");
                                                sb.append(" ");
                                                }  
	     }}
	     else{
	    	 sb.append(" Please enter a valid query. Type 'HELP' for sample use cases.");
	     }
                       return " " + sb;

}

}
// Action Name----------QMDMheadrevenue

public static String qmdmheadrevenue(Connection con, Map<String, Object> properties, String dm_name, String mon,String month, String rev,String ytd) throws SQLException {
	StringBuffer sb = new StringBuffer();
	
	if(dm_name!=null && month!=null && rev.equalsIgnoreCase("total revenue")){
		 if(ytd.isEmpty()){
	      		ytd="FY 18-19";
	      	}
	
	if(mon.equalsIgnoreCase("AMJ") || mon.equalsIgnoreCase("JAS") || mon.equalsIgnoreCase("OND") || mon.equalsIgnoreCase("JFM"))
{            
ResultSet rs = con.createStatement().executeQuery("select ceiling(sum(ubs_ytd_pp_report.Total_Revenue)) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='"+ytd+"' and ubs_ytd_pp_report.DM_Name='"+dm_name+"' and ubs_ytd_pp_report.Quarter like '%"+mon+"%'");

String s=null;
while (rs.next()) {
	s=rs.getString("result");
}
	if(s==null)
	{
		sb.append("Data not available for entered time period");
	}
	else
	{
sb.append("Total revenue for "+ytd+" " + dm_name.toUpperCase() +" as DM in "+ month.toUpperCase() +" quarter is : ");


sb.append( FinanceService.numberFormat(s));
sb.append(" ");
}
}
	else if(mon.equalsIgnoreCase("hy1") || mon.equalsIgnoreCase("hy2")){
		String Q1;String Q2;
	if(mon.equalsIgnoreCase("hy1")){
		Q1="amj";
		Q2="jas";
	}
	else{
		Q1="ond";
		Q2="jfm";
	}
		
		 ResultSet rs = con.createStatement().executeQuery("select ceiling(sum(ubs_ytd_pp_report.Total_Revenue)) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='"+ytd+"' and ubs_ytd_pp_report.DM_Name='"+dm_name+"' and (ubs_ytd_pp_report.Quarter like '%"+Q1+"%' or ubs_ytd_pp_report.Quarter like '%"+Q2+"%')");
    	  String s=null;
    	  while (rs.next()) {
      
    		  
          s=rs.getString("result");
    	  }
    	  
    	  
    	  if(s==null){
    		  sb.append("Data not available for entered time period");
    	  }
    	  else{
    		   sb.append("Total revenue for "+ytd+" " + dm_name.toUpperCase() +" in "+ Q1.toUpperCase()+" & "+Q2.toUpperCase() +" Half Year is : ");
          
    		   sb.append( FinanceService.numberFormat(s));
               sb.append(" ");
        }
    	  
    	  
		
	}	
	
	
	else 
           {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select ceiling(sum(ubs_ytd_pp_report.Total_Revenue)) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='"+ytd+"' and ubs_ytd_pp_report.DM_Name='"+dm_name+"' and ubs_ytd_pp_report.Month like '%"+mon+"%'");
            String s =null;
            while (rs.next()) 
{
s = rs.getString("result");
 sb.append(" ");
}
if( s==null)
 {
      sb.append("Data not available for entered time period");
 }
       else{
sb.append("Total revenue for "+ytd+" " +dm_name.toUpperCase() +" as DM in "+ month.toUpperCase() +" month is : ");


sb.append( FinanceService.numberFormat(s));
sb.append(" ");
       }
}
	}
	else {
		sb.append("Please enter a valid query. Type 'HELP' for sample use cases.");
	}
	
   return " " + sb;
}



//Action Name--------DUHeadGMQuartermonth   

public static String qmduheadgm(Connection con, Map<String, Object> properties, String du_head, String mon,String month,String gm,String ytd) throws SQLException {

	
	
	
		StringBuffer sb = new StringBuffer();
	if(du_head!=null && month!=null && gm.equalsIgnoreCase("Grossmargin")){
		
		 if(ytd.isEmpty()){
	      		ytd="FY 18-19";
	      	}
  if(mon.equalsIgnoreCase("AMJ") || mon.equalsIgnoreCase("JAS") || mon.equalsIgnoreCase("OND")|| mon.equalsIgnoreCase("JFM"))
  {
                  Statement stmt = con.createStatement();
                  ResultSet rs = stmt.executeQuery("select ceiling(sum(ubs_ytd_pp_report.Gross_Margin)) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='"+ytd+"' and ubs_ytd_pp_report.DU_Head='"+du_head+"' and ubs_ytd_pp_report.Quarter like '%"+mon+"%'");
                  String s=null;
                  while (rs.next()) 
                  	s=rs.getString("result");
                 if(s==null)
                 {
              	   sb.append("Data not available for entered time period");
                 }
                 else
                  
                      {   sb.append(" For "+ytd+" " + du_head.toUpperCase()+" as DU head in "+month.toUpperCase()+" Quarter, Gross Margin is : ");
                      
                      
                      sb.append( FinanceService.numberFormat(s));
                      sb.append(" ");
                  ResultSet rs1 = stmt.executeQuery("select round((sum(ubs_ytd_pp_report.Gross_Margin) / sum(ubs_ytd_pp_report.Total_Revenue))*100,2) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='"+ytd+"' and ubs_ytd_pp_report.DU_Head='"+du_head+"' and ubs_ytd_pp_report.Quarter like '%"+mon+"%'");
                 
                  while (rs1.next())
                  {      sb.append(" & Gross Margin % is : ");
                          sb.append(rs1.getString("result"));
                          sb.append("% ");
                          sb.append(" ");
                  }
 }
  }
  
  else if(mon.equalsIgnoreCase("hy1") || mon.equalsIgnoreCase("hy2")){
   	String Q1;String Q2;
			if(mon.equalsIgnoreCase("hy1")){
				Q1="amj";
				Q2="jas";
			}
			else{
				Q1="ond";
				Q2="jfm";
			}
   	
   	   Statement stmt = con.createStatement();
          ResultSet rs = stmt.executeQuery("select ceiling(sum(ubs_ytd_pp_report.Gross_Margin)) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='"+ytd+"' and ubs_ytd_pp_report.DU_Head='"+du_head+"' and (ubs_ytd_pp_report.Quarter like '%"+Q1+"%' or ubs_ytd_pp_report.Quarter like '%"+Q2+"%')");
          String s=null;
          while (rs.next()) 
         
              {   
          	s=rs.getString("result");
              }
          if(s==null){
          	sb.append("Data not available for entered time period");
          }
          else{
          	sb.append("For "+ytd+" " + Q1.toUpperCase()+" & "+Q2.toUpperCase()+" Half Year, Gross Margin is : ");
              
          	 sb.append( FinanceService.numberFormat(s));
               sb.append(" ");
              
          ResultSet rs1 = stmt.executeQuery("select round((sum(ubs_ytd_pp_report.Gross_Margin) / sum(ubs_ytd_pp_report.Total_Revenue))*100,2) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='"+ytd+"' and ubs_ytd_pp_report.DU_Head='"+du_head+"' and (ubs_ytd_pp_report.Quarter like '%"+Q1+"%' or ubs_ytd_pp_report.Quarter like '%"+Q2+"%')");
          while (rs1.next())
          {      sb.append(" & Gross Margin % is : ");
                  sb.append(rs1.getString("result"));
                  sb.append("% ");
                  sb.append(" ");
          }
   }
   } 
  
  else 
  {   
  	
  	Statement stmt = con.createStatement();
                                                  ResultSet rs = stmt.executeQuery("select ceiling(sum(ubs_ytd_pp_report.Gross_Margin)) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='"+ytd+"' and ubs_ytd_pp_report.DU_Head='"+du_head+"' and ubs_ytd_pp_report.Month like '%"+mon+"%'");
                                                // System.out.println(rs);
                                                  String s =null;
                                                  while (rs.next()) 
                                                                  {   s = rs.getString("result");
                                                                                  sb.append(" ");
                                                                  }
                                                                  if( s==null)
                                                                                  {   sb.append("Data not available for entered time period");
                                                                                  }
                                                                  else
                                                                                  {   sb.append("For "+ytd+" " +du_head.toUpperCase()+" as DU head in "+ month.toUpperCase() +"  , Gross Margin is : ");
                                                                                                 
                                                                                  
                                                                                  sb.append( FinanceService.numberFormat(s));
                                                                                  sb.append(" ");
ResultSet rs1 = stmt.executeQuery("select round((sum(ubs_ytd_pp_report.Gross_Margin) / sum(ubs_ytd_pp_report.Total_Revenue))*100,2) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='"+ytd+"' and ubs_ytd_pp_report.DU_Head='"+du_head+"' and ubs_ytd_pp_report.Month like '%"+mon+"%'");
                                  String s1 =null;
                                  while (rs1.next()) 
                                   {                             s1 = rs1.getString("result");
                                                            
                                   								sb.append(" & Gross Margin % is : ");
                                                                  sb.append(s1);
                                                                  sb.append("%");
                                                                  sb.append(" ");
                                                 }
}
  }
	}
	else{
		sb.append("Please enter a valid query. Type 'HELP' for sample use cases.");
	}
return " " + sb;
}



//Action Name----------QMDMHeadGM


public static String qmdmheadgm(Connection con, Map<String, Object> properties, String dm_name, String mon, String month, String gm,String ytd) throws SQLException {
	
StringBuffer sb = new StringBuffer();
	 if(dm_name!=null && month!=null && gm.equalsIgnoreCase("Grossmargin")){
		 if(ytd.isEmpty()){
	      		ytd="FY 18-19";
	      	}
	 
     if(mon.equalsIgnoreCase("AMJ") || mon.equalsIgnoreCase("JAS") || mon.equalsIgnoreCase("OND")|| mon.equalsIgnoreCase("JFM"))
     {
                     Statement stmt = con.createStatement();
                     ResultSet rs = stmt.executeQuery("select ceiling(sum(ubs_ytd_pp_report.Gross_Margin)) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='"+ytd+"' and ubs_ytd_pp_report.DM_Name='"+dm_name+"' and ubs_ytd_pp_report.Quarter like '%"+mon+"%'");
String s=null;
while (rs.next()) 
                         {
	s=rs.getString("result");
                         }
	if(s==null)
	{
		sb.append("Data not available for entered time period");
	}
	
	else {
	 sb.append(" For "+ytd+" " + dm_name.toUpperCase()+" as DM in "+month.toUpperCase()+" Quarter, Gross Margin is : ");
	 sb.append( FinanceService.numberFormat(s));
     sb.append(" ");
                     ResultSet rs1 = stmt.executeQuery("select round((sum(ubs_ytd_pp_report.Gross_Margin)/sum(ubs_ytd_pp_report.Total_Revenue))*100,2) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='"+ytd+"' and ubs_ytd_pp_report.DM_Name='"+dm_name+"' and ubs_ytd_pp_report.Quarter like '%"+mon+"%'");
                     while (rs1.next())
                     {      sb.append(" & Gross Margin % is : ");
                             sb.append(rs1.getString("result"));
                             sb.append("% ");
                             sb.append(" ");
                     }
    }
                         }
     
     else if(mon.equalsIgnoreCase("hy1") || mon.equalsIgnoreCase("hy2")){
    	   	String Q1;String Q2;
    				if(mon.equalsIgnoreCase("hy1")){
    					Q1="amj";
    					Q2="jas";
    				}
    				else{
    					Q1="ond";
    					Q2="jfm";
    				}
    	   	
    	   	   Statement stmt = con.createStatement();
    	          ResultSet rs = stmt.executeQuery("select ceiling(sum(ubs_ytd_pp_report.Gross_Margin)) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='"+ytd+"' and ubs_ytd_pp_report.DM_Name='"+dm_name+"' and (ubs_ytd_pp_report.Quarter like '%"+Q1+"%' or ubs_ytd_pp_report.Quarter like '%"+Q2+"%')");
    	          String s=null;
    	          while (rs.next()) 
    	         
    	              {   
    	          	s=rs.getString("result");
    	              }
    	          if(s==null){
    	          	sb.append("Data not available for entered time period");
    	          }
    	          else{
    	          	sb.append("For "+ytd+" " + Q1.toUpperCase()+" & "+Q2.toUpperCase()+" Half Year, Gross Margin is : ");
    	              
    	          	 sb.append( FinanceService.numberFormat(s));
    	               sb.append(" ");
    	              
    	          ResultSet rs1 = stmt.executeQuery("select round((sum(ubs_ytd_pp_report.Gross_Margin)/sum(ubs_ytd_pp_report.Total_Revenue))*100,2) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='"+ytd+"' and ubs_ytd_pp_report.DM_Name='"+dm_name+"' and (ubs_ytd_pp_report.Quarter like '%"+Q1+"%' or ubs_ytd_pp_report.Quarter like '%"+Q2+"%')");
    	          while (rs1.next())
    	          {      sb.append(" & Gross Margin % is : ");
    	                  sb.append(rs1.getString("result"));
    	                  sb.append("% ");
    	                  sb.append(" ");
    	          }
    	   }
    	   } 
     
     else 
     {                               
    	 System.out.println("i am in method");
    	 Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery("select ceiling(sum(ubs_ytd_pp_report.Gross_Margin)) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='"+ytd+"' and ubs_ytd_pp_report.DM_Name='"+dm_name+"' and ubs_ytd_pp_report.Month like '%"+mon+"%'");
         String s =null;
         	 while (rs.next()) 
     	{ 
         		 s = rs.getString("result");
           sb.append(" ");
        }
      if( s==null)
        {  
    	  sb.append("Data not available for entered time period");
              }
      else
         {   sb.append("For "+ytd+" " + dm_name.toUpperCase()+" as DM in "+ month.toUpperCase() +" month , Gross Margin is : ");
         		
         sb.append( FinanceService.numberFormat(s));
         sb.append(" ");
ResultSet rs1 = stmt.executeQuery("select round((sum(ubs_ytd_pp_report.Gross_Margin)/sum(ubs_ytd_pp_report.Total_Revenue))*100,2) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='"+ytd+"' and ubs_ytd_pp_report.DM_Name='"+dm_name+"' and ubs_ytd_pp_report.Month like '%"+mon+"%'");
                                     String s1 =null;
                                     while (rs1.next()) 
                                      {                             s1 = rs1.getString("result");
                                             sb.append(" & Gross Margin % is : ");
                                                                     sb.append(s1);
                                                                     sb.append("%");
                                                                     sb.append(" ");
                                                    }
         }
     }
	 }
	 else{
		 sb.append("Please enter a valid query. Type 'HELP' for sample use cases.");
	 }
	 
      
return " " + sb;
}


public String content(){
	
	return null;
}



//Action name---------DMHeadYTDDRC
public static String DRCYTDdmhead(Connection con, Map<String, Object> properties, String dm_name,String du_head, String ytd,String common,String lob) throws SQLException {
	StringBuffer sb = new StringBuffer();
	 System.out.println("1 "+ytd+" 3 "+common+" 4 "  + dm_name+" 5 "  + du_head+" 6 "  + lob);
	if((!dm_name.isEmpty() || !lob.isEmpty())&& !common.isEmpty()){
		 if(ytd.isEmpty()){
	      		ytd="FY 18-19";
	      	}
		String TableName = null;String value = null;String Query1=null;
		if(!dm_name.isEmpty()){
	 TableName="DM_Name";
	 value=dm_name;
	 lob="null";
		System.out.println("--------9");
		}else if(!lob.isEmpty()){
	 TableName="LOB";
	 value=lob;
	 
		System.out.println("--------10"+lob);
		}
		if(lob.equalsIgnoreCase("apps")){
		Query1=DataBaseQueryForFinance.Query_To_Fetch_dmname_ytd_all_parameters+common+DataBaseQueryForFinance.Query_To_Fetch_dmname_ytd_all_parameters_cntd_for_apps+ytd+"'";
			System.out.println("--------7");
		}
		else if(lob.equalsIgnoreCase("ESI") || lob.equalsIgnoreCase("IAS BFSI")){
			Query1=DataBaseQueryForFinance.Query_To_Fetch_dmname_ytd_all_parameters+common+DataBaseQueryForFinance.Query_To_Fetch_dmname_ytd_all_parameters_cntd_for_apps+ytd+DataBaseQueryForFinance.Query_To_Fetch_dmname_ytd_all_parameters_cntd_for_apps1+lob+"'";
				System.out.println("--------11");
			}
		
		else{
		Query1=DataBaseQueryForFinance.Query_To_Fetch_dmname_ytd_all_parameters+common+DataBaseQueryForFinance.Query_To_Fetch_dmname_ytd_all_parameters_cntd1+ytd+DataBaseQueryForFinance.Query_To_Fetch_dmname_ytd_all_parameters_cntd2+TableName+DataBaseQueryForFinance.Query_To_Fetch_dmname_ytd_all_parameters_cntd3+"'"+value+"'";
		System.out.println("--------8");
		}
	
	sb.append(FinanceService.YTDdmduhead(con, properties, dm_name, du_head, ytd, common,lob, Query1));
	}
	
	else{
		sb.append("Please enter a valid query. Type 'HELP' for sample use cases.");
	}
	
	return ""+sb;
     }









//Action name---------DUHeadYTDDRC
public static String DRCYTDduhead(Connection con, Map<String, Object> properties,String dm_name, String du_head, String ytd,String common,String lob) throws SQLException {
	StringBuffer sb = new StringBuffer();
	if(!du_head.isEmpty() && !common.isEmpty()){
		 if(ytd.isEmpty()){
	      		ytd="FY 18-19";
	      	}	
	String Query1=DataBaseQueryForFinance.Query_To_Fetch_duhead_ytd_all_parameters+common+DataBaseQueryForFinance.Query_To_Fetch_duhead_ytd_all_parameters_cntd1+ytd+DataBaseQueryForFinance.Query_To_Fetch_duhead_ytd_all_parameters_cntd2+"'"+du_head+"'";
	sb.append(FinanceService.YTDdmduhead(con, properties, dm_name, du_head, ytd, common,lob, Query1));
	}
	else{
		sb.append("Please enter a valid query. Type 'HELP' for sample use cases.");
	}
	
	return ""+sb;
   }



//Action Name----------DMHeadQMDRC

public static String qmdmheaddrc(Connection con, Map<String, Object> properties, String dm_name,String du_head, String mon, String month, String common, String lob,String ytd) throws SQLException {
	
StringBuffer sb = new StringBuffer();
	
	if((!dm_name.isEmpty() || !lob.isEmpty()) && !month.isEmpty() && !common.isEmpty()){
		 if(ytd.isEmpty()){
	      		ytd="FY 18-19";
	      	}
		String TableName = null;String value = null;String Query1=null;String Query2=null;String Query3=null;
		if(!dm_name.isEmpty()){
	 TableName="DM_Name";
	 value=dm_name;
	 lob="null";
		}else if(!lob.isEmpty()){
	 TableName="LOB";
	 value=lob;
		}
		if(lob.equalsIgnoreCase("apps")){
		Query1=DataBaseQueryForFinance.Query_To_Fetch_dmname_Quarter_all_parameters+common+DataBaseQueryForFinance.Query_To_Fetch_dmname_Quarter_all_parameters_cntd_for_apps+ytd+DataBaseQueryForFinance.Query_To_Fetch_dmname_Quarter_all_parameters_cntd_for_apps1+mon+"%'";
			
		}
		else if(lob.equalsIgnoreCase("ESI") || lob.equalsIgnoreCase("IAS BFSI")){
			Query1=DataBaseQueryForFinance.Query_To_Fetch_dmname_Quarter_all_parameters+common+DataBaseQueryForFinance.Query_To_Fetch_dmname_Quarter_all_parameters_cntd_for_apps+ytd+DataBaseQueryForFinance.Query_To_Fetch_dmname_Quarter_all_parameters_cntd_for_apps1+mon+DataBaseQueryForFinance.Query_To_Fetch_dmname_Quarter_all_parameters_cntd_for_apps2+lob+"'";
				System.out.println("amj");
			}
		else{
		
				Query1=DataBaseQueryForFinance.Query_To_Fetch_dmname_Quarter_all_parameters+common+DataBaseQueryForFinance.Query_To_Fetch_dmname_Quarter_all_parameters_cntd1+ytd+DataBaseQueryForFinance.Query_To_Fetch_dmname_Quarter_all_parameters_cntd2+TableName+DataBaseQueryForFinance.Query_To_Fetch_dmname_Quarter_all_parameters_cntd3+value+DataBaseQueryForFinance.Query_To_Fetch_dmname_Quarter_all_parameters_cntd4+mon+"%'";
		}
		
		String Q1 = null;String Q2 = null;
		if(mon.equalsIgnoreCase("hy1")){
	  		Q1="amj";
	  		Q2="jas";
	  	}
		else if(mon.equalsIgnoreCase("hy2")){
	  		Q1="ond";
	  		Q2="jfm";
	  	}
		if(lob.equalsIgnoreCase("apps")){
		Query2=DataBaseQueryForFinance.Query_To_Fetch_dmname_Halfyear_all_parameters+common+DataBaseQueryForFinance.Query_To_Fetch_dmname_Halfyear_all_parameters_cntd_for_apps+ytd+DataBaseQueryForFinance.Query_To_Fetch_dmname_Halfyear_all_parameters_cntd_for_apps1+Q1+DataBaseQueryForFinance.Query_To_Fetch_dmname_Halfyear_all_parameters_cntd5+Q2+"%')";
		}
		else if(lob.equalsIgnoreCase("ESI") || lob.equalsIgnoreCase("IAS BFSI")){
			Query2=DataBaseQueryForFinance.Query_To_Fetch_dmname_Halfyear_all_parameters+common+DataBaseQueryForFinance.Query_To_Fetch_dmname_Halfyear_all_parameters_cntd_for_apps+ytd+DataBaseQueryForFinance.Query_To_Fetch_dmname_Halfyear_all_parameters_cntd_for_apps1+Q1+DataBaseQueryForFinance.Query_To_Fetch_dmname_Halfyear_all_parameters_cntd5+Q2+DataBaseQueryForFinance.Query_To_Fetch_dmname_Halfyear_all_parameters_cntd_for_apps2+lob+"'";	
			System.out.println("hy");
		}
		else{
			Query2=DataBaseQueryForFinance.Query_To_Fetch_dmname_Halfyear_all_parameters+common+DataBaseQueryForFinance.Query_To_Fetch_dmname_Halfyear_all_parameters_cntd1+ytd+DataBaseQueryForFinance.Query_To_Fetch_dmname_Halfyear_all_parameters_cntd2+TableName+DataBaseQueryForFinance.Query_To_Fetch_dmname_Halfyear_all_parameters_cntd3+value+DataBaseQueryForFinance.Query_To_Fetch_dmname_Halfyear_all_parameters_cntd4+Q1+DataBaseQueryForFinance.Query_To_Fetch_dmname_Halfyear_all_parameters_cntd5+Q2+"%')";
		}
		if(lob.equalsIgnoreCase("apps")){
		 Query3=DataBaseQueryForFinance.Query_To_Fetch_dmname_month_all_parameters+common+DataBaseQueryForFinance.Query_To_Fetch_dmname_month_all_parameters_cntd_for_apps+ytd+DataBaseQueryForFinance.Query_To_Fetch_dmname_month_all_parameters_cntd_for_apps1+mon+"%'";
		}
		else if(lob.equalsIgnoreCase("ESI") || lob.equalsIgnoreCase("IAS BFSI")){
			Query3=DataBaseQueryForFinance.Query_To_Fetch_dmname_month_all_parameters+common+DataBaseQueryForFinance.Query_To_Fetch_dmname_month_all_parameters_cntd_for_apps+ytd+DataBaseQueryForFinance.Query_To_Fetch_dmname_month_all_parameters_cntd_for_apps1+mon+DataBaseQueryForFinance.Query_To_Fetch_dmname_month_all_parameters_cntd_for_apps2+lob+"'";	
			System.out.println("month"+Query3);
		}
		else{
			Query3=DataBaseQueryForFinance.Query_To_Fetch_dmname_month_all_parameters+common+DataBaseQueryForFinance.Query_To_Fetch_dmname_month_all_parameters_cntd1+ytd+DataBaseQueryForFinance.Query_To_Fetch_dmname_month_all_parameters_cntd2+TableName+DataBaseQueryForFinance.Query_To_Fetch_dmname_month_all_parameters_cntd3+value+DataBaseQueryForFinance.Query_To_Fetch_dmname_month_all_parameters_cntd4+mon+"%'";
		}
		sb.append(FinanceService.qmdmduhead(con, properties, dm_name,du_head, mon, month, common,lob, Query1, Query2, Query3,ytd));
	}
	else {
		sb.append("Please enter a valid query. Type 'HELP' for sample use cases.");
	}
	
   return " " + sb;
}

//Action Name----------DuHeadQMDRC

public static String qmduheaddrc(Connection con, Map<String, Object> properties, String dm_name,String du_head, String mon, String month, String common, String lob,String ytd) throws SQLException {
	
StringBuffer sb = new StringBuffer();
	
	if(!du_head.isEmpty() && !month.isEmpty() && !common.isEmpty()){
		 if(ytd.isEmpty()){
	      		ytd="FY 18-19";
	      	}
		String Query1=DataBaseQueryForFinance.Query_To_Fetch_duhead_Quarter_all_parameters+common+DataBaseQueryForFinance.Query_To_Fetch_duhead_Quarter_all_parameters_cntd1+ytd+DataBaseQueryForFinance.Query_To_Fetch_duhead_Quarter_all_parameters_cntd2+du_head+DataBaseQueryForFinance.Query_To_Fetch_duhead_Quarter_all_parameters_cntd3+mon+"%'";
		String Q1 = null;String Q2 = null;
		if(mon.equalsIgnoreCase("hy1")){
	  		Q1="amj";
	  		Q2="jas";
	  	}
		else if(mon.equalsIgnoreCase("hy2")){
	  		Q1="ond";
	  		Q2="jfm";
	  	}
		String Query2=DataBaseQueryForFinance.Query_To_Fetch_duhead_Halfyear_all_parameters+common+DataBaseQueryForFinance.Query_To_Fetch_duhead_Halfyear_all_parameters_cntd1+ytd+DataBaseQueryForFinance.Query_To_Fetch_duhead_Halfyear_all_parameters_cntd2+du_head+DataBaseQueryForFinance.Query_To_Fetch_duhead_Halfyear_all_parameters_cntd3+Q1+DataBaseQueryForFinance.Query_To_Fetch_duhead_Halfyear_all_parameters_cntd4+Q2+"%')";
		
		String Query3=DataBaseQueryForFinance.Query_To_Fetch_duhead_month_all_parameters+common+DataBaseQueryForFinance.Query_To_Fetch_duhead_month_all_parameters_cntd1+ytd+DataBaseQueryForFinance.Query_To_Fetch_duhead_month_all_parameters_cntd2+du_head+DataBaseQueryForFinance.Query_To_Fetch_duhead_month_all_parameters_cntd3+mon+"%'";
	
		sb.append(FinanceService.qmdmduhead(con, properties, dm_name, du_head, mon, month, common,lob,Query1, Query2, Query3,ytd));
	}
	else {
		sb.append("Please enter a valid query. Type 'HELP' for sample use cases.");
	}
	
 return " " + sb;
}

//Action name-----------------YTDDRC------------------
public static String YTDdrc(Connection con, Map<String, Object> properties, String ytd, String common,String lob,String du_head,String dm_name) throws SQLException {
	StringBuffer sb = new StringBuffer();
	if(!common.isEmpty()){
		 if(ytd.isEmpty()){
	      		ytd="FY 18-19";
	      	}	
	String Query1=DataBaseQueryForFinance.Query_To_Fetch_ytd_all_parameters+common+DataBaseQueryForFinance.Query_To_Fetch_ytd_all_parameters_cntd+ytd+"'";
	sb.append(FinanceService.YTDdmduhead(con, properties, dm_name, du_head, ytd, common,lob, Query1));
	}
	else{
		sb.append("Please enter a valid query. Type 'HELP' for sample use cases.");
	}
	
	return ""+sb;
 }


//Action Name----------QMDRC
public static String QMdrc(Connection con, Map<String, Object> properties, String mon, String month,String common, String ytd,String lob,String du_head,String dm_name) throws SQLException {
	
StringBuffer sb = new StringBuffer();
	
	if(!month.isEmpty() && !common.isEmpty()){
		 if(ytd.isEmpty()){
	      		ytd="FY 18-19";
	      	}
		String Query1=DataBaseQueryForFinance.Query_To_Fetch_Quarter_all_parameters+common+DataBaseQueryForFinance.Query_To_Fetch_Quarter_all_parameters_cntd+ytd+DataBaseQueryForFinance.Query_To_Fetch_Quarter_all_parameters_cntd1+mon+"%'";
		String Q1 = null;String Q2 = null;
		if(mon.equalsIgnoreCase("hy1")){
	  		Q1="amj";
	  		Q2="jas";
	  	}
		else if(mon.equalsIgnoreCase("hy2")){
	  		Q1="ond";
	  		Q2="jfm";
	  	}
		String Query2=DataBaseQueryForFinance.Query_To_Fetch_Halfyear_all_parameters+common+DataBaseQueryForFinance.Query_To_Fetch_Halfyear_all_parameters_cntd+ytd+DataBaseQueryForFinance.Query_To_Fetch_Halfyear_all_parameters_cntd1+Q1+DataBaseQueryForFinance.Query_To_Fetch_Halfyear_all_parameters_cntd2+Q2+"%')";
		
		String Query3=DataBaseQueryForFinance.Query_To_Fetch_month_all_parameters+common+DataBaseQueryForFinance.Query_To_Fetch_month_all_parameters_cntd+ytd+DataBaseQueryForFinance.Query_To_Fetch_month_all_parameters_cntd1+mon+"%'";
	
		sb.append(FinanceService.qmdmduhead(con, properties, dm_name,du_head, mon, month, common,lob,Query1, Query2, Query3,ytd));
	}
	else {
		sb.append("Please enter a valid query. Type 'HELP' for sample use cases.");
	}
	
   return " " + sb;
}



//---------report---
public static String Report(Connection con, Map<String, Object> properties, String du_head, String dm_name,Map<String, Object> properties_username, String id,String name,String ytd) throws SQLException {
	
	System.out.println("hi this is mail method");
	
	System.out.println("-----------------------------hi-----------------------------------------------------------------------------------------------------------------------------------------"
			+ "");
	System.out.println(dm_name);
	System.out.println(du_head);
	System.out.println(id);

	String Tomail=id.substring(4);	
System.out.println("First --"+Tomail);
	StringBuffer sb = new StringBuffer();
	try{
		
		//String output = Tomail.substring(Tomail.length() - 8);
		
	
	if((!du_head.isEmpty()) || (!dm_name.isEmpty())){
		 if(ytd.isEmpty()){
	      		ytd="FY 18-19";
	      	}
		 System.out.println("----------ytd----------"+ytd);
		String TableName = null;String value = null;String role=null;
		String ActualRev = null;String Actualgm=null;String ActualgmPer=null;
		String BudgetRevGmGMper = null;String Budgetgm=null;String achievementgm=null;
		if(!dm_name.isEmpty()){
			 TableName="DM_Name";
			 value=dm_name;
			 role="DM";
			 
				}else if(!du_head.isEmpty()){
			 TableName="DU_Head";
			 value=du_head;
			 role="DU";
			 
				}
		List Budget =new ArrayList();
		List AllAcheivements = new ArrayList();
		//----------------------ACTUALS
		 ResultSet allActuals = con.createStatement().executeQuery(DataBaseQueryForFinance.Query_To_Fetch_Revenue_GM_GmPer_Actual+ytd+DataBaseQueryForFinance.Query_To_Fetch_Revenue_GM_GmPer_Actual_cntd+TableName+DataBaseQueryForFinance.Query_To_Fetch_Revenue_GM_GmPer_Actual_cntd1+value+"'");
		 while (allActuals.next()) {
			 ActualRev=allActuals.getString("rev");
			 Actualgm=allActuals.getString("gm");
			 ActualgmPer=allActuals.getString("gmper");
			}
		 
		
		 //----------------------BUDGETS
		 ResultSet allBudgets = con.createStatement().executeQuery(DataBaseQueryForFinance.Query_To_Fetch_Revenue_GM_GmPer_Budget+ytd
				 +DataBaseQueryForFinance.Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd+value
				 +DataBaseQueryForFinance.Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd1+role
				 +DataBaseQueryForFinance.Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd2+ytd
				 +DataBaseQueryForFinance.Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd3+value
				 +DataBaseQueryForFinance.Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd4+role
				 +DataBaseQueryForFinance.Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd5+ytd
				 +DataBaseQueryForFinance.Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd6+value
				 +DataBaseQueryForFinance.Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd7+role
				 +DataBaseQueryForFinance.Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd8+ytd
				 +DataBaseQueryForFinance.Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd9+value
				 +DataBaseQueryForFinance.Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd10+role
				 +DataBaseQueryForFinance.Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd11);
		 while (allBudgets.next()) {
			 BudgetRevGmGMper=allBudgets.getString("result");
		 
			 Budget.add(BudgetRevGmGMper); 
			}
		 String Budgetrev=(String) Budget.get(0);
			String BudgetGM=(String) Budget.get(1);
			String BudgetGMPer=(String) Budget.get(2);
			System.out.println(" bbbb   "+Budgetrev +" "+ BudgetGM +" "+ BudgetGMPer);
			//--------------------------ACHIEVEMENTS
			String Arev=null; String Agm=null; String Agmp=null;
			ResultSet AchievementsRev=con.createStatement().executeQuery(DataBaseQueryForFinance.Query_To_Fetch_Revenue_Achievement+ytd+
					DataBaseQueryForFinance.Query_To_Fetch_Revenue_Achievement_cntd+value+
					DataBaseQueryForFinance.Query_To_Fetch_Revenue_Achievement_cntd1+role+
					DataBaseQueryForFinance.Query_To_Fetch_Revenue_Achievement_cntd2+ytd+
					DataBaseQueryForFinance.Query_To_Fetch_Revenue_Achievement_cntd3+TableName+
					DataBaseQueryForFinance.Query_To_Fetch_Revenue_Achievement_cntd4+value+"'");
			 
			 while (AchievementsRev.next()) {
				 Arev= AchievementsRev.getString("result");
				
				}
			 
			 ResultSet AchievementsGM=con.createStatement().executeQuery(DataBaseQueryForFinance.Query_To_Fetch_GM_Achievement+ytd+
					 DataBaseQueryForFinance.Query_To_Fetch_GM_Achievement_cntd+value+
					 DataBaseQueryForFinance.Query_To_Fetch_GM_Achievement_cntd1+role+
					 DataBaseQueryForFinance.Query_To_Fetch_GM_Achievement_cntd2+ytd+
					 DataBaseQueryForFinance.Query_To_Fetch_GM_Achievement_cntd3+TableName+
					 DataBaseQueryForFinance.Query_To_Fetch_GM_Achievement_cntd4+value+"'");
				
			 while (AchievementsGM.next()) {
				 Agm= AchievementsGM.getString("result");
				
				}
			 ResultSet AchievementsGMP=con.createStatement().executeQuery(DataBaseQueryForFinance.Query_To_Fetch_GMP_Achievement+ytd+
					 DataBaseQueryForFinance.Query_To_Fetch_GMP_Achievement_cntd+value+
					 DataBaseQueryForFinance.Query_To_Fetch_GMP_Achievement_cntd1+role+
					 DataBaseQueryForFinance.Query_To_Fetch_GMP_Achievement_cntd2+ytd+
					 DataBaseQueryForFinance.Query_To_Fetch_GMP_Achievement_cntd3+value+
					 DataBaseQueryForFinance.Query_To_Fetch_GMP_Achievement_cntd4+role+
					 DataBaseQueryForFinance.Query_To_Fetch_GMP_Achievement_cntd5+ytd+
					 DataBaseQueryForFinance.Query_To_Fetch_GMP_Achievement_cntd6+TableName+
					 DataBaseQueryForFinance.Query_To_Fetch_GMP_Achievement_cntd7+value+"'");
			 
			 while (AchievementsGMP.next()) {
				 Agmp= AchievementsGMP.getString("result");
				
				}
			 System.out.println("Achv   "+Arev+"    "+Agm+"  "+Agmp);
			//---------------------------MOM----------------------------------------------------------------
		 List Month = new ArrayList();
		 List revMOM = new ArrayList();
		 List gmMOM = new ArrayList();
		 List gmPerMOM = new ArrayList();
		 
		 ResultSet MonthOnMonth = con.createStatement().executeQuery(DataBaseQueryForFinance.Query_To_Fetch_MOM+ytd+
				 DataBaseQueryForFinance.Query_To_Fetch_MOM_cntd+TableName+
				 DataBaseQueryForFinance.Query_To_Fetch_MOM_cntd1+value+
				 DataBaseQueryForFinance.Query_To_Fetch_MOM_cntd2);
		 while (MonthOnMonth.next()) {
			
			 Month.add(MonthOnMonth.getString("Month"));
			 revMOM.add(MonthOnMonth.getString("Total_Revenue")+"M");
			 gmMOM.add(MonthOnMonth.getString("Gross_margin")+"M");
			 gmPerMOM.add(MonthOnMonth.getString("Gross_margin_percentage"));
			 
			}
		 System.out.println("checkimg million------------"+revMOM);
		 //--------------------------MOMyearlyTotal---------------------------------------
		 String MomTrev=null; String MomTgm=null; String MomTgmp=null;
		 ResultSet MonthOnMonthYearlyRev = con.createStatement().executeQuery(DataBaseQueryForFinance.Query_To_Fetch_MOM_TotalRev_Yearly+ytd+
				 DataBaseQueryForFinance.Query_To_Fetch_MOM_TotalRev_Yearly_cntd+TableName+
				 DataBaseQueryForFinance.Query_To_Fetch_MOM_TotalRev_Yearly_cntd1+value+"'");
		 while(MonthOnMonthYearlyRev.next()){
			 MomTrev=MonthOnMonthYearlyRev.getString("result");
			 
		 }
		 ResultSet MonthOnMonthYearlygm = con.createStatement().executeQuery(DataBaseQueryForFinance.Query_To_Fetch_MOM_TotalGM_Yearly+ytd+
				 DataBaseQueryForFinance.Query_To_Fetch_MOM_TotalGM_Yearly_cntd+TableName+
				 DataBaseQueryForFinance.Query_To_Fetch_MOM_TotalGM_Yearly_cntd1+value+"'");
		 while(MonthOnMonthYearlygm.next()){
			 MomTgm=MonthOnMonthYearlygm.getString("result");
			 
		 }
		 ResultSet MonthOnMonthYearlygmp = con.createStatement().executeQuery(DataBaseQueryForFinance.Query_To_Fetch_MOM_TotalGMP_Yearly+ytd+
				 DataBaseQueryForFinance.Query_To_Fetch_MOM_TotalGMP_Yearly_cntd+TableName+
				 DataBaseQueryForFinance.Query_To_Fetch_MOM_TotalGMP_Yearly_cntd1+value+"'");
		 while(MonthOnMonthYearlygmp.next()){
			 MomTgmp=MonthOnMonthYearlygmp.getString("result");
			 
		 }
	AllAcheivements.add(FinanceService.millions(ActualRev));
		 AllAcheivements.add(FinanceService.millions(Actualgm));
		 AllAcheivements.add(ActualgmPer);
		 AllAcheivements.add(FinanceService.millions(Budgetrev));
		 AllAcheivements.add(FinanceService.millions(BudgetGM));
		 AllAcheivements.add(BudgetGMPer);
		 AllAcheivements.add(Arev);
		 AllAcheivements.add(Agm);
		 AllAcheivements.add(Agmp);
		 
		/*AllAcheivements.addAll(Month);		
		AllAcheivements.addAll(revMOM);		
		AllAcheivements.addAll(gmMOM);		
		AllAcheivements.addAll(gmPerMOM);	*/	
		
		AllAcheivements.add(FinanceService.millions(MomTrev));
		 AllAcheivements.add(FinanceService.millions(MomTgm));
		 AllAcheivements.add(MomTgmp);
		 System.out.println(FinanceService.millions(ActualRev));
		// String Unique= FinanceService.getSaltString();
		// ResultSet Attachment = con.createStatement().executeQuery(DataBaseQueryForFinance.Query_To_Fetch_Attachment_excel+value+"_"+Unique+DataBaseQueryForFinance.Query_To_Fetch_Attachment_excel_cntd1+DataBaseQueryForFinance.Query_To_Fetch_Attachment_excel_cntd2+ytd+DataBaseQueryForFinance.Query_To_Fetch_Attachment_excel_cntd3+TableName+DataBaseQueryForFinance.Query_To_Fetch_Attachment_excel_cntd4+value+"'");		
	
		
		System.out.println("----------------------------------------------------------------------------------------------");
	System.out.println(Tomail);
	System.out.println("----------------------------------------------------------------------------------------------");
		
	sb.append("Mail sent successfully");

	System.out.println("--------9"+Tomail);
	
	//String XLSXsavedPath=FinanceService.maiCSVtoEXCEL("C:\\ProgramData\\MySQL\\MySQL Server 5.7\\Uploads\\"+value+"_"+Unique+".csv",value,Unique);
	
	//mail.Mailtrigger("Celeritas@hcl.com", Tomail, value.toUpperCase()+" ("+role+")"+" : Financials FY17-18", role, "checking.vm", AllAcheivements,Month,revMOM,gmMOM,gmPerMOM, XLSXsavedPath);
		
		
	}
	else{
		sb.append("Please enter a valid query. Type 'HELP' for sample use cases.");
	}
		
}
catch(Exception e){

	System.out.println("---------------------");
	System.out.println(e);
	System.out.println("---------------------");
	sb.append("Data not available for entered time period.");
	
}
	return "" +sb;
}

//------------report 2nd------------
public static String Reportcntd(Connection con, Map<String, Object> properties, String du_head, String dm_name,Map<String, Object> properties_username, String id,String name,String ytd) throws SQLException {
	StringBuffer sb = new StringBuffer();
try{
		

			String Tomail=id.substring(4);	
		System.out.println("First --"+Tomail);
	
		if((!du_head.isEmpty()) || (!dm_name.isEmpty())){
			 if(ytd.isEmpty()){
		      		ytd="FY 18-19";
		      	}
			 System.out.println("----------ytd----------"+ytd);
			String TableName = null;String value = null;String role=null;
			String ActualRev = null;String Actualgm=null;String ActualgmPer=null;
			String BudgetRevGmGMper = null;String Budgetgm=null;String achievementgm=null;
			if(!dm_name.isEmpty()){
				 TableName="DM_Name";
				 value=dm_name;
				 role="DM";
				 
					}else if(!du_head.isEmpty()){
				 TableName="DU_Head";
				 value=du_head;
				 role="DU";
				 
					}
			List Budget =new ArrayList();
			List AllAcheivements = new ArrayList();
			//----------------------ACTUALS
			 ResultSet allActuals = con.createStatement().executeQuery(DataBaseQueryForFinance.Query_To_Fetch_Revenue_GM_GmPer_Actual+ytd+DataBaseQueryForFinance.Query_To_Fetch_Revenue_GM_GmPer_Actual_cntd+TableName+DataBaseQueryForFinance.Query_To_Fetch_Revenue_GM_GmPer_Actual_cntd1+value+"'");
			 while (allActuals.next()) {
				 ActualRev=allActuals.getString("rev");
				 Actualgm=allActuals.getString("gm");
				 ActualgmPer=allActuals.getString("gmper");
				}
			 
			
			 //----------------------BUDGETS
			 ResultSet allBudgets = con.createStatement().executeQuery(DataBaseQueryForFinance.Query_To_Fetch_Revenue_GM_GmPer_Budget+ytd
					 +DataBaseQueryForFinance.Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd+value
					 +DataBaseQueryForFinance.Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd1+role
					 +DataBaseQueryForFinance.Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd2+ytd
					 +DataBaseQueryForFinance.Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd3+value
					 +DataBaseQueryForFinance.Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd4+role
					 +DataBaseQueryForFinance.Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd5+ytd
					 +DataBaseQueryForFinance.Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd6+value
					 +DataBaseQueryForFinance.Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd7+role
					 +DataBaseQueryForFinance.Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd8+ytd
					 +DataBaseQueryForFinance.Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd9+value
					 +DataBaseQueryForFinance.Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd10+role
					 +DataBaseQueryForFinance.Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd11);
			 while (allBudgets.next()) {
				 BudgetRevGmGMper=allBudgets.getString("result");
			 
				 Budget.add(BudgetRevGmGMper); 
				}
			 String Budgetrev=(String) Budget.get(0);
				String BudgetGM=(String) Budget.get(1);
				String BudgetGMPer=(String) Budget.get(2);
				System.out.println(" bbbb   "+Budgetrev +" "+ BudgetGM +" "+ BudgetGMPer);
				//--------------------------ACHIEVEMENTS
				String Arev=null; String Agm=null; String Agmp=null;
				ResultSet AchievementsRev=con.createStatement().executeQuery(DataBaseQueryForFinance.Query_To_Fetch_Revenue_Achievement+ytd+
						DataBaseQueryForFinance.Query_To_Fetch_Revenue_Achievement_cntd+value+
						DataBaseQueryForFinance.Query_To_Fetch_Revenue_Achievement_cntd1+role+
						DataBaseQueryForFinance.Query_To_Fetch_Revenue_Achievement_cntd2+ytd+
						DataBaseQueryForFinance.Query_To_Fetch_Revenue_Achievement_cntd3+TableName+
						DataBaseQueryForFinance.Query_To_Fetch_Revenue_Achievement_cntd4+value+"'");
				 
				 while (AchievementsRev.next()) {
					 Arev= AchievementsRev.getString("result");
					
					}
				 
				 ResultSet AchievementsGM=con.createStatement().executeQuery(DataBaseQueryForFinance.Query_To_Fetch_GM_Achievement+ytd+
						 DataBaseQueryForFinance.Query_To_Fetch_GM_Achievement_cntd+value+
						 DataBaseQueryForFinance.Query_To_Fetch_GM_Achievement_cntd1+role+
						 DataBaseQueryForFinance.Query_To_Fetch_GM_Achievement_cntd2+ytd+
						 DataBaseQueryForFinance.Query_To_Fetch_GM_Achievement_cntd3+TableName+
						 DataBaseQueryForFinance.Query_To_Fetch_GM_Achievement_cntd4+value+"'");
					
				 while (AchievementsGM.next()) {
					 Agm= AchievementsGM.getString("result");
					
					}
				 ResultSet AchievementsGMP=con.createStatement().executeQuery(DataBaseQueryForFinance.Query_To_Fetch_GMP_Achievement+ytd+
						 DataBaseQueryForFinance.Query_To_Fetch_GMP_Achievement_cntd+value+
						 DataBaseQueryForFinance.Query_To_Fetch_GMP_Achievement_cntd1+role+
						 DataBaseQueryForFinance.Query_To_Fetch_GMP_Achievement_cntd2+ytd+
						 DataBaseQueryForFinance.Query_To_Fetch_GMP_Achievement_cntd3+value+
						 DataBaseQueryForFinance.Query_To_Fetch_GMP_Achievement_cntd4+role+
						 DataBaseQueryForFinance.Query_To_Fetch_GMP_Achievement_cntd5+ytd+
						 DataBaseQueryForFinance.Query_To_Fetch_GMP_Achievement_cntd6+TableName+
						 DataBaseQueryForFinance.Query_To_Fetch_GMP_Achievement_cntd7+value+"'");
				 
				 while (AchievementsGMP.next()) {
					 Agmp= AchievementsGMP.getString("result");
					
					}
				 System.out.println("Achv   "+Arev+"    "+Agm+"  "+Agmp);
				//---------------------------MOM----------------------------------------------------------------
			 List Month = new ArrayList();
			 List revMOM = new ArrayList();
			 List gmMOM = new ArrayList();
			 List gmPerMOM = new ArrayList();
			 
			 ResultSet MonthOnMonth = con.createStatement().executeQuery(DataBaseQueryForFinance.Query_To_Fetch_MOM+ytd+
					 DataBaseQueryForFinance.Query_To_Fetch_MOM_cntd+TableName+
					 DataBaseQueryForFinance.Query_To_Fetch_MOM_cntd1+value+
					 DataBaseQueryForFinance.Query_To_Fetch_MOM_cntd2);
			 while (MonthOnMonth.next()) {
				
				 Month.add(MonthOnMonth.getString("Month"));
				 revMOM.add(MonthOnMonth.getString("Total_Revenue")+"M");
				 gmMOM.add(MonthOnMonth.getString("Gross_margin")+"M");
				 gmPerMOM.add(MonthOnMonth.getString("Gross_margin_percentage"));
				 
				}
			 
			 //--------------------------MOMyearlyTotal---------------------------------------
			 String MomTrev=null; String MomTgm=null; String MomTgmp=null;
			 ResultSet MonthOnMonthYearlyRev = con.createStatement().executeQuery(DataBaseQueryForFinance.Query_To_Fetch_MOM_TotalRev_Yearly+ytd+
					 DataBaseQueryForFinance.Query_To_Fetch_MOM_TotalRev_Yearly_cntd+TableName+
					 DataBaseQueryForFinance.Query_To_Fetch_MOM_TotalRev_Yearly_cntd1+value+"'");
			 while(MonthOnMonthYearlyRev.next()){
				 MomTrev=MonthOnMonthYearlyRev.getString("result");
				 
			 }
			 ResultSet MonthOnMonthYearlygm = con.createStatement().executeQuery(DataBaseQueryForFinance.Query_To_Fetch_MOM_TotalGM_Yearly+ytd+
					 DataBaseQueryForFinance.Query_To_Fetch_MOM_TotalGM_Yearly_cntd+TableName+
					 DataBaseQueryForFinance.Query_To_Fetch_MOM_TotalGM_Yearly_cntd1+value+"'");
			 while(MonthOnMonthYearlygm.next()){
				 MomTgm=MonthOnMonthYearlygm.getString("result");
				 
			 }
			 ResultSet MonthOnMonthYearlygmp = con.createStatement().executeQuery(DataBaseQueryForFinance.Query_To_Fetch_MOM_TotalGMP_Yearly+ytd+
					 DataBaseQueryForFinance.Query_To_Fetch_MOM_TotalGMP_Yearly_cntd+TableName+
					 DataBaseQueryForFinance.Query_To_Fetch_MOM_TotalGMP_Yearly_cntd1+value+"'");
			 while(MonthOnMonthYearlygmp.next()){
				 MomTgmp=MonthOnMonthYearlygmp.getString("result");
				 
			 }
		AllAcheivements.add(FinanceService.millions(ActualRev));
			 AllAcheivements.add(FinanceService.millions(Actualgm));
			 AllAcheivements.add(ActualgmPer);
			 AllAcheivements.add(FinanceService.millions(Budgetrev));
			 AllAcheivements.add(FinanceService.millions(BudgetGM));
			 AllAcheivements.add(BudgetGMPer);
			 AllAcheivements.add(Arev);
			 AllAcheivements.add(Agm);
			 AllAcheivements.add(Agmp);
			 
			/*AllAcheivements.addAll(Month);		
			AllAcheivements.addAll(revMOM);		
			AllAcheivements.addAll(gmMOM);		
			AllAcheivements.addAll(gmPerMOM);	*/	
			
			AllAcheivements.add(FinanceService.millions(MomTrev));
			 AllAcheivements.add(FinanceService.millions(MomTgm));
			 AllAcheivements.add(MomTgmp);
			 System.out.println(FinanceService.millions(ActualRev));
			 String Unique= FinanceService.getSaltString();
			 ResultSet Attachment = con.createStatement().executeQuery(DataBaseQueryForFinance.Query_To_Fetch_Attachment_excel+value+"_"+Unique+DataBaseQueryForFinance.Query_To_Fetch_Attachment_excel_cntd1+DataBaseQueryForFinance.Query_To_Fetch_Attachment_excel_cntd2+ytd+DataBaseQueryForFinance.Query_To_Fetch_Attachment_excel_cntd3+TableName+DataBaseQueryForFinance.Query_To_Fetch_Attachment_excel_cntd4+value+"'");	
		
			
			System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println(Tomail);
		System.out.println("----------------------------------------------------------------------------------------------");
			
		sb.append("Mail sent successfully");

		System.out.println("--------9"+Tomail);
		String sql = "select * from datapoints";
		
		/*
		List<String> dataPointsactual = new ArrayList<String>();
		List<String> dataPointsrev = new ArrayList<String>();
		List<String> dataPointsmonth = new ArrayList<String>();
			 ResultSet graph = con.createStatement().executeQuery(sql);
			 while (graph.next()) {
				
				 dataPointsactual.add(graph.getString("label"));
				 dataPointsrev.add(graph.getString("y"));
						
				}
			 System.out.println("graph1----------"+dataPointsactual);
			 System.out.println("graph2----------"+dataPointsrev); */
	//String XLSXsavedPath=FinanceService.maiCSVtoEXCEL("C:\\ProgramData\\MySQL\\MySQL Server 5.7\\Uploads\\"+value+"_"+Unique+".csv",value,Unique);
	System.out.println("--------9completed");
	
		
		
	}
	else{
		sb.append("Please enter a valid query. Type 'HELP' for sample use cases.");
	}
		
}
catch(Exception e){

	System.out.println("---------------------");
	System.out.println(e);
	System.out.println("---------------------");
	sb.append("Data not available for entered time period. ");
	
}
	return "" +sb;
	
}

//----------apps report-----------
public static String appsReport(Connection con, Map<String, Object> properties, String APPS,Map<String, Object> properties_username, String id,String name,String ytd) throws SQLException {
	StringBuffer sb = new StringBuffer();
	try{
		//String output = usermail.substring(usermail.length() - 8);

		String usermail=id.substring(4);	
	System.out.println("First --"+usermail);
		
	
	if(!APPS.isEmpty()){
		 if(ytd.isEmpty()){
	      		ytd="FY 18-19";
	      	}
		 System.out.println("----------ytd----------"+ytd);
		String ActualRev = null;String Actualgm=null;String ActualgmPer=null;
		String BudgetRevGmGMper = null;String Budgetgm=null;String achievementgm=null;
		
		List Budget =new ArrayList();
		List AllAcheivements = new ArrayList();
		//----------------------ACTUALS
		 ResultSet allActuals = con.createStatement().executeQuery(DataBaseQueryForFinance.Query_To_Fetch_Apps_Actual_data_Rev_Gm_Gmp+ytd+"'");
		 while (allActuals.next()) {
			 ActualRev=allActuals.getString("rev");
			 Actualgm=allActuals.getString("gm");
			 ActualgmPer=allActuals.getString("gmp");
			}
		 
		//----------------------BUDGETS
		 ResultSet allBudgets = con.createStatement().executeQuery(DataBaseQueryForFinance.Query_To_Fetch_Apps_Budget_data_Rev_Gm_Gmp+ytd+
				 DataBaseQueryForFinance.Query_To_Fetch_Apps_Budget_data_Rev_Gm_Gmp_cntd+ytd+
				 DataBaseQueryForFinance.Query_To_Fetch_Apps_Budget_data_Rev_Gm_Gmp_cntd1+ytd+
				 DataBaseQueryForFinance.Query_To_Fetch_Apps_Budget_data_Rev_Gm_Gmp_cntd2+ytd+
				 DataBaseQueryForFinance.Query_To_Fetch_Apps_Budget_data_Rev_Gm_Gmp_cntd3);
		 while (allBudgets.next()) {
			 BudgetRevGmGMper=allBudgets.getString("result");
		 
			 Budget.add(BudgetRevGmGMper); 
			}
		 	String Budgetrev=(String) Budget.get(0);
			String BudgetGM=(String) Budget.get(1);
			String BudgetGMPer=(String) Budget.get(2);
			System.out.println(" bbbb   "+Budgetrev +" "+ BudgetGM +" "+ BudgetGMPer);
			//--------------------------ACHIEVEMENTS
			String Arev=null; String Agm=null; String Agmp=null;
			ResultSet AchievementsRev=con.createStatement().executeQuery(DataBaseQueryForFinance.Query_To_Fetch_Apps_Achievements_data_rev+ytd+
					DataBaseQueryForFinance.Query_To_Fetch_Apps_Achievements_data_rev_cntd);
			
			 while (AchievementsRev.next()) {
				 Arev= AchievementsRev.getString("result");
				
				}
			 System.out.println("------ach rev------"+Arev);
			 ResultSet AchievementsGM=con.createStatement().executeQuery(DataBaseQueryForFinance.Query_To_Fetch_Apps_Achievements_data_Gm+ytd+
					 DataBaseQueryForFinance.Query_To_Fetch_Apps_Achievements_data_Gm_cntd);
				
			 while (AchievementsGM.next()) {
				 Agm= AchievementsGM.getString("result");
				
				}
			 ResultSet AchievementsGMP=con.createStatement().executeQuery(DataBaseQueryForFinance.Query_To_Fetch_Apps_Achievements_data_Gmp+ytd+
					 DataBaseQueryForFinance.Query_To_Fetch_Apps_Achievements_data_Gmp_cntd+ytd+
					 DataBaseQueryForFinance.Query_To_Fetch_Apps_Achievements_data_Gmp_cntd1);
			 
			 while (AchievementsGMP.next()) {
				 Agmp= AchievementsGMP.getString("result");
				
				}
			 System.out.println("Achv   "+Arev+"    "+Agm+"  "+Agmp);
			//---------------------------MOM----------------------------------------------------------------
			 List Month = new ArrayList();
			 List revMOM = new ArrayList();
			 List gmMOM = new ArrayList();
			 List gmPerMOM = new ArrayList();
			 
			 ResultSet MonthOnMonth = con.createStatement().executeQuery(DataBaseQueryForFinance.Query_To_Fetch_Apps_MOM_data+ytd+
					 DataBaseQueryForFinance.Query_To_Fetch_Apps_MOM_data_cntd);
			 while (MonthOnMonth.next()) {
				
				 Month.add(MonthOnMonth.getString("Month"));
				 revMOM.add(MonthOnMonth.getString("Total_Revenue")+"M");
				 gmMOM.add(MonthOnMonth.getString("Gross_margin")+"M");
				 gmPerMOM.add(MonthOnMonth.getString("Gross_margin_percentage"));
				 
				}
			 
			 //--------------------------MOMyearlyTotal---------------------------------------
		
			String MomTrev=null;String MomTgm=null; String MomTgmp=null;
			 ResultSet MonthOnMonthYearlyRev = con.createStatement().executeQuery(DataBaseQueryForFinance.Query_To_Fetch_Apps_MOM_Total_data+ytd+"'");
			 while(MonthOnMonthYearlyRev.next()){
			
				 MomTrev=MonthOnMonthYearlyRev.getString("rev");
				 MomTgm=MonthOnMonthYearlyRev.getString("gm");
				 MomTgmp=MonthOnMonthYearlyRev.getString("gmp");
				
				}
			 	
				 
			
			 AllAcheivements.add(FinanceService.millions(ActualRev));
			 AllAcheivements.add(FinanceService.millions(Actualgm));
			 AllAcheivements.add(ActualgmPer);
			 AllAcheivements.add(FinanceService.budgetformillions(Budgetrev));
			 AllAcheivements.add(FinanceService.budgetformillions(BudgetGM));
			 AllAcheivements.add(BudgetGMPer);
			 AllAcheivements.add(Arev);
			 AllAcheivements.add(Agm);
			 AllAcheivements.add(Agmp);
			 
			/*AllAcheivements.addAll(Month);		
			AllAcheivements.addAll(revMOM);		
			AllAcheivements.addAll(gmMOM);		
			AllAcheivements.addAll(gmPerMOM);	*/	
			
			AllAcheivements.add(FinanceService.millions(MomTrev));
			 AllAcheivements.add(FinanceService.millions(MomTgm));
			 AllAcheivements.add(MomTgmp);
			 System.out.println(FinanceService.millions(ActualRev));
			// String Unique= FinanceService.getSaltString();
		//	ResultSet Attachment = con.createStatement().executeQuery(DataBaseQueryForFinance.Query_To_Fetch_Attachment_excel+APPS+"_"+Unique+DataBaseQueryForFinance.Query_To_Fetch_Attachment_excel_cntd1+DataBaseQueryForFinance.Query_To_Fetch_Attachment_excel_cntd2+ytd+"'");			
		
			
			sb.append("Mail sent successfully");
		
		System.out.println("--------9"+usermail);
		
		
	//	String XLSXsavedPath=FinanceService.maiCSVtoEXCEL("C:\\ProgramData\\MySQL\\MySQL Server 5.7\\Uploads\\"+APPS+"_"+Unique+".csv", APPS, Unique);
		//	mail.Mailtrigger("Celeritas@hcl.com", sendmail, APPS.toUpperCase()+" : Financials FY17-18", APPS, "checking.vm", AllAcheivements,Month,revMOM,gmMOM,gmPerMOM,XLSXsavedPath);
		
			
			
		}
		else{
			sb.append("Please enter a valid query. Type 'HELP' for sample use cases.");
		}
			
			
		}
	catch(Exception e){
		
		sb.append("Data not available for entered time period.");
		
	}
		return "" +sb;
	}

//-------------apps report 2nd----------
public static String appsReportcntd(Connection con, Map<String, Object> properties, String APPS,Map<String, Object> properties_username, String id,String name,String ytd) throws SQLException {
	StringBuffer sb = new StringBuffer();
	try{
		//String output = usermail.substring(usermail.length() - 8);
		String usermail=id.substring(4);	
		System.out.println("First --"+usermail);	
		
	
		if(!APPS.isEmpty()){
			 if(ytd.isEmpty()){
		      		ytd="FY 18-19";
		      	}
			 System.out.println("----------ytd----------"+ytd);
			String ActualRev = null;String Actualgm=null;String ActualgmPer=null;
			String BudgetRevGmGMper = null;String Budgetgm=null;String achievementgm=null;
			
			List Budget =new ArrayList();
			List AllAcheivements = new ArrayList();
			//----------------------ACTUALS
			 ResultSet allActuals = con.createStatement().executeQuery(DataBaseQueryForFinance.Query_To_Fetch_Apps_Actual_data_Rev_Gm_Gmp+ytd+"'");
			 while (allActuals.next()) {
				 ActualRev=allActuals.getString("rev");
				 Actualgm=allActuals.getString("gm");
				 ActualgmPer=allActuals.getString("gmp");
				}
			 
			//----------------------BUDGETS
			 ResultSet allBudgets = con.createStatement().executeQuery(DataBaseQueryForFinance.Query_To_Fetch_Apps_Budget_data_Rev_Gm_Gmp+ytd+
					 DataBaseQueryForFinance.Query_To_Fetch_Apps_Budget_data_Rev_Gm_Gmp_cntd+ytd+
					 DataBaseQueryForFinance.Query_To_Fetch_Apps_Budget_data_Rev_Gm_Gmp_cntd1+ytd+
					 DataBaseQueryForFinance.Query_To_Fetch_Apps_Budget_data_Rev_Gm_Gmp_cntd2+ytd+
					 DataBaseQueryForFinance.Query_To_Fetch_Apps_Budget_data_Rev_Gm_Gmp_cntd3);
			 while (allBudgets.next()) {
				 BudgetRevGmGMper=allBudgets.getString("result");
			 
				 Budget.add(BudgetRevGmGMper); 
				}
			 	String Budgetrev=(String) Budget.get(0);
				String BudgetGM=(String) Budget.get(1);
				String BudgetGMPer=(String) Budget.get(2);
				System.out.println(" bbbb   "+Budgetrev +" "+ BudgetGM +" "+ BudgetGMPer);
				//--------------------------ACHIEVEMENTS
				String Arev=null; String Agm=null; String Agmp=null;
				ResultSet AchievementsRev=con.createStatement().executeQuery(DataBaseQueryForFinance.Query_To_Fetch_Apps_Achievements_data_rev+ytd+
						DataBaseQueryForFinance.Query_To_Fetch_Apps_Achievements_data_rev_cntd);
				 
				 while (AchievementsRev.next()) {
					 Arev= AchievementsRev.getString("result");
					
					}
				 
				 ResultSet AchievementsGM=con.createStatement().executeQuery(DataBaseQueryForFinance.Query_To_Fetch_Apps_Achievements_data_Gm+ytd+
						 DataBaseQueryForFinance.Query_To_Fetch_Apps_Achievements_data_Gm_cntd);
					
				 while (AchievementsGM.next()) {
					 Agm= AchievementsGM.getString("result");
					
					}
				 ResultSet AchievementsGMP=con.createStatement().executeQuery(DataBaseQueryForFinance.Query_To_Fetch_Apps_Achievements_data_Gmp+ytd+
						 DataBaseQueryForFinance.Query_To_Fetch_Apps_Achievements_data_Gmp_cntd+ytd+
						 DataBaseQueryForFinance.Query_To_Fetch_Apps_Achievements_data_Gmp_cntd1);
				 
				 while (AchievementsGMP.next()) {
					 Agmp= AchievementsGMP.getString("result");
					
					}
				 System.out.println("Achv   "+Arev+"    "+Agm+"  "+Agmp);
				//---------------------------MOM----------------------------------------------------------------
				 List Month = new ArrayList();
				 List revMOM = new ArrayList();
				 List gmMOM = new ArrayList();
				 List gmPerMOM = new ArrayList();
				 
				 ResultSet MonthOnMonth = con.createStatement().executeQuery(DataBaseQueryForFinance.Query_To_Fetch_Apps_MOM_data+ytd+
						 DataBaseQueryForFinance.Query_To_Fetch_Apps_MOM_data_cntd);
				 while (MonthOnMonth.next()) {
					
					 Month.add(MonthOnMonth.getString("Month"));
					 revMOM.add(MonthOnMonth.getString("Total_Revenue")+"M");
					 gmMOM.add(MonthOnMonth.getString("Gross_margin")+"M");
					 gmPerMOM.add(MonthOnMonth.getString("Gross_margin_percentage"));
					 
					}
				 
				 //--------------------------MOMyearlyTotal---------------------------------------
			
				String MomTrev=null;String MomTgm=null; String MomTgmp=null;
				 ResultSet MonthOnMonthYearlyRev = con.createStatement().executeQuery(DataBaseQueryForFinance.Query_To_Fetch_Apps_MOM_Total_data+ytd+"'");
				 while(MonthOnMonthYearlyRev.next()){
				
					 MomTrev=MonthOnMonthYearlyRev.getString("rev");
					 MomTgm=MonthOnMonthYearlyRev.getString("gm");
					 MomTgmp=MonthOnMonthYearlyRev.getString("gmp");
					
					}
				 	
					 
				
				 AllAcheivements.add(FinanceService.millions(ActualRev));
				 AllAcheivements.add(FinanceService.millions(Actualgm));
				 AllAcheivements.add(ActualgmPer);
				 AllAcheivements.add(FinanceService.budgetformillions(Budgetrev));
				 AllAcheivements.add(FinanceService.budgetformillions(BudgetGM));
				 AllAcheivements.add(BudgetGMPer);
				 AllAcheivements.add(Arev);
				 AllAcheivements.add(Agm);
				 AllAcheivements.add(Agmp);
				 
				/*AllAcheivements.addAll(Month);		
				AllAcheivements.addAll(revMOM);		
				AllAcheivements.addAll(gmMOM);		
				AllAcheivements.addAll(gmPerMOM);	*/	
				
				AllAcheivements.add(FinanceService.millions(MomTrev));
				 AllAcheivements.add(FinanceService.millions(MomTgm));
				 AllAcheivements.add(MomTgmp);
				 System.out.println(FinanceService.millions(ActualRev));
				 String Unique= FinanceService.getSaltString();
			 ResultSet Attachment = con.createStatement().executeQuery(DataBaseQueryForFinance.Query_To_Fetch_Attachment_excel+APPS+"_"+Unique+DataBaseQueryForFinance.Query_To_Fetch_Attachment_excel_cntd1+DataBaseQueryForFinance.Query_To_Fetch_Attachment_excel_cntd2+ytd+"'");	
			
				
				sb.append("Mail sent successfully");
			
			System.out.println("--------9"+usermail);
		
			List<String> dataPointsactual = new ArrayList<String>();
			List<String> dataPointsrev = new ArrayList<String>();
		String XLSXsavedPath=FinanceService.maiCSVtoEXCEL("C:\\ProgramData\\MySQL\\MySQL Server 5.7\\Uploads\\"+APPS+"_"+Unique+".csv", APPS, Unique);
		System.out.println("--------10"+usermail);
		
			System.out.println("finally.................");
			
		}
		else{
			sb.append("Please enter a valid query. Type 'HELP' for sample use cases.");
		}
			
		}
	catch(Exception e){
		
		sb.append("Data not available for entered time period.");
		
	}
		return "" +sb;
}


public static String welcomeMsg(Connection con, Map<String, Object> properties_username, String id,
		String name) {
	StringBuffer sb = new StringBuffer();
	String mailid=id.substring(4);
	System.out.println("id------------ "+id+" name---------- "+name);
	
	GregorianCalendar time = new GregorianCalendar();
	  int hour = time.get(Calendar.HOUR_OF_DAY);
	  int min = time.get(Calendar.MINUTE);
	  int day = time.get(Calendar.DAY_OF_MONTH);
	  int month = time.get(Calendar.MONTH) + 1;
	  int year = time.get(Calendar.YEAR);
String salutation="";
	  System.out.println("The current time is \t" + hour + ":" + min);
	  System.out.println("Today's date is \t" + month + "/" + day + "/"
	    + year);

	  if (hour < 12)
	   salutation="Good Morning! ";
	  else if (hour < 17 && !(hour == 12))
		  salutation="Good Afternoon! ";
	  else if (hour == 12)
		  salutation="Good Noon! ";
	  else
		  salutation="Good Evening! ";
	  
	  sb.append(salutation);
	  
	sb.append(name);
	sb.append(".");
	sb.append(" How can I help you....");
	
	return ""+sb;
}



}









	
