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
import kr.or.ddit.member.vo.MemberVO;

@WebServlet("/MemberSelect")
public class MemberSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberSelect() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트 요청시 전송되는 데이터를 받아온다. 
		// DB를 이용하는 CRUD처리를 한다. 
		// 처리한 결과를 클라이언트로 응답한다. 
		// 응답타입은 json object배열로 한다.
		
		// Service객체
		IMemberService service = MemberServiceImpl.getInstance();
		
		List<MemberVO> memberList = service.selectAll();
		
		// CRUD의 결과값 memberList를 view페이지로 전송
		// 보내는 방법:
		//	- redirect : 요청 두번, 클라이언트로(서버 외부)로 이동했다가(request와 response가 소멸)
		//				  다시 서버 내부의 페이지 재요청(데이터 공유 X)
		//	- forward  : 요청 한번, 서버 내부에서 페이지 변경(request와 response를 공유 ==> 데이터 공유 O)
		
		// CRUD의 결과값인 memberList를 request에 저장
		request.setAttribute("memberList", memberList);
		
		request.getRequestDispatcher("/0809/memberList.jsp").forward(request, response);
	}

}
