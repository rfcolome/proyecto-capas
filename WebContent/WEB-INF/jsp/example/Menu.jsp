<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title>
			Mantenimiento de Usuarios
		</title>
	</head>

	<body>
		<s:form action="Login">
    		<s:textfield key="nombre"/>
    		<s:textfield key="apellido" />
    		<s:submit/>
		</s:form>		
	</body>
</html>
