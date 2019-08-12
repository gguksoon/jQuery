<%@page import="kr.or.ddit.prod.vo.ProdVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%
		ProdVO prodVo = (ProdVO) request.getAttribute("prodVo");
	%>
		{	
			"prod_id" : "<%=prodVo.getProd_id()%>",
			"prod_name" : "<%=prodVo.getProd_name()%>",
			"prod_lgu" : "<%=prodVo.getProd_lgu()%>",
			"prod_buyer" : "<%=prodVo.getProd_buyer()%>",
			"prod_cost" : "<%=prodVo.getProd_cost()%>",
			"prod_price" : "<%=prodVo.getProd_price()%>",
			"prod_outline" : "<%=prodVo.getProd_outline()%>",	
			"prod_sale" : "<%=prodVo.getProd_sale()%>",
			"prod_detail" : "<%=prodVo.getProd_detail()%>"
		}	
