package com.edulab.subscription.dto;

public class ServiceDetail {
	
	private String serviceName;
	private String serviceDesc;
	private String levelName;
	private char examFlag;
	private String examDay;
	private int examQuantity;
	private String accessType;
	
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getServiceDesc() {
		return serviceDesc;
	}
	public void setServiceDesc(String serviceDesc) {
		this.serviceDesc = serviceDesc;
	}
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	public char getExamFlag() {
		return examFlag;
	}
	public void setExamFlag(char examFlag) {
		this.examFlag = examFlag;
	}
	public String getExamDay() {
		return examDay;
	}
	public void setExamDay(String examDay) {
		this.examDay = examDay;
	}
	public int getExamQuantity() {
		return examQuantity;
	}
	public void setExamQuantity(int examQuantity) {
		this.examQuantity = examQuantity;
	}
	public String getAccessType() {
		return accessType;
	}
	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}
	
	

}
