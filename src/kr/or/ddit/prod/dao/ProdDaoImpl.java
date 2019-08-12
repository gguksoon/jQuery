package kr.or.ddit.prod.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.prod.vo.ProdVO;

public class ProdDaoImpl implements IProdDao{

	private SqlMapClient client; // sql 연결
	private static IProdDao dao; // 자신의 싱글톤
	
	private ProdDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	public static IProdDao getInstance() {
		if(dao == null) dao = new ProdDaoImpl();
		return dao;
	}
	
	@Override
	public List<ProdVO> selectAll() {
		List<ProdVO> prodList = null;
		
		try {
			prodList = client.queryForList("prod.selectAll");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return prodList;
	}

	@Override
	public List<ProdVO> selectLgu(String prod_lgu) {
		List<ProdVO> prodList = null;
		
		try {
			prodList = client.queryForList("prod.selectLgu", prod_lgu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return prodList;
	}

	@Override
	public ProdVO selectProd(String prod_id) {
		ProdVO prodVo = null;
		
		try {
			prodVo = (ProdVO) client.queryForObject("prod.selectProd", prod_id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return prodVo;
	}

}
