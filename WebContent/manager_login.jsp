<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager Login</title>
    </head>
	<body>
		<h1>管理员登录</h1>
	   <form action="managerLogin" method="post">
	      	用户名<br/><input type="text" name="manager.name"/><br/>
	      	密码：<br/><input type="password" name="manager.password"/><br/>
	      <input type="submit" value="Login"/>		
	   </form>
	</body>
</html>