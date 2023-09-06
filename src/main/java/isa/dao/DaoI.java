package isa.dao;

import java.sql.SQLException;
import java.util.List;

public interface DaoI<T> {
	
	public int save(T t) throws SQLException, ClassNotFoundException;
	public int update(int id, T t) throws SQLException, ClassNotFoundException;
	public int delete(int id) throws SQLException, ClassNotFoundException;
	public List<T> list() throws SQLException, ClassNotFoundException;
	public T getById(int id) throws SQLException, ClassNotFoundException;
}
