package queue.dao;

import java.util.ArrayList;

import model.Queue;

public interface QueueDao {
	ArrayList<String> selectOne(String s_name);
	void add(Queue q);
	Queue select(String g_name);
	Queue selectByNames(String s_name, String g_name);
	int countByName(Queue q);			// 
	int count_visiting(String s_name);	// 현재 상점의 대기팀 수
	ArrayList<Queue> selectByS_Name(String s_name);	// 가게에 방문한 고객 리스트 조회(날짜별로)
	void delete(int num);
}
