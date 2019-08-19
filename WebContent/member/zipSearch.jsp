<%@page import="kr.or.ddit.member.vo.ZipVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<ZipVO> zipList = (List<ZipVO>) request.getAttribute("zipList");
%>
	[
<%
	for(int i = 0; i < zipList.size(); i++) {
		ZipVO zipVo = zipList.get(i);
		String bunji = zipVo.getBunji();
		if(bunji == null) bunji = "";
		if(i > 0) out.print(",");
%>
		{
			"zipcode" : "<%=zipVo.getZipcode()%>",
			"addr" : "<%=zipVo.getSido()%> <%=zipVo.getGugun()%> <%=zipVo.getDong()%>",
			"bunji" : "<%=bunji%>"
		}
<%
	}
%>
	]