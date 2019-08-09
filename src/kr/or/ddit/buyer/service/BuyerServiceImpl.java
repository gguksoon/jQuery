package kr.or.ddit.buyer.service;

import java.util.List;

import kr.or.ddit.buyer.dao.BuyerDaoImpl;
import kr.or.ddit.buyer.dao.IBuyerDao;
import kr.or.ddit.buyer.vo.BuyerVO;

public class BuyerServiceImpl implements IBuyerService {

	private static IBuyerService service;
	private IBuyerDao dao;
	
	public static IBuyerService getInstance() {
		if(service == null) service = new BuyerServiceImpl();
		return service;
	}
	
	private BuyerServiceImpl() {
		dao = BuyerDaoImpl.getInstance();
	}
	
	@Override
	public List<BuyerVO> selectAll() {
		return dao.selectAll();
	}
	
}
