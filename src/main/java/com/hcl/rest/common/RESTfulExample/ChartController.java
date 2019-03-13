package com.hcl.rest.common.RESTfulExample;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.hcl.rest.Database.DatabaseConnector;

@Controller
@RequestMapping("Finance/chart")
public class ChartController {

	@RequestMapping(value="/RevenueView.php", method = RequestMethod.GET)
	public String Revenue(HttpServletRequest request,
    		HttpServletResponse response) throws SQLException{
		final Connection con = DatabaseConnector.getMySqlConnection();
		//---------test---
		//String year ="FY 17-18";
		//String dmduname ="dm_name";
		//String value ="anand r";		
		//-----------from database-------
		String path=null;
		String year =request.getParameter("ytd");
		String dmduname =request.getParameter("dmduname");
		String value =request.getParameter("dmduvalue");
		System.out.println("---year----"+year+"====dmdu====="+dmduname+"----------value--------"+value);
		System.out.println("revenue inside");
		if(year!=null && dmduname!=null && value!=null){
		Gson gsonObj = new Gson();
		Map<Object,Object> map = null;
		List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
		String dataPoints = null;
		String label, yVal;
		Statement stmt =  con.createStatement();
		System.out.println("Query-- select ubs_ytd_pp_report.Month label,round((sum(ubs_ytd_pp_report.Total_Revenue)/1000000),2) y from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.year='"+year+"' and ubs_ytd_pp_report."+dmduname+"='"+value+"' group by ubs_ytd_pp_report.Month order by month(04)");
		ResultSet resultSet = stmt.executeQuery("select ubs_ytd_pp_report.Month label,round((sum(ubs_ytd_pp_report.Total_Revenue)/1000000),2) y from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.year='"+year+"' and ubs_ytd_pp_report."+dmduname+"='"+value+"' group by ubs_ytd_pp_report.Month order by month(04)");
		
		while(resultSet.next()){
			label = resultSet.getString("label");
			yVal = resultSet.getString("y");
			map = new HashMap<Object,Object>(); map.put("label", label); map.put("y", Double.parseDouble(yVal)); list.add(map);
			dataPoints = gsonObj.toJson(list);
		}
		System.out.println("---?? "+dataPoints);
		request.setAttribute("dataPoints",dataPoints);
		request.setAttribute("value",value);
		path="charts/revenue";
		}
	
	else{
		path="charts/error";
	}	
		return path;
	}
	
	@RequestMapping(value="/GmView.php", method = RequestMethod.GET)
	public String GrossMargin(HttpServletRequest request,
    		HttpServletResponse response) throws SQLException{
		final Connection con = DatabaseConnector.getMySqlConnection();
		//---------test---
		//String year ="FY 17-18";
		//String dmduname ="dm_name";
		//String value ="anand r";		
		//-----------from database-------
		String path=null;
		String year =request.getParameter("ytd");
		String dmduname =request.getParameter("dmduname");
	    String value =request.getParameter("dmduvalue");
		System.out.println("---year----"+year+"====dmdu====="+dmduname+"----------value--------"+value);
		System.out.println("GM inside");
		
	
		if(year!=null && dmduname!=null && value!=null){
		Gson gsonObj = new Gson();
		Map<Object,Object> map = null;
		List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
		String dataPoints = null;			
			String label, yVal;			
			 Statement stmt =  con.createStatement();			
			ResultSet resultSet = stmt.executeQuery("select ubs_ytd_pp_report.Month label,round((sum(ubs_ytd_pp_report.Gross_Margin)/1000000),2) y from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.year='"+year+"' and ubs_ytd_pp_report."+dmduname+"='"+value+"' group by ubs_ytd_pp_report.Month order by month(04)"); 
			while(resultSet.next()){
				label = resultSet.getString("label");
				yVal = resultSet.getString("y");
				map = new HashMap<Object,Object>(); map.put("label", label); map.put("y", Double.parseDouble(yVal)); list.add(map);
				dataPoints = gsonObj.toJson(list);
			}
			System.out.println("======-------"+dataPoints);
			request.setAttribute("dataPoints",dataPoints);
			request.setAttribute("value",value);
			path="charts/GrossMargin";
		}
		
		else{
			path="charts/error";
		}
		
		return path;
	}
	
	
	@RequestMapping(value="/GraphView.php", method = RequestMethod.GET)
	public String GraphView(HttpServletRequest request,
    		HttpServletResponse response) throws SQLException{
		final Connection con = DatabaseConnector.getMySqlConnection();
		//---------test---			
	//String parameter="Total_Revenue";
	//String year =null;
	//String startdate="apr17";
	//String enddate="dec17";
	//String dmduname ="dm_name";
	//String value ="anand r";
	//String type="bar";	
		//-----------from database-------
		String path=null;
		
				
		String year =request.getParameter("ytd");
		String dmduname =request.getParameter("dmduname");
		String value =request.getParameter("dmduvalue");		
		String parameter=request.getParameter("parameter");	
		String startdate=request.getParameter("startdate");
    	String enddate=request.getParameter("enddate");
		String type=request.getParameter("graphtype");
		System.out.println("111====dmdu====="+dmduname+"----------value--------"
		+value+"----------parameter----"+parameter+"---year----"+year+"=======---"+startdate
		+"============----------888888888---+ "+enddate);
		System.out.println("parameter inside");
		
		Gson gsonObj = new Gson();
		Map<Object,Object> map = null;
		List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
		String dataPoints = null; 
		String label, yVal;
		 Statement stmt =  con.createStatement();	
		 ResultSet resultSet = null;
		 try{
		if(!dmduname.isEmpty() && !value.isEmpty() && !parameter.isEmpty() ){	
			System.out.println("working1");
		 if(!year.isEmpty() && startdate.isEmpty() && enddate.isEmpty()){
			 if(parameter.equalsIgnoreCase("GFTE")|| parameter.equalsIgnoreCase("AFTE") ||parameter.equalsIgnoreCase("BFTE")){
				 System.out.println("GFTE O/P");
				 resultSet = stmt.executeQuery(DataBaseChartController.Query_to_fetch_barview_FY+parameter+DataBaseChartController.Query_to_fetch_barview_FY_cntd_GFTE+year+DataBaseChartController.Query_to_fetch_barview_FY_cntd1+dmduname+DataBaseChartController.Query_to_fetch_barview_FY_cntd2+value+DataBaseChartController.Query_to_fetch_barview_FY_cntd3);
				 
			 }else{
			 System.out.println("in query year sql");
			  resultSet = stmt.executeQuery(DataBaseChartController.Query_to_fetch_barview_FY+parameter+DataBaseChartController.Query_to_fetch_barview_FY_cntd+year+DataBaseChartController.Query_to_fetch_barview_FY_cntd1+dmduname+DataBaseChartController.Query_to_fetch_barview_FY_cntd2+value+DataBaseChartController.Query_to_fetch_barview_FY_cntd3); 
		System.out.println("working2");
			 } 
		 }else{
			 if(parameter.equalsIgnoreCase("GFTE")||parameter.equalsIgnoreCase("AFTE")||parameter.equalsIgnoreCase("BFTE")){
				 System.out.println("GFTE O/P");
				 resultSet=stmt.executeQuery(DataBaseChartController.Query_to_fetch_barview_MONTH+parameter+DataBaseChartController.Query_to_fetch_barview_MONTH_cntd_gfte+startdate
						 +DataBaseChartController.Query_to_fetch_barview_MONTH_cntd1+startdate+DataBaseChartController.Query_to_fetch_barview_MONTH_cntd2+enddate
						 +DataBaseChartController.Query_to_fetch_barview_MONTH_cntd3+enddate+DataBaseChartController.Query_to_fetch_barview_MONTH_cntd4
						 +DataBaseChartController.Query_to_fetch_barview_MONTH_cntd5+dmduname+DataBaseChartController.Query_to_fetch_barview_MONTH_cntd6+value+DataBaseChartController.Query_to_fetch_barview_MONTH_cntd7);
				 
			 }else{
			 resultSet=stmt.executeQuery(DataBaseChartController.Query_to_fetch_barview_MONTH+parameter+DataBaseChartController.Query_to_fetch_barview_MONTH_cntd+startdate
					 +DataBaseChartController.Query_to_fetch_barview_MONTH_cntd1+startdate+DataBaseChartController.Query_to_fetch_barview_MONTH_cntd2+enddate
					 +DataBaseChartController.Query_to_fetch_barview_MONTH_cntd3+enddate+DataBaseChartController.Query_to_fetch_barview_MONTH_cntd4
					 +DataBaseChartController.Query_to_fetch_barview_MONTH_cntd5+dmduname+DataBaseChartController.Query_to_fetch_barview_MONTH_cntd6+value+DataBaseChartController.Query_to_fetch_barview_MONTH_cntd7);
				System.out.println("working3");
				
				}
			
			System.out.println("========="+resultSet);
		 }
			while(resultSet.next()){
				label = resultSet.getString("label");
				yVal = resultSet.getString("y");
				map = new HashMap<Object,Object>(); map.put("label", label); map.put("y", Double.parseDouble(yVal)); list.add(map);
				dataPoints = gsonObj.toJson(list);
			}
			System.out.println("======-------"+dataPoints);
			request.setAttribute("dataPoints",dataPoints);
			request.setAttribute("value",value);
			request.setAttribute("param", parameter);
			if(parameter.equalsIgnoreCase("GFTE")||parameter.equalsIgnoreCase("AFTE")||parameter.equalsIgnoreCase("BFTE")){
				request.setAttribute("axisYtitle", " ");
				request.setAttribute("axisYprefix", " ");
				request.setAttribute("axisYsuffix", " ");
				request.setAttribute("yValueFormatString","#,##0.0");
			}else{
				request.setAttribute("axisYtitle", "(in million dollars USD)");
				request.setAttribute("axisYprefix", "$");
				request.setAttribute("axisYsuffix", "mn");
				request.setAttribute("yValueFormatString","$#,##0.0mn");
			}
			if(type.equalsIgnoreCase("bar")||type.equalsIgnoreCase("bar graph")||type.equalsIgnoreCase("bar chart")){
				
				path="charts/BarGraphParameter";
				}	      
		         else if(type.equalsIgnoreCase("line")||type.equalsIgnoreCase("line graph")||type.equalsIgnoreCase("line chart")){
		        	 path="charts/LineGraphParameter";
		         }
		}
		else if(dmduname.isEmpty() && !value.isEmpty() && !parameter.isEmpty() ){
			if(!year.isEmpty() && startdate.isEmpty() && enddate.isEmpty()){
				if(parameter.equalsIgnoreCase("GFTE")||parameter.equalsIgnoreCase("AFTE")||parameter.equalsIgnoreCase("BFTE")){
					 System.out.println("GFTE O/P apps");
					 resultSet = stmt.executeQuery(DataBaseChartController.Query_to_fetch_barview_FY+parameter+DataBaseChartController.Query_to_fetch_barview_FY_cntd_GFTE+year+DataBaseChartController.Query_to_fetch_barview_FY_cntd3);
				}
				else{
				  resultSet = stmt.executeQuery(DataBaseChartController.Query_to_fetch_barview_FY+parameter+DataBaseChartController.Query_to_fetch_barview_FY_cntd+year+DataBaseChartController.Query_to_fetch_barview_FY_cntd3); 
			 }
			}
			else{
				if(parameter.equalsIgnoreCase("GFTE")||parameter.equalsIgnoreCase("AFTE")||parameter.equalsIgnoreCase("BFTE")){
					 resultSet=stmt.executeQuery(DataBaseChartController.Query_to_fetch_barview_MONTH+parameter+DataBaseChartController.Query_to_fetch_barview_MONTH_cntd_gfte+startdate
							 +DataBaseChartController.Query_to_fetch_barview_MONTH_cntd1+startdate+DataBaseChartController.Query_to_fetch_barview_MONTH_cntd2+enddate
							 +DataBaseChartController.Query_to_fetch_barview_MONTH_cntd3+enddate+DataBaseChartController.Query_to_fetch_barview_MONTH_cntd4
							 +DataBaseChartController.Query_to_fetch_barview_MONTH_cntd8);
				 
					 System.out.println("GFTE O/P apps months");
				}else{
				 resultSet=stmt.executeQuery(DataBaseChartController.Query_to_fetch_barview_MONTH+parameter+DataBaseChartController.Query_to_fetch_barview_MONTH_cntd+startdate
						 +DataBaseChartController.Query_to_fetch_barview_MONTH_cntd1+startdate+DataBaseChartController.Query_to_fetch_barview_MONTH_cntd2+enddate
						 +DataBaseChartController.Query_to_fetch_barview_MONTH_cntd3+enddate+DataBaseChartController.Query_to_fetch_barview_MONTH_cntd4
						 +DataBaseChartController.Query_to_fetch_barview_MONTH_cntd8);
			 }
			}
			System.out.println("========="+resultSet);
			while(resultSet.next()){
				label = resultSet.getString("label");
				yVal = resultSet.getString("y");
				map = new HashMap<Object,Object>(); map.put("label", label); map.put("y", Double.parseDouble(yVal)); list.add(map);
				dataPoints = gsonObj.toJson(list);
			}
			System.out.println("======-------"+dataPoints);
			request.setAttribute("dataPoints",dataPoints);
			request.setAttribute("value",value);
			request.setAttribute("param", parameter);
			if(parameter.equalsIgnoreCase("GFTE") || parameter.equalsIgnoreCase("AFTE")||parameter.equalsIgnoreCase("BFTE")){
				request.setAttribute("axisYtitle", " ");
				request.setAttribute("axisYprefix", " ");
				request.setAttribute("axisYsuffix", " ");
				request.setAttribute("yValueFormatString","#,##0.0");
			}else{
				request.setAttribute("axisYtitle", "(in million dollars USD)");
				request.setAttribute("axisYprefix", "$");
				request.setAttribute("axisYsuffix", "mn");
				request.setAttribute("yValueFormatString","$#,##0.0mn");
			}
			if(type.equalsIgnoreCase("bar")||type.equalsIgnoreCase("bar graph")||type.equalsIgnoreCase("bar chart")){
			path="charts/BarGraphParameter";
			}	      
	         else if(type.equalsIgnoreCase("line")||type.equalsIgnoreCase("line graph")||type.equalsIgnoreCase("line chart")){
	        	 path="charts/LineGraphParameter";
	         }
		}
		else{
			path="charts/error";
		}
		 }
			catch(Exception e){
				path="charts/error";
			}
		return path;
	}
	@RequestMapping(value="/GraphViewCustomize.php", method = RequestMethod.GET)
	public String GraphViewCustomize(HttpServletRequest request,
    		HttpServletResponse response) throws SQLException{
		final Connection con = DatabaseConnector.getMySqlConnection();
		//---------test---	
		//String parameter="Salary_Cost";
		//String year ="FY 17-18";
		//String startdate="";
		//String enddate="";
		//String dmduname ="dm_name";
		//String value ="anand r";
		//String avgper="Total_Revenue";
		//String type="bar";
		//String avgpertype="average";
			//-----------from database-------
	
			String path=null;					
			String year =request.getParameter("ytd");
			String dmduname =request.getParameter("dmduname");
			String value =request.getParameter("dmduvalue");		
			String parameter=request.getParameter("parameter");	
			String avgper=request.getParameter("avgper");	
			String startdate=request.getParameter("startdate");
	    	String enddate=request.getParameter("enddate");
			String type=request.getParameter("graphtype");
			String avgpertype=request.getParameter("avgpertype");
			System.out.println("111====dmdu====="+dmduname+"----------value--------"
			+value+"----------parameter----"+parameter+"---year----"+year+"=======---"+startdate
			+"============----------888888888---+ "+enddate+"  "+avgper);
			System.out.println("parameter inside");
			
			Gson gsonObj = new Gson();
			Map<Object,Object> map = null;
			List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
			String dataPoints = null; 
			String label, yVal;
			 Statement stmt =  con.createStatement();	
			 ResultSet resultSet = null;
			 try{
			 if(!dmduname.isEmpty() && !value.isEmpty() && !parameter.isEmpty()&& !avgper.isEmpty() ){
				 if(!year.isEmpty() && startdate.isEmpty() && enddate.isEmpty()){
					if(avgpertype.equalsIgnoreCase("average")){
						resultSet=stmt.executeQuery(DataBaseChartController.Query_to_fetch_graphview_avgper_for_year+parameter
								+DataBaseChartController.Query_to_fetch_graphview_avgper_for_year_cntd+avgper+
								DataBaseChartController.Query_to_fetch_graphview_avgper_for_year_cntd1+year+
								DataBaseChartController.Query_to_fetch_graphview_avgper_for_year_cntd2+dmduname+
								DataBaseChartController.Query_to_fetch_graphview_avgper_for_year_cntd3+value+
								DataBaseChartController.Query_to_fetch_graphview_avgper_for_year_cntd4);
					}
					else if(avgpertype.equalsIgnoreCase("percentage")){
						System.out.println("in month customize per");
						resultSet=stmt.executeQuery(DataBaseChartController.Query_to_fetch_graphview_avgper_for_year+parameter
								+DataBaseChartController.Query_to_fetch_graphview_avgper_for_year_cntd+avgper+
								DataBaseChartController.Query_to_fetch_graphview_avgper_for_year_cntd1_percntd+year+
								DataBaseChartController.Query_to_fetch_graphview_avgper_for_year_cntd2+dmduname+
								DataBaseChartController.Query_to_fetch_graphview_avgper_for_year_cntd3+value+
								DataBaseChartController.Query_to_fetch_graphview_avgper_for_year_cntd4);
					}
				 }
				  else if(year.isEmpty() && !startdate.isEmpty() && !enddate.isEmpty()){
					if(avgpertype.equalsIgnoreCase("average")){
						System.out.println("in month customize avg");
						 resultSet=stmt.executeQuery(DataBaseChartController.Query_to_fetch_graphview_avgper_for_month+parameter+
								 DataBaseChartController.Query_to_fetch_graphview_avgper_for_month_cntd+avgper+DataBaseChartController.Query_to_fetch_graphview_avgper_for_month_cntd1+startdate
								 +DataBaseChartController.Query_to_fetch_graphview_avgper_for_month_cntd2+startdate+DataBaseChartController.Query_to_fetch_graphview_avgper_for_month_cntd3+enddate
								 +DataBaseChartController.Query_to_fetch_graphview_avgper_for_month_cntd4+enddate+DataBaseChartController.Query_to_fetch_graphview_avgper_for_month_cntd5+
								 DataBaseChartController.Query_to_fetch_graphview_avgper_for_month_cntd6+dmduname+DataBaseChartController.Query_to_fetch_graphview_avgper_for_month_cntd7+value
								 +DataBaseChartController.Query_to_fetch_graphview_avgper_for_month_cntd8);
					}
					else if(avgpertype.equalsIgnoreCase("percentage")){
						System.out.println("in month customize per");
						 resultSet=stmt.executeQuery(DataBaseChartController.Query_to_fetch_graphview_avgper_for_month+parameter+
								 DataBaseChartController.Query_to_fetch_graphview_avgper_for_month_cntd+avgper+DataBaseChartController.Query_to_fetch_graphview_avgper_for_month_cntd1_percntd+startdate
								 +DataBaseChartController.Query_to_fetch_graphview_avgper_for_month_cntd2+startdate+DataBaseChartController.Query_to_fetch_graphview_avgper_for_month_cntd3+enddate
								 +DataBaseChartController.Query_to_fetch_graphview_avgper_for_month_cntd4+enddate+DataBaseChartController.Query_to_fetch_graphview_avgper_for_month_cntd5+
								 DataBaseChartController.Query_to_fetch_graphview_avgper_for_month_cntd6+dmduname+DataBaseChartController.Query_to_fetch_graphview_avgper_for_month_cntd7+value
								 +DataBaseChartController.Query_to_fetch_graphview_avgper_for_month_cntd8);
					}
				  }
					
				 
				 System.out.println("========="+resultSet);
					while(resultSet.next()){
						label = resultSet.getString("label");
						yVal = resultSet.getString("y");
						map = new HashMap<Object,Object>(); map.put("label", label); map.put("y", Double.parseDouble(yVal)); list.add(map);
						dataPoints = gsonObj.toJson(list);
					}
					System.out.println("======-------"+dataPoints);
					request.setAttribute("dataPoints",dataPoints);
					request.setAttribute("value",value);
					request.setAttribute("param", parameter);
					request.setAttribute("avgper", avgper);
					
					if(avgpertype.equalsIgnoreCase("average")){						
						request.setAttribute("avgpertype", avgpertype);
						request.setAttribute("axisYtitle", "(in million dollars USD)");
						request.setAttribute("axisYprefix", "$");
						request.setAttribute("axisYsuffix", "mn");
						request.setAttribute("yValueFormatString","$#,##0.00000mn");
					}else if(avgpertype.equalsIgnoreCase("percentage")){						
						request.setAttribute("avgpertype", avgpertype);
						request.setAttribute("axisYtitle", "(Values in %)");
						request.setAttribute("axisYprefix", "");
						request.setAttribute("axisYsuffix", "%");
						request.setAttribute("yValueFormatString","#,##0.00000");
					}					
					
					if(type.equalsIgnoreCase("bar")||type.equalsIgnoreCase("bar graph")||type.equalsIgnoreCase("bar chart")){
						
						path="charts/BarGraphView";
						}	      
				         else if(type.equalsIgnoreCase("line")||type.equalsIgnoreCase("line graph")||type.equalsIgnoreCase("line chart")){
				        	 path="charts/LineGraphView";
				         }
			 }
				 else if(dmduname.isEmpty() && !value.isEmpty() && !parameter.isEmpty() && !avgper.isEmpty() ){
					 if(!year.isEmpty() && startdate.isEmpty() && enddate.isEmpty()){
						 if(avgpertype.equalsIgnoreCase("average")){
							 resultSet=stmt.executeQuery(DataBaseChartController.Query_to_fetch_graphview_avgper_for_year+parameter
										+DataBaseChartController.Query_to_fetch_graphview_avgper_for_year_cntd+avgper+
										DataBaseChartController.Query_to_fetch_graphview_avgper_for_year_cntd1+year+
										DataBaseChartController.Query_to_fetch_graphview_avgper_for_year_cntd4);
						 }
						 else if(avgpertype.equalsIgnoreCase("percentage")){
							 resultSet=stmt.executeQuery(DataBaseChartController.Query_to_fetch_graphview_avgper_for_year+parameter
										+DataBaseChartController.Query_to_fetch_graphview_avgper_for_year_cntd+avgper+
										DataBaseChartController.Query_to_fetch_graphview_avgper_for_year_cntd1_percntd+year+
										DataBaseChartController.Query_to_fetch_graphview_avgper_for_year_cntd4);
						 }
					  }
					 else if(year.isEmpty() && !startdate.isEmpty() && !enddate.isEmpty()){
						 if(avgpertype.equalsIgnoreCase("average")){
							 System.out.println("in month customize avg my");
							 resultSet=stmt.executeQuery(DataBaseChartController.Query_to_fetch_graphview_avgper_for_month+parameter+
									 DataBaseChartController.Query_to_fetch_graphview_avgper_for_month_cntd+avgper+DataBaseChartController.Query_to_fetch_graphview_avgper_for_month_cntd1+startdate
									 +DataBaseChartController.Query_to_fetch_graphview_avgper_for_month_cntd2+startdate+DataBaseChartController.Query_to_fetch_graphview_avgper_for_month_cntd3+enddate
									 +DataBaseChartController.Query_to_fetch_graphview_avgper_for_month_cntd4+enddate+DataBaseChartController.Query_to_fetch_graphview_avgper_for_month_cntd5+
									 DataBaseChartController.Query_to_fetch_graphview_avgper_for_month_cntd8_percntd);
						 }
						 else if(avgpertype.equalsIgnoreCase("percentage")){
							 System.out.println("in month customize per my");
							 resultSet=stmt.executeQuery(DataBaseChartController.Query_to_fetch_graphview_avgper_for_month+parameter+
									 DataBaseChartController.Query_to_fetch_graphview_avgper_for_month_cntd+avgper+DataBaseChartController.Query_to_fetch_graphview_avgper_for_month_cntd1_percntd+startdate
									 +DataBaseChartController.Query_to_fetch_graphview_avgper_for_month_cntd2+startdate+DataBaseChartController.Query_to_fetch_graphview_avgper_for_month_cntd3+enddate
									 +DataBaseChartController.Query_to_fetch_graphview_avgper_for_month_cntd4+enddate+DataBaseChartController.Query_to_fetch_graphview_avgper_for_month_cntd5+
									 DataBaseChartController.Query_to_fetch_graphview_avgper_for_month_cntd8_percntd);
						 }
					 }
					 System.out.println("========="+resultSet);
						while(resultSet.next()){
							label = resultSet.getString("label");
							yVal = resultSet.getString("y");
							map = new HashMap<Object,Object>(); map.put("label", label); map.put("y", Double.parseDouble(yVal)); list.add(map);
							dataPoints = gsonObj.toJson(list);
						}
						System.out.println("======-------"+dataPoints);
						request.setAttribute("dataPoints",dataPoints);
						request.setAttribute("value",value);
						request.setAttribute("param", parameter);
						request.setAttribute("avgper", avgper);

						if(avgpertype.equalsIgnoreCase("average")){						
							request.setAttribute("avgpertype", avgpertype);
							request.setAttribute("axisYtitle", "(in million dollars USD)");
							request.setAttribute("axisYprefix", "$");
							request.setAttribute("axisYsuffix", "mn");
							request.setAttribute("yValueFormatString","$#,##0.00000mn");
						}else if(avgpertype.equalsIgnoreCase("percentage")){						
							request.setAttribute("avgpertype", avgpertype);
							request.setAttribute("axisYtitle", "(Values in %)");
							request.setAttribute("axisYprefix", "");
							request.setAttribute("axisYsuffix", "%");
							request.setAttribute("yValueFormatString","#,##0.00000");
						}		
						
						if(type.equalsIgnoreCase("bar")||type.equalsIgnoreCase("bar graph")||type.equalsIgnoreCase("bar chart")){
							
							path="charts/BarGraphView";
							}	      
					         else if(type.equalsIgnoreCase("line")||type.equalsIgnoreCase("line graph")||type.equalsIgnoreCase("line chart")){
					        	 path="charts/LineGraphView";
					         }
				 }
				
				 else{
						path="charts/error";
					}
			 }
			 catch(Exception e){
			 path="charts/error";
			 }
		return path;
	}
}
