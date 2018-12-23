<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>主页</title>
    </head>
	<body>
		<h1>主页</h1>
		<p>欢迎  <s:property value="#session.user.name"/></p>
		<img src="<s:property value="#session.user.profilePicPath"/>" height=50px width=50px/> <br/>
		<a href="user_change_profile.jsp">更改头像</a>
		<a href="user_change_password.jsp">修改密码</a>
		<a href="userQuit.action">退出</a>
		
		<form action="startExam" method="post">
	   		<input type="submit" value="开始考试"/>	
		</form>
		
		<form action="queryGrade" method="post">
	   		<input type="submit" value="查询成绩"/>		
		</form>
	
	</body>
</html>