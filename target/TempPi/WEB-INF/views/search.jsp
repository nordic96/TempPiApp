<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript"> var searchResult = '${searchResultJson}';</script>
<script type="text/javascript" src="js/linechart.js"></script>
<meta charset="ISO-8859-1">
<title>TempPi Search</title>
</head>
<body>
	<div align="center" style="width:70%">
	   <h1>Temperature Record List</h1>
	   <div align="left">
	   <form name="search" action="search" method="POST">
	   <table>
	   	<tr><td colspan="7">Search by date</td></tr>
	   	<tr>
	   		<td>Year:</td>
	   		<td>
	   			<form:select path="yearList" name="search_year">
	   				<form:option value="NONE" label="Select"/>
	   				<form:options items="${yearList}"/>
	   			</form:select>
	   		</td>
	   		<td>Month:</td>
	   		<td>
	   			<form:select path="monthList" name="search_month">
	   				<form:option value="NONE" label="Select"/>
	   				<form:options items="${monthList}"/>
	   			</form:select>
	   		</td>
	   		<td>Day:</td>
	   		<td>
	   			<form:select path="dateList" name="search_date">
	   				<form:option value="NONE" label="Select"/>
	   				<form:options items="${dateList}"/>
	   			</form:select>
	   		</td>
	   		<td><input type="submit" value="Search" class="btn"></td>
	   	</tr>
	   </table>	 
	   </form>  
	   </div>
	   <div id="tempLineChart"></div>
	   <div>
		   <table border="1" style="width:100%">
		   	<tr>
			   	<th>ID</th>
			   	<th>Year</th>
			   	<th>Month</th>
			   	<th>Day</th>
			   	<th>Time</th>
			   	<th>Temperature</th>
		   	</tr>
	        <c:forEach var="tempRecord" items="${searchResultList}" varStatus="status">
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
	</div>
</body>
</html>