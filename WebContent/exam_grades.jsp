<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exam Grades</title>
    </head>
	<body>
	
		<s:iterator value="grades" var="grade" status="status">
			ID：<s:property value="#grade.id"/><br/>
			姓名：<s:property value="#grade.userName"/><br/>
			成绩：<s:property value="#grade.score"/><br/>
		</s:iterator>
		
		<a href="manager_home_page.jsp">返回主页</a>
	
	</body>
</html>