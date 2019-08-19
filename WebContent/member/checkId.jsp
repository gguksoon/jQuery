<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String resId = (String) request.getAttribute("resId");
	String inputId = (String) request.getAttribute("inputId");

	if(resId == null) { // 저장된 이름이 없다 - 사용가능
%>
		{
			"res" : "<%=inputId %>는(은) 사용 가능"
		}
<%
	} else { // 저장된 이름이 있다 - 사용불가
%>
		{
			"res" : "<%=inputId %>는(은) 사용 불가능"
		}
<%
	}
%>