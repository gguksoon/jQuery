package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

@WebServlet("/MemberIdCheck")
public class MemberIdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 입력받은 id값을 전달받는다.
		String inputId = request.getParameter("id");
		
		// service객체
		IMemberService service = MemberServiceImpl.getInstance();
		
		// 메소드 호출 - 결과값: null이거나 기존의 id값
		MemberVO memVo = service.checkId(inputId);
		String resId = null;
		if(memVo != null) resId = memVo.getMem_id(); 
		
		// jsp로 보내서 json데이터 생성
		request.setAttribute("inputId", inputId);
		request.setAttribute("resId", memVo);

		// json데이터 생성2
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("inputId", inputId);
//		map.put("resId", resId);
//		
//		request.setAttribute("map", map);
		
		request.getRequestDispatcher("member/checkId.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
