<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Grade</title>
    </head>
	<body>
		<h1>成绩查询</h1>
		用户名：<s:property value="#session.user.name"/> <br/>
		成绩：<s:property value="score"/> <br/>
		<a href="user_home_page.jsp">返回主页</a>
	</body>
</html>