package kr.or.ddit.board.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

@WebServlet("/BoardWrite")
public class BoardWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		BoardVO boardVo = new BoardVO();
		
		try {
			BeanUtils.populate(boardVo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		// 클라이언트의 ip얻기
		boardVo.setWip(request.getRemoteAddr());
		
		IBoardService service = BoardServiceImpl.getInstance();
		
		int seq = service.insertBoard(boardVo);
		
		request.setAttribute("seq", seq);
		
		request.getRequestDispatcher("/accordion/write.jsp").forward(request, response);
	}

}
