package com.amit.springdata.springdatajparnd.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ch")
public class Check extends Payment {
	
	@Column(name="checknumber")
	private String checknumber;

	public String getChecknumber() {
		return checknumber;
	}

	public void setChecknumber(String checknumber) {
		this.checknumber = checknumber;
	}

}
