package isa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import isa.entity.Category;

public class CategoryDao implements DaoI<Category> {

	@Override
	public int save(Category category) throws SQLException, ClassNotFoundException {
		
		Connection conn = Util.getConnection();
		String query = "Insert Into category (name) values (?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, category.getName());
		int status = ps.executeUpdate();
		Util.close(null, ps, conn);
		return status;
	}

	@Override
	public int update(int id, Category category) throws SQLException, ClassNotFoundException {
		
		Connection conn = Util.getConnection();
		String query = "Update category Set name = ? Where id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, category.getName());
		ps.setInt(2, id);
		int status = ps.executeUpdate();
		Util.close(null, ps, conn);
		return status;
	}

	@Override
	public int delete(int id) throws SQLException, ClassNotFoundException {
		
		Connection conn = Util.getConnection();
		String query = "Delete From category Where id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, id);
		int status = ps.executeUpdate();
		Util.close(null, ps, conn);
		return status;		
	}

	@Override
	public List<Category> list() throws SQLException, ClassNotFoundException {
		
		ArrayList<Category> list = new ArrayList<Category>();
		Connection conn = Util.getConnection();
		String query = "Select * From category";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()) {
			Category category = new Category();
			category.setId(rs.getInt(1));
			category.setName(rs.getString(2));
			list.add(category);			
		}
		
		Util.close(null, st, conn);		
		return list;
	}

	@Override
	public Category getById(int id) throws SQLException, ClassNotFoundException {
		
		Category category = null;
		Connection conn = Util.getConnection();
		String query = "Select * From category Where id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			category = new Category();
			category.setId(rs.getInt(1));
			category.setName(rs.getString(2));
			break;		
		}
		
		Util.close(null, ps, conn);		
		return category;
	}
}
