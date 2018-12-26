package com.shangyu.order.pojo;

import java.util.Date;

import com.shangyu.order.domain.OrderDetail;

public class OrderDetailPojo extends OrderDetail {
	private Integer customerId;
	private String vehicleName;
	private Double vehiclePrice;
	private Date orderDate;
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public Double getVehiclePrice() {
		return vehiclePrice;
	}
	public void setVehiclePrice(Double vehiclePrice) {
		this.vehiclePrice = vehiclePrice;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	@Override
	public String toString() {
		return "OrderDetailPojo [customerId=" + customerId + ", vehicleName="
				+ vehicleName + ", vehiclePrice=" + vehiclePrice
				+ ", orderDate=" + orderDate + "]";
	}
}
