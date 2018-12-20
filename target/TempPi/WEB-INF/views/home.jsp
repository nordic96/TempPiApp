<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Testing Page</title>
</head>
<body>
HELLO WORLD
	Greeting: ${greeting}
	<div align="center" style="width:70%">
	   <h1>Temperature Record List</h1>
	   <table style="width:100%">
	   	<tr>
	   		<td>Select Date:</td>
	   		<td></td>
	   	</tr>
	   </table>
	   <table border="1" style="width:100%">
	   	<tr>
		   	<th>ID</th>
		   	<th>Year</th>
		   	<th>Month</th>
		   	<th>Day</th>
		   	<th>Time</th>
		   	<th>Temperature</th>
	   	</tr>
        <c:forEach var="tempRecord" items="${tempRecordList}" varStatus="status">
        <tr>
        	<td>${tempRecord.id}</td>
            <td>${tempRecord.rec_year}</td>
            <td>${tempRecord.rec_month}</td>
            <td>${tempRecord.rec_date}</td>
            <td>${tempRecord.rec_time}</td>
            <td>${tempRecord.temp}</td>   
        </tr>
        </c:forEach>             
	   </table>
	</div>
</body>
</html>