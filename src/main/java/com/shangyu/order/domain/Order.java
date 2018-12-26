package com.shangyu.order.domain;

import java.util.Date;

/**
 * 订单实体类
 * @author lhl
 *
 */
public class Order {
	private Integer id;//订单ID
	private Integer customerId;//客户ID
	private Double orderPrice;//订单总金额
	private Date orderDate;//下单时间
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Double getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(Double orderPrice) {
		this.orderPrice = orderPrice;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
}
