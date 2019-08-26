package kr.or.ddit.board.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;

public class BoardServiceImpl implements IBoardService {

	private static IBoardService service;
	private IBoardDao dao;
	
	public static IBoardService getInstance() {
		if(service == null) service = new BoardServiceImpl();
		return service;
	}
	
	private BoardServiceImpl() {
		dao = BoardDaoImpl.getInstance();
	}
	
	@Override
	public List<BoardVO> selectAll() {
		return dao.selectAll();
	}

	@Override
	public int insertBoard(BoardVO boardVo) {
		return dao.insertBoard(boardVo);
	}
	
	@Override
	public int deleteBoard(int seq) {
		int seq1 = 0;

 		try {
			seq1 = dao.deleteBoard(seq);
		} catch (SQLException e) {
			e.printStackTrace();
		}

 		return seq1;
	}

 	@Override
	public int insertReply(ReplyVO vo) {
		int seq = 0;

 		try {
			seq = dao.insertReply(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}

 		return seq;
	}

 	@Override
	public List<ReplyVO> listReply(int seq) {
		List<ReplyVO> list = null;

 		try {
			list = dao.listReply(seq);
		} catch (SQLException e) {
			e.printStackTrace();
		}

 		return list;
	}

	@Override
	public int deleteReply(int renum) {
		int res = 0;
		
		try {
			res = dao.deleteReply(renum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public int modifyReply(Map<String, Object> map) {
		int res = 0;
		
		try {
			res = dao.modifyReply(map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}
}
