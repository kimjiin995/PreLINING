package board.dao;


import java.util.ArrayList;

import model.Board;

public interface BoardDao {
	void insert(Board b);
	void update(Board b);
	void delete(int num);
	Board select(int num);
	ArrayList<Board> selectAllByG_name(String g_name);
	ArrayList<Board> selectAllByS_name(String s_name);
	float selectScoreAvgByS_name(String s_name);
}
