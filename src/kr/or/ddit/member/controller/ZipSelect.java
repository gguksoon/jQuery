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

@WebServlet("/ZipSelect")
public class ZipSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// service 객체 얻기
		IMemberService service = MemberServiceImpl.getInstance();
		
		// 입력한 dong을 전달받는다.
		String sido  = (String) request.getParameter("sido");
		String gugun = (String) request.getParameter("gugun");
		
		List<String> resultList = null;
		if(sido == null && gugun == null) {
			resultList = service.searchZipSido();
		} else if(sido != null && gugun == null) {
			resultList = service.searchZipGugun(sido);
		} else if(sido != null && gugun != null) {
			 resultList = service.searchZipDong(sido, gugun);
		}
		
		// 결과값을 request에 저장
		request.setAttribute("resultList", resultList);
		
		// jsp(zipSearch.jsp)로 이동 - json데이터 생성
		request.getRequestDispatcher("/member/zipSearch2.jsp").forward(request, response);
	}

}
