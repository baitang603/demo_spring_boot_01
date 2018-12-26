package com.shangyu.order.domain;
/**
 * 车辆实体类
 * @author lhl
 *
 */
public class Vehicle {
	private Integer id;//车辆ID
	private String name;//车辆名称
	private Double price;//车辆的租价

	public Vehicle() {}

	public Vehicle(String name, Double price) {
		this.name = name;
		this.price = price;
	}

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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", name=" + name + ", price=" + price
				+ "]";
	}
}
