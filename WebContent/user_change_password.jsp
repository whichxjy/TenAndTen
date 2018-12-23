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
	   
	   		<s:form action="uploadPicture" enctype="multipart/form-data">
		   	<s:file name="profilePicture" label="选择文件"/> <br/>
		   	<input type="submit" value="提交"/>	
		</s:form>
		
				<img src="<s:property value="files"/>"/>
	
	</body>
</html>