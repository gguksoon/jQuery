package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

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

	@Override
	public MemberVO checkId(String mem_id) {
		MemberVO memberVo = null;
		
		try {
			memberVo = (MemberVO)client.queryForObject("member.checkId", mem_id);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return memberVo;
	}

	@Override
	public List<ZipVO> searchZip(String dong) {
		List<ZipVO> zipList = null;
		
		try {
			zipList = (List<ZipVO>) client.queryForList("member.searchZip", dong);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return zipList;
	}

	@Override
	public List<String> searchZipSido() {
		List<String> sidoList = null;
		
		try {
			sidoList = (List<String>) client.queryForList("member.searchZipSido");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return sidoList;
	}

	@Override
	public List<String> searchZipGugun(String sido) {
		List<String> gugunList = null;
		
		try {
			gugunList = (List<String>) client.queryForList("member.searchZipGugun", sido);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return gugunList;
	}

	@Override
	public List<String> searchZipDong(String sido, String gugun) {
		List<String> dongList = null;
		Map<String, String> map = new HashMap<String, String>();
		map.put("sido", sido);
		map.put("gugun", gugun);
		
		try {
			dongList = (List<String>) client.queryForList("member.searchZipDong", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dongList;
	}
	
	@Override
	public List<ZipVO> searchZipResult(Map<String, String> map) {
		List<ZipVO> zipList = null;
		
		try {
			zipList = (List<ZipVO>) client.queryForList("member.searchZipResult", map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return zipList;
	}
	
	@Override
	public int insertMember(MemberVO memberVo) {
		int cnt = 0;
		
		try {
			Object obj = client.insert("member.insertMember", memberVo);
			if(obj == null) cnt = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return cnt;
	}
}
