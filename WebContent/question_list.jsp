<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Question List</title>
    </head>
	<body>
	
		<s:iterator value="questionItems" var="questionItem" status="status">
			题号：<s:property value="#questionItem.id"/><br/>
			题目：<s:property value="#questionItem.question"/><br/>
			答案：<s:property value="#questionItem.rightAnswer"/><br/>
		</s:iterator>
		
		<a href="manager_home_page.jsp">返回主页</a>
	
	</body>
</html>