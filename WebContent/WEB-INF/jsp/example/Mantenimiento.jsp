<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
	<head>
		<title>
			Mantenimiento de Usuarios
		</title>
	</head>

	<body>
		<s:form action="Mantenimiento">
    		<s:textfield key="nombre"/>
    		<s:textfield key="apellido" />
    		<s:textfield key="usuario" />
    		<s:textfield key="password" />
    		
    		<s:submit value="guardar"/>
		</s:form>		
	</body>
</html>
