package queue.service;

import java.util.ArrayList;

import model.Queue;
import queue.dao.QueueDao;
import queue.dao.QueueDaoImpl;

public class QueueServiceImpl implements QueueService{
	private QueueDao qdao;
	
	public QueueServiceImpl() {
		qdao = new QueueDaoImpl();
	}

	@Override
	public void enQueue(Queue q) {
		qdao.add(q);
	}

	@Override
	public Queue getQueue(String g_name) {
		return qdao.select(g_name);
	}
	
	

	@Override
	public Queue getQueueBySname(String s_name) {
		return qdao.select(s_name);
	}

	@Override
	public int myQueue(Queue q) {
		return qdao.countByName(q);
		
	}

	@Override
	public int totalQueueByS_Name(String s_name) {
		return qdao.count_visiting(s_name);
	}

	@Override
	public ArrayList<Queue> getByS_Name(String s_name) {
		return qdao.selectByS_Name(s_name);
	}

	@Override
	public void deQueue(int num) {
		qdao.delete(num);
	}
	
	@Override
	public ArrayList<String> selectOne(String s_name) {
		return qdao.selectOne(s_name);
	}
	
}
