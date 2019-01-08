<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<!-- Populating Date Select options -->
<script type="text/javascript" src="js/populateSelect.js"></script>
