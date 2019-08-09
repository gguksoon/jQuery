package kr.or.ddit.buyer.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.buyer.vo.BuyerVO;
import kr.or.ddit.ibatis.config.SqlMapClientFactory;

public class BuyerDaoImpl implements IBuyerDao {

	private static IBuyerDao dao; // 자신의 싱글톤
	private SqlMapClient client;  // Mapper에 접근하기 위한 객체
	
	public static IBuyerDao getInstance() {
		if(dao == null) dao = new BuyerDaoImpl();
		return dao;
	}
	
	private BuyerDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	@Override
	public List<BuyerVO> selectAll() {
		List<BuyerVO> buyerList = null;
		
		try {
			buyerList = client.queryForList("buyer.selectAll");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return buyerList;
	}
}
