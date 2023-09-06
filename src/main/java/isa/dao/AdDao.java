package isa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import isa.entity.Ad;

public class AdDao implements DaoI<Ad> {

	@Override
	public int save(Ad ad) throws SQLException, ClassNotFoundException {
		
		Connection conn = Util.getConnection();
		String query = "Insert Into ad (user_id, category_id, date, title, description, price, active) values (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, ad.getUserId());
		ps.setInt(2, ad.getCategoryId());
		ps.setDate(3, ad.getDate());
		ps.setString(4, ad.getTitle());
		ps.setString(5, ad.getDescription());
		ps.setDouble(6, ad.getPrice());
		ps.setBoolean(7, ad.isActive());
		int status = ps.executeUpdate();
		Util.close(null, ps, conn);
		return status;
	}

	@Override
	public int update(int id, Ad ad) throws SQLException, ClassNotFoundException {
		
		Connection conn = Util.getConnection();
		//String query = "Update ad Set user_id = ?, category_id = ?, date = ?, title = ?, description = ?, price = ?, active = ? Where id = ?";
		String query = "Update ad Set user_id = ?, date = ?, title = ?, description = ?, price = ? Where id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, ad.getUserId());
		//ps.setInt(2, ad.getCategoryId());
		ps.setDate(2, ad.getDate());
		ps.setString(3, ad.getTitle());
		ps.setString(4, ad.getDescription());
		ps.setDouble(5, ad.getPrice());
		//ps.setBoolean(7, ad.isActive());
		ps.setInt(6, ad.getId());
		int status = ps.executeUpdate();
		Util.close(null, ps, conn);
		return status;
	}

	@Override
	public int delete(int id) throws SQLException, ClassNotFoundException {
		
		Connection conn = Util.getConnection();
		String query = "Delete From ad Where id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, id);
		int status = ps.executeUpdate();
		Util.close(null, ps, conn);
		return status;		
	}

	@Override
	public List<Ad> list() throws SQLException, ClassNotFoundException {
		
		ArrayList<Ad> list = new ArrayList<>();
		Connection conn = Util.getConnection();
		String query = "Select * From ad Order By date Desc";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()) {
			Ad ad = new Ad();
			ad.setId(rs.getInt(1));
			ad.setUserId(rs.getInt(2));	
			ad.setCategoryId(rs.getInt(3));
			ad.setDate(rs.getDate(4));
			ad.setTitle(rs.getString(5));
			ad.setDescription(rs.getString(6));
			ad.setPrice(rs.getDouble(7));
			ad.setActive(rs.getBoolean(8));			
			list.add(ad);			
		}
		
		Util.close(null, st, conn);		
		return list;
	}
	
	public List<Ad> search(String keyWord) throws SQLException, ClassNotFoundException {
		
		ArrayList<Ad> list = new ArrayList<>();
		Connection conn = Util.getConnection();
		String query = "Select * From ad Where title Like " + "%" + keyWord + "%";
		PreparedStatement ps = conn.prepareStatement(query);
		//ps.setString(1, "%" + keyWord + "%");
		ResultSet rs = ps.executeQuery(query);
		
		while(rs.next()) {
			Ad ad = new Ad();
			ad.setId(rs.getInt(1));
			ad.setUserId(rs.getInt(2));	
			ad.setCategoryId(rs.getInt(3));
			ad.setDate(rs.getDate(4));
			ad.setTitle(rs.getString(5));
			ad.setDescription(rs.getString(6));
			ad.setPrice(rs.getDouble(7));
			ad.setActive(rs.getBoolean(8));			
			list.add(ad);			
		}
		
		Util.close(null, ps, conn);		
		return list;
	}

	@Override
	public Ad getById(int id) throws SQLException, ClassNotFoundException {
		
		Ad ad = null;
		Connection conn = Util.getConnection();
		String query = "Select * From ad Where id = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			ad = new Ad();
			ad.setId(id);
			ad.setUserId(rs.getInt(2));	
			ad.setCategoryId(rs.getInt(3));
			ad.setDate(rs.getDate(4));
			ad.setTitle(rs.getString(5));
			ad.setDescription(rs.getString(6));
			ad.setPrice(rs.getDouble(7));
			ad.setActive(rs.getBoolean(8));
			break;		
		}
		
		Util.close(null, ps, conn);		
		return ad;
	}}
