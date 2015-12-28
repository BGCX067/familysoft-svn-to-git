<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
<html>
<head>
	<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>Create Account</title>
	<link rel="stylesheet" href="<c:url value="/styles/blueprint/screen.css" />" type="text/css" media="screen, projection">
	<link rel="stylesheet" href="<c:url value="/styles/blueprint/print.css" />" type="text/css" media="print">
	<!--[if lt IE 8]>
		<link rel="stylesheet" href="<c:url value="/styles/blueprint/ie.css" />" type="text/css" media="screen, projection">
	<![endif]-->
	<link rel="stylesheet" href="<c:url value="/styles/blueprint/print.css" />" type="text/css" media="print">
	<script type="text/javascript" src="/script/jquery-1.4.2.min.js"></script>	
	<script type="text/javascript">
		$('addRows').click( function() {
			$('<input id="foodAliases" type="text"/>').appendTo('aliasSet');
		});
	</script>
</head>	
<body>
<div class="container">
	<h1>
		ADD Food
	</h1>
	<div class="span-12 last">	
		<form:form modelAttribute="food" method="post">
		  	<fieldset>		
				<legend>Food Fields</legend>
				<p>
					<form:label	for="name" path="name" cssErrorClass="error">Name</form:label>
					<form:input path="name" /> <form:errors path="name" />			
				</p>
				<p id="aliasSet">
					<label for="foodAlias" >Alias</label>
					<input name="foodAlias" id="foodAlias" /><button id="addRows" type="button">ADD ROWS</button>
				</p>
				<p>	
					<input type="submit" />
				</p>
			</fieldset>
		</form:form>
	</div>
	<hr>	
	<ul>
		<li> <a href="?locale=en_us">us</a> |  <a href="?locale=en_gb">gb</a> | <a href="?locale=es_es">es</a> | <a href="?locale=de_de">de</a> </li>
	</ul>	
</div>
</body>
</html>