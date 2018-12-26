package com.shangyu.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import com.mysql.jdbc.Statement;
import com.shangyu.order.domain.Order;
import com.shangyu.util.CloseUtil;
import com.shangyu.util.DBCPUtil;

import org.springframework.stereotype.Repository;

public class OrderDao {
	private static DataSource ds = DBCPUtil.getInstance().getDataSource();
	public int save(Order record) {
		int res = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ds.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert into t_order ");
			sql.append("(customer_id, order_price, order_date) ");
			sql.append("values ");
			sql.append("(?, ?, ?) ");
			stmt = conn.prepareStatement(sql.toString());
			stmt.setInt(1, record.getCustomerId());
			stmt.setDouble(2, record.getOrderPrice());
			stmt.setObject(3, record.getOrderDate());
			res = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(stmt);
			CloseUtil.close(conn);
		}
		return res;
	}
	
	public int saveReturnId(Order record) {
		int res = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert into t_order ");
			sql.append("(customer_id, order_price, order_date) ");
			sql.append("values ");
			sql.append("(?, ?, ?) ");
			//这里也非常重要
			//Statement.RETURN_GENERATED_KEYS用来告诉JDBC把记录对应的ID保存到结果集中以便下面的
			//getGeneratedKeys方法能返回
			stmt = conn.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, record.getCustomerId());
			stmt.setDouble(2, record.getOrderPrice());
			stmt.setObject(3, record.getOrderDate());
			stmt.executeUpdate();
			//以下是核心代码
			rs = stmt.getGeneratedKeys();
			while (rs.next()) {
				res = rs.getInt(1);//套路写法
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(stmt);
			CloseUtil.close(conn);
		}
		return res;
	}
}
