package kr.or.ddit.buyer.service;

import java.util.List;

import kr.or.ddit.buyer.vo.BuyerVO;

public interface IBuyerService {

	/**
	 * 전체 Buyer를 반환
	 * @return List<BuyerVO> buyerList
	 */
	public List<BuyerVO> selectAll();
}
