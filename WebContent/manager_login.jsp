<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>管理员登录</title>
    </head>
	<body>
		<h1>管理员登录</h1>
	   <s:form action="managerLogin" method="post">
	      	用户名：<input type="text" name="manager.name"/><br/>
	      	密码：<input type="password" name="manager.password"/><br/>
	      <input type="submit" value="登录"/>		
	   </s:form>
	   <a href="index.jsp">返回首页</a>
	</body>
</html>