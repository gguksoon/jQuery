<%@page import="kr.or.ddit.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
[
	<%
		List<BoardVO> boardList = (List<BoardVO>)request.getAttribute("boardList");
		for(int i = 0; i < boardList.size(); i++) {
			BoardVO boardVo = boardList.get(i);
			if(i > 0) out.print(",");
	%>			
			{
				"seq" : "<%=boardVo.getSeq() %>",
				"subject" : "<%=boardVo.getSubject() %>",
				"writer" : "<%=boardVo.getWriter() %>",
				"mail" : "<%=boardVo.getMail() %>",
				"password" : "<%=boardVo.getPassword() %>",
				"content" : "<%=boardVo.getContent().replaceAll("\r", "").replaceAll("\n", "<br>") %>",
				"hit" : "<%=boardVo.getHit() %>",
				"wip" : "<%=boardVo.getWip() %>",
				"wdate" : "<%=boardVo.getWdate() %>"
			}		
	<%	
		}
	%>
]
