package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public class MemberServiceImpl implements IMemberService {

	private static IMemberService service;	// 자신의 싱글톤 생성
	private IMemberDao dao;	// dao의 싱글톤 불러오기
		
	public static IMemberService getInstance() {
		if(service == null) service = new MemberServiceImpl();
		return service;
	}
	
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}
	
	@Override
	public List<MemberVO> selectAll(){
		return dao.selectAll();
	}

	@Override
	public MemberVO checkId(String mem_id) {
		return dao.checkId(mem_id);
	}

	@Override
	public List<ZipVO> searchZip(String dong) {
		return dao.searchZip(dong);
	}

	@Override
	public int insertMember(MemberVO memberVo) {
		return dao.insertMember(memberVo);
	}

}
