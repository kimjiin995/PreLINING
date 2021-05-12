package  member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import conn.DBConnect;
import model.Member;


public class JoinDaoImpl implements JoinDao {
	
	
	private DBConnect db;
	 
	public JoinDaoImpl() {
		db = DBConnect.getInstance();
	}

		
	
	public void insert(Member m) {
		Connection conn = null;

		String sql = "insert into member values(?,?,?,?,?,?,?,0,?)";
		
		PreparedStatement pstmt = null;
		
		try {
			
			conn = db.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPwd());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getNickname());
			pstmt.setString(5, m.getEmail());
			pstmt.setString(6, m.getPhone());
			pstmt.setString(7, m.getAddr());
			pstmt.setInt(8, m.getType());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Member select(String id) {
		Connection conn = null;
		String sql = "select * from member where id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member m = null;
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				m = new Member(rs.getString("id"), rs.getString("pwd"),
							rs.getString("name"), rs.getString("nickname"),
							rs.getString("email"),rs.getString("phone"),
							rs.getString("addr"), rs.getInt("point"),
							rs.getInt("type"));
				rs.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return m;
	}
	
	public void update(Member m) {
		Connection conn = null;
		String sql = "update member set pwd=?, name=?, nickname=?, email=?, addr=?, phone=? where id=?";
		PreparedStatement pstmt = null;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getPwd());
			pstmt.setString(2, m.getName());
			pstmt.setString(3, m.getNickname());
			pstmt.setString(4, m.getEmail());
			pstmt.setString(5, m.getAddr());
			pstmt.setString(6, m.getPhone());
			pstmt.setString(7, m.getId());
			pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void delete(String id, String pwd) {
		// TODO Auto-generated method stub
		Connection conn = null;
		String sql = "delete member where id=? and pwd=?";
		PreparedStatement pstmt = null;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.executeUpdate();
		} catch (SQLException e) {
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	

}
