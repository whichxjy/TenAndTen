<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>题目</title>
    </head>
	<body>
		<s:action name="getQuestionList" executeResult="true"/>
		
		<a href="add_question.jsp">
			<input type="submit" value="添加题目"/>
		</a>
		
		<br/>
			
		<a href="manager_home_page.jsp">返回主页</a>
	</body>

</html>