package org.crazyit.activiti.sale;

import java.math.BigDecimal;
import java.util.Date;

public class Sale {

	// 整笔销售单价格
	private BigDecimal money;
	
	// 销售日期，为了简起见，此处使用字符串
	private String saleDate;

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public String getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}
	
	/**
	 * price为打折的限定价，本类的money为销售单金额
	 */
	public boolean isBiggerThan(double price) {
		BigDecimal p = new BigDecimal(price);
		if(money.compareTo(p) == -1) {
			// 销售单总金额小于打折价格，不打折
			return false;
		}		
		return true;
	}
	
	/**
	 * 处理打折并返回结果
	 */
	public double doDiscount(double discount) {
		BigDecimal p = new BigDecimal(discount);
		return this.money.multiply(p).doubleValue();
	}
}
