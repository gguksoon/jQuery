package kr.or.ddit.lprod.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.lprod.vo.LprodVO;

public class LprodDaoImpl implements ILprodDao {

	private static ILprodDao dao; // 자신의 싱글톤
	private SqlMapClient client;  // Mapper에 접근하기 위한 객체
	
	public static ILprodDao getInstance() {
		if(dao == null) dao = new LprodDaoImpl();
		return dao;
	}
	
	private LprodDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	@Override
	public List<LprodVO> selectAll() {
		List<LprodVO> lprodList = null;
		
		try {
			lprodList = client.queryForList("lprod.selectAll");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lprodList;
	}

}
