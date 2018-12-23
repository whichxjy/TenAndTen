<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>开始考试</title>
    </head>
	<body>
		<h1>开始考试</h1>
		<p>用户名：<s:property value="#session.user.name"/></p>
		
		<s:form action="submitAnswers" method="post">
			<s:iterator value="questionItems" var='questionItem' status="status">
				<s:property value="#status.count"/>. <s:property value="#questionItem.question"/><br/>
				<input type="text" name="userAnswers[${status.index}]" size="25"/><br/>
			</s:iterator>
			
			<input type="submit" value="提交答案"/>
		</s:form>
		
		<a href="user_home_page.jsp">返回主页</a>
	</body>
</html>