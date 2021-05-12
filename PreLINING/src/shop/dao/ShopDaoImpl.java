package shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.DBConnect;
import model.Shop;

public class ShopDaoImpl implements ShopDao{
	
	private DBConnect db;
	
	public ShopDaoImpl() {
		db = DBConnect.getInstance();
	}

	@Override
	public void insert(Shop s) { //가게등록
		Connection conn = null;
		String sql = "insert into shop values"
				+ "(seq_shop.nextval,?,?,?,?,?,?,?,?,0,0,0)";
		PreparedStatement pstmt = null;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s.getId());
			pstmt.setString(2, s.getName());
			pstmt.setString(3, s.getMenu());
			pstmt.setString(4, s.getLocation());
			pstmt.setString(5, s.getPhone());
			pstmt.setString(6, s.getImg());
			pstmt.setString(7, s.getContent());
			pstmt.setString(8, s.getCategory());
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
	public Shop select(int num) { //num=?인 Shop객체 하나 조회
		Connection conn = null;
		String sql = "select * from shop where num=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Shop s = new Shop();
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				s = new Shop(rs.getInt("num"), rs.getString("id"), rs.getString("name"),
						rs.getString("menu"), rs.getString("location"),
						rs.getString("phone"), rs.getString("img"),
						rs.getString("content"), rs.getString("category"),
						rs.getInt("queue_num"), rs.getInt("viewcount"),
						rs.getFloat("scoreavg"));
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
		return s;
	}
	
	@Override
	public Shop select(String id) {
		Connection conn = null;
		String sql = "select * from shop where id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Shop s = new Shop();
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				s = new Shop(rs.getInt("num"), rs.getString("id"), rs.getString("name"),
						rs.getString("menu"), rs.getString("location"),
						rs.getString("phone"), rs.getString("img"),
						rs.getString("content"), rs.getString("category"),
						rs.getInt("queue_num"), rs.getInt("viewcount"),
						rs.getFloat("scoreavg"));
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
		return s;
	}
	
	@Override
	public Shop selectByName(String s_name) {
		Connection conn = null;
		String sql = "select * from shop where name=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Shop s = new Shop();
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s_name);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				s = new Shop(rs.getInt("num"), rs.getString("id"), rs.getString("name"),
						rs.getString("menu"), rs.getString("location"),
						rs.getString("phone"), rs.getString("img"),
						rs.getString("content"), rs.getString("category"),
						rs.getInt("queue_num"), rs.getInt("viewcount"),
						rs.getFloat("scoreavg"));
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
		return s;
	}

	@Override
	public void update(Shop s) { //가게 정보 수정
		Connection conn = null;
		String sql = "update shop set menu=?, location=?, phone=?,"
						+"content=?, category=? where num=?";
		PreparedStatement pstmt = null;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, s.getMenu());
			pstmt.setString(2, s.getLocation());
			pstmt.setString(3, s.getPhone());
			pstmt.setString(4, s.getContent());
			pstmt.setString(5, s.getCategory());
			pstmt.setInt(6, s.getNum());
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
	public void delete(int num) { //가게 삭제
		Connection conn = null;
		String sql = "delete from shop where num=?";
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
	public ArrayList<Shop> selectAll() { //모든 가게 num을 order로 ArrayList로 조회.(아직 사용한 적이 없어서 지울까 고민중)
		Connection conn = null;
		String sql = "select * from shop order by num";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Shop> list = new ArrayList<Shop>();
		Shop s = new Shop();
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				s = new Shop(rs.getInt("num"), rs.getString("id"), rs.getString("name"),
						rs.getString("menu"), rs.getString("location"),
						rs.getString("phone"), rs.getString("img"),
						rs.getString("content"), rs.getString("category"),
						rs.getInt("queue_num"), rs.getInt("viewcount"),
						rs.getFloat("scoreavg"));
				list.add(s);
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
	public ArrayList<Shop> selectAllBySearch(String search) { //검색을 통해 얻은 Shop들을 ArrayList로 저장. "%"+search+"%"를 통해 그 단어 포함된 모든 가게 조회 가능
		Connection conn = null;
		String sql = "select * from shop where name like ? or menu like ? "
				+ "or content like ? or category like ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Shop> list = new ArrayList<Shop>();
		Shop s = new Shop();
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+search+"%");
			pstmt.setString(2, "%"+search+"%");
			pstmt.setString(3, "%"+search+"%");
			pstmt.setString(4, "%"+search+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				s = new Shop(rs.getInt("num"), rs.getString("id"), rs.getString("name"),
						rs.getString("menu"), rs.getString("location"),
						rs.getString("phone"), rs.getString("img"),
						rs.getString("content"), rs.getString("category"),
						rs.getInt("queue_num"), rs.getInt("viewcount"),
						rs.getFloat("scoreavg"));
				list.add(s);
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
	public ArrayList<Shop> selectAllByCategory(String category) { //카테고리 이미지 선택 시 실행되는 메서드. 카테고리별로 모인 Shop객체들을 ArrayList로 return한다.
		Connection conn = null;
		String sql = "select * from shop where category like ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Shop> list = new ArrayList<Shop>();
		Shop s = new Shop();
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+category+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				s = new Shop(rs.getInt("num"), rs.getString("id"), rs.getString("name"),
						rs.getString("menu"), rs.getString("location"),
						rs.getString("phone"), rs.getString("img"),
						rs.getString("content"), rs.getString("category"),
						rs.getInt("queue_num"), rs.getInt("viewcount"),
						rs.getFloat("scoreavg"));
				list.add(s);
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
	public ArrayList<Shop> selectAllByQnum() { //오늘의 핫플을 위한 메서드. queue_num desc 순으로 조회하여 대기팀이 가장 많은 가게들이 ArrayList로 return됨
		Connection conn = null;
		String sql = "select * from shop order by queue_num desc";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Shop> list = new ArrayList<Shop>();
		Shop s = new Shop();
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				s = new Shop(rs.getInt("num"), rs.getString("id"), rs.getString("name"),
						rs.getString("menu"), rs.getString("location"),
						rs.getString("phone"), rs.getString("img"),
						rs.getString("content"), rs.getString("category"),
						rs.getInt("queue_num"), rs.getInt("viewcount"),
						rs.getFloat("scoreavg"));
				list.add(s);
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
	public ArrayList<Shop> selectAllByscoreavg() { //위 메서드에서 queue_num 대신 scoreavg로 대체된것
		Connection conn = null;
		String sql = "select * from shop order by scoreavg desc";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Shop> list = new ArrayList<Shop>();
		Shop s = new Shop();
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				s = new Shop(rs.getInt("num"), rs.getString("id"), rs.getString("name"),
						rs.getString("menu"), rs.getString("location"),
						rs.getString("phone"), rs.getString("img"),
						rs.getString("content"), rs.getString("category"),
						rs.getInt("queue_num"), rs.getInt("viewcount"),
						rs.getFloat("scoreavg"));
				list.add(s);
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
	public void updateQnum(int queue_num, String name) { //대기팀에 변화가 생길때마다 호출될 메서드. 이걸 통해 최신화 유지
		Connection conn = null;
		String sql = "update shop set queue_num=? where name=?";
		PreparedStatement pstmt = null;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, queue_num);
			pstmt.setString(2, name);
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
	public void updateScore(float scoreavg, String name) { //Board에서 얻은 scoreavg값을 Shop객체에 넣어주는 메서드
		Connection conn = null;
		String sql = "update shop set scoreavg=? where name=?";
		PreparedStatement pstmt = null;
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setFloat(1, scoreavg);
			pstmt.setString(2, name);
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
}
