<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>题库</title>
    </head>
	<body>
		题目总数：<s:property value="totalNumberOfQuestions"/><br/>
		<s:iterator value="questionItems" var="questionItem" status="status">
			
			<s:property value="#status.count"/>. 题目：<s:property value="#questionItem.question"/><br/>
			答案：<s:property value="#questionItem.rightAnswer"/><br/>
			
			<form action="deleteQuestion?question_id=<s:property value="#questionItem.id"/>" method="post" >
				<input type="submit" value="删除">
			</form>
			
			<br/>
		</s:iterator>	
	</body>
</html>