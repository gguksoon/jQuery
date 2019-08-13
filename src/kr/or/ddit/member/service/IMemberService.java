package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public interface IMemberService {

	/**
	 * 전체 Member를 반환
	 * @return List<MemberVO> memberList
	 */
	public List<MemberVO> selectAll();
	
	/**
	 * 아이디 중복검사
	 * @param user_id
	 * @return 존재하면 1, 없으면 0
	 */
	public int checkId(String mem_id);
	
	/**
	 * 우편번호 검색
	 * @param dong
	 * @return
	 */
	public List<ZipVO> searchZip(String dong);
	
	/**
	 * 회원 가입
	 * @param memberVo
	 * @return
	 */
	public int insertMember(MemberVO memberVo);
}
