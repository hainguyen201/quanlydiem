package quanlydiemsinhvien.dao;

import java.util.List;

import quanlydiemsinhvien.mapper.RowMapper;

public interface GenericDAO<T> {
	/**
	 * Hàm chung để lấy dữ liệu từ db
	 * 
	 * @param <T>
	 * @param sql
	 * @param rowMapper
	 * @param parameters
	 * @return
	 */

	<T> List<T> query(String sql,RowMapper<T> rowMapper, Object... parameters);

	/*
	 * void update(String sql, Object... parameters);
	 * 
	 * Long insert(String sql, Object... parameters);
	 */
}
