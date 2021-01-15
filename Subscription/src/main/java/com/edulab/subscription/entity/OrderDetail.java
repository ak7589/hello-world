package com.edulab.subscription.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_detail")
public class OrderDetail implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long orderDetailId;
	
	//offer_id foreign key
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="order_id")
	private Orders order;
	
	@Column(name="product_id")
	private long productId;
	
	@Column(name="transaction_id")
	private String transactionId;
	
	@Column(name="subscription_YN")
	private char subscriptionFlag;

	@Column(name="active_YN")
	private char activeFlag;
	
	@Column(name = "start_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime  startDate;
	
	@Column(name = "end_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime  endDate;

	public long getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(long orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public char getSubscriptionFlag() {
		return subscriptionFlag;
	}

	public void setSubscriptionFlag(char subscriptionFlag) {
		this.subscriptionFlag = subscriptionFlag;
	}

	public char getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(char activeFlag) {
		this.activeFlag = activeFlag;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
	

}
