package cn.tledu.order.dao;

import java.util.Date;

import org.junit.Test;

import com.shangyu.order.dao.OrderDao;
import com.shangyu.order.domain.Order;

public class OrderDaoTest {
	private static OrderDao orderDao = new OrderDao();
	//@Test
	public void testSave() {
		Order record = new Order();
		record.setCustomerId(1);
		record.setOrderPrice(1000.0);
		record.setOrderDate(new Date());
		int n  = orderDao.save(record);
		System.out.println("影响了" + n + "条记录");
	}
}
