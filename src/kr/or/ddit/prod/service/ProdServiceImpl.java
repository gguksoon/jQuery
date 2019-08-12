package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.prod.dao.IProdDao;
import kr.or.ddit.prod.dao.ProdDaoImpl;
import kr.or.ddit.prod.vo.ProdVO;

public class ProdServiceImpl implements IProdService {

	private static IProdService service;
	private static IProdDao dao;
	
	private ProdServiceImpl() {
		dao = ProdDaoImpl.getInstance();
	}
	
	public static IProdService getInstance() {
		if(service == null) service = new ProdServiceImpl();
		return service;
	}
	
	@Override
	public List<ProdVO> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<ProdVO> selectLgu(String prod_lgu) {
		return dao.selectLgu(prod_lgu);
	}

	@Override
	public ProdVO selectProd(String prod_id) {
		return dao.selectProd(prod_id);
	}

}
