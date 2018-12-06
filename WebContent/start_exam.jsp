<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Start Exam</title>
    </head>
	<body>
	
		<form action="submitAnswers" method="post">
			<s:iterator value="questions" var='question'  status="status">
				question<s:property value="#status.count"/>: <s:property value="question"/><br/>
				<input type="text" name="answers[${status.index}]"/><br/>
			</s:iterator>
			
			<input type="submit" value="提交答案"/>	
		</form>

		
	</body>
</html>