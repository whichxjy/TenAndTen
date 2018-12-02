<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
	<body>
	   <form action="login" method="post">
	      User:<br/><input type="text" name="userName"/><br/>
	      Password:<br/><input type="password" name="userPassword"/><br/>
	      <input type="submit" value="Login"/>		
	   </form>
	   
	   <form action="register" method="post">
	      User:<br/><input type="text" name="userName"/><br/>
	      Password:<br/><input type="password" name="userPassword"/><br/>
	      <input type="submit" value="Register"/>		
	   </form>
	</body>
</html>