<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Start Exam</title>
    </head>
	<body>
		名字：<s:property value="#session.user.name"/> <br/>
		
		<form action="submitAnswers" method="post">
			<s:iterator value="questionItems" var='questionItem' status="status">
				question<s:property value="#status.count"/>: <s:property value="questionItem.question"/><br/>
				<input type="text" name="userAnswers[${status.index}]"/><br/>
			</s:iterator>
			
			<input type="submit" value="提交答案"/>
		</form>
		
		<a href="user_home_page.jsp">返回主页</a>

		
	</body>
</html>