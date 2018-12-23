<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager Home Page</title>
    </head>
	<body>
		<p>欢迎管理员 <s:property value="#session.manager.name"/></p>
		
		<a href="question_list.jsp">
			<input type="submit" value="查看题库"/>
		</a>
		
		<s:form action="getExamGrades" method="post">
			<input type="submit" value="查看成绩表"/>
		</s:form>
		
		<a href="managerQuit.action">退出</a>
		
					
	</body>
</html>