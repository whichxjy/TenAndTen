<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
	<body>
	   	<s:form action="uploadPicture" enctype="multipart/form-data">
		   	<s:file name="profilePic" label="选择文件"/> <br/>
		   	<input type="submit" value="提交"/>	
		</s:form>
		
		<br/>
		<s:fielderror/>
	</body>
</html>