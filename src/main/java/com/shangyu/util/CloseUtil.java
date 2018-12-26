package com.shangyu.util;

public class CloseUtil {
	private CloseUtil() {}
	public static void close(AutoCloseable closeObj) {
		if (closeObj != null) {
			try {
				closeObj.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
