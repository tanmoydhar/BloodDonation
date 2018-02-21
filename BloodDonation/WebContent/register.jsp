<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="/struts-tags" prefix="s" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<s:form action="register">  
	<s:textfield key="name" label="UserName"></s:textfield>  
	<s:password key="password" label="Password"></s:password>  
	<s:textfield key="email" label="Email"></s:textfield>  
	<s:radio list="{'male','female'}" key="gender"></s:radio>  
	<s:select label="Blood Group"
        key="blood"
        headerKey="-1" headerValue="Select Month"
        list="#{'01':'A+', '02':'B+' , '03':'AB+' , '04':'O+' , '05':'Bombay Blood'}"
        value="selectedMonth"
        required="true"
	 />
  	<s:submit value="register"></s:submit> 
</s:form>
</body>
</html>