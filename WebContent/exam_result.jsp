<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>result</title>
    </head>
	<body>
		成绩：<s:property value="score"/><br/>
		正确答案:：<br/>
		<s:iterator value="right_answers" var='right_answer'  status="status">
				question<s:property value="status.count"/>:<br/>
				<s:property value="right_answer"/><br/>
		</s:iterator>
		
	</body>
</html>