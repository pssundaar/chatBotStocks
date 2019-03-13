package com.hcl.rest.service;

public interface DataBaseQueryForFinance {
	
	
	String Query_To_Fetch_dmname_ytd_all_parameters="select ceiling(sum(ubs_ytd_pp_report.";
	String Query_To_Fetch_dmname_ytd_all_parameters_cntd1=")) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='"; 
	String Query_To_Fetch_dmname_ytd_all_parameters_cntd2="' and ubs_ytd_pp_report.";
	String Query_To_Fetch_dmname_ytd_all_parameters_cntd3="=";
	String Query_To_Fetch_dmname_ytd_all_parameters_cntd_for_apps=")) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='";
	String Query_To_Fetch_dmname_ytd_all_parameters_cntd_for_apps1="' and ubs_ytd_pp_report.LOB='";
	String Query_To_Fetch_dmname_Quarter_all_parameters="select ceiling(sum(ubs_ytd_pp_report.";
	String Query_To_Fetch_dmname_Quarter_all_parameters_cntd1=")) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='"; 
	String Query_To_Fetch_dmname_Quarter_all_parameters_cntd2="' and ubs_ytd_pp_report.";
	String Query_To_Fetch_dmname_Quarter_all_parameters_cntd3="='";
	String Query_To_Fetch_dmname_Quarter_all_parameters_cntd4="' and ubs_ytd_pp_report.Quarter like '%";
	String Query_To_Fetch_dmname_Quarter_all_parameters_cntd_for_apps="))  as result from banker_app_schema.ubs_ytd_pp_report  where ubs_ytd_pp_report.Year='";
	String Query_To_Fetch_dmname_Quarter_all_parameters_cntd_for_apps1="' and ubs_ytd_pp_report.Quarter like '%";
	String Query_To_Fetch_dmname_Quarter_all_parameters_cntd_for_apps2="%' and ubs_ytd_pp_report.LOB='";
	String Query_To_Fetch_dmname_Halfyear_all_parameters="select ceiling(sum(ubs_ytd_pp_report.";
    String Query_To_Fetch_dmname_Halfyear_all_parameters_cntd1=")) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='";
    String Query_To_Fetch_dmname_Halfyear_all_parameters_cntd2="' and ubs_ytd_pp_report.";
    String Query_To_Fetch_dmname_Halfyear_all_parameters_cntd3="='";
	String Query_To_Fetch_dmname_Halfyear_all_parameters_cntd4="' and (ubs_ytd_pp_report.Quarter like '%";
	String Query_To_Fetch_dmname_Halfyear_all_parameters_cntd5="%' or ubs_ytd_pp_report.Quarter like '%";
	String Query_To_Fetch_dmname_Halfyear_all_parameters_cntd_for_apps=")) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='";
	String Query_To_Fetch_dmname_Halfyear_all_parameters_cntd_for_apps1="' and (ubs_ytd_pp_report.Quarter like '%";
	String Query_To_Fetch_dmname_Halfyear_all_parameters_cntd_for_apps2="%') and ubs_ytd_pp_report.LOB='";
	String Query_To_Fetch_dmname_month_all_parameters="select ceiling(sum(ubs_ytd_pp_report.";
	String Query_To_Fetch_dmname_month_all_parameters_cntd1=")) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='";
	String Query_To_Fetch_dmname_month_all_parameters_cntd2="' and ubs_ytd_pp_report.";
	String Query_To_Fetch_dmname_month_all_parameters_cntd3="='";
	String Query_To_Fetch_dmname_month_all_parameters_cntd4="' and ubs_ytd_pp_report.Month like '%";
	String Query_To_Fetch_dmname_month_all_parameters_cntd_for_apps=")) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='";
	String Query_To_Fetch_dmname_month_all_parameters_cntd_for_apps1="' and ubs_ytd_pp_report.Month like '%";
	String Query_To_Fetch_dmname_month_all_parameters_cntd_for_apps2="%' and ubs_ytd_pp_report.LOB='";
	String Query_To_Fetch_ytd_all_parameters="SELECT ceiling(sum(ubs_ytd_pp_report.";
	String Query_To_Fetch_ytd_all_parameters_cntd=")) as result FROM banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='";
	
	String Query_To_Fetch_duhead_ytd_all_parameters="select ceiling(sum(ubs_ytd_pp_report.";
	String Query_To_Fetch_duhead_ytd_all_parameters_cntd1=")) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='";
	String Query_To_Fetch_duhead_ytd_all_parameters_cntd2="' and ubs_ytd_pp_report.DU_Head=";
	
	String Query_To_Fetch_Quarter_all_parameters="select ceiling(sum(ubs_ytd_pp_report.";
	String Query_To_Fetch_Quarter_all_parameters_cntd=")) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='";
	String Query_To_Fetch_Quarter_all_parameters_cntd1="' and  ubs_ytd_pp_report.Quarter like '%";
	
	String Query_To_Fetch_Halfyear_all_parameters="select ceiling(sum(ubs_ytd_pp_report.";
	String Query_To_Fetch_Halfyear_all_parameters_cntd=")) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='";
	String Query_To_Fetch_Halfyear_all_parameters_cntd1="' and  (ubs_ytd_pp_report.Quarter like '%";
	String Query_To_Fetch_Halfyear_all_parameters_cntd2="%' or ubs_ytd_pp_report.Quarter like '%";
	
	String Query_To_Fetch_month_all_parameters="select  ceiling(sum(ubs_ytd_pp_report.";
	String Query_To_Fetch_month_all_parameters_cntd=")) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='";
	String Query_To_Fetch_month_all_parameters_cntd1="' and ubs_ytd_pp_report.Month like '%";
	
	String Query_To_Fetch_duhead_Quarter_all_parameters="select ceiling(sum(ubs_ytd_pp_report.";
	String Query_To_Fetch_duhead_Quarter_all_parameters_cntd1=")) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='";
	String Query_To_Fetch_duhead_Quarter_all_parameters_cntd2="' and ubs_ytd_pp_report.DU_Head='";
	String Query_To_Fetch_duhead_Quarter_all_parameters_cntd3="' and ubs_ytd_pp_report.Quarter like '%";
	
	String Query_To_Fetch_duhead_Halfyear_all_parameters="select ceiling(sum(ubs_ytd_pp_report.";
	String Query_To_Fetch_duhead_Halfyear_all_parameters_cntd1=")) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='";
	String Query_To_Fetch_duhead_Halfyear_all_parameters_cntd2="' and ubs_ytd_pp_report.DU_Head='";
	String Query_To_Fetch_duhead_Halfyear_all_parameters_cntd3="' and (ubs_ytd_pp_report.Quarter like '%";
	String Query_To_Fetch_duhead_Halfyear_all_parameters_cntd4="%' or ubs_ytd_pp_report.Quarter like '%";
	
	String Query_To_Fetch_duhead_month_all_parameters="select ceiling(sum(ubs_ytd_pp_report.";
	String Query_To_Fetch_duhead_month_all_parameters_cntd1=")) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='";
	String Query_To_Fetch_duhead_month_all_parameters_cntd2="' and ubs_ytd_pp_report.DU_Head='";
	String Query_To_Fetch_duhead_month_all_parameters_cntd3="' and ubs_ytd_pp_report.Month like '%";
	
	
	
	String Query_To_Fetch_Revenue_GM_GmPer_Actual="select ceiling(sum(ubs_ytd_pp_report.Total_Revenue)) rev,ceiling(sum(ubs_ytd_pp_report.Gross_Margin)) gm,round((sum(ubs_ytd_pp_report.Gross_Margin)/sum(ubs_ytd_pp_report.Total_Revenue))*100,2)  gmper from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='";
	String Query_To_Fetch_Revenue_GM_GmPer_Actual_cntd="' and ubs_ytd_pp_report.";
	String Query_To_Fetch_Revenue_GM_GmPer_Actual_cntd1="='";
/*	
	String Query_To_Fetch_Revenue_GM_GmPer_Budget="select ceiling(budget.ytd)*1000 as result from banker_app_schema.budget where budget.name='"; 
	String Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd1="' and budget.role='"; 
	String Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd2="' and budget.rev_gm='Rev' union all select ceiling(budget.ytd)*1000 as result from banker_app_schema.budget where budget.name='";
	String Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd3="' and budget.role='";
	String Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd4="' and budget.rev_gm='GM' union all select round(((select budget.ytd from banker_app_schema.budget where budget.name='";
	String Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd5="' and budget.role='";
	String Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd6="' and budget.rev_gm='GM')/(select budget.ytd from banker_app_schema.budget where budget.name='";
	String Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd7="' and budget.role='";
	String Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd8="' and budget.rev_gm='Rev') )*100,2) as result from banker_app_schema.budget  where budget.name='";
	String Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd9="' and budget.role='";
	String Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd10="' and budget.rev_gm='GM'";*/
	
	
	String Query_To_Fetch_Revenue_GM_GmPer_Budget="select sum(budget.ytd)*1000 as result from banker_app_schema.budget where budget.Year='";
	String Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd="' and budget.name='";
	String Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd1="' and budget.role='";
	String Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd2="' and budget.rev_gm='Rev' union all select sum(budget.ytd)*1000  from banker_app_schema.budget where budget.Year='";
	String Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd3="' and budget.name='";
	String Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd4="' and budget.role='";
	String Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd5="' and budget.rev_gm='GM' union all select round((sum(budget.ytd) /(select sum(budget.ytd) from banker_app_schema.budget where budget.Year='";
	String Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd6="' and budget.name='";
	String Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd7="' and budget.role='";
	String Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd8="' and budget.rev_gm='Rev'))*100,2)	from banker_app_schema.budget where budget.Year='";
	String Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd9="' and budget.name='";
	String Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd10="' and budget.role='"; 
	String Query_To_Fetch_Revenue_GM_GmPer_Budget_cntd11="' and budget.rev_gm='GM'";
	
	/*String Query_To_Fetch_Revenue_Achievement="select round((sum(ubs_ytd_pp_report.Total_Revenue)/(budget.ytd*1000) )*100,2) as result from banker_app_schema.ubs_ytd_pp_report, banker_app_schema.budget where ubs_ytd_pp_report.";
	String Query_To_Fetch_Revenue_Achievement_cntd1="='";
	String Query_To_Fetch_Revenue_Achievement_cntd2="' and budget.name=ubs_ytd_pp_report.";
	String Query_To_Fetch_Revenue_Achievement_cntd3=" and budget.role='";
	String Query_To_Fetch_Revenue_Achievement_cntd4="' and budget.rev_gm='Rev';";*/
	
	String Query_To_Fetch_Revenue_Achievement="select round((sum(ubs_ytd_pp_report.Total_Revenue)/(select sum(budget.ytd)*1000 from banker_app_schema.budget where budget.Year='";
	String Query_To_Fetch_Revenue_Achievement_cntd="' and budget.name='";
	String Query_To_Fetch_Revenue_Achievement_cntd1="' and budget.rev_gm='Rev' and budget.role='";
	String Query_To_Fetch_Revenue_Achievement_cntd2="'))*100,2) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='"; 
	String Query_To_Fetch_Revenue_Achievement_cntd3="' and ubs_ytd_pp_report.";
	String Query_To_Fetch_Revenue_Achievement_cntd4="='";
	
	

	/*String Query_To_Fetch_GM_Achievement="select round((sum(ubs_ytd_pp_report.Gross_Margin)/(budget.ytd*1000) )*100,2) as result from banker_app_schema.ubs_ytd_pp_report, banker_app_schema.budget where ubs_ytd_pp_report.";
	String Query_To_Fetch_GM_Achievement_cntd1="='";
	String Query_To_Fetch_GM_Achievement_cntd2="' and budget.name=ubs_ytd_pp_report.";
	String Query_To_Fetch_GM_Achievement_cntd3=" and budget.role='";
	String Query_To_Fetch_GM_Achievement_cntd4="' and budget.rev_gm='GM'";*/
	
	String Query_To_Fetch_GM_Achievement="select round((sum(ubs_ytd_pp_report.Gross_Margin)/(select sum(budget.ytd)*1000 from banker_app_schema.budget where budget.Year='";
	String Query_To_Fetch_GM_Achievement_cntd="' and budget.name='";
	String Query_To_Fetch_GM_Achievement_cntd1="' and budget.rev_gm='GM' and budget.role='";
	String Query_To_Fetch_GM_Achievement_cntd2="'))*100,2) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='";
	String Query_To_Fetch_GM_Achievement_cntd3="' and ubs_ytd_pp_report.";
	String Query_To_Fetch_GM_Achievement_cntd4="='";
	
	
	
	
	/*String Query_To_Fetch_GMP_Achievement="select round(((sum(ubs_ytd_pp_report.Gross_Margin)/sum(ubs_ytd_pp_report.Total_Revenue))/((select budget.ytd from banker_app_schema.budget where budget.name='";
	String Query_To_Fetch_GMP_Achievement_cntd1="' and budget.role='";
	String Query_To_Fetch_GMP_Achievement_cntd2="' and budget.rev_gm='GM')/(select budget.ytd from banker_app_schema.budget where budget.name='";
	String Query_To_Fetch_GMP_Achievement_cntd3="' and budget.role='";
	String Query_To_Fetch_GMP_Achievement_cntd4="' and budget.rev_gm='Rev')))*100,2) as result from banker_app_schema.ubs_ytd_pp_report, banker_app_schema.budget where ubs_ytd_pp_report.";
	String Query_To_Fetch_GMP_Achievement_cntd5="='";
	String Query_To_Fetch_GMP_Achievement_cntd6="' and budget.name=ubs_ytd_pp_report.";
	String Query_To_Fetch_GMP_Achievement_cntd7=" and budget.role='";
	String Query_To_Fetch_GMP_Achievement_cntd8="' and budget.rev_gm='GM'";*/
	
	String Query_To_Fetch_GMP_Achievement="select round(((sum(ubs_ytd_pp_report.Gross_Margin)/sum(ubs_ytd_pp_report.Total_Revenue))/((select (sum(budget.ytd) /(select sum(budget.ytd) from banker_app_schema.budget where budget.Year='";
	String Query_To_Fetch_GMP_Achievement_cntd="' and budget.name='";
	String Query_To_Fetch_GMP_Achievement_cntd1="' and budget.role='";
	String Query_To_Fetch_GMP_Achievement_cntd2="' and budget.rev_gm='Rev'))from banker_app_schema.budget where budget.Year='";
	String Query_To_Fetch_GMP_Achievement_cntd3="' and budget.name='";
	String Query_To_Fetch_GMP_Achievement_cntd4="' and budget.role='";
	String Query_To_Fetch_GMP_Achievement_cntd5="' and budget.rev_gm='GM')))*100,2) as result from banker_app_schema.ubs_ytd_pp_report, banker_app_schema.budget where ubs_ytd_pp_report.Year='";
	String Query_To_Fetch_GMP_Achievement_cntd6="' and ubs_ytd_pp_report.";
	String Query_To_Fetch_GMP_Achievement_cntd7="='";
	
			
	String Query_To_Fetch_MOM="select ubs_ytd_pp_report.Month,round((sum(ubs_ytd_pp_report.Total_Revenue)/1000000),2) as Total_Revenue,round((sum(ubs_ytd_pp_report.Gross_Margin)/1000000),2) Gross_margin,round((sum(ubs_ytd_pp_report.Gross_Margin)/sum(ubs_ytd_pp_report.Total_Revenue))*100,2) as Gross_margin_percentage from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='";
	String Query_To_Fetch_MOM_cntd="' and ubs_ytd_pp_report.";
	String Query_To_Fetch_MOM_cntd1="='";
	String Query_To_Fetch_MOM_cntd2="' group by ubs_ytd_pp_report.Month order by month(04)" ;
	
	
	String Query_To_Fetch_MOM_TotalRev_Yearly="select ceiling(sum(ubs_ytd_pp_report.Total_Revenue)) as result from banker_app_schema.ubs_ytd_pp_report	where ubs_ytd_pp_report.Year='";
	String Query_To_Fetch_MOM_TotalRev_Yearly_cntd="' and ubs_ytd_pp_report.";
	String Query_To_Fetch_MOM_TotalRev_Yearly_cntd1="='";
	
	String Query_To_Fetch_MOM_TotalGM_Yearly="select ceiling(sum(ubs_ytd_pp_report.Gross_Margin)) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='";
	String Query_To_Fetch_MOM_TotalGM_Yearly_cntd="' and ubs_ytd_pp_report.";
	String Query_To_Fetch_MOM_TotalGM_Yearly_cntd1="='";
	
	String Query_To_Fetch_MOM_TotalGMP_Yearly="select round((sum(ubs_ytd_pp_report.Gross_Margin)/sum(ubs_ytd_pp_report.Total_Revenue))*100,2) as result from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='";
	String Query_To_Fetch_MOM_TotalGMP_Yearly_cntd="' and ubs_ytd_pp_report.";
	String Query_To_Fetch_MOM_TotalGMP_Yearly_cntd1="='";
    
	char s='"';
	String Query_To_Fetch_Attachment_excel="SELECT  'Silo','DU_Head','DM_Name', 'LOB','Quarter',"
			+ " 'Month', 'Customer', 'Customer_Name','Project','Project_Desc','Revised_Component','Project_Type',"
			+ "'Employee_Id','Employee_Name','Employee_Subgroup','Total_Revenue','Direct_Resource_Cost',"
			+ "'Salary_Cost','Consulting_TP_Cost','Travel_Cost','Total_Project_Expenses','Project_Expenses','BW_Cost','Transport_Cost',"
			+ "'Bad_Debt','DC_CFS_Tools_Standard_Cost_Project','Facility_Cost','Domestic_Direct_Cost','Fresher_Cost_Credit','SEZ_Booster',"
			+ "'Gross_Margin','Gross_FTE','AvailableFTE','Billed_FTE','GFTE','AFTE','BFTE' union all select "
			+ " `ubs_ytd_pp_report`.`Silo`,"
			+ " `ubs_ytd_pp_report`.`DU_Head`,"
   + " `ubs_ytd_pp_report`.`DM_Name`,"
   + " `ubs_ytd_pp_report`.`LOB`,"
   + " `ubs_ytd_pp_report`.`Quarter`,"
   + " `ubs_ytd_pp_report`.`Month`,"
    + "`ubs_ytd_pp_report`.`Customer`,"
   + " `ubs_ytd_pp_report`.`Customer_Name`,"
   + " `ubs_ytd_pp_report`.`Project`,"
   + " `ubs_ytd_pp_report`.`Project_Desc`,"
   + " `ubs_ytd_pp_report`.`Revised_Component`,"
   + " `ubs_ytd_pp_report`.`Project_Type`,"
   
    + "`ubs_ytd_pp_report`.`Employee_Id`,"
   + " `ubs_ytd_pp_report`.`Employee_Name`,"
  + "  `ubs_ytd_pp_report`.`Employee_Subgroup`,"
  + "  `ubs_ytd_pp_report`.`Total_Revenue`,"
  + "  `ubs_ytd_pp_report`.`Direct_Resource_Cost`,"
  + "  `ubs_ytd_pp_report`.`Salary_Cost`,"
  + "  `ubs_ytd_pp_report`.`Consulting_TP_Cost`,"
  + "  `ubs_ytd_pp_report`.`Travel_Cost`,"
  + "  `ubs_ytd_pp_report`.`Total_Project_Expenses`,"
  + "  `ubs_ytd_pp_report`.`Project_Expenses`,"
  + "  `ubs_ytd_pp_report`.`BW_Cost`,"
  + "  `ubs_ytd_pp_report`.`Transport_Cost`,"
  + "  `ubs_ytd_pp_report`.`Bad_Debt`,"
  + "  `ubs_ytd_pp_report`.`DC_CFS_Tools_Standard_Cost_Project`,"
  + "  `ubs_ytd_pp_report`.`Facility_Cost`,"
  + "  `ubs_ytd_pp_report`.`Domestic_Direct_Cost`,"
  + "  `ubs_ytd_pp_report`.`Fresher_Cost_Credit`,"
  + "  `ubs_ytd_pp_report`.`SEZ_Booster`,"
  + "  `ubs_ytd_pp_report`.`Gross_Margin`,"
   + " `ubs_ytd_pp_report`.`Gross_FTE`,"
   + " `ubs_ytd_pp_report`.`AvailableFTE`,"
   + " `ubs_ytd_pp_report`.`Billed_FTE`,"
   + " `ubs_ytd_pp_report`.`GFTE`,"
   + " `ubs_ytd_pp_report`.`AFTE`,"
   + " `ubs_ytd_pp_report`.`BFTE`"
  
+ "INTO OUTFILE 'C:/ProgramData/MySQL/MySQL Server 5.7/Uploads/";
	
	String Query_To_Fetch_Attachment_excel_cntd1=".csv'  FIELDS TERMINATED BY ','  ENCLOSED BY '"+s+"' LINES TERMINATED BY '\n'"
+ "from banker_app_schema.ubs_ytd_pp_report";

	String Query_To_Fetch_Attachment_excel_cntd2=" where ubs_ytd_pp_report.year='";
			String Query_To_Fetch_Attachment_excel_cntd3="' and ubs_ytd_pp_report.";
	String Query_To_Fetch_Attachment_excel_cntd4="='";


	String Query_To_Fetch_Apps_Actual_data_Rev_Gm_Gmp="select ceiling(sum(ubs_ytd_pp_report.Total_Revenue)) as "
			+ "rev,ceiling(sum(ubs_ytd_pp_report.Gross_Margin)) "
			+ "as gm,round(sum(ubs_ytd_pp_report.Gross_Margin)/sum(ubs_ytd_pp_report.Total_Revenue)*100,2)"
			+ " as gmp from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='";
	
	String Query_To_Fetch_Apps_Budget_data_Rev_Gm_Gmp="select budget.ytd  as result from banker_app_schema.budget where budget.Year='";
	String Query_To_Fetch_Apps_Budget_data_Rev_Gm_Gmp_cntd="' and budget.name='apps' and budget.rev_gm='rev' union all select budget.ytd as result from banker_app_schema.budget where budget.Year='";
	String Query_To_Fetch_Apps_Budget_data_Rev_Gm_Gmp_cntd1="' and budget.name='apps' and budget.rev_gm='gm' union all select round(budget.ytd/(select budget.ytd as result from banker_app_schema.budget where budget.Year='";
	String Query_To_Fetch_Apps_Budget_data_Rev_Gm_Gmp_cntd2="' and budget.name='apps' and budget.rev_gm='rev')*100,2) as result from banker_app_schema.budget where budget.Year='";
	String Query_To_Fetch_Apps_Budget_data_Rev_Gm_Gmp_cntd3="' and budget.name='apps' and budget.rev_gm='gm'";

	String Query_To_Fetch_Apps_Achievements_data_rev="select round((sum(ubs_ytd_pp_report.Total_Revenue)/ (select sum(budget.ytd)*1000 from banker_app_schema.budget  where budget.Year='";
	String Query_To_Fetch_Apps_Achievements_data_rev_cntd="' and budget.name='apps' and budget.rev_gm='rev'))*100,2) as result from banker_app_schema.ubs_ytd_pp_report";
	
	String Query_To_Fetch_Apps_Achievements_data_Gm="select round((sum(ubs_ytd_pp_report.gross_margin)/(select sum(budget.ytd)*1000 from banker_app_schema.budget where budget.Year='";
	String Query_To_Fetch_Apps_Achievements_data_Gm_cntd="' and budget.name='apps' and budget.rev_gm='gm'))*100,2) as result from banker_app_schema.ubs_ytd_pp_report";

	 String Query_To_Fetch_Apps_Achievements_data_Gmp="select round(((sum(ubs_ytd_pp_report.Gross_Margin)/sum(ubs_ytd_pp_report.Total_Revenue))/((select (sum(budget.ytd) /(select sum(budget.ytd) from banker_app_schema.budget where budget.Year='";
	 String Query_To_Fetch_Apps_Achievements_data_Gmp_cntd="' and budget.name='Apps'  and budget.rev_gm='Rev')) from banker_app_schema.budget where budget.Year='";
	 String Query_To_Fetch_Apps_Achievements_data_Gmp_cntd1="' and budget.name='Apps' and budget.rev_gm='GM')))*100,2) as result from banker_app_schema.ubs_ytd_pp_report";

	 String Query_To_Fetch_Apps_MOM_data="select ubs_ytd_pp_report.Month,round((sum(ubs_ytd_pp_report.Total_Revenue)/1000000),2)"
	 		+ " as Total_Revenue,round((sum(ubs_ytd_pp_report.Gross_Margin)/1000000),2) Gross_margin,"
	 		+ "round((sum(ubs_ytd_pp_report.Gross_Margin)/sum(ubs_ytd_pp_report.Total_Revenue))*100,2) "
	 		+ "as Gross_margin_percentage from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='";
	 String Query_To_Fetch_Apps_MOM_data_cntd="' group by ubs_ytd_pp_report.Month order by month(04)";
	 
	 String Query_To_Fetch_Apps_MOM_Total_data="select ceiling(sum(ubs_ytd_pp_report.Total_Revenue))"
	 		+ " rev,ceiling(sum(ubs_ytd_pp_report.Gross_Margin)) gm, round((sum(ubs_ytd_pp_report.Gross_Margin)/"
	 		+ "sum(ubs_ytd_pp_report.Total_Revenue))*100,2) gmp from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.Year='";
	

	 String Query_To_Fetch_Graph_Parameters="select distinct ubs_hierarchy.Apps name,'APPS' role from banker_app_schema.ubs_hierarchy where ubs_hierarchy.Apps like '%";
	 String Query_To_Fetch_Graph_Parameters_1="select distinct ubs_hierarchy.Du_head name,'Du_Head' role from banker_app_schema.ubs_hierarchy where ubs_hierarchy.Du_head like '%";
	 String Query_To_Fetch_Graph_Parameters_2="select distinct ubs_hierarchy.Dm_name name,'Dm_name' role from banker_app_schema.ubs_hierarchy where ubs_hierarchy.Dm_name like '%";
 
	 String Query_To_Fetch_Graph_Auth_for_du="SELECT distinct dm_name FROM banker_app_schema.ubs_ytd_pp_report where Du_head='";
	 String Query_To_Fetch_Graph_Auth_for_du_cntd="' and Dm_name='";
}


