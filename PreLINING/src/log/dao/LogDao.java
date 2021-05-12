package log.dao;

import java.util.ArrayList;

import model.Log;
import model.Queue;

public interface LogDao {
	int add(Log l);
	void add(Queue q);
	Log select(String g_name);
	int count();
	ArrayList<Log> selectByG_Name(String g_name);
	void delete(int num);
	void deleteAll();
}
