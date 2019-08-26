package kr.or.ddit.member.service;

import java.util.List;
import java.util.Map;

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
	 * @return 존재하면 member객체, 없으면 null
	 */
	public MemberVO checkId(String mem_id);
	
	/**
	 * 우편번호 검색
	 * @param dong
	 * @return
	 */
	public List<ZipVO> searchZip(String dong);
	
	/**
	 * 카테고리 검색: 시/도
	 * @return
	 */
	public List<String> searchZipSido();
	
	/**
	 * 카테고리 검색: 구/군
	 * @param sido
	 * @return
	 */
	public List<String> searchZipGugun(String sido);
	
	/**
	 * 카테고리 검색: 읍/면/동
	 * @param sido
	 * @param gugun
	 * @return
	 */
	public List<String> searchZipDong(String sido, String gugun);
	
	/**
	 * 카테고리 검색 결과 zip list 반환
	 * @param map
	 * @return
	 */
	public List<ZipVO> searchZipResult(Map<String, String> map);
	
	/**
	 * 회원 가입
	 * @param memberVo
	 * @return
	 */
	public int insertMember(MemberVO memberVo);
}
