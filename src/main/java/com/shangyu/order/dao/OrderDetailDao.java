package com.shangyu.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.shangyu.order.domain.OrderDetail;
import com.shangyu.util.CloseUtil;
import com.shangyu.util.DBCPUtil;

public class OrderDetailDao {
	private static DataSource ds = DBCPUtil.getInstance().getDataSource();
	public int save(OrderDetail record) {
		int res = 0;
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = ds.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("insert into t_order_detail ");
			sql.append("(order_id, vehicle_id) ");
			sql.append("values ");
			sql.append("(?, ?) ");
			stmt = conn.prepareStatement(sql.toString());
			stmt.setInt(1, record.getOrderId());
			stmt.setInt(2, record.getVehicleId());
			res = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(stmt);
			CloseUtil.close(conn);
		}
		return res;
	}
}
