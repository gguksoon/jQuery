package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.prod.vo.ProdVO;

@WebServlet("/ProdServlet")
public class ProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prod_lgu = request.getParameter("lprod_gu");
		
		IProdService service = ProdServiceImpl.getInstance();
		List<ProdVO> prodList = service.selectLgu(prod_lgu);
		
		request.setAttribute("prodList", prodList);
		request.getRequestDispatcher("/0812/prodList.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String prod_id = req.getParameter("prod_id");
		
		IProdService service = ProdServiceImpl.getInstance();
		ProdVO prodVo = service.selectProd(prod_id);
		
		req.setAttribute("prodVo", prodVo);
		req.getRequestDispatcher("/0812/prod.jsp").forward(req, resp);
	}
}
