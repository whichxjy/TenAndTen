<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>注册</title>
    </head>
	<body>
		<h1>用户注册</h1>
		<s:form action="userRegister" method="post">
			用户名：<input type="text" name="user.name"/><br/>
			密码：<input type="password" name="user.password"/><br/>
	      <input type="submit" value="注册"/>
	   </s:form>
	   <a href="index.jsp">返回首页</a>
	</body>
</html>