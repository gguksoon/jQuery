package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.member.vo.MemberVO;

public class MemberDaoImpl implements IMemberDao {

	private static IMemberDao dao;	// 자신의 싱글톤 생성
	private SqlMapClient client;	// Mapper에 접근하기 위한 SqlMapClient객체
		
	public static IMemberDao getInstance() {
		if(dao == null) dao = new MemberDaoImpl();
		return dao;
	}
	
	private MemberDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	@Override
	public List<MemberVO> selectAll(){
		List<MemberVO> memberList = null;
		
		try {
			memberList = client.queryForList("member.selectAll");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return memberList;
	}

}
