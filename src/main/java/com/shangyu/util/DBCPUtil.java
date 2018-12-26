package com.shangyu.util;

import org.apache.commons.dbcp2.BasicDataSource;

public class DBCPUtil {
	private BasicDataSource bds;
	private static DBCPUtil du = null;
	
	private DBCPUtil() {
		ReadCfgUtil cfg = new ReadCfgUtil("jdbc.properties");
		String driverClassName = cfg.get("className");
		String url = cfg.get("url");
		String username = cfg.get("user");
		String password = cfg.get("password");
		bds = new BasicDataSource();
		bds.setDriverClassName(driverClassName);
		bds.setUrl(url);
		bds.setUsername(username);
		bds.setPassword(password);
	}
	
	public static DBCPUtil getInstance() {
		if (du == null) {
			synchronized (DBCPUtil.class) {
				if (du == null) {
					du = new DBCPUtil();
				}
			}
		}
		return du;
	}
	
	public BasicDataSource getDataSource() {
		return bds;
	}
}
