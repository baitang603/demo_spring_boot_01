package com.shangyu.order.domain;
/**
 * 客户实体类
 * @author lhl
 *
 */
public class Customer {
	private Integer id;//客户ID
	private String name;//客户姓名
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
