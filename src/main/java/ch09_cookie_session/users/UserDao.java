package ch09_cookie_session.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserDao {
	public Connection getConnection() {
		Connection conn = null;
		try {
			Context initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/project"); 
			conn = ds.getConnection();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public User getUser(String uid) {
		
		Connection conn = getConnection();
		User user = null;
		String sql = "select * from users where uid=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						LocalDate.parse(rs.getString(5)), rs.getInt(6));
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return user;
	}
	
	public List<User> getUserList() {
		
		Connection conn = getConnection();
		List<User>  list = new ArrayList<User>();
		String sql = "select * from users where isDeleted=0 order by regDate, uid";
		
		try {

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				
				 list.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						LocalDate.parse(rs.getString(5)), rs.getInt(6)));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return list;
	}
	
	public void insertUser(User u) {
		
		Connection conn = getConnection();
		String sql = "insert into users values(?, ?, ?, ?, default, default);";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u.getUid() );
			pstmt.setString(2, u.getPassword());
			pstmt.setString(3, u.getUname());
			pstmt.setString(4, u.getEmail());
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateUser(User u) {
		
		Connection conn = getConnection();
		String sql = "update users set uname=?, email=?, regDate=?, where uid=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u.getUname());
			pstmt.setString(2, u.getEmail());
			pstmt.setString(3, u.getRegDate().toString());
			pstmt.setString(4, u.getUid() );
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateUserWithoutPassword(User u) {
		
		Connection conn = getConnection();
		String sql = "update users set uname=?, email=? where uid=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, u.getUname());
			pstmt.setString(2, u.getEmail());
			pstmt.setString(3, u.getUid() );
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void deleteUser(String uid) {
		Connection conn = getConnection();
		String sql = "update users set isDeleted=1 where uid=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
