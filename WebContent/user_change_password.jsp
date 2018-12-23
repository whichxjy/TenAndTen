<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>修改密码</title>
    </head>
	<body>
		 <form action="userChangePassword" method="post">
			旧密码： <input type="password" name="oldPassword"/><br/>
			新密码：<input type="password" name="newPassword"/><br/>
			确认新密码：<input type="password" name="confirmPassword"/><br/>
			<input type="submit" value="修改密码"/>	
	   	</form>
		<a href="user_home_page.jsp">返回主页</a>
	</body>
</html>