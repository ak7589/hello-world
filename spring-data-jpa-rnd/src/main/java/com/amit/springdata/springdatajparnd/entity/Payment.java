package com.amit.springdata.springdatajparnd.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "pmode",discriminatorType = DiscriminatorType.STRING)
@Table(name = "Payment")
public abstract class Payment {
	
	@Id
	private int id;
	private double amount;
	
	@Column(name="pmode",insertable =  false, updatable = false)
	private String mode;
	
	public String getMode() {
		return mode;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", amount=" + amount + ", mode=" + mode + "]";
	}
	
	
}
