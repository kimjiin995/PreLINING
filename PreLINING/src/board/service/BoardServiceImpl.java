package board.service;

import java.util.ArrayList;

import board.dao.BoardDao;
import board.dao.BoardDaoImpl;
import model.Board;

public class BoardServiceImpl implements BoardService{
	private BoardDao bdao;
	
	
	public BoardServiceImpl() {
		bdao = new BoardDaoImpl();
	}

	@Override
	public void addBoard(Board b) {
		bdao.insert(b);
		
	}

	@Override
	public void editBoard(Board b) {
		bdao.update(b);
	}

	@Override
	public void delBoard(int num) {
		bdao.delete(num);
	}

	@Override
	public Board getBoard(int num) {
		return bdao.select(num);
	}

	@Override
	public ArrayList<Board> getAllByG_name(String g_name) {
		return bdao.selectAllByG_name(g_name);
	}

	@Override
	public ArrayList<Board> getAllByS_name(String s_name) {
		return bdao.selectAllByS_name(s_name);
	}

	@Override
	public float getAvgScoreByS_name(String s_name) {
		// TODO Auto-generated method stub
		return bdao.selectScoreAvgByS_name(s_name);
	}
	
}
