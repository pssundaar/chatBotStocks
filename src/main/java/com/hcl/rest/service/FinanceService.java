package com.hcl.rest.service;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class FinanceService {
	public static String dateperiod(String parameternumber){
		return "";
	}


	public static String parameterConvert(String parameternumber){
		
		 if(parameternumber.equalsIgnoreCase("1")||parameternumber.equalsIgnoreCase("revenue")||parameternumber.equalsIgnoreCase("Total revenue")||parameternumber.equalsIgnoreCase("rev")){
	        	parameternumber="Total_Revenue";
	        }
	        else if(parameternumber.equalsIgnoreCase("2")||parameternumber.equalsIgnoreCase("grossmargin")||parameternumber.equalsIgnoreCase("gross margin")||parameternumber.equalsIgnoreCase("gm")||parameternumber.equalsIgnoreCase("g m")){
	        	parameternumber="Gross_Margin";
	        }
	        else if(parameternumber.equalsIgnoreCase("3")||parameternumber.equalsIgnoreCase("direct resource cost")||parameternumber.equalsIgnoreCase("directresourcecost")||parameternumber.equalsIgnoreCase("DRC")){
	        	parameternumber="Direct_Resource_Cost";
	        }
	        else if(parameternumber.equalsIgnoreCase("4")||parameternumber.equalsIgnoreCase("Salary Cost")||parameternumber.equalsIgnoreCase("SalaryCost")){
	        	parameternumber="Salary_Cost";
	        }
	        else if(parameternumber.equalsIgnoreCase("5")||parameternumber.equalsIgnoreCase("Consulting TP Cost")||parameternumber.equalsIgnoreCase("ConsultingTPCost")){
	        	parameternumber="Consulting_TP_Cost";
	        }
	        else if(parameternumber.equalsIgnoreCase("6")||parameternumber.equalsIgnoreCase("Travel Cost ")||parameternumber.equalsIgnoreCase("TravelCost ")){
	        	parameternumber="Travel_Cost";
	        }
	        else if(parameternumber.equalsIgnoreCase("7")||parameternumber.equalsIgnoreCase("Total Project Expenses")||parameternumber.equalsIgnoreCase("Total Project Expense")||parameternumber.equalsIgnoreCase("TotalProjectExpenses")){
	        	parameternumber="Total_Project_Expenses";
	        }
	        else if(parameternumber.equalsIgnoreCase("8")||parameternumber.equalsIgnoreCase("Project Expenses")||parameternumber.equalsIgnoreCase("ProjectExpenses")){
	        	parameternumber="Project_Expenses";
	        }
	        else if(parameternumber.equalsIgnoreCase("9")||parameternumber.equalsIgnoreCase("Facility Cost")||parameternumber.equalsIgnoreCase("FacilityCost")){
	        	parameternumber="Facility_Cost";
	        }
	        else if(parameternumber.equalsIgnoreCase("10")||parameternumber.equalsIgnoreCase("Transport Cost")||parameternumber.equalsIgnoreCase("TransportCost")){
	        	parameternumber="Transport_Cost";
	        }
	        else if(parameternumber.equalsIgnoreCase("11")||parameternumber.equalsIgnoreCase("DC/CFS/Tools Standard Cost Project")||parameternumber.equalsIgnoreCase("DC/CFS/Tools StandardCostProject")){
	        	parameternumber="DC_CFS_Tools_Standard_Cost_Project";
	        }
	        else if(parameternumber.equalsIgnoreCase("12")||parameternumber.equalsIgnoreCase("Bad Debt")||parameternumber.equalsIgnoreCase("BadDebt")){
	        	parameternumber="Bad_Debt";
	        }
	        else if(parameternumber.equalsIgnoreCase("13")||parameternumber.equalsIgnoreCase("BW Cost")||parameternumber.equalsIgnoreCase("BWCost")){
	        	parameternumber="BW_Cost";
	        }
	        else if(parameternumber.equalsIgnoreCase("14")||parameternumber.equalsIgnoreCase("GFTE")||parameternumber.equalsIgnoreCase("g f t e")){
	        	parameternumber="GFTE";
	        }
	        else if(parameternumber.equalsIgnoreCase("15")||parameternumber.equalsIgnoreCase("AFTE")||parameternumber.equalsIgnoreCase("a f t e")){
	        	parameternumber="AFTE";
	        }
	        else if(parameternumber.equalsIgnoreCase("16")||parameternumber.equalsIgnoreCase("BFTE")||parameternumber.equalsIgnoreCase("b f t e")){
	        	parameternumber="BFTE";
	        }
	        
		return parameternumber;
		
	}
	public static String parameterConvertforCCustomize(String parameternumber){
		if(parameternumber.equalsIgnoreCase("1")||parameternumber.equalsIgnoreCase("Salary Cost")||parameternumber.equalsIgnoreCase("SalaryCost")){
	        	parameternumber="Salary_Cost";
	        }
	        else if(parameternumber.equalsIgnoreCase("2")||parameternumber.equalsIgnoreCase("Consulting TP Cost")||parameternumber.equalsIgnoreCase("ConsultingTPCost")){
	        	parameternumber="Consulting_TP_Cost";
	        }
	        else if(parameternumber.equalsIgnoreCase("3")||parameternumber.equalsIgnoreCase("Travel Cost ")||parameternumber.equalsIgnoreCase("TravelCost ")){
	        	parameternumber="Travel_Cost";
	        }
	        else if(parameternumber.equalsIgnoreCase("4")||parameternumber.equalsIgnoreCase("Project Expenses")||parameternumber.equalsIgnoreCase("ProjectExpenses")){
	        	parameternumber="Project_Expenses";
	        }
	        else if(parameternumber.equalsIgnoreCase("5")||parameternumber.equalsIgnoreCase("Facility Cost")||parameternumber.equalsIgnoreCase("FacilityCost")){
	        	parameternumber="Facility_Cost";
	        }
	        else if(parameternumber.equalsIgnoreCase("6")||parameternumber.equalsIgnoreCase("Transport Cost")||parameternumber.equalsIgnoreCase("TransportCost")){
	        	parameternumber="Transport_Cost";
	        }
	        else if(parameternumber.equalsIgnoreCase("7")||parameternumber.equalsIgnoreCase("DC/CFS/Tools Standard Cost Project")||parameternumber.equalsIgnoreCase("DC/CFS/Tools StandardCostProject")){
	        	parameternumber="DC_CFS_Tools_Standard_Cost_Project";
	        }
	        else if(parameternumber.equalsIgnoreCase("8")||parameternumber.equalsIgnoreCase("Bad Debt")||parameternumber.equalsIgnoreCase("BadDebt")){
	        	parameternumber="Bad_Debt";
	        }
	        else if(parameternumber.equalsIgnoreCase("9")||parameternumber.equalsIgnoreCase("BW Cost")||parameternumber.equalsIgnoreCase("BWCost")){
	        	parameternumber="BW_Cost";
	        }  
		return parameternumber;
		
	}

	public static List<String> parameterConvertforavgper(String parameternumber){
		String type=null;
		if(parameternumber.equalsIgnoreCase("1")||parameternumber.equalsIgnoreCase("revenue")||parameternumber.equalsIgnoreCase("Total revenue")||parameternumber.equalsIgnoreCase("rev")){
        	parameternumber="Total_Revenue";
        	type="average";
        }
	        else if(parameternumber.equalsIgnoreCase("2")||parameternumber.equalsIgnoreCase("Total Cost")||parameternumber.equalsIgnoreCase("TotalCost")||parameternumber.equalsIgnoreCase("Cost")){
	        	parameternumber="Total_Cost";
	        	type="average";
	        }
	        else if(parameternumber.equalsIgnoreCase("3")||parameternumber.equalsIgnoreCase("GFTE")||parameternumber.equalsIgnoreCase("g f t e")){
	        	parameternumber="GFTE";
	        	type="average";
	        }
	        else if(parameternumber.equalsIgnoreCase("4")||parameternumber.equalsIgnoreCase("AFTE")||parameternumber.equalsIgnoreCase("a f t e")){
	        	parameternumber="AFTE";type="average";
	        }
	        else if(parameternumber.equalsIgnoreCase("5")||parameternumber.equalsIgnoreCase("BFTE")||parameternumber.equalsIgnoreCase("b f t e")){
	        	parameternumber="BFTE";type="average";
	        }
	        else if(parameternumber.equalsIgnoreCase("6")||parameternumber.equalsIgnoreCase("revenue percentage")||parameternumber.equalsIgnoreCase("Total revenue percentage")||parameternumber.equalsIgnoreCase("revenue %")||parameternumber.equalsIgnoreCase("revenue%")){
	        	parameternumber="Total_Revenue";type="percentage";
	        }
		        else if(parameternumber.equalsIgnoreCase("7")||parameternumber.equalsIgnoreCase("Total Cost percentage")||parameternumber.equalsIgnoreCase("TotalCostpercentage")||parameternumber.equalsIgnoreCase("Cost %")||parameternumber.equalsIgnoreCase("cost%")){
		        	parameternumber="Total_Cost";type="percentage";
		        }
		List<String> inputs=new ArrayList<String>();
		inputs.add(parameternumber);
		inputs.add(type);
		return inputs;
		
	}
    public static String maiCSVtoEXCEL(String csvFileAddress,String value,String Unique) {
    	   String xlsxFileAddress = null;
    	try {
    	
            xlsxFileAddress= "C:\\ProgramData\\MySQL\\MySQL Server 5.7\\Uploads\\"+value+"_"+Unique+".xlsx";
            XSSFWorkbook workBook = new XSSFWorkbook();
            XSSFSheet sheet = workBook.createSheet("sheet1");
            
            String currentLine=null;
            int RowNum=-1;
            BufferedReader br = new BufferedReader(new FileReader(csvFileAddress));
            while ((currentLine = br.readLine()) != null) {
                String str[] = currentLine.split(",");
                RowNum++;
                XSSFRow currentRow=sheet.createRow(RowNum);
                for(int i=0;i<str.length;i++){
                    currentRow.createCell(i).setCellValue(str[i]);
                }
            }
            
            FileOutputStream fileOutputStream =  new FileOutputStream(xlsxFileAddress);
            workBook.write(fileOutputStream);
            fileOutputStream.close();
           
        } catch (Exception ex) {
            System.out.println(ex.getMessage()+"Exception in try");
        }
		return xlsxFileAddress;
    }

	public static String millions( String num){
	      BigDecimal a= new BigDecimal(num);
	      BigDecimal number = new BigDecimal(1000000.00);
	      return String.format("%.2fM", a.divide(number, 2, RoundingMode.CEILING));
	      
	}
	 

	public static String budgetformillions( String num){
	      BigDecimal a= new BigDecimal(num);
	      BigDecimal number = new BigDecimal(1000.00);
	      return String.format("%.2fM", a.divide(number, 2, RoundingMode.CEILING));
	      
	}
	 
	
	  public static  String numberFormat(String s)
    {
    	 String no=null;
    	 System.out.println(s);
         if(new BigInteger(s).compareTo(BigInteger.ZERO) < 0)
         {
        	 System.out.println(s);
          String number=(NumberFormat.getCurrencyInstance(new Locale("en", "US"))
              	             .format(new BigInteger(s).abs().not().add(BigInteger.ONE))
              	             .substring(0, NumberFormat.getCurrencyInstance(new Locale("en", "US"))
              	             .format(new BigInteger(s).abs().not().add(BigInteger.ONE))
              	             .length()-3));
          			   System.out.println(number);
              		   no="-"+number.subSequence(1, number.length());
              		   System.out.println(no);
           }
           else{
                no=NumberFormat.getCurrencyInstance(new Locale("en", "US"))
                                  .format(new BigInteger(s))
                                  .substring(0, NumberFormat.getCurrencyInstance(new Locale("en", "US"))
                                  .format(new BigInteger(s))
                                  .length()-3);
                               
                   }
                   
        
        
                
                           return  no;
            }

	  
	 
	  //
	  public static String methodP2(Connection con, Map<String, Object> properties, String parameter1, 
			  String parameter2, String revenueData,String ytddata, String Query1, String appendData )
              throws SQLException
    {
    	StringBuffer sb = new StringBuffer();
        if(parameter1.equalsIgnoreCase(revenueData) && parameter2.equalsIgnoreCase(ytddata))     
    	
        {
    	
              Statement stmt = con.createStatement();
              ResultSet rs = stmt.executeQuery(Query1);
              String s=null;
                 while (rs.next()) {
                               s=rs.getString("result");
                               sb.append(" ");
                 }
                   if(s== null)
                   {
                                   sb.append("Please check the value entered"); 
                   }
                   else{
                   sb.append(appendData);
                   sb.append( FinanceService.numberFormat(s));
                   sb.append(" ");
}
        }
        else{
        	 sb.append("Please enter a valid query. Type 'HELP' for sample use cases. ");
        }
                   
                           return " " + sb;
            }

	  
	  
	  
	  
	  
	  
//query 4
	  public static String qmdmheadgm(Connection con, Map<String, Object> properties, String dm_name, String mon, String month,
			  String gm,
			  String query1, String query2,String query3, String query4,
			  String gmdata,String du_head,String ytd)			  throws SQLException {
			 StringBuffer sb = new StringBuffer();
			
			 if(dm_name!=null && month!=null && gm.equalsIgnoreCase(gmdata)&&ytd!=null){
				 
			 
		     if(mon.equalsIgnoreCase("AMJ") || mon.equalsIgnoreCase("JAS") || mon.equalsIgnoreCase("OND")|| mon.equalsIgnoreCase("JFM"))
		     {
		                     Statement stmt = con.createStatement();
		                     ResultSet rs = stmt.executeQuery(query1);
		String s=null;
		while (rs.next()) 
		                         {
			s=rs.getString("result");
		                         }
			if(s==null)
			{
				sb.append("Please check the value entered");
			}
			
			else {
			 sb.append(" For " + dm_name.toUpperCase()+" as DM in "+ytd.toUpperCase()+" "+month.toUpperCase()+" Quarter, Gross Margin is : ");
			 sb.append( FinanceService.numberFormat(s));
		     sb.append(" ");
		                     ResultSet rs1 = stmt.executeQuery(query2);
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
		         ResultSet rs = stmt.executeQuery(query3);
		         String s =null;
		         	 while (rs.next()) 
		     	{ 
		         		 s = rs.getString("result");
		           sb.append(" ");
		        }
		      if( s==null)
		        {  
		    	  sb.append(" ");
		              }
		      else
		         {   sb.append(" For " + dm_name.toUpperCase()+" as DM in "+ytd.toUpperCase()+" "+ month.toUpperCase() +" month , Gross Margin is : ");
		         		System.out.println(s);
		         sb.append(FinanceService.numberFormat(s));
		         sb.append(" ");
		ResultSet rs1 = stmt.executeQuery(query4);
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
				 sb.append("Please enter a valid query. Type 'HELP' for sample use cases. ");
			 }
			 
		      
		return " " + sb;
		}

//Action name--------------DM And DU
	  public static String YTDdmduhead(Connection con, Map<String, Object> properties, String dm_name,String du_head, String ytd,String common,String lob,String Query1) throws SQLException {
			StringBuffer sb = new StringBuffer();
			 System.out.println("1 "+ytd+" 3 "+common+" 4 "  + dm_name+" 5 "  + du_head+" 6 "  + lob);
			if(common.equalsIgnoreCase("Direct_Resource_Cost")){
				common="DRC";
			}else if(common.equalsIgnoreCase("Salary_Cost")){
				common="Salary Cost";
			}else if(common.equalsIgnoreCase("Consulting_TP_Cost")){
				common="Consulting Tp Cost";
			}
			else if(common.equalsIgnoreCase("Travel_Cost")){
				common="Travel Cost";
			}
			else if(common.equalsIgnoreCase("Total_Project_Expenses")){
				common="Total Project Expenses";
			}
			else if(common.equalsIgnoreCase("Project_Expenses")){
				common="Project Expenses";
			}
			else if(common.equalsIgnoreCase("BW_Cost")){
				common="BW Cost";
			}
			else if(common.equalsIgnoreCase("Transport_Cost")){
				common="Transport Cost";
			}
			else if(common.equalsIgnoreCase("Bad_Debt")){
				common="Bad Debt";
			}
			else if(common.equalsIgnoreCase("DC_CFS_Tools_Standard_Cost_Project")){
				common="DC CFS Tools Standard cost(Project)";
			}
			else if(common.equalsIgnoreCase("Facility_Cost")){
				common="Facility Cost";
			}
			
		    Statement stmt = con.createStatement();
		         ResultSet rs = stmt.executeQuery(Query1);
		         System.out.println(Query1);
		         String s=null;					   
		         while (rs.next()) 
		               {
		        	 s=rs.getString("result");
		        	 System.out.println("------------------------------------"+s);
		             sb.append(" ");
		               }
		         if(s== null)
		               {
		            sb.append("Data not available for entered time period"); 
		               }
		         else{
		        	 if(!dm_name.isEmpty() ){
		        	 sb.append(common.toUpperCase()+" "+ytd.toUpperCase()+" for " + dm_name.toUpperCase() + " as DM is : ");
		        	 }
		        	 else if(!du_head.isEmpty()){
		        		 sb.append(common.toUpperCase()+" "+ytd.toUpperCase()+" for " + du_head.toUpperCase() + " as DU is : ");
		        	 }
		        	 else if(!lob.isEmpty()){
		        		 sb.append(common.toUpperCase()+" "+ytd.toUpperCase()+" for " + lob.toUpperCase() + " is : ");
		        	 } 
		        	 else if(dm_name.isEmpty() && du_head.isEmpty() && lob.isEmpty() ){
		        		 sb.append(common.toUpperCase()+" for "+ytd.toUpperCase()+" is : ");
		        	 } 
		         
		        	 if(common.equalsIgnoreCase("GFTE")){
		        		 sb.append(s);
		        	 }else{
		                   sb.append( FinanceService.numberFormat(s));
		        	 }
		                   sb.append(" ");
		         }
			
			
		                                               return " " + sb;
		     }

		
	  
	  //Action name ------DM DU HEAD DRC
	  
	  
	  public static String qmdmduhead(Connection con, Map<String, Object> properties, String dm_name,
			  String du_head, String mon, String month,String common,String lob,String Query1, String Query2, String Query3,String ytd) throws SQLException {
			
		  StringBuffer sb = new StringBuffer();
		  	
		  if(common.equalsIgnoreCase("Direct_Resource_Cost")){
				common="DRC";
			}else if(common.equalsIgnoreCase("Salary_Cost")){
				common="Salary Cost";
			}else if(common.equalsIgnoreCase("Consulting_TP_Cost")){
				common="Consulting Tp Cost";
			}
			else if(common.equalsIgnoreCase("Travel_Cost")){
				common="Travel Cost";
			}
			else if(common.equalsIgnoreCase("Total_Project_Expenses")){
				common="Total Project Expenses";
			}
			else if(common.equalsIgnoreCase("Project_Expenses")){
				common="Project Expenses";
			}
			else if(common.equalsIgnoreCase("BW_Cost")){
				common="BW Cost";
			}
			else if(common.equalsIgnoreCase("Transport_Cost")){
				common="Transport Cost";
			}
			else if(common.equalsIgnoreCase("Bad_Debt")){
				common="Bad Debt";
			}
			else if(common.equalsIgnoreCase("DC_CFS_Tools_Standard_Cost_Project")){
				common="DC CFS Tools Standard cost(Project)";
			}
			else if(common.equalsIgnoreCase("Facility_Cost")){
				common="Facility Cost";
			}
			
		  	if(mon.equalsIgnoreCase("AMJ") || mon.equalsIgnoreCase("JAS") || mon.equalsIgnoreCase("OND") || mon.equalsIgnoreCase("JFM"))
		  {            
		  ResultSet rs = con.createStatement().executeQuery(Query1);

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
		  	if(!dm_name.isEmpty())
		  	{
		  sb.append(common.toUpperCase()+" for " + dm_name.toUpperCase() +" as DM in "+ytd.toUpperCase()+" "+ month.toUpperCase() +" quarter is : ");
		  	}
		  	
		  	else if(!du_head.isEmpty())
		  	{
		  		sb.append(common.toUpperCase()+" for " + du_head.toUpperCase() +" as DU in "+ytd.toUpperCase()+" "+ month.toUpperCase() +" quarter is : ");
		  	}
		  	else if(!lob.isEmpty())
		  	{
		  		sb.append(common.toUpperCase()+" for " + lob.toUpperCase() +" in "+ytd.toUpperCase()+" "+ month.toUpperCase() +" quarter is : ");
		  	}
		  	else if(dm_name.isEmpty() && du_head.isEmpty() && lob.isEmpty()){
       		 sb.append(common.toUpperCase()+" in "+ytd.toUpperCase()+" "+ month.toUpperCase() +" quarter is : ");
       	 }
		  	 if(common.equalsIgnoreCase("GFTE")){
        		 sb.append(s);
        	 }else{
                   sb.append( FinanceService.numberFormat(s));
        	 }
		  sb.append(" ");
		  }
		  }
		  	else if(mon.equalsIgnoreCase("hy1") || mon.equalsIgnoreCase("hy2")){
		  		
		  		 ResultSet rs = con.createStatement().executeQuery(Query2);
		  		 									
		      	  String s=null;
		      	  while (rs.next()) {
		        
		      		  
		            s=rs.getString("result");
		      	  }
		      	  
		      	  
		      	  if(s==null){
		      		  sb.append("Data not available for entered time period");
		      	  }
		      	  else{
		      		  
		      		String Q1 = null;String Q2 = null;
		    		if(mon.equalsIgnoreCase("hy1")){
		    	  		Q1="amj";
		    	  		Q2="jas";
		    	  	}
		    		else if(mon.equalsIgnoreCase("hy2")){
		    	  		Q1="ond";
		    	  		Q2="jfm";
		    	  	}
		    		 if(!dm_name.isEmpty()){
		      			sb.append(common.toUpperCase()+" for "+ dm_name.toUpperCase()+" " +ytd.toUpperCase()+" in "+ Q1.toUpperCase()+" & "+Q2.toUpperCase() +" Half Year is : ");
		      		  }
		      		  
		      		  else if(!du_head.isEmpty()){
		      			sb.append(common.toUpperCase()+" for "+ du_head.toUpperCase() +" "+ytd.toUpperCase()+" "+" in "+ Q1.toUpperCase()+" & "+Q2.toUpperCase() +" Half Year is : "); 
		      		  }
		      		 else if(!lob.isEmpty()){
			      			sb.append(common.toUpperCase()+" for "+ lob.toUpperCase()+ " "+ytd.toUpperCase()+" "+" in "+ Q1.toUpperCase()+" & "+Q2.toUpperCase() +" Half Year is : "); 
			      		  }
		      		else if(dm_name.isEmpty() && du_head.isEmpty() && lob.isEmpty()){
		          		 sb.append(common.toUpperCase()+" for "+ytd.toUpperCase()+" "+" in "+ Q1.toUpperCase()+" & "+Q2.toUpperCase() +" Half Year is : ");
		          	 }
		      		   
		            
		    		 if(common.equalsIgnoreCase("GFTE")){
		        		 sb.append(s);
		        	 }else{
		                   sb.append( FinanceService.numberFormat(s));
		        	 }
		                 sb.append(" ");
		          }
		      	  
		      	  
		  		
		  	}	
		  	
		  	
		  	else 
		             {
		              Statement stmt = con.createStatement();
		              ResultSet rs = stmt.executeQuery(Query3);
		              System.out.println(Query3);
		              String s =null;
		              while (rs.next()) 
		  {
		  s = rs.getString("result");
		  System.out.println("-0-0-0-0-0000000000-------------"+s);
		   sb.append(" ");
		  }
		  if( s==null)
		   {
		        sb.append("Data not available for entered time period");
		   }
		         else{
		        	 if(!dm_name.isEmpty()){
		  sb.append(common.toUpperCase()+" for " + dm_name.toUpperCase() +" as DM in " +ytd.toUpperCase()+" "+ month.toUpperCase() +" month is : ");
		        	 }
		        	 else if(!du_head.isEmpty()){
		 sb.append(common.toUpperCase()+" for " + du_head.toUpperCase() +" as DU in "+ytd.toUpperCase()+" "+ month.toUpperCase() +" month is : ");
		        	 }
		        	 else if(!lob.isEmpty()){
		        		 sb.append(common.toUpperCase()+" for " + lob.toUpperCase() +" in "+ytd.toUpperCase()+" "+ month.toUpperCase() +" month is : ");
		        		        	 }
		        		else if(dm_name.isEmpty() && du_head.isEmpty() && lob.isEmpty() ){
		              		 sb.append(common.toUpperCase()+" in "+ytd.toUpperCase()+" "+ month.toUpperCase() +" month is : ");
		              	 }

		        	 if(common.equalsIgnoreCase("GFTE")){
		        		 sb.append(s);
		        	 }else{
		                   sb.append( FinanceService.numberFormat(s));
		        	 }
		  sb.append(" ");
		         }
		  }
		  	
		     return " " + sb;
		  }
	  public static String getSaltString() {
	        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
			//String SALTCHARS = "1234567890";
	        StringBuilder salt = new StringBuilder();
	        Random rnd = new Random();
	        while (salt.length() < 6) {
	            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
	            salt.append(SALTCHARS.charAt(index));
	        }
	        String saltStr = salt.toString();
	      
	        return saltStr;

	    }

		  }
		  	

	  
	  
	  



