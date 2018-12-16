<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager Home Page</title>
    </head>
	<body>
		管理员名字：<s:property value="#session.manager.name"/> <br/>
		Login Success! <br/>
		<s:property value="tip"/>
		
		<s:form action="getQuestionList" method="post">
			<input type="submit" value="进入题库界面"/>
		</s:form>
		
		<s:form action="getExamGrades" method="post">
			<input type="submit" value="进入成绩表界面"/>
		</s:form>
					
	</body>
</html>