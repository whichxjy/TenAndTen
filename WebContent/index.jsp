<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>首页</title>
    </head>
	<body>
		<h1>Ten &#38; Ten</h1>
		<s:form action="userLogin" method="post">
	    	用户名：<br/><input type="text" name="user.name"/><br/>
	    	密码：<br/><input type="password" name="user.password"/><br/>
	    	<input type="submit" value="登录"/>		
	    </s:form>
	   
		<a href="user_register.jsp">用户注册</a>
		<a href="manager_login.jsp">管理员登录</a>
 
	</body>
</html>