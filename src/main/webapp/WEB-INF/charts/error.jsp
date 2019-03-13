<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/OpportunityTrcakerCSS/global.css" />

<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/IMAGES/48.png" />
<script type="text/javascript">
	function disableBackButton() {
		window.history.forward();
	}
	setTimeout("disableBackButton()", 0);
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Something went wrong</title>
</head>
<body onload="disableBackButton()">
	<%
		response.setHeader("Cache-Control",
				"no-cache,no-store,must-revalidate");//HTTP 1.1
		response.setHeader("Pragma", "no-cache"); //HTTP 1.0
		response.setDateHeader("Expires", 0); //prevents caching at the proxy server
	%>
		<div align="center">
		<font color="#33cc33" size="5px">Something went wrong</font>
	</div>
	<br>

	<font color="#006600" size="4px"><div align="center">

			This page automatically will be closed in 10 Sec, If not close,
			Please close this window. This will ensure that any information that
			is cached (stored) on your browser is erased and will not allow
			others to use it later for login.
			<hr>
			<h2 align="center">For Security reason window will auto closed
				after 0 seconds</h2>
		</div></font>
		
		

	<script type="text/javascript">
		var time = 10; /* how long the timer runs for */
		var initialOffset = '440';
		var i = 1
		var interval = setInterval(function() {

			$('h2').text(
					"For Security reason window will auto closed after " + i
							+ " seconds");
			if (i == time) {
				window.open('', '_self', '');
				window.close();
			}
			i++;
		}, 1000);
	</script>
	<br>
	
</body>
</html>