package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.prod.vo.ProdVO;

public interface IProdDao {
	
	/**
	 * 전체 Prod를 반환
	 * @return List<ProdVO> prodList
	 */
	public List<ProdVO> selectAll();
	
	/**
	 * lgu에 해당하는 prod 반환
	 * @param prod_lgu
	 * @return List<ProdVO> prodList
	 */
	public List<ProdVO> selectLgu(String prod_lgu);
	
	/**
	 * id에 해당하는 prod 반환
	 * @param prod_id
	 * @return prodVo
	 */
	public ProdVO selectProd(String prod_id);
}
