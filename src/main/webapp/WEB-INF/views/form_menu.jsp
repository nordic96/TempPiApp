<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>Menu Form</h3>
<div class="line"></div>
<table style="width:80%">
	<tr><td align="left"><img src="img/add_icon.png" class="img_add_icon" id="img_add_icon" onclick="openMenuForm()"/></td></tr>
</table>
<div style="width:80%">
<table id="dtVerticalScroll"
class="display">
	<tbody>
		<thead>
	 	<tr>
	  	<th class="th-sm">Menu ID</th>
	  	<th class="th-sm">Menu Name</th>
	 	</tr>		   		
		</thead>
	</tbody>        
</table>
</div>
<div class="line"></div>
<div class="form_hide">
	<form:form action="addMenu" modelAttribute="addMenuForm" method="POST">
	<table>
		<tr>
			<td>Menu Name: </td>
			<td><form:input path="menu_name" id="menu_name"/></td>
		</tr>
	</table>
	<br>
	<input type="submit" value="Submit" class="btn btn-primary btn-sm">
	</form:form>
</div>
<br>
<table><tr><td>Menu Insertion Result: ${successMsg}</td></tr></table>
<script type="text/javascript">
	$(document).ready(function() {
		var data = eval('${menuListJson}');
		$('#dtVerticalScroll').DataTable({
			"aaData" : data,	
			"aoColumns" : [
				{"mData": "menu_id"},	
				{"mData": "menu_name"}
			],
			"scrollY": "250px",
			"scrollCollapse": true,
		});
		$('.dataTables_length').addClass('bs-select');
	});
	function openMenuForm() {
		$('.form_hide').show();
	}
</script>