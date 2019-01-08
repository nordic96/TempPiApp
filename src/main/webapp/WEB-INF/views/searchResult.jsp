<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h3>Temperature Record List</h3>
<br>
<p>Temperature record graph for: <c:out value="${year}"/>/<c:out value="${month}"/>
/<c:out value="${date}"/></p>
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
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript"> var searchResult = '${searchResultJson}';</script>
<script type="text/javascript" src="js/linechart.js"></script> 