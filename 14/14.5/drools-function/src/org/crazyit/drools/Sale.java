package org.crazyit.drools;

import java.util.Date;

public class Sale {
	// 日期
	private Date date;
	// 单价
	private int price;
	// 数量
	private int amount;
	// 销售单号
	private String saleCode;

	public Sale(Date date, int price, int amount, String saleCode) {
		this.date = date;
		this.price = price;
		this.amount = amount;
		this.saleCode = saleCode;
	}

	public String getSaleCode() {
		return saleCode;
	}

	public void setSaleCode(String saleCode) {
		this.saleCode = saleCode;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
