<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Question List</title>
    </head>
	<body>
		题目总数：<s:property value="totalNumberOfQuestions"/><br/>
		<s:iterator value="questionItems" var="questionItem" status="status">
			题目：<s:property value="#questionItem.question"/><br/>
			答案：<s:property value="#questionItem.rightAnswer"/><br/>
			
			<form action="deleteQuestion?Flag=<s:property value="#questionItem.id"/>" method="post" >
				<input type="submit" value="删除">
			</form>
		</s:iterator>
		
		<a href="add_question.jsp">
			<input type="submit" value="进入添加题目界面"/>   
		</a>
		
		<a href="manager_home_page.jsp">返回主页</a>
	
	</body>
</html>