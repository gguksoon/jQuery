<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String result = (String) request.getAttribute("result");
	
	if(result == null) {
%>
		{
			"res" : "저장실패"
		}
<%
	} else {
%>
		{
			"res" : "저장성공"
		}
<%
	}
%>