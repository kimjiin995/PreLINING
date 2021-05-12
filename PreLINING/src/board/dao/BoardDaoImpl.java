package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.DBConnect;
import model.Board;

public class BoardDaoImpl implements BoardDao{

	private DBConnect db;

	public BoardDaoImpl() {
		db = DBConnect.getInstance();
	}

	@Override
	public void insert(Board b) {
		Connection conn = null;
		String sql = "insert into board values"
				+ "(seq_board.nextval,?,?,sysdate,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getG_name());
			pstmt.setString(2, b.getS_name());
			pstmt.setString(3, b.getContent());
			pstmt.setInt(4, b.getScore());
			pstmt.setInt(5, b.getParent());
			pstmt.executeUpdate();
		}catch(SQLException e) {
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
	
	@Override
	public void update(Board b) {
		Connection conn = null;
		String sql = "update board set content=?,score=?, w_date=sysdate where num=?";
		PreparedStatement pstmt = null;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getContent());
			pstmt.setInt(2, b.getScore());
			pstmt.setInt(3, b.getNum());

			pstmt.executeUpdate();			
		}catch(SQLException e) {
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

	@Override
	public void delete(int num) {
		Connection conn = null;
		String sql = "delete from board where num=?";
		PreparedStatement pstmt = null;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);

			pstmt.executeUpdate();
		}catch(SQLException e) {
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
	
	@Override
	public Board select(int num) {
		Connection conn = null;
		String sql = "select * from board where num=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Board b = new Board();
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				b = new Board(rs.getInt("num"), rs.getString("g_name"),
						rs.getString("s_name"), rs.getDate("w_date"),
						rs.getString("content"),rs.getInt("score"),
						rs.getInt("parent"));
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)
					rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return b;
	}

	@Override
	public ArrayList<Board> selectAllByG_name(String g_name) {
		Connection conn = null;
		String sql = "select * from board where g_name=? and parent=0";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Board> list = new ArrayList<Board>();
		Board b = new Board();
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, g_name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				b = new Board(rs.getInt("num"), rs.getString("g_name"),
						rs.getString("s_name"), rs.getDate("w_date"),
						rs.getString("content"), rs.getInt("score"),
						rs.getInt("parent"));
				list.add(b);
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)
					rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public ArrayList<Board> selectAllByS_name(String s_name) {
		Connection conn = null;
		String sql = "select * from board where s_name=? order by w_date desc";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Board> list = new ArrayList<Board>();
		Board b = new Board();
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s_name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				b = new Board(rs.getInt("num"), rs.getString("g_name"),
						rs.getString("s_name"), rs.getDate("w_date"),
						rs.getString("content"), rs.getInt("score"),
						rs.getInt("parent"));
				list.add(b);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)
					rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	
	@Override
	public float selectScoreAvgByS_name(String s_name) {
		Connection conn = null;
		String sql = "select score from board where s_name=? and parent=0";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		float scoreavg=0;
		int cnt=0;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s_name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				scoreavg += rs.getInt("score");
				cnt++;
			}
			scoreavg /= cnt;
			scoreavg = Math.round(scoreavg*10)/(float)10.0;
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)
					rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return scoreavg;
	}
}
