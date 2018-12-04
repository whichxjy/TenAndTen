<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LoginSuccess</title>
    </head>
	<body>
		Login Success!
		用户： ${sessionScope.user} <br>
		${requestScope.tip}
		
		<s:iterator value="questions" var='question'>
			question: <s:property value="question"/>
		</s:iterator>
		
	</body>
</html>