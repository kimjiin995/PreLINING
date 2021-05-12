package queue.service;

import java.util.ArrayList;

import model.Queue;

public interface QueueService {
	void enQueue(Queue q);		// 대기열 추가
	
	Queue getQueue(String g_name);	// (for log에 기록)
	
	Queue getQueueBySname(String s_name);
	
	int myQueue(Queue q);	// 내 대기 순번 조회
	
	int totalQueueByS_Name(String s_name);			// 전체 대기팀 수 조회
	
	ArrayList<Queue> getByS_Name(String s_name);	// 전체 대기열 리스트 조회
	
	void deQueue(int num);
	
	ArrayList<String> selectOne(String s_name);
}
