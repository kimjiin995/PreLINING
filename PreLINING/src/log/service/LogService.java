package log.service;

import java.util.ArrayList;

import model.Log;
import model.Queue;

public interface LogService {
	int write(Log l);			// 대기열 추가
	void addLog(Queue q);
	Log getLog(String g_name);	// (for log에 기록)
	int countLog();
	ArrayList<Log> getByG_Name(String g_name);	// 내 방문 리스트 조회
	void deleteLog(int num);
	void deleteLogAll();
}
