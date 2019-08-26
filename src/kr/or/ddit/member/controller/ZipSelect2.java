package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.ZipVO;

@WebServlet("/ZipSelect2")
public class ZipSelect2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		// service 객체 얻기
		IMemberService service = MemberServiceImpl.getInstance();
		
		// 입력한 dong을 전달받는다.
		String sido  = (String) request.getParameter("sido");
		String gugun = (String) request.getParameter("gugun");
		String dong  = (String) request.getParameter("dong");
		Map<String, String> map = new HashMap<String, String>();
		map.put("sido", sido);
		map.put("gugun", gugun);
		map.put("dong", dong);
		
		List<ZipVO> zipList = service.searchZipResult(map);
		
		// 결과값을 request에 저장
		request.setAttribute("zipList", zipList);
		
		// jsp(zipSearch.jsp)로 이동 - json데이터 생성
		request.getRequestDispatcher("/member/zipSearch.jsp").forward(request, response);
	}

}
