<%@page import="kr.or.ddit.lprod.vo.LprodVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
[
	<%
		List<LprodVO> lprodList = (List<LprodVO>)request.getAttribute("lprodList");
		for(int i = 0; i < lprodList.size(); i++) {
			LprodVO lprod = lprodList.get(i);
			if(i > 0) out.print(", ");
	%>
			{
				"id" : "<%= lprod.getLprod_id()%>",
				"gu" : "<%= lprod.getLprod_gu()%>",
				"nm" : "<%= lprod.getLprod_nm()%>"
			}
	<%	
		} 
	%>
]