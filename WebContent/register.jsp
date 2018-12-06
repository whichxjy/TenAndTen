<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
	<body>
		<form action="register" method="post">
	      User:<br/><input type="text" name="user.name"/><br/>
	      Password:<br/><input type="password" name="user.password"/><br/>
	      <input type="submit" value="注册"/>	
	   </form>
	</body>
</html>