package cn.tledu.order.dao;

import java.util.Date;

import org.junit.Test;

import com.shangyu.order.dao.OrderDao;
import com.shangyu.order.dao.OrderDetailDao;
import com.shangyu.order.domain.Order;
import com.shangyu.order.domain.OrderDetail;

public class OrderDetailDaoTest {
	private static OrderDetailDao orderDetailDao = new OrderDetailDao();
	private static OrderDao orderDao = new OrderDao();
	//@Test
	public void testSave() {
		OrderDetail record = new OrderDetail();
		record.setOrderId(1);
		record.setVehicleId(1);
		int n = orderDetailDao.save(record);
		System.out.println("影响了" + n + "条记录");
	}
	
	//@Test
	public void testMultiSave() {
		Order record = new Order();
		record.setCustomerId(1);
		record.setOrderPrice(1000.0);
		record.setOrderDate(new Date());
		int orderId  = orderDao.saveReturnId(record);
		
		OrderDetail record2 = new OrderDetail();
		record2.setOrderId(orderId);
		record2.setVehicleId(1);
		int n = orderDetailDao.save(record2);
		System.out.println("影响了" + n + "条记录");
	}
}
