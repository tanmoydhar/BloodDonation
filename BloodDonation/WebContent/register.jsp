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

<s:form action="RegisterUser">  
	<s:textfield key="name" label="UserName"></s:textfield>  
	<s:password key="password" label="Password"></s:password>  
	<s:textfield key="email" label="Email"></s:textfield> 
	<s:textfield key="contact" label="Contact no"></s:textfield> 
	<s:radio list="{'male','female'}" key="gender"></s:radio>  
	<s:select label="Blood Group"
        key="blood"
        headerKey="-1" headerValue="Select Blood Group"
        list="#{'A+':'A+', 'B+':'B+' , 'AB+':'AB+' , 'O+':'O+' , 'Bombay Blood':'Bombay Blood'}"
        value="selectedMonth"
        required="true"
	 />
	 <s:textfield key="state" label="State"></s:textfield>
	 <s:radio list="{'show','hide'}" key="show" label="Display info in public"></s:radio>
  	<s:submit value="Register"></s:submit> 
</s:form>
</body>
</html>