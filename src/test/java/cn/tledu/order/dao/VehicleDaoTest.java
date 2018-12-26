package cn.tledu.order.dao;

import java.util.List;

import org.junit.Test;

import com.shangyu.order.dao.VehicleDao;
import com.shangyu.order.domain.Vehicle;

public class VehicleDaoTest {
	private static VehicleDao vehicleDao = new VehicleDao();
	//@Test
	public void testSave() {
		Vehicle record = new Vehicle();
		record.setName("宝马");
		record.setPrice(100.0);
		int n = vehicleDao.save(record);
		System.out.println("影响了"+n+"条记录");
	}
	//@Test
	public void testDel() {
		Vehicle record = new Vehicle();
		record.setId(1);
		int n = vehicleDao.delete(record);
		System.out.println("影响了"+n+"条记录");
	}
	//@Test
	public void testUpd() {
		Vehicle record = new Vehicle();
		record.setId(2);
		record.setName("Audi");
		int n = vehicleDao.update(record);
		System.out.println("影响了"+n+"条记录");
	}
	
	//@Test
	public void testSelectOne() {
		Vehicle condition = new Vehicle();
		condition.setId(2);
		Vehicle result = vehicleDao.selectOne(condition);
		System.out.println(result);
	}
	
	@Test
	public void testSelectList() {
		Vehicle condition = new Vehicle();
		List<Vehicle> list = vehicleDao.selectList(condition);
		for (Vehicle v : list) {
			System.out.println(v);
		}
	}
}
