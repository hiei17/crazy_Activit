package org.crazyit.activiti.webservice;

import java.io.Serializable;
import java.util.Date;

public class Sale implements Serializable {

	private String saleCode;
	
	private String creator;
	
	private Date createDate;

	public String getSaleCode() {
		return saleCode;
	}

	public void setSaleCode(String saleCode) {
		this.saleCode = saleCode;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
