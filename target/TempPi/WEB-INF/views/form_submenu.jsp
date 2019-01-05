<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>Sub Menu</h3>
<div class="line"></div>
<table style="width:80%">
	<tr><td align="right"><img src="img/add_icon.png" class="img_add_icon" id="img_add_icon" onclick="openForm()"/></td></tr>
</table>
<table class="table table-sm" style="width:80%">
	<thead class="thead-light">
 	<tr>
  	<th>SubMenu ID</th>
  	<th>SubMenu Name</th>
  	<th>Context</th>
  	<th>Menu ID</th>
  	<th>Menu Name</th>
  	<th>Edit/Delete</th>
 	</tr>		   		
	</thead>
    <c:forEach var="submenu" items="${subMenuList}" varStatus="status">
    <tr>
    	<td>${submenu.sub_id}</td>
        <td>${submenu.sub_name}</td>
        <td>${submenu.context}</td>
        <td>${submenu.menu.menu_id}</td>
        <td>${submenu.menu.menu_name}</td>
        <td><img src="img/edit.png" class="img_edit"/></td>
    </tr>
    </c:forEach>             
</table>
<div class="line"></div>
<div class="form_hide">
	<form:form action="submenu/add" modelAttribute="subMenuForm" method="POST">
	<table style="width:80%">
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
	</table>
	<br>
	<input type="submit" value="Submit" class="btn btn-primary btn-sm">
	</form:form>
</div>
<br>
<table><tr><td>Sub Menu Insertion Result: ${insertResult}</td></tr></table>

<script type="text/javascript">
	function openForm() {
		$('.form_hide').show();
	}
</script>