<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
<html>
<head>
	<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>Create Conflict</title>
	<link rel="stylesheet" href="<c:url value="/styles/blueprint/screen.css" />" type="text/css" media="screen, projection">
	<link rel="stylesheet" href="<c:url value="/styles/blueprint/print.css" />" type="text/css" media="print">
	<!--[if lt IE 8]>
		<link rel="stylesheet" href="<c:url value="/styles/blueprint/ie.css" />" type="text/css" media="screen, projection">
	<![endif]-->
	<link rel="stylesheet" href="<c:url value="/styles/blueprint/print.css" />" type="text/css" media="print">	
</head>	
<body>
<div class="container">
	<h1>
		Conflict
	</h1>
	<div class="span-12 last">	
		<form:form modelAttribute="conflict" method="post">
		  	<fieldset>		
				<legend>Conflict Fields</legend>
				<p>
					<label>Source</label>
					<input id="source" name="source" /> <form:errors path="source" />			
				</p>
				<p>
					<label>Order</label>
					<input id="order" name="order" /> <form:errors path="order" />
 				</p><p>
					<form:label	for="description" path="description" cssErrorClass="error">Description</form:label>
					<form:input path="description" /> <form:errors path="description" />			
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