<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
	<body>
		名字：<s:property value="#session.user.name"/> <br/>
		Login Success! <br/>
		<form action="startExam" method="post">
	   		<input type="submit" value="进入考试页面"/>		
		</form>
		
		<form action="queryGrade" method="post">
	   		<input type="submit" value="查询成绩"/>		
		</form>
	</body>
</html>