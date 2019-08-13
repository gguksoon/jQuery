<%@page import="kr.or.ddit.prod.vo.ProdVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
		List<ProdVO> prodList = (List<ProdVO>) request.getAttribute("prodList");
		if(prodList.size() == 0) {
	%>
		{
			"flag" : "false"
		}
	
	<%		
		}
		else {
	%>
	
[
	<%

		for(int i = 0; i < prodList.size(); i++) {
			if(i > 0) out.print(",");
	%>
			{	
				"prod_id" : "<%=prodList.get(i).getProd_id()%>",
				"prod_name" : "<%=prodList.get(i).getProd_name()%>"
			}	
	<%	
		}
	%>
]
	<%
		}
	%>