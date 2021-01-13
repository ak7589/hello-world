package com.testprgs;

public class ProdItem {
	
	private long id;
	private String prodName;
	private int itemQuantiy;
	private double price;
	
	public ProdItem(long id, String prodName, int itemQuantiy, double price) {
		this.id = id;
		this.prodName = prodName;
		this.itemQuantiy = itemQuantiy;
		this.price = price;
	}

	//Setters and Getters
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public int getItemQuantiy() {
		return itemQuantiy;
	}

	public void setItemQuantiy(int itemQuantiy) {
		this.itemQuantiy = itemQuantiy;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
