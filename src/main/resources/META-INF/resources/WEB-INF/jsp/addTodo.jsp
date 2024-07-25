<%@include file="common/header.jspf" %>
<%@include file="common/navigation.jspf" %>

<div>Add Todo</div>>
<div>Hello ${name}</div>
<div><form:form method="post" modelAttribute="todo">
<fieldset class="mb-3">
<form:label  path="description"> Description </form:label>>
<form:input type="text" required="required" path="description"/>
<form:errors  path="description" cssClass="text-warning"/>
</fieldset>

<fieldset class="mb-3">
<form:label  path="targetDate"> Target Date </form:label>>
<form:input type="text" required="required" path="targetDate"/>
<form:errors  path="targetDate" cssClass="text-warning"/>
</fieldset>

<form:input type="hidden"  path="id"/>
<form:input type="hidden"  path="done"/>
<input type="submit" class="btn btn-success"> 
</form:form></div>
<div></div>

<%@include file="common/footer.jspf" %>>

<script type="text/javascript">
	$('#targetDate').datepicker({
	    format: 'yyyy-mm-dd'
	});
</script>
