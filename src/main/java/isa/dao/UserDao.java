package isa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import isa.entity.User;

public class UserDao implements DaoI<User> {

	@Override
	public int save(User user) throws SQLException, ClassNotFoundException {
		
		Connection conn = Util.getConnection();
		String query = "Insert Into user (name, phone, email, password, role, active) values (?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, user.getName());
		ps.setString(2, user.getPhone());
		ps.setString(3, user.getEmail());
		ps.setString(4, user.getPassword());
		ps.setString(5, user.getRole());
		ps.setBoolean(6, user.isActive());
		int status = ps.executeUpdate();
		Util.close(null, ps, conn);
		return status;
	}

	@Override
	public int update(int id, User user) throws SQLException, ClassNotFoundException {
		
		Connection conn = Util.getConnection();
		String query = "Update user Set name = ?, phone = ?, email = ?, password = ?, role = ?, active = ? Where id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, user.getName());
		ps.setString(2, user.getPhone());
		ps.setString(3, user.getEmail());
		ps.setString(4, user.getPassword());
		ps.setString(5, user.getRole());
		ps.setBoolean(6, user.isActive());
		ps.setInt(7, id);
		int status = ps.executeUpdate();
		Util.close(null, ps, conn);
		return status;
	}

	@Override
	public int delete(int id) throws SQLException, ClassNotFoundException {
		
		Connection conn = Util.getConnection();
		String query = "Delete From user Where id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, id);
		int status = ps.executeUpdate();
		Util.close(null, ps, conn);
		return status;		
	}

	@Override
	public List<User> list() throws SQLException, ClassNotFoundException {
		
		ArrayList<User> list = new ArrayList<>();
		Connection conn = Util.getConnection();
		String query = "Select * From user";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()) {
			User user = new User();
			user.setId(rs.getInt(1));
			user.setName(rs.getString(2));
			user.setPhone(rs.getString(3));
			user.setEmail(rs.getString(4));
			user.setPassword(rs.getString(5));
			user.setActive(rs.getBoolean(7));			
			
			list.add(user);			
		}
		
		Util.close(null, st, conn);		
		return list;
	}

	@Override
	public User getById(int id) throws SQLException, ClassNotFoundException {
		
		User user = null;
		Connection conn = Util.getConnection();
		String query = "Select * From user Where id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			user = new User();
			user.setId(rs.getInt(1));
			user.setName(rs.getString(2));
			user.setPhone(rs.getString(3));
			user.setEmail(rs.getString(4));
			user.setPassword(rs.getString(5));
			user.setRole(rs.getString(6));
			user.setActive(rs.getBoolean(7));
			break;		
		}
		
		Util.close(null, ps, conn);		
		return user;
	}
	
	public User login(String email, String password) throws ClassNotFoundException, SQLException {
		
		User user = null;
		Connection conn = Util.getConnection();
		String query = "Select * From user Where email = ? And password = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, email);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			user = new User();
			user.setId(rs.getInt(1));
			user.setName(rs.getString(2));
			user.setPhone(rs.getString(3));
			user.setEmail(rs.getString(4));
			user.setPassword(rs.getString(5));
			user.setRole(rs.getString(6));
			user.setActive(rs.getBoolean(7));
			break;		
		}
		
		Util.close(null, ps, conn);		
		return user;		
	}
}
