<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="icon" type="image/ico" href="/TempPi/favicon.ico"/>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>Temperature Search</title>

    <!-- Bootstrap CSS CDN -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" 
    integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" 
    crossorigin="anonymous">
    
    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/image.css">
	
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
        <h3>Temperature Search</h3>
	   <form:form name="search" action="searchResult" modelAttribute="searchForm" method="POST">
		   <table>
		   	<tr><td colspan="7">Search by date</td></tr>
		   	<tr>
		   		<td>Year:</td>
		   		<td>
		   			<form:select class="form-control form-control-sm" path="search_year"
		   			id="search_year">
		   				<form:option value="NONE" label="Select" selected="true"/>
		   				<form:options items="${yearList}"/>
		   			</form:select>
		   		</td>
		   		<td>Month:</td>
		   		<td>
		   			<form:select class="form-control form-control-sm" path="search_month"
		   			id="search_month">
		   				<form:option value="NONE" label="Select"/>
		   			</form:select>
		   		</td>
		   		<td> Day:</td>
		   		<td>
		   			<form:select class="form-control form-control-sm" path="search_date"
		   			id="search_date">
		   				<form:option value="NONE" label="Select"/>
		   			</form:select>
		   		</td>
		   		<td><input type="submit" value="Search" class="btn btn-primary btn-sm"></td>
		   		<td class="td_loading">loading..<img id="loading_search" src="img/loading.gif"/></td>
		   	</tr>
		   	<tr>
		   		<td colspan="7"><form:errors path="search_year" class="error"/></td>
		   	</tr>
		   	<tr>		   		
		   		<td colspan="7"><form:errors path="search_month" class="error"/></td>
		   	</tr>
		   	<tr>
		   		<td colspan="7"><form:errors path="search_date" class="error"/></td>
		   	</tr>
		   </table>
	   </form:form>
	   <br>
    </div>
</div>
    <!-- jQuery CDN - (with AJAX) -->
	<script src="https://code.jquery.com/jquery-3.3.1.js"
  	integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
  	crossorigin="anonymous"></script>
  	
    <!-- Popper.JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" 
    integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" 
    crossorigin="anonymous"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" 
    integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" 
    crossorigin="anonymous"></script>
    
    <!-- Populating Date Select options -->
    <script type="text/javascript" src="js/populateSelect.js"></script>
    
    <!-- jQuery Custom Scroller CDN -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.concat.min.js"></script>
    
    <!-- sidebar JQuery -->
    <script type="text/javascript">
        $(document).ready(function () {
            $("#sidebar").mCustomScrollbar({
                theme: "minimal"
            });

            $('#sidebarCollapse').on('click', function () {
                $('#sidebar, #content').toggleClass('active');
                $('.collapse.in').toggleClass('in');
                $('a[aria-expanded=true]').attr('aria-expanded', 'false');
            });
        });
    </script>
</body>
</html>