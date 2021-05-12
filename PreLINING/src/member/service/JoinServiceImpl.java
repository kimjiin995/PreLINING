package member.service;

import member.dao.JoinDaoImpl;
import member.dao.JoinDao;
import model.Member;


public class JoinServiceImpl implements JoinService {

	private JoinDao dao;

	public JoinServiceImpl() {
		this.dao = new JoinDaoImpl();
	}

	public void join(Member m) {
		dao.insert(m);
	}

	public Member getMember(String id) {
		return dao.select(id);
	}

	public void editMember(Member m) {
		dao.update(m);
	}


	public void delMember(String id, String pwd) {
		dao.delete(id,pwd);
	}

}
