package log.service;

import java.util.ArrayList;

import model.Log;
import model.Queue;
import log.dao.LogDao;
import log.dao.LogDaoImpl;

public class LogServiceImpl implements LogService{

	private LogDao ldao;
	
	public LogServiceImpl() {
		ldao = new LogDaoImpl();
	}
	
	@Override
	public int write(Log l) {
		return ldao.add(l);
	}
	
	@Override
	public void addLog(Queue q) {
		ldao.add(q);
	}

	@Override
	public Log getLog(String g_name) {
		return ldao.select(g_name);
	}

	@Override
	public int countLog() {
		return ldao.count();
	}

	@Override
	public ArrayList<Log> getByG_Name(String g_name) {
		return ldao.selectByG_Name(g_name);
	}

	@Override
	public void deleteLog(int num) {
		ldao.delete(num);
	}

	@Override
	public void deleteLogAll() {
		ldao.deleteAll();
	}
	
}
