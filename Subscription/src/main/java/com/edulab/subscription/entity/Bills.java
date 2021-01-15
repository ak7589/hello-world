package com.edulab.subscription.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bills")
public class Bills implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long billId;
	
	// offer_id foreign key
	@Column(name="order_id")
	private int order_id;
	
	@Column(name="member_id")
	private String memberId;
	
	@Column(name="member_id")
	private BigDecimal amount;
	
	@Column(name="status")
	private String  status;
	
	@Column(name="payment_id")
	private String  paymentId;
	
	@Column(name = "bill_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime  billDate;
	
	@Column(name = "due_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime  dueDate;
	
	
	@Column(name = "payment_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime  paymentDate;


	public long getBillId() {
		return billId;
	}


	public void setBillId(long billId) {
		this.billId = billId;
	}


	public int getOrder_id() {
		return order_id;
	}


	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public BigDecimal getAmount() {
		return amount;
	}


	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getPaymentId() {
		return paymentId;
	}


	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}


	public LocalDateTime getBillDate() {
		return billDate;
	}


	public void setBillDate(LocalDateTime billDate) {
		this.billDate = billDate;
	}


	public LocalDateTime getDueDate() {
		return dueDate;
	}


	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}


	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}


	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}

	
}
