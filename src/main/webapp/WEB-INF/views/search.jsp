<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<!-- BootStrap Loader -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" 
integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript"> var searchResult = '${searchResultJson}';</script>
<script type="text/javascript" src="js/linechart.js"></script>

<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>TempPi Search</title>
</head>
<body>
	<div align="center" style="padding:80px">
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
	   <div id="tempLineChart" align="left"></div>
	   <div>
		   <table class="table table-hover" border="1" style="width:100%">
		   	<thead>
			   	<tr>
				   	<th scope="col">#</th>
				   	<th scope="col">Year</th>
				   	<th scope="col">Month</th>
				   	<th scope="col">Day</th>
				   	<th scope="col">Time</th>
				   	<th scope="col">Temperature</th>
			   	</tr>		   		
		   	</thead>
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
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>