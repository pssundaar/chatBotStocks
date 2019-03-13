package com.hcl.rest.common.RESTfulExample;

public interface DataBaseChartController {
	
	String Query_to_fetch_barview_FY="select ubs_ytd_pp_report.Month label,round((sum(ubs_ytd_pp_report.";
	String Query_to_fetch_barview_FY_cntd=")/1000000),2) y from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.year='";
    String Query_to_fetch_barview_FY_cntd1="' and ubs_ytd_pp_report.";
	String Query_to_fetch_barview_FY_cntd2="='";
	String Query_to_fetch_barview_FY_cntd3="' group by ubs_ytd_pp_report.Month order by month(04)";
	String Query_to_fetch_barview_FY_cntd_GFTE=")),2) y from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.year='";
	
	
	
	String Query_to_fetch_barview_MONTH="select ubs_ytd_pp_report.Month label,round((sum(ubs_ytd_pp_report.";
	String Query_to_fetch_barview_MONTH_cntd=")/1000000),2) y from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.dates >=str_to_date(concat(20,substring('";
	String Query_to_fetch_barview_MONTH_cntd1="',4,5),'-',substring('";
	String Query_to_fetch_barview_MONTH_cntd2="',1,3),'-','01'),'%Y-%b-%d')	and	ubs_ytd_pp_report.dates <= str_to_date(concat(20,substring('";
	String Query_to_fetch_barview_MONTH_cntd3="',4,5),'-',substring('";
	String Query_to_fetch_barview_MONTH_cntd4="',1,3),'-','01'),'%Y-%b-%d')";
	String Query_to_fetch_barview_MONTH_cntd5=" and ubs_ytd_pp_report.";
	String Query_to_fetch_barview_MONTH_cntd6="='";
	String Query_to_fetch_barview_MONTH_cntd7="' group by ubs_ytd_pp_report.Month order by month(04)";
	String Query_to_fetch_barview_MONTH_cntd8=" group by ubs_ytd_pp_report.Month order by month(04)";
	String Query_to_fetch_barview_MONTH_cntd_gfte=")),2) y from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.dates >=str_to_date(concat(20,substring('";

	String Query_to_fetch_graphview_avgper_for_year="select ubs_ytd_pp_report.Month label,(((sum(ubs_ytd_pp_report.";
	String Query_to_fetch_graphview_avgper_for_year_cntd=")))/((sum(ubs_ytd_pp_report.";
	String Query_to_fetch_graphview_avgper_for_year_cntd1=")))) y from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.year='";
	String Query_to_fetch_graphview_avgper_for_year_cntd1_percntd=")))*100) y from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.year='";
	String Query_to_fetch_graphview_avgper_for_year_cntd2="' and ubs_ytd_pp_report.";
	String Query_to_fetch_graphview_avgper_for_year_cntd3="='";
	String Query_to_fetch_graphview_avgper_for_year_cntd4="' group by ubs_ytd_pp_report.Month order by month(04);";

	String Query_to_fetch_graphview_avgper_for_month="select ubs_ytd_pp_report.Month label,(((sum(ubs_ytd_pp_report.";
	String Query_to_fetch_graphview_avgper_for_month_cntd=")))/((sum(ubs_ytd_pp_report.";
	String Query_to_fetch_graphview_avgper_for_month_cntd1=")))) y from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.dates >=str_to_date(concat(20,substring('";
	String Query_to_fetch_graphview_avgper_for_month_cntd1_percntd=")))*100) y from banker_app_schema.ubs_ytd_pp_report where ubs_ytd_pp_report.dates >=str_to_date(concat(20,substring('";
	String Query_to_fetch_graphview_avgper_for_month_cntd2="',4,5),'-',substring('";
	String Query_to_fetch_graphview_avgper_for_month_cntd3="',1,3),'-','01'),'%Y-%b-%d') and ubs_ytd_pp_report.dates <= str_to_date(concat(20,substring('";
	String Query_to_fetch_graphview_avgper_for_month_cntd4="',4,5),'-',substring('";
	String Query_to_fetch_graphview_avgper_for_month_cntd5="',1,3),'-','01'),'%Y-%b-%d')";
	String Query_to_fetch_graphview_avgper_for_month_cntd6=" and ubs_ytd_pp_report.";
	String Query_to_fetch_graphview_avgper_for_month_cntd7="='";
	String Query_to_fetch_graphview_avgper_for_month_cntd8="' group by ubs_ytd_pp_report.Month order by month(04)";
	String Query_to_fetch_graphview_avgper_for_month_cntd8_percntd=" group by ubs_ytd_pp_report.Month order by month(04)";
}
