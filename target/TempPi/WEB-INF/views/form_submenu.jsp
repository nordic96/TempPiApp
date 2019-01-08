<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>Sub Menu</h3>
<div class="line"></div>
<table>
	<tr><td align="left"><img src="img/add_icon.png" class="img_add_icon" id="img_add_icon" onclick="openForm()"/></td></tr>
</table>
<div style="width:80%">
<table id="dtVerticalScroll"
class="table table-striped table-bordered table-sm">
	<tbody>
		<thead>
	 	<tr>
	  	<th class="th-sm">SubMenu ID</th>
	  	<th class="th-sm">SubMenu Name</th>
	  	<th class="th-sm">Context</th>
	  	<th class="th-sm">Menu ID</th>
	  	<th class="th-sm">Menu Name</th>
	 	</tr>		   		
		</thead>
	</tbody>        
</table>
</div>
<div class="line"></div>
<div class="form_hide" style="width:80%">
	<form:form action="submenu/add" modelAttribute="subMenuForm" method="POST">
	<table>
	<tbody>
		<tr>
			<td>SubMenu Name: </td>
			<td><form:input path="sub_name" id="sub_name"/></td>
			<td>SubMenu Context: </td>
			<td><form:input path="context" id="context"/></td>
		</tr>
		<tr>
			<td>Menu: </td>
			<td>
			<form:select class="form-control form-control-sm" path="menu" id="menu">
					<form:options items="${menuList}" itemLabel="menu_name"/>
			</form:select>
			</td>
		</tr>	
	</tbody>
	</table>
	<br>
	<input type="submit" value="Submit" class="btn btn-primary btn-sm">
	</form:form>
</div>
<br>
<table><tr><td>Sub Menu Insertion Result: <c:out value="${insertResult}"/></td></tr></table>
<script type="text/javascript">
$(document).ready(function() {
	var data = eval('${subMenuListJson}');
	$('#dtVerticalScroll').DataTable({
		"aaData" : data,	
		"aoColumns" : [
			{"mData": "sub_id"},	
			{"mData": "sub_name"},
			{"mData": "context"},
			{"mData": "menu.menu_id"},
			{"mData": "menu.menu_name"}
		],
		"scrollY": "250px",
		"scrollCollapse": true,
	});
	$('.dataTables_length').addClass('bs-select');
});
</script>
