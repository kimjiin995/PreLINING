package log.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.DBConnect;
import model.Log;
import model.Queue;

public class LogDaoImpl implements LogDao {

	private DBConnect db;
	
	public LogDaoImpl() {
		db = DBConnect.getInstance();
	}
	
	@Override
	public int add(Log l) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into log values(seq_log.nextval,?,?,?,?,?,?)";
		int num = 0;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, l.getS_name());
			pstmt.setString(2, l.getG_name());
			pstmt.setString(3, l.getG_phone());
			pstmt.setInt(4, l.getPnum());
			pstmt.setInt(5, l.getSnum());
			pstmt.setString(6, l.getR_date());
			
			num =  pstmt.executeUpdate();
			return num;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return num;
	}
	
	@Override
	public void add(Queue q) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into log values(seq_log.nextval,?,?,?,?,?,?)";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, q.getS_name());
			pstmt.setString(2, q.getG_name());
			pstmt.setString(3, q.getG_phone());
			pstmt.setInt(4, q.getPnum());
			pstmt.setInt(5, q.getSnum());
			pstmt.setString(6, q.getR_date().toString());
			
			pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Log select(String g_name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql_cnt = "select count(*) from log";
		int cnt = 0;
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql_cnt);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cnt = rs.getInt(1);
			}
			return cnt;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}

	@Override
	public ArrayList<Log> selectByG_Name(String g_name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from log where g_name = ? order by r_date desc ";
		ArrayList<Log> list = new ArrayList<Log>();
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, g_name);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Log l = new Log(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getInt(6),
						rs.getString(7));
				list.add(l);
			}
			return list;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				pstmt.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	
}
