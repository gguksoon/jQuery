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
import kr.or.ddit.board.vo.ReplyVO;

 @WebServlet("/ReplyList")
public class ReplyList extends HttpServlet {
	private static final long serialVersionUID = 1L;

 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int seq = Integer.parseInt(request.getParameter("seq"));

 		IBoardService service = BoardServiceImpl.getInstance();

 		List<ReplyVO> list = service.listReply(seq);

 		request.setAttribute("list", list);

 		request.getRequestDispatcher("accordion/replylist.jsp").forward(request, response);
	}

 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

 }