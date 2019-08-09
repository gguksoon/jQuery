<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
[
	<%
		List<MemberVO> memberList = (List<MemberVO>)request.getAttribute("memberList");
		for(int i = 0; i < memberList.size(); i++) {
			MemberVO member = memberList.get(i);
			if(i > 0) out.print(", ");
	%>
		<%-- json object --%>
		{
			"name" : "<%= member.getMem_name()%>",
			"id" : "<%= member.getMem_id()%>",
			"addr" : "<%= member.getMem_zip() + " " + member.getMem_add1() + " " + member.getMem_add2()%>",
			"hp" : "<%= member.getMem_hp()%>",
			"birthday" : "<%= member.getMem_bir()%>",
			"mail" : "<%= member.getMem_mail()%>"
		}
	<%	
		} 
	%>
]