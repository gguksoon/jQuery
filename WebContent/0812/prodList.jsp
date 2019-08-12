<%@page import="kr.or.ddit.prod.vo.ProdVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
[
	<%
		List<ProdVO> prodList = (List<ProdVO>) request.getAttribute("prodList");
		for(int i = 0; i < prodList.size(); i++) {
			if(i > 0) out.print(",");
	%>
		{	
			"prod_id" : "<%=prodList.get(i).getProd_id()%>",
			"prod_name" : "<%=prodList.get(i).getProd_name()%>",
			"prod_lgu" : "<%=prodList.get(i).getProd_lgu()%>",
			"prod_buyer" : "<%=prodList.get(i).getProd_buyer()%>",
			"prod_cost" : "<%=prodList.get(i).getProd_cost()%>",
			"prod_price" : "<%=prodList.get(i).getProd_price()%>",
			"prod_outline" : "<%=prodList.get(i).getProd_outline()%>",	
			"prod_sale" : "<%=prodList.get(i).getProd_sale()%>",
			"prod_detail" : "<%=prodList.get(i).getProd_detail()%>"
		}	
	<%	
		}
	%>
]