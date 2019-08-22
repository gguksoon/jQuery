package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

@WebServlet("/BoardSelect")
public class BoardSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IBoardService service = BoardServiceImpl.getInstance();
		
		List<BoardVO> boardList = service.selectAll();
		
		request.setAttribute("boardList", boardList);
		
		request.getRequestDispatcher("accordion/list.jsp").forward(request, response);
	}

}
