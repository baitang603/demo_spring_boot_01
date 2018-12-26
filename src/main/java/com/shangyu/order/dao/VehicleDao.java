package com.shangyu.order.dao;

import org.springframework.stereotype.Repository;

import com.shangyu.order.domain.Vehicle;
import com.shangyu.util.CloseUtil;
import com.shangyu.util.DBCPUtil;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
@Repository
public class VehicleDao {
	private static DataSource ds = DBCPUtil.getInstance().getDataSource();
	public int save(Vehicle record) {
		int res = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ds.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert into t_vehicle ");
			sql.append("(name, price) ");
			sql.append("values ");
			sql.append("(?, ?) ");
			stmt = conn.prepareStatement(sql.toString());
			stmt.setString(1, record.getName());
			stmt.setDouble(2, record.getPrice());
			res = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(stmt);
			CloseUtil.close(conn);
		}
		return res;
	}
	
	public int delete(Vehicle record) {
		int res = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ds.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("delete from t_vehicle ");
			sql.append("where id = ? ");
			stmt = conn.prepareStatement(sql.toString());
			stmt.setInt(1, record.getId());
			res = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(stmt);
			CloseUtil.close(conn);
		}
		return res;
	}
	
	public int update(Vehicle record) {
		int res = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ds.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("update t_vehicle ");
			sql.append("set ");
			sql.append("name = ? ");
			sql.append("where id = ? ");
			stmt = conn.prepareStatement(sql.toString());
			stmt.setString(1, record.getName());
			stmt.setInt(2, record.getId());
			res = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(stmt);
			CloseUtil.close(conn);
		}
		return res;
	}
	
	public Vehicle selectOne(Vehicle record) {
		Vehicle res = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select id, name, price ");
			sql.append("from t_vehicle ");
			sql.append("where id = ? ");
			stmt = conn.prepareStatement(sql.toString());
			stmt.setInt(1, record.getId());
			rs = stmt.executeQuery();
			while (rs.next()) {
				res = new Vehicle();
				res.setId(rs.getInt("id"));
				res.setName(rs.getString("name"));
				res.setPrice(rs.getDouble("price"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(rs);
			CloseUtil.close(stmt);
			CloseUtil.close(conn);
		}
		return res;
	}
	
	public List<Vehicle> selectList(Vehicle record) {
		List<Vehicle> list = new ArrayList<Vehicle>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select id, name, price ");
			sql.append("from t_vehicle ");
			stmt = conn.prepareStatement(sql.toString());
			rs = stmt.executeQuery();
			while (rs.next()) {
				Vehicle obj = new Vehicle();
				obj.setId(rs.getInt("id"));
				obj.setName(rs.getString("name"));
				obj.setPrice(rs.getDouble("price"));
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(rs);
			CloseUtil.close(stmt);
			CloseUtil.close(conn);
		}
		return list;
	}
}
