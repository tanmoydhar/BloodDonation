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

<h1 align="center"> WELCOME </h1>
<h3 align="center"> User Email: <s:property value="#session.email"/> </h3>
<h3 align="center"> User Blood Group: <s:property value="#session.blood"/> </h3>
<br>
<br>
<br>
<s:form action="PostRequest">
<s:textfield label="Proide your request:" key="bloodRequest"></s:textfield>
<s:submit value="Post"></s:submit>
</s:form>



<s:form  action="/logoutUser">

		<s:submit value="logout"></s:submit>

</s:form>


</body>
</html>