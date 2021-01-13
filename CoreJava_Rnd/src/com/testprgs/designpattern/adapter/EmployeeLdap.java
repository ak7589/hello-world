package com.testprgs.designpattern.adapter;

public class EmployeeLdap {
	
	private int cn;
	private String name;
	private String name2;
	private String mail;
	
	public EmployeeLdap(int cn, String name, String name2, String mail) {
		super();
		this.cn = cn;
		this.name = name;
		this.name2 = name2;
		this.mail = mail;
	}

	public int getCn() {
		return cn;
	}

	public void setCn(int cn) {
		this.cn = cn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
}
