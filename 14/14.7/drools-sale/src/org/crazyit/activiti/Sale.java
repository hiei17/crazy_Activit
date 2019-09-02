package org.crazyit.activiti;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 销售单对象
 * @author yangenxiong
 *
 */
public class Sale implements Serializable {

	// 销售单号
	private String saleCode;
	// 销售日期
	private Date date;
	// 销售明细
	private List<SaleItem> items;
	
	//折扣
	private BigDecimal discount = new BigDecimal(1);
		
	public Sale(String saleCode, Date date) {
		super();
		this.saleCode = saleCode;
		this.date = date;
		this.items = new ArrayList<SaleItem>();
	}
	
	public int getDayOfWeek() {
		Calendar c = Calendar.getInstance();
		c.setTime(this.date);
		int dow = c.get(Calendar.DAY_OF_WEEK);
		return dow;
	}
	
	// 返回该销售单的总金额（优惠前）
	public BigDecimal getTotal() {
		BigDecimal total = new BigDecimal(0);
		for (SaleItem item : this.items) {
			BigDecimal itemTotal = item.getPrice().multiply(item.getAmount());
			total = total.add(itemTotal);
		}
		total = total.setScale(2, BigDecimal.ROUND_HALF_UP);
		return total;
	}
	
	// 返回优惠后的总金额
	public BigDecimal getDiscountTotal() {
		BigDecimal total = getTotal();
		total = total.multiply(this.discount).setScale(2, BigDecimal.ROUND_HALF_UP);
		return total;
	}
	
	public void setDiscount(BigDecimal dicsount) {
		this.discount = dicsount.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	public BigDecimal getDiscount() {
		return this.discount;
	}
	
	public void addItem(SaleItem item) {
		this.items.add(item);
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
	
	public List<SaleItem> getItems() {
		return items;
	}
	
	public void setItems(List<SaleItem> items) {
		this.items = items;
	}
	
	
}
