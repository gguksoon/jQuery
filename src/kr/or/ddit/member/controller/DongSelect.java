package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.ZipVO;

@WebServlet("/DongSelect")
public class DongSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post방식일 때 먼저 인코딩해줘야함(get은 서버의 server.xml에서)
		request.setCharacterEncoding("UTF-8");
		
		// 입력한 dong을 전달받는다.
		String dong = (String) request.getParameter("dong");
		
		// service 객체 얻기
		IMemberService service = MemberServiceImpl.getInstance();
		
		// 메소드 호출 - 결과값 받기 - List
		List<ZipVO> zipList = service.searchZip(dong);
		
		// 결과값을 request에 저장
		request.setAttribute("zipList", zipList);
		
		// jsp(zipSearch.jsp)로 이동 - json데이터 생성
		request.getRequestDispatcher("/member/zipSearch.jsp").forward(request, response);
	}

}
