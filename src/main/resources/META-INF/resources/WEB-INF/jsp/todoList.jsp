<%@include file="common/header.jspf" %>
<%@include file="common/navigation.jspf" %>

<div class="container">
<div><h1>Welcome</div>
<div>Hello ${name} list is</div>
<hr>
<table class="table">
<thead>
<tr>
<th>desc</th>
<th>date</th>
<th>isdone</th>
<th></th>
<th></th>
</tr>
</thead>
<tbody>
	<c:forEach items="${list}" var="todo">
	<tr>
		<td>${todo.description}</td>
		<td>${todo.targetDate}</td>
		<td>${todo.done}</td>
		<td> <a href="delete-todo?id=${todo.id}"   class="btn btn-warning">Delete</a> </td>
		<td> <a href="update-todo?id=${todo.id}"   class="btn btn-success">Update</a> </td>
		</tr>
	</c:forEach>

</tbody>

</table>



<div><a href="add-todo" class="btn btn-success">Add Todo</a></div>
</div>

<%@include file="common/footer.jspf" %>>
