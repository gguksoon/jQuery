<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<String> resultList = (List<String>) request.getAttribute("resultList");
%>
	[
<%
	for(int i = 0; i < resultList.size(); i++) {
		String str = resultList.get(i);
		if(i > 0) out.print(",");
%>
		{
			"res" : "<%=str%>"
		}
<%
	}
%>
	]