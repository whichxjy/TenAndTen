<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result Table</title>
    </head>
	<body>
	
		<s:iterator value="examResult">
			姓名：<s:property value="key"/><br/>
			成绩：<s:property value="value"/><br/>
		</s:iterator>
		
		<a href="manager_home_page.jsp">返回主页</a>
	
	</body>
</html>