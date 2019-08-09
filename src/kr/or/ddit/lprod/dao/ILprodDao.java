package kr.or.ddit.lprod.dao;

import java.util.List;

import kr.or.ddit.lprod.vo.LprodVO;

public interface ILprodDao {

	/**
	 * 전체 Lprod를 반환
	 * @return List<LprodVO> lprodList
	 */
	public List<LprodVO> selectAll();
}
