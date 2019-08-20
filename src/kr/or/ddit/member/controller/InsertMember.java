package kr.or.ddit.member.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

@WebServlet("/InsertMember")
public class InsertMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 한글
		
		// 입력한 모든 값을 가져온다.
//		String mem_id    = request.getParameter("mem_id");  
//		String mem_name  = request.getParameter("mem_name");
//		String mem_bir = request.getParameter("mem_bir");
//		String mem_pass  = request.getParameter("mem_pass");
//		String mem_hp    = request.getParameter("mem_hp");
//		String mem_mail  = request.getParameter("mem_mail");
//		String mem_zip   = request.getParameter("mem_zip");
//		String mem_add1  = request.getParameter("mem_add1");
//		String mem_add2  = request.getParameter("mem_add2");
		
		// MemVo에 저장
//		MemberVO memVo = new MemberVO();
//		memVo.setMem_id(mem_id);
//		memVo.setMem_name(mem_name);
//		memVo.setMem_bir(mem_bir);
//		memVo.setMem_pass(mem_pass);
//		memVo.setMem_hp(mem_hp);
//		memVo.setMem_mail(mem_mail);
//		memVo.setMem_zip(mem_zip);
//		memVo.setMem_add1(mem_add1);
//		memVo.setMem_add2(mem_add2);
		
		// 위 내용을 beanutils를 이용하여 함축하기 
		MemberVO memVo = new MemberVO();
		try {
			BeanUtils.populate(memVo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		
		// 서비스객체 얻기
		IMemberService service = MemberServiceImpl.getInstance();
		
		// 메소드 호출 - 파라미터
		int cnt = service.insertMember(memVo); // 성공 1 실패 0
		String result = null;
		if(cnt == 1) 
			result = "1";
			
		// 결과를 request에 저장
		request.setAttribute("result", result);

		// jsp로 이동(insert.jsp)
		request.getRequestDispatcher("member/insert.jsp").forward(request, response);
		
	}

}
