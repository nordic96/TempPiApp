<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<link rel="icon" type="image/ico" href="/TempPi/favicon.ico"/>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	
	<title>TempPi Search</title>

    <!-- Bootstrap CSS CDN -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" 
    integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" 
    crossorigin="anonymous">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/style.css">
	
	<!-- Scrollbar Custom CSS -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.css">
    
    <!-- Font Awesome JS -->
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" 
    integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" 
    crossorigin="anonymous"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" 
    integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" 
    crossorigin="anonymous"></script>
</head>
<body>
<div class="wrapper">
    <!-- Sidebar -->
    <nav id="sidebar">
        <div class="sidebar-header">
            <h3>TempPi</h3>
        </div>

        <ul class="list-unstyled components">
            <li>
                <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Home</a>
                <ul class="collapse list-unstyled" id="homeSubmenu">
                    <li>
                        <a href="${contextPath}/">Home</a>
                    </li>
                </ul>
            </li>
            <li class="active">
                <a href="#pageSubmenu" data-toggle="collapse" aria-expanded="true" class="dropdown-toggle">Search</a>
                <ul class="list-unstyled collapse show" id="pageSubmenu">
                    <li>
                        <a href="${contextPath}/search">Temperature Search</a>
                    </li>
                </ul>
            </li>
        </ul>
    </nav> 

    <!-- Page Content -->
    <div id="content">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">

                <button type="button" id="sidebarCollapse" class="btn btn-info">
                    <i class="fas fa-align-left"></i>
                    <span>Toggle Sidebar</span>
                </button>
            </div>
        </nav>
        <h2>Temperature Record List</h2>
	    <form name="search" action="searchResult" method="POST">
		   <table>
		   	<tr><td colspan="7">Search by date</td></tr>
		   	<tr>
		   		<td>Year:</td>
		   		<td>
		   			<form:select class="form-control form-control-sm" path="yearList" name="search_year">
		   				<form:option value="NONE" label="Select"/>
		   				<form:options items="${yearList}"/>
		   			</form:select>
		   		</td>
		   		<td>Month:</td>
		   		<td>
		   			<form:select class="form-control form-control-sm" path="monthList" name="search_month">
		   				<form:option value="NONE" label="Select"/>
		   				<form:options items="${monthList}"/>
		   			</form:select>
		   		</td>
		   		<td> Day:</td>
		   		<td>
		   			<form:select class="form-control form-control-sm" path="dateList" name="search_date">
		   				<form:option value="NONE" label="Select"/>
		   				<form:options items="${dateList}"/>
		   			</form:select>
		   		</td>
		   		<td><input type="submit" value="Search" class="btn btn-primary btn-sm"></td>
		   	</tr>
		   </table>
	   </form>
	   <br>
	   <p>Temperature record graph for:</p>
	   <div id="tempLineChart" style="width:80%" align="left"></div>
	   <br>
	   <table class="table table-sm" style="width:80%">
	   	<thead class="thead-light">
		   	<tr>
			   	<th>#</th>
			   	<th>Year</th>
			   	<th>Month</th>
			   	<th>Day</th>
			   	<th>Time</th>
			   	<th>Temperature</th>
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
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	<script type="text/javascript"> var searchResult = '${searchResultJson}';</script>
	<script type="text/javascript" src="js/linechart.js"></script>

    <!-- jQuery CDN - Slim version (=without AJAX) -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" 
    integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" 
    crossorigin="anonymous"></script>
    <!-- Popper.JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" 
    integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" 
    crossorigin="anonymous"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" 
    integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" 
    crossorigin="anonymous"></script>
    
    <!-- jQuery Custom Scroller CDN -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.concat.min.js"></script>
    
    <!-- sidebar JQuery -->
    <script type="text/javascript">
        $(document).ready(function () {
            $('#sidebarCollapse').on('click', function () {
                $('#sidebar').toggleClass('active');
            });
        });
    </script>
</body>
</html>