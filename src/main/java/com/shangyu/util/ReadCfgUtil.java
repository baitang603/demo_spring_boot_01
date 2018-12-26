package com.shangyu.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Properties;

public class ReadCfgUtil {
	private Properties p = new Properties();
	public ReadCfgUtil(String path) {
		this(path, "utf-8");
	}
	public ReadCfgUtil(String path, String enc) {
		try {
			p.load(new BufferedReader(new InputStreamReader(ReadCfgUtil.class.getClassLoader().getResourceAsStream(path) , enc)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String get(String key) {
		return p.getProperty(key);
	}
	
	public String get(String key, String defaultValue) {
		return p.getProperty(key, defaultValue);
	}
}
