<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager Home Page</title>
    </head>
	<body>
			Login Success! <br/>
			<s:property value="tip"/>
			
			<a href="add_question.jsp">
				<input type="submit" value="进入添加题目界面"/>   
			</a>
					
	</body>
</html>