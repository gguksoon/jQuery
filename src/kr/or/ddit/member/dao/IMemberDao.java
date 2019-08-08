package kr.or.ddit.member.dao;

import java.util.List;

import kr.or.ddit.member.vo.MemberVO;

public interface IMemberDao {
	
	/**
	 * 전체 Member를 반환
	 * @return List<MemberVO> memberList
	 */
	public List<MemberVO> selectAll();
}
