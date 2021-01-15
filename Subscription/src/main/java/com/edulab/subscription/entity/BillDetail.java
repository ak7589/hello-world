package com.edulab.subscription.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "bill_detail")
public class BillDetail implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long billDetailId;
	
	//bill_id foreign key
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="bill_id")
	private Bills bills;
	
	@Column(name="product_id")
	private long productId;
	
	@Column(name="price_charged")
	private BigDecimal priceCharged;
	
	@Column(name="transaction_id")
	private String transactionId;
	
	@Column(name="subscription_YN")
	private char subscriptionFlag;
	
	@Column(name = "product_expiry_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime  productExpiryDate;

	public long getBillDetailId() {
		return billDetailId;
	}

	public void setBillDetailId(long billDetailId) {
		this.billDetailId = billDetailId;
	}

	public Bills getBills() {
		return bills;
	}

	public void setBills(Bills bills) {
		this.bills = bills;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public BigDecimal getPriceCharged() {
		return priceCharged;
	}

	public void setPriceCharged(BigDecimal priceCharged) {
		this.priceCharged = priceCharged;
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

	public LocalDateTime getProductExpiryDate() {
		return productExpiryDate;
	}

	public void setProductExpiryDate(LocalDateTime productExpiryDate) {
		this.productExpiryDate = productExpiryDate;
	}
	
	
}
