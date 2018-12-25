<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>更改头像</title>
    </head>
	<body>
		<h1>更改头像</h1>
	   	<s:form action="uploadPicture" enctype="multipart/form-data">
		   	<s:file name="profilePic" label="选择图片"/>
			<s:submit value="提交"/>
		</s:form>		
		<br/>
		<s:fielderror/> <br/>
		<a href="user_home_page.jsp">返回主页</a>
	</body>
</html>