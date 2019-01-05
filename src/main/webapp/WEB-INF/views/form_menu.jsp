<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>Menu Form</h3>
<div class="line"></div>
<table style="width:80%">
	<tr><td align="right"><img src="img/add_icon.png" class="img_add_icon" id="img_add_icon" onclick="openMenuForm()"/></td></tr>
</table>
<table class="table table-sm" style="width:80%">
	<thead class="thead-light">
 	<tr>
  	<th>#</th>
  	<th>Menu Name</th>
  	<th>Edit/Delete</th>
 	</tr>		   		
	</thead>
    <c:forEach var="menu" items="${menuList}" varStatus="status">
    <tr>
    	<td>${menu.menu_id}</td>
        <td>${menu.menu_name}</td>
        <td><img src="img/edit.png" class="img_edit"/></td>
    </tr>
    </c:forEach>             
</table>
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
	function openMenuForm() {
		$('.form_hide').show();
	}
</script>