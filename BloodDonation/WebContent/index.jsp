<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<s:form  action="loginUser">

	<s:textfield label="Login Id" key="userId"></s:textfield>
	<s:password label="Password" key="password"></s:password>
	<s:submit></s:submit>

</s:form>

<a href="registeration"> Register Here </a>

</body>
</html>