package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.vo.BoardVO;

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

}
