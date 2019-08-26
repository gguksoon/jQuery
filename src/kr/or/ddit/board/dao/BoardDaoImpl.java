package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;
import kr.or.ddit.ibatis.config.SqlMapClientFactory;

public class BoardDaoImpl implements IBoardDao {

	private static IBoardDao dao; // 자신의 싱글톤
	private SqlMapClient client;  // Mapper에 접근하기 위한 객체
	
	public static IBoardDao getInstance() {
		if(dao == null) dao = new BoardDaoImpl();
		return dao;
	}
	
	private BoardDaoImpl() {
		client = SqlMapClientFactory.getSqlMapClient();
	}
	
	@Override
	public List<BoardVO> selectAll() {
		List<BoardVO> boardList = null;
		
		try {
			boardList = client.queryForList("board.selectAll");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return boardList;
	}

	@Override
	public int insertBoard(BoardVO boardVo) {
		int seq = 0;
		
		try {
			seq = (int) client.insert("board.insertBoard", boardVo);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return seq;
	}
	
	@Override
	public int deleteBoard(int seq) throws SQLException {
		return (int) client.delete("board.deleteBoard", seq);
	}

	@Override
	public int insertReply(ReplyVO vo) throws SQLException {
		return (int) client.insert("board.insertReply", vo);
	}

	@Override
	public List<ReplyVO> listReply(int seq) throws SQLException {
		return client.queryForList("board.listReply", seq);
	}

	@Override
	public int deleteReply(int renum) throws SQLException {
		return client.delete("board.deleteReply", renum);
	}

	@Override
	public int modifyReply(Map<String, Object> map) throws SQLException {
		return client.update("board.modifyReply", map);
	}
}
