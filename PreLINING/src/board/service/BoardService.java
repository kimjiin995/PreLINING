package board.service;

import java.util.ArrayList;

import model.Board;

public interface BoardService {
	void addBoard(Board b);
	void editBoard(Board b);
	void delBoard(int num);
	Board getBoard(int num);
	ArrayList<Board> getAllByG_name(String g_name);
	ArrayList<Board> getAllByS_name(String s_name);
	float getAvgScoreByS_name(String s_name);
}
