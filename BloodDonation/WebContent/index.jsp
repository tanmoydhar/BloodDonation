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

	<s:textfield label="Email" key="email"></s:textfield>
	<s:password label="Password" key="password"></s:password>
	<s:submit value="LOGIN"></s:submit>

</s:form>

<a href="registeration"> Register Here </a>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<h3>---- Search for Doner -----</h3>
<s:form  action="SearchDoner">

	<s:textfield label="Blood Group" key="blood"></s:textfield>
	<s:textfield label="State" key="state"></s:textfield>
	<s:submit value="Search"></s:submit>

</s:form>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<s:form action="FetchRequest">
<s:submit value="View Recent Requests"></s:submit>
</s:form>
<s:if test="noticeBoard != null">
<h3>----- Blood Requests ------</h3>


<s:iterator value="noticeBoard">
   <s:property value="requestId"/><s:property value="email"/>  
<s:property value="request"/>
<br>
</s:iterator>

</s:if>


</body>
</html>