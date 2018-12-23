<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
	<body>
		<h1>主页</h1>
		<img src="<s:property value="#session.user.profilePicPath"/>"  height=50px width=50px/>
		<a href="user_change_profile.jsp">更改头像</a>
		名字：<s:property value="#session.user.name"/> <br/>
		<form action="startExam" method="post">
	   		<input type="submit" value="进入考试页面"/>		
		</form>
		
		<form action="queryGrade" method="post">
	   		<input type="submit" value="查询成绩"/>		
		</form>
		
		<a href="user_change_password.jsp">
			<input type="button" value="修改密码"/>		
		</a>
	</body>
</html>