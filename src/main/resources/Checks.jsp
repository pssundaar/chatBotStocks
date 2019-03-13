<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1"><style type="text/css">

    body { width:85%; font-family: Verdana, Arial, Helvetica, sans-serif; background-color: #CCCCCC; }
    .appName { font-size: 18px; font-weight: bold; color: #FFFFFF; padding-left: 4px; }
    .dataTblGrid { font-size: 11px; }
    .autoGen { font-size: 8pt; color: #FF0000; text-align: center; font-weight: normal; }
    .dataTbl { font-size: 11px; padding: 4px; }
    .footerNote { font-size: 9px; text-align: center; }
    .disclaimer { font-size: 9px; text-align: center; }
    .dataTbl a:visited { font-weight: bold; color: #0000FF; text-decoration: underline; }
    .dataTbl a:link { font-weight: bold; color: #0000FF; text-decoration: underline; }
    .btn { font-size: 11px; font-weight: bold; color: #FFFFFF; background-color: #0065B3; border: 1px solid #0065B3; height: 20px; }
    .note { font-size: 10px; font-weight: bold; color: #FF0000; }
    .rA { background-color: #E6F4FF; }
    .rB { background-color: #CCE8FF; }
    .r1 { background-color: #66BAFF; font-weight: bold; text-align: center; }
    .r2 { background-color: #95CFFF; font-weight: bold; text-align: left; color: #FFFFFF; }
    .rowtotal { background-color: #33CCFF; font-weight: bold; text-align: center; }
    .combo { background-color: #FFFFFF; font-size: 11px; border: 1px solid #A6D7FF; }
    .header{font-size:11px; FONT-WEIGHT: bold;background-color: #0081DF; color:white; padding:3.0pt 3.0pt 3.0pt 3.0pt;}

    </style>
    </head>

    <body leftmargin="0" topmargin="10">

    <table width="85%" cellspacing="0" cellpadding="0" valign="top" border="0" align="center">

    <tr>
    <td class="autoGen">
    This is an Auto Generated Mail. Please do not reply to this mail
    </td>
    </tr>

    <tr bgcolor="#0065b3">
    <td>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
    <td class="appName">
    <strong>Report Details </strong>
    </td>
  
    </tr>
    </table>
    </td>
    </tr>

    <tr>
    <td align="center">
    

			<table cellspacing="0" cellpadding="0" valign="top" border="0" align="center" width="100%">
			
			<tr>
			<td bgcolor="#ffffff" class="dataTbl">

			Dear <b> HCLite, </b> <br> <br>
			
			</td>
			</tr>

			<tr>
			<td bgcolor="#ffffff" class="dataTbl">
			</td>
			</tr>

			<tr>
			<td bgcolor="#ffffff" align="center">
			<table width="99%" bordercolor="#0065b3" style="BORDER-COLLAPSE:collapse" class="dataTblGrid" cellpadding="0" cellspacing="0" border="0">
			<tr bgcolor="#0065b3" class="header">
			<td style="border:inset #0065B3 1.0pt;">
		    Achievement View
			</td>
			</tr>
			<tr>
			<td>
			<table width="100%" cellpadding="4" cellspacing="0" bordercolor="#0065b3" 
			style="BORDER-COLLAPSE:collapse" class="dataTblGrid" border="1">
			<tr>
			<td style="padding-left:5px;width:30%" class="rB"> </td>
			<td style="padding-left:5px;" class="rA"> Budget</td>
			<td style="padding-left:5px;" class="rA"> Actual</td>
			<td style="padding-left:5px;" class="rA"> Achievement (%)</td>
			</tr>
			<tr>
			<tr>
			<td style="padding-left:5px;width:30%" class="rB">Revenue </td>
			<td style="padding-left:5px;" class="rA"> $firstName[3]</td>
			<td style="padding-left:5px;" class="rA"> $firstName[0]</td>
			<td style="padding-left:5px;" class="rA"> $firstName[6]</td>
			</tr>
			<tr>
			<td style="padding-left:5px;width:30%" class="rB"> GM$ </td>
			<td style="padding-left:5px;" class="rA"> $firstName[4]</td>
			<td style="padding-left:5px;" class="rA"> $firstName[1]</td>
			<td style="padding-left:5px;" class="rA"> $firstName[7]</td>
			</tr>
			<tr><td style="padding-left:5px;width:30%" class="rB"> GM% </td>
			<td style="padding-left:5px;" class="rA"> $firstName[5]</td>
			<td style="padding-left:5px;" class="rA"> $firstName[2]</td>
			<td style="padding-left:5px;" class="rA"> $firstName[8]</td>
			</tr>
			</table>
			</td>
			</tr>
			</table>
			
						<table width="99%" bordercolor="#0065b3" style="BORDER-COLLAPSE:collapse" class="dataTblGrid" cellpadding="0" cellspacing="0" border="0">
			<tr bgcolor="#0065b3" class="header">
			<td style="border:inset #0065B3 1.0pt;">
		    Month on Month View
			</td>
			</tr>
			<tr>
			<td>
			<table width="100%" cellpadding="4" cellspacing="0" bordercolor="#0065b3" 
			style="BORDER-COLLAPSE:collapse" class="dataTblGrid" border="1">
			
			<tr>
			<td style="padding-left:5px;width:30%" class="rB">Values </td>
			<td style="padding-left:5px;width:30%" class="rB">Sum of Total Revenue </td>
			<td style="padding-left:5px;" class="rA">Sum of Gross Margin</td>
			 <td style="padding-left:5px;" class="rA">Sum of GM%</td>
			
			</tr>
			<tr>
			#foreach ($monthMOM in $months)
			<td style="padding-left:5px;" class="rA"> $monthMOM</td>
			#end
			</tr>
					
			<tr>			
			#foreach ($revMOM in $momREV)	
			<td style="padding-left:5px;" class="rA"> $revMOM</td>	
			#end		
			</tr>
			
			
			<tr>
			#foreach ($gmMOM in $momGM)
			<td style="padding-left:5px;" class="rA"> gmMOM</td>
			#end
			</tr>
			
			
			<tr>
		   #foreach ($gmpMOM in $momGMP)
			<td style="padding-left:5px;" class="rA">gmpMOM</td>
			#end
			</tr>
			</table>
			</td>
			</tr>
			</table>
			
			</td>
			</tr>

			<tr>
			<td bgcolor="#ffffff" class="dataTbl">
			</td>
			</tr>

			
		
    </td>
    </tr>

    <tr>
    <td bgcolor="#ffffff">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
    <td colspan="3">
    <hr align="center" width="99%" size="1" noshade="">
    </td>
    </tr>

    <tr>
   
      

    
    </tr>
    </table>
    </td>
    </tr>

    <tr>
    <td height="10" bgcolor="#0065b3"></td>
    </tr>

    <tr>
    <td class="disclaimer">
    Disclaimer: This message and any attachment(s) contained here are information that is confidential, proprietary to HCL Technologies and its customers. Contents may be privileged or otherwise protected by law. The information is solely intended for the individual or the entity it is addressed to. If you are not the intended recipient of this message, you are not authorized to read, forward, print, retain, copy or disseminate this message or any part of it.
    </td>
    </tr>

    </table>

    </body>

    </html>
  