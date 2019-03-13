package com.hcl.rest.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;



public class FinanceGraph {

	//-----------Graph------------

	public static String Graph(Connection con, Map<String, Object> properties,Map<String, Object> properties_username, String id,String name) {
		String Tomail=id.substring(4);
		 StringBuffer sb = new StringBuffer();
		  if(Tomail.equalsIgnoreCase("prasad.ra@hcl.com") || Tomail.equalsIgnoreCase("ravi.dhingra@hcl.com")||
				  Tomail.equalsIgnoreCase("swaminathan.natarajan@hcl.com")||
				  Tomail.equalsIgnoreCase("kotipalliv@hcl.com")||Tomail.equalsIgnoreCase("rupadevi.k@hcl.com") || 
				  Tomail.equalsIgnoreCase("Vinodkrishnan.Cheniveettil@hcl.com") ||
				  Tomail.equalsIgnoreCase("vijayashree.b@hcl.com")|| Tomail.equalsIgnoreCase("lekhashree.k@hcl.com") || 
				  Tomail.equalsIgnoreCase("chandni.j@hcl.com")){
			 sb.append("Whose graph would you like to see please enter name or if you want to see your graph please type 'MY'?");
		 }
		  else if(Tomail.equalsIgnoreCase("anand.ramachandran@hcl.com")||Tomail.equalsIgnoreCase("chindu.jose@hcl.com")
					||Tomail.equalsIgnoreCase("Naveen.Ram@hcl.com")||Tomail.equalsIgnoreCase("Atul.Kulkarni@hcl.com")
					||Tomail.equalsIgnoreCase("vikas.rakshe@hcl.com")||Tomail.equalsIgnoreCase("Sadiq.Zainuddin@hcl.com")
					||Tomail.equalsIgnoreCase("kandalan@hcl.com")||Tomail.equalsIgnoreCase("kumars-d@hcl.com")){
				System.out.println("5");
				 sb.append(" Please enter in which parameter would you like to see graph :");
		            sb.append(" 1. Revenue 2.Gross Margin 3. Direct Resource Cost 4. Salary Cost 5. Consulting TP Cost 6. Travel Cost 7. Total Project Expense  8. Project Expenses 9. Facility Cost 10. Transport Cost 11. DC/CFS/Tools Standard Cost Project 12. Bad Debt 13. BW Cost 14. GFTE 15. AFTE 16. BFTE 17. Customize");
		             
				
			}
		  
		  else{        
	          sb.append("You are not the authorised person to view this graph"); 
		 }  	
		
		return ""+sb;
	}
	//------------graph authentication---------
	public static String GraphAuthentication(Connection con, Map<String, Object> properties,
			Map<String, Object> properties_username,String my, String dm_name, String du_head,String apps, String id, String name) throws SQLException {
		StringBuffer sb = new StringBuffer();
		String YES="Please enter in which parameter would you like to see graph : 1. Revenue 2. Gross Margin 3. Direct Resource Cost 4. Salary Cost 5. Consulting TP Cost 6. Travel Cost 7. Total Project Expense  "
				+ "8. Project Expenses 9. Facility Cost 10. Transport Cost 11. DC/CFS/Tools Standard Cost Project 12. Bad Debt 13. BW Cost 14. GFTE 15. AFTE 16. BFTE 17. Customize";
		String NO="You are not the authorised person to view this graph";
		String Tomail=id.substring(4);
		if(Tomail.equalsIgnoreCase("prasad.ra@hcl.com")||Tomail.equalsIgnoreCase("kotipalliv@hcl.com")||Tomail.equalsIgnoreCase("Vinodkrishnan.Cheniveettil@hcl.com") ||
				  Tomail.equalsIgnoreCase("vijayashree.b@hcl.com") || Tomail.equalsIgnoreCase("chandni.j@hcl.com")){
			System.out.println("1");
		sb.append(YES);	
		}
		else{
	if(my.isEmpty()){
		System.out.println("2");
		if(Tomail.equalsIgnoreCase("ravi.dhingra@hcl.com")||Tomail.equalsIgnoreCase("rupadevi.k@hcl.com")){
			System.out.println("3");
			name="Ravi Dhingra";
			Statement stmt = (Statement) con.createStatement();
		    ResultSet rs = stmt.executeQuery(DataBaseQueryForFinance.Query_To_Fetch_Graph_Auth_for_du+name+DataBaseQueryForFinance.Query_To_Fetch_Graph_Auth_for_du_cntd+dm_name+"'");
		    String dm=null;
		    while (rs.next()) 
		    {
		    	dm = rs.getString("dm_name");		    	
		        	
		    }
		    if(dm==null || dm.isEmpty()){
		    	sb.append(NO);
		    }else{
		    if(dm.equalsIgnoreCase(dm_name)){
		    	sb.append(YES);
		    }
		    else if(dm.isEmpty()){
		    	sb.append(NO);
		    }
		    } 
		}
		else if(Tomail.equalsIgnoreCase("swaminathan.natarajan@hcl.com")|| Tomail.equalsIgnoreCase("lekhashree.k@hcl.com")){
			System.out.println("4");
			name="Swaminathan N";
			Statement stmt = (Statement) con.createStatement();
		    ResultSet rs = stmt.executeQuery(DataBaseQueryForFinance.Query_To_Fetch_Graph_Auth_for_du+name+DataBaseQueryForFinance.Query_To_Fetch_Graph_Auth_for_du_cntd+dm_name+"'");
		    String dm=null;
		    while (rs.next()) 
		    {
		    	dm = rs.getString("dm_name");		    	
		        	
		    }
		    if(dm==null || dm.isEmpty()){
		    	sb.append(NO);
		    }else{
		    if(dm.equalsIgnoreCase(dm_name)){
		    	sb.append(YES);
		    }
		    else if(dm.isEmpty()){
		    	sb.append(NO);
		    }
		    }
		}
		else if(Tomail.equalsIgnoreCase("anand.ramachandran@hcl.com")||Tomail.equalsIgnoreCase("chindu.jose@hcl.com")
				||Tomail.equalsIgnoreCase("Naveen.Ram@hcl.com")||Tomail.equalsIgnoreCase("Atul.Kulkarni@hcl.com")
				||Tomail.equalsIgnoreCase("vikas.rakshe@hcl.com")||Tomail.equalsIgnoreCase("Sadiq.Zainuddin@hcl.com")
				||Tomail.equalsIgnoreCase("kandalan@hcl.com")||Tomail.equalsIgnoreCase("kumars-d@hcl.com")){
			System.out.println("5");
			sb.append(YES);
			
		}
		
		else{
			System.out.println("7");
			sb.append(NO);
		}
	}
	else{
		System.out.println("8");
		sb.append(YES);
	}
		}	
		return ""+sb;
	}
	
	// ----------Graph parameters-----------

	public static String Graphparameters(Connection con, Map<String, Object> properties,
			String parameter, String dateperiod,String type, Map<String, Object> properties_username, 
			String id, String name,String my,String dm_name,String du_head,String apps) throws SQLException {
		StringBuffer sb = new StringBuffer();
		String Tomail=id.substring(4);
		 String colname=null;String value=null;String link=null;String startmonth = null;String endmonth=null;
		 String parameternumber=null;String resname =null;String role=null;
		 System.out.println("1"+parameter);
		 System.out.println("2"+dateperiod);
		 System.out.println("3"+type);
		 System.out.println("4"+id);
		 System.out.println("5"+name);
		 System.out.println("6"+my);
		 System.out.println("7"+dm_name);
		 System.out.println("8"+du_head);
		 System.out.println("9"+apps);
	if( du_head.isEmpty() && dm_name.isEmpty() && apps.isEmpty()){
		
	    if(!parameter.isEmpty() && !dateperiod.isEmpty() && !type.isEmpty() && (!name.isEmpty() || !my.isEmpty())){  	   
	        //--parameter--- 
	     		parameternumber=FinanceService.parameterConvert(parameter);		
	            System.out.println("-----------------------------param---------------"+parameter);
	        //----date period--- 
	            if(dateperiod.contains("FY") || dateperiod.contains("fy") || dateperiod.contains("Fy") || dateperiod.contains("fY")){
	                if(dateperiod.equalsIgnoreCase("FY 17-18")||dateperiod.equalsIgnoreCase("FY17-18")||dateperiod.equalsIgnoreCase("FY 17to18")
	                		||dateperiod.equalsIgnoreCase("FY17to18")||dateperiod.equalsIgnoreCase("FY'17-18")
	                		||dateperiod.equalsIgnoreCase("FY '17-18")||dateperiod.equalsIgnoreCase("FY17 -18")
	                		||dateperiod.equalsIgnoreCase("FY 17-18")||dateperiod.equalsIgnoreCase("FY17- 18")
	                		||dateperiod.equalsIgnoreCase("FY 17- 18") || dateperiod.equalsIgnoreCase("FY18")
	                		 || dateperiod.equalsIgnoreCase("FY 18") || dateperiod.equalsIgnoreCase("FY'18")){
	        			dateperiod="FY 17-18";	
	        			startmonth=""; endmonth="";
	        			System.out.println("122"+dateperiod);
	        		}
	        		else if (dateperiod.equalsIgnoreCase("FY 18-19")||dateperiod.equalsIgnoreCase("FY18-19")
	        				||dateperiod.equalsIgnoreCase("FY 18to19")||dateperiod.equalsIgnoreCase("FY18to19")
	        				||dateperiod.equalsIgnoreCase("FY'18-19")||dateperiod.equalsIgnoreCase("FY '18-19")
	        				||dateperiod.equalsIgnoreCase("FY18 -19")||dateperiod.equalsIgnoreCase("FY 18-19")
	        				||dateperiod.equalsIgnoreCase("FY18- 19")||dateperiod.equalsIgnoreCase("FY 18- 19")
	        				 || dateperiod.equalsIgnoreCase("FY19")|| dateperiod.equalsIgnoreCase("FY 19") || dateperiod.equalsIgnoreCase("FY'19")){
	        			dateperiod="FY 18-19";
	        			startmonth=""; endmonth="";
	        			System.out.println("122123"+dateperiod);
	        		}
	                System.out.println("11"+dateperiod);
	               }
	        		else{
	        			 startmonth=dateperiod.substring(0,5);	    	   
	        	    		endmonth=dateperiod.substring(6,11);
	        	    		dateperiod="";
	        	    		 System.out.println("10"+startmonth+"-"+endmonth+"--"+dateperiod);
	        	    	
	        		} 	        
	      
		  //---------name,role--------
	       Statement stmt = (Statement) con.createStatement();
	      
	    	   
	    	   if(name.contains(" ")){
		    	name= name.substring(0, name.indexOf(" ")); 
		       System.out.println(name);
		    }
		    ResultSet rs = stmt.executeQuery(DataBaseQueryForFinance.Query_To_Fetch_Graph_Parameters+name+"%'");
		    while (rs.next()) 
		    {
		    	resname = rs.getString("name");
		    	role = rs.getString("role");
		    }
		    ResultSet rs1=stmt.executeQuery(DataBaseQueryForFinance.Query_To_Fetch_Graph_Parameters_1+name+"%'");
		    while (rs1.next()) 
		    {
		    	resname = rs1.getString("name");
		    	role = rs1.getString("role");
		    }
		    ResultSet rs2=stmt.executeQuery(DataBaseQueryForFinance.Query_To_Fetch_Graph_Parameters_2+name+"%'");
		     while (rs2.next()) 
		    {
		    	resname = rs2.getString("name");
		    	role = rs2.getString("role");
		    }
		      
		   
	        if(resname==null){
		    	sb.append("You are not the authorised person to view this graph");
		    }
		    else{
		    	 if(role.equalsIgnoreCase("Dm_name")){
		    		 role="DM";
		     	    	colname="dm_name";
		     	    	value=resname;
		     	    }
		     	    else if(role.equalsIgnoreCase("Du_Head")){
		     	    	role="DU";
		     	    	colname="du_head";
		     	    	value=resname;
		     	    }
		     	    else if(role.equalsIgnoreCase("apps")){
		     	    	role="APPS";
		     	    	colname="";
		     	    	value=resname;
		     	    }
		    	 System.out.println("12"+colname+"-------------"+value);
	   //---type of graph---- 
	        
	        link ="https://celeritas.hcl.com/RESTfulExample/Finance/chart/GraphView.php?parameter="+parameternumber+"&ytd="+dateperiod+"&startdate="+startmonth+"&enddate="+endmonth+"&dmduname="+colname+"&dmduvalue="+value+"&graphtype="+type;        
	        link=link.replaceAll(" ", "%20");
	     
	     
			sb.append("Graph Link sent to your mail box. ");
			sb.append(""); 
	        sb.append(link);	        
		    } 	    	
	  }else{
	     		sb.append("Please enter valid inputs based on given formats");
	     	}
	    
	}else if(!du_head.isEmpty() || !dm_name.isEmpty() || !apps.isEmpty()){
		
		 if(!du_head.isEmpty()){
			 role="DU";
			 colname="du_head";
			 value=du_head;
		}
		else if(!dm_name.isEmpty()){
			role="DM";
			 colname="dm_name";
			 value=dm_name;
		}
		else if(!apps.isEmpty()){
			role="APPS";
			value=apps;
			colname="";
		}
		 System.out.println("13"+colname+"------"+value);
		  //--parameter--- 
  		parameternumber=FinanceService.parameterConvert(parameter);		
         System.out.println("-----------------------------param2---------------"+parameter);
     //----date period--- 
     	        
         if(dateperiod.contains("FY") || dateperiod.contains("fy") || dateperiod.contains("Fy") || dateperiod.contains("fY")){
             if(dateperiod.equalsIgnoreCase("FY 17-18")||dateperiod.equalsIgnoreCase("FY17-18")
            		 ||dateperiod.equalsIgnoreCase("FY 17to18")||dateperiod.equalsIgnoreCase("FY17to18")
            		 ||dateperiod.equalsIgnoreCase("FY'17-18")||dateperiod.equalsIgnoreCase("FY '17-18")
            		 ||dateperiod.equalsIgnoreCase("FY17 -18")||dateperiod.equalsIgnoreCase("FY 17-18")
            		 ||dateperiod.equalsIgnoreCase("FY17- 18")||dateperiod.equalsIgnoreCase("FY 17- 18")
            		 || dateperiod.equalsIgnoreCase("FY18")
            		 || dateperiod.equalsIgnoreCase("FY 18") || dateperiod.equalsIgnoreCase("FY'18")){
     			dateperiod="FY 17-18";	
     			startmonth=""; endmonth="";
     			System.out.println("else case "+dateperiod);
     		}
     		else if (dateperiod.equalsIgnoreCase("FY 18-19")||dateperiod.equalsIgnoreCase("FY18-19")
     				||dateperiod.equalsIgnoreCase("FY 18to19")||dateperiod.equalsIgnoreCase("FY18to19")
     				||dateperiod.equalsIgnoreCase("FY'18-19")||dateperiod.equalsIgnoreCase("FY '18-19")
     				||dateperiod.equalsIgnoreCase("FY18 -19")||dateperiod.equalsIgnoreCase("FY 18-19")
     				||dateperiod.equalsIgnoreCase("FY18- 19")||dateperiod.equalsIgnoreCase("FY 18- 19")
     				|| dateperiod.equalsIgnoreCase("FY19")
           		 || dateperiod.equalsIgnoreCase("FY 19") || dateperiod.equalsIgnoreCase("FY'19")){
     			dateperiod="FY 18-19";
     			startmonth=""; endmonth="";
     			System.out.println("else case1"+dateperiod);
     		}
             System.out.println("11"+dateperiod);
            }
     		else{
     			 startmonth=dateperiod.substring(0,5);	    	   
     	    		endmonth=dateperiod.substring(6,11);
     	    		dateperiod="";
     	    		 System.out.println("10"+startmonth+"-"+endmonth+"--"+dateperiod);
     	    	
     		} 	        
   
    //---type of graph---- 
    
    link ="https://celeritas.hcl.com/RESTfulExample/Finance/chart/GraphView.php?parameter="+parameternumber+"&ytd="+dateperiod+"&startdate="+startmonth+"&enddate="+endmonth+"&dmduname="+colname+"&dmduvalue="+value+"&graphtype="+type;        
    link=link.replaceAll(" ", "%20");
   
	sb.append("Graph Link sent to your mail box. ");
	sb.append("");
    sb.append(link);
	}
	         return "" + sb;
	}
	
	//------------Graph Customize---------

    public static String Graphcustomize(Connection con, Map<String, Object> properties,
                  String dateperiod, String avgper,String parameter,String type,
                  Map<String, Object> properties_username, String id,String name,String my,String dm_name,
                  String du_head,String apps) throws SQLException {
           
           StringBuffer sb = new StringBuffer();
           String Tomail=id.substring(4);
           String colname=null;String value=null;String link=null;String startmonth = null;String endmonth=null;
           String parameternumber=null;String resname =null;String role=null;String avgpertype=null;
           
            if( du_head.isEmpty() && dm_name.isEmpty() && apps.isEmpty()){
                        
                      if(!parameter.isEmpty() && !dateperiod.isEmpty() && !type.isEmpty() && (!name.isEmpty() || !my.isEmpty())){     

    //-----------------parameter--------------
                               
           parameternumber=FinanceService.parameterConvertforCCustomize(parameter);              
           System.out.println("-----------------------------param customize---------------"+parameter);
        
         //----date period--- 
           if(dateperiod.contains("FY") || dateperiod.contains("fy") || dateperiod.contains("Fy") || dateperiod.contains("fY")){
               if(dateperiod.equalsIgnoreCase("FY 17-18")||dateperiod.equalsIgnoreCase("FY17-18")||dateperiod.equalsIgnoreCase("FY 17to18")
               		||dateperiod.equalsIgnoreCase("FY17to18")||dateperiod.equalsIgnoreCase("FY'17-18")
               		||dateperiod.equalsIgnoreCase("FY '17-18")||dateperiod.equalsIgnoreCase("FY17 -18")
               		||dateperiod.equalsIgnoreCase("FY 17-18")||dateperiod.equalsIgnoreCase("FY17- 18")
               		||dateperiod.equalsIgnoreCase("FY 17- 18") || dateperiod.equalsIgnoreCase("FY18")
               		 || dateperiod.equalsIgnoreCase("FY 18") || dateperiod.equalsIgnoreCase("FY'18")){
       			dateperiod="FY 17-18";	
       			startmonth=""; endmonth="";
       			System.out.println("122"+dateperiod);
       		}
       		else if (dateperiod.equalsIgnoreCase("FY 18-19")||dateperiod.equalsIgnoreCase("FY18-19")
       				||dateperiod.equalsIgnoreCase("FY 18to19")||dateperiod.equalsIgnoreCase("FY18to19")
       				||dateperiod.equalsIgnoreCase("FY'18-19")||dateperiod.equalsIgnoreCase("FY '18-19")
       				||dateperiod.equalsIgnoreCase("FY18 -19")||dateperiod.equalsIgnoreCase("FY 18-19")
       				||dateperiod.equalsIgnoreCase("FY18- 19")||dateperiod.equalsIgnoreCase("FY 18- 19")
       				 || dateperiod.equalsIgnoreCase("FY19")|| dateperiod.equalsIgnoreCase("FY 19") || dateperiod.equalsIgnoreCase("FY'19")){
       			dateperiod="FY 18-19";
       			startmonth=""; endmonth="";
       			System.out.println("122123"+dateperiod);
       		}
               System.out.println("11"+dateperiod);
              }
       		else{
       			 startmonth=dateperiod.substring(0,5);	    	   
       	    		endmonth=dateperiod.substring(6,11);
       	    		dateperiod="";
       	    		 System.out.println("10"+startmonth+"-"+endmonth+"--"+dateperiod);
       	    	
       		} 	        
      
     //----avg or %----
           List<String> avgperinputs=FinanceService.parameterConvertforavgper(avgper);
           avgper=avgperinputs.get(0);
           avgpertype=avgperinputs.get(1);
          
             //---------name,role--------
          
Statement stmt = (Statement) con.createStatement();
          
              
              if(name.contains(" ")){
                  name= name.substring(0, name.indexOf(" ")); 
                  System.out.println(name);
               }
               ResultSet rs = stmt.executeQuery(DataBaseQueryForFinance.Query_To_Fetch_Graph_Parameters+name+"%'");
               while (rs.next()) 
               {
                  resname = rs.getString("name");
                  role = rs.getString("role");
               }
               ResultSet rs1=stmt.executeQuery(DataBaseQueryForFinance.Query_To_Fetch_Graph_Parameters_1+name+"%'");
               while (rs1.next()) 
               {
                  resname = rs1.getString("name");
                  role = rs1.getString("role");
               }
               ResultSet rs2=stmt.executeQuery(DataBaseQueryForFinance.Query_To_Fetch_Graph_Parameters_2+name+"%'");
                while (rs2.next()) 
               {
                  resname = rs2.getString("name");
                  role = rs2.getString("role");
               }
                 
                if(resname==null){
    		    	sb.append("You are not the authorised person to view this graph");
    		    }
    		    else{
    		    	 if(role.equalsIgnoreCase("Dm_name")){
    		    		 role="DM";
    		     	    	colname="dm_name";
    		     	    	value=resname;
    		     	    }
    		     	    else if(role.equalsIgnoreCase("Du_Head")){
    		     	    	role="DU";
    		     	    	colname="du_head";
    		     	    	value=resname;
    		     	    }
    		     	    else if(role.equalsIgnoreCase("apps")){
    		     	    	role="APPS";
    		     	    	colname="";
    		     	    	value=resname;
    		     	    }
    		    	 System.out.println("12"+colname+"-------------"+value);
           //-----------type of graph----------------
    		    	 link ="https://celeritas.hcl.com/RESTfulExample/Finance/chart/GraphViewCustomize.php?ytd="+dateperiod+"&startdate="+startmonth+"&enddate="+endmonth+"&dmduname="+colname+"&dmduvalue="+value+"&avgper="+avgper+"&parameter="+parameternumber+"&graphtype="+type+"&avgpertype="+avgpertype;        
                     link=link.replaceAll(" ", "%20");
    		    	 
    		    		sb.append("Graph Link sent to your mail box. ");
    		    		sb.append("");
    		    	    sb.append(link);                     
                      
                            }        
                    }else{
                               sb.append("Please enter valid inputs based on given formats");
                         }
                      
                  }else if(!du_head.isEmpty() || !dm_name.isEmpty() || !apps.isEmpty()){
                	  if(!du_head.isEmpty()){
             			 role="DU";
             			 colname="du_head";
             			 value=du_head;
             		}
             		else if(!dm_name.isEmpty()){
             			role="DM";
             			 colname="dm_name";
             			 value=dm_name;
             		}
             		else if(!apps.isEmpty()){
             			role="APPS";
             			value=apps;
             			colname="";
             		}
             		 System.out.println("13"+colname+"------"+value);
             		  //--parameter--- 
               		parameternumber=FinanceService.parameterConvertforCCustomize(parameter);		
                      System.out.println("-----------------------------param2---------------"+parameter);
                      //----avg or %----
                      List<String> avgperinputs=FinanceService.parameterConvertforavgper(avgper);
                      avgper=avgperinputs.get(0);
                      avgpertype=avgperinputs.get(1);
                
                       
                    //----date period--- 
                      if(dateperiod.contains("FY") || dateperiod.contains("fy") || dateperiod.contains("Fy") || dateperiod.contains("fY")){
                          if(dateperiod.equalsIgnoreCase("FY 17-18")||dateperiod.equalsIgnoreCase("FY17-18")||dateperiod.equalsIgnoreCase("FY 17to18")
                          		||dateperiod.equalsIgnoreCase("FY17to18")||dateperiod.equalsIgnoreCase("FY'17-18")
                          		||dateperiod.equalsIgnoreCase("FY '17-18")||dateperiod.equalsIgnoreCase("FY17 -18")
                          		||dateperiod.equalsIgnoreCase("FY 17-18")||dateperiod.equalsIgnoreCase("FY17- 18")
                          		||dateperiod.equalsIgnoreCase("FY 17- 18") || dateperiod.equalsIgnoreCase("FY18")
                          		 || dateperiod.equalsIgnoreCase("FY 18") || dateperiod.equalsIgnoreCase("FY'18")){
                  			dateperiod="FY 17-18";	
                  			startmonth=""; endmonth="";
                  			System.out.println("122"+dateperiod);
                  		}
                  		else if (dateperiod.equalsIgnoreCase("FY 18-19")||dateperiod.equalsIgnoreCase("FY18-19")
                  				||dateperiod.equalsIgnoreCase("FY 18to19")||dateperiod.equalsIgnoreCase("FY18to19")
                  				||dateperiod.equalsIgnoreCase("FY'18-19")||dateperiod.equalsIgnoreCase("FY '18-19")
                  				||dateperiod.equalsIgnoreCase("FY18 -19")||dateperiod.equalsIgnoreCase("FY 18-19")
                  				||dateperiod.equalsIgnoreCase("FY18- 19")||dateperiod.equalsIgnoreCase("FY 18- 19")
                  				 || dateperiod.equalsIgnoreCase("FY19")|| dateperiod.equalsIgnoreCase("FY 19") || dateperiod.equalsIgnoreCase("FY'19")){
                  			dateperiod="FY 18-19";
                  			startmonth=""; endmonth="";
                  			System.out.println("122123"+dateperiod);
                  		}
                          System.out.println("11"+dateperiod);
                         }
                  		else{
                  			 startmonth=dateperiod.substring(0,5);	    	   
                  	    		endmonth=dateperiod.substring(6,11);
                  	    		dateperiod="";
                  	    		 System.out.println("10"+startmonth+"-"+endmonth+"--"+dateperiod);
                  	    	
                  		} 	        
              
               //---type of graph---- 
               
               link ="https://celeritas.hcl.com/RESTfulExample/Finance/chart/GraphViewCustomize.php?ytd="+dateperiod+"&startdate="+startmonth+"&enddate="+endmonth+"&dmduname="+colname+"&dmduvalue="+value+"&avgper="+avgper+"&parameter="+parameternumber+"&graphtype="+type+"&avgpertype="+avgpertype;        
               link=link.replaceAll(" ", "%20");
               

	    		sb.append("Graph Link sent to your mail box. ");
	    		sb.append("");
	    	    sb.append(link);  
                  }
                           return "" + sb;
    

    }


}
