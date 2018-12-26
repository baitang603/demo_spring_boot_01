package cn.tledu.order.service;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.shangyu.order.pojo.OrderDetailPojo;
import com.shangyu.order.service.OrderDetailService;

public class OrderDetailServiceTest {
	private static OrderDetailService orderDetailService = new OrderDetailService();
	//@Test
	public void testJoinSelect() {
		List<Map<String, Object>> list = orderDetailService.findOrderDetail(1);
		for (Map<String, Object> map : list) {
			System.out.println(map);
			System.out.println("======================");
		}
	}	
	
	@Test
	public void testJoinSelect2() {
		List<OrderDetailPojo> list = orderDetailService.findOrderDetail2(1);
		for (OrderDetailPojo pojo : list) {
			System.out.println(pojo);
			System.out.println("======================");
		}
	}	
	
}
