package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;

public interface IBoardService {
	
	public List<BoardVO> selectAll();
	
	public int insertBoard(BoardVO boardVo);
	
	public int deleteBoard(int seq);

 	public int insertReply(ReplyVO vo);

 	public List<ReplyVO> listReply(int seq);
 	
 	public int deleteReply(int renum);
 	
 	public int modifyReply(Map<String, Object> map);
}
