package cn.tledu.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import com.shangyu.util.CloseUtil;
import com.shangyu.util.DBCPUtil;
import com.shangyu.util.ReadCfgUtil;

public class ConnectTest {
	
	//@Test
	public void testConnection() {
		Connection conn = null;
		try {
			ReadCfgUtil cfg = new ReadCfgUtil("jdbc.properties");
			String className = cfg.get("className");
			Class.forName(className);
			String url = cfg.get("url");
			String user = cfg.get("user");
			String password = cfg.get("password");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println(conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(conn);
		}
	}
	
	@Test
	public void testDBCP() {
		Connection conn = null;
		try {
			conn = DBCPUtil.getInstance().getDataSource().getConnection();
			System.out.println(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			CloseUtil.close(conn);
		}
	}
}
