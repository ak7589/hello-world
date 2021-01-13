package com.amit.springdata.springdatajparnd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "bankcheck")
@PrimaryKeyJoinColumn(name="id")
public class Check extends Payment {

	@Column(name = "checknumber")
	private String checknumber;

	public String getChecknumber() {
		return checknumber;
	}

	public void setChecknumber(String checknumber) {
		this.checknumber = checknumber;
	}

	@Override
	public String toString() {
		return "Check [checknumber=" + checknumber + "]" + " Payment ID : " + this.getId() + " Amt : "
				+ this.getAmount();
	}

}
