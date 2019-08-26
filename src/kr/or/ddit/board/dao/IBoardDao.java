package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;

public interface IBoardDao {

	public List<BoardVO> selectAll();
	
	public int insertBoard(BoardVO boardVo);
	
 	public int deleteBoard(int seq) throws SQLException;

 	public int insertReply(ReplyVO vo) throws SQLException;

 	public List<ReplyVO> listReply(int seq) throws SQLException;
 	
 	public int deleteReply(int renum) throws SQLException;
 	
 	public int modifyReply(Map<String, Object> map) throws SQLException;
}
