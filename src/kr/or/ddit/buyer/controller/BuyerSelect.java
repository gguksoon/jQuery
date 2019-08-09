package kr.or.ddit.buyer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.buyer.service.BuyerServiceImpl;
import kr.or.ddit.buyer.service.IBuyerService;
import kr.or.ddit.buyer.vo.BuyerVO;

@WebServlet("/BuyerSelect")
public class BuyerSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IBuyerService service = BuyerServiceImpl.getInstance();
		
		List<BuyerVO> buyerList = service.selectAll();
		
		request.setAttribute("buyerList", buyerList);
		request.getRequestDispatcher("/0809/buyerList.jsp").forward(request, response);
	}

}
