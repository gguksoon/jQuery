<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
	%>
	<h3><%=name %>씨 (전화번호 : <%=tel %> )안녕하세요. AJax를 공부합니다.</h3>
</body>
</html>