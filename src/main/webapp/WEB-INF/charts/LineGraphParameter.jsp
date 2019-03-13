<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@ page import="java.util.*,java.sql.*" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>



<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

 <script type="text/javascript">
window.onload = function() { 
 
var chart = new CanvasJS.Chart("chartContainer", {
	theme: "light2",
	title: {
		text: "<%=request.getAttribute("value")%> <%=request.getAttribute("param")%>"
	},
	axisX: {
		title: "<%=request.getAttribute("axisYtitle")%>"
	},
	axisY: {
		title: "<%=request.getAttribute("axisYtitle")%>"
	},
	data: [{
		type: "line",
		yValueFormatString: "<%=request.getAttribute("yValueFormatString")%>",
		dataPoints : <%out.print(request.getAttribute("dataPoints"));%>
	}]
});
chart.render();
 
}
</script>
</head>
<body>
<div id="chartContainer" style="height: 370px; width: 100%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
</html>