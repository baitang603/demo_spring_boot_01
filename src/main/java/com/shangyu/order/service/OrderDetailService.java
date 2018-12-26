package com.shangyu.order.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import com.shangyu.order.pojo.OrderDetailPojo;
import com.shangyu.util.CloseUtil;
import com.shangyu.util.DBCPUtil;

public class OrderDetailService {
	private static DataSource ds = DBCPUtil.getInstance().getDataSource();
	public List<Map<String, Object>> findOrderDetail(int orderId) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select  o.customer_id, v.`name`, v.price, ");
			sql.append("    o.order_date ");
			sql.append("from t_order_detail od ");
			sql.append("    inner join t_order o on o.id = od.order_id ");
			sql.append("    inner join t_vehicle v on v.id = od.vehicle_id ");
			sql.append("where od.order_id = ? ");
			stmt = conn.prepareStatement(sql.toString());
			stmt.setInt(1, orderId);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("customerId", rs.getInt("customer_id"));
				map.put("vehicleName", rs.getString("name"));
				map.put("vehiclePrice", rs.getDouble("price"));
				map.put("orderDate", rs.getDate("order_date"));
				list.add(map);
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
	
	public List<OrderDetailPojo> findOrderDetail2(int orderId) {
		List<OrderDetailPojo> list = new ArrayList<OrderDetailPojo>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			StringBuffer sql = new StringBuffer();
			sql.append("select  o.customer_id, v.`name`, v.price, ");
			sql.append("    o.order_date ");
			sql.append("from t_order_detail od ");
			sql.append("    inner join t_order o on o.id = od.order_id ");
			sql.append("    inner join t_vehicle v on v.id = od.vehicle_id ");
			sql.append("where od.order_id = ? ");
			stmt = conn.prepareStatement(sql.toString());
			stmt.setInt(1, orderId);
			rs = stmt.executeQuery();
			while (rs.next()) {
				OrderDetailPojo pojo = new OrderDetailPojo();
				pojo.setCustomerId(rs.getInt("customer_id"));
				pojo.setVehicleName(rs.getString("name"));
				pojo.setVehiclePrice(rs.getDouble("price"));
				pojo.setOrderDate(rs.getDate("order_date"));
				list.add(pojo);
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
