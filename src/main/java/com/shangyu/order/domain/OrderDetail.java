package com.shangyu.order.domain;
/**
 * 订单详情实体类
 * @author lhl
 *
 */
public class OrderDetail {
	private Integer id;//详情ID
	private Integer orderId;//所属订单ID
	private Integer vehicleId;//车辆ID
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}
}
