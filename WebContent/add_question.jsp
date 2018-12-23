<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>添加题目</title>
    </head>
	<body>
		<p>请输入您要添加的题目</p>
		<s:form action="addQuestion" method="post">
	    	问题：<br/><textarea name="questionItem.question"></textarea><br/>
	    	答案：<br/><input type="text" name="questionItem.rightAnswer"/><br/>
	    	<input type="submit" value="添加"/>		
	    </s:form>
	    <a href="question_list.jsp">返回题库</a>
	</body>
</html>