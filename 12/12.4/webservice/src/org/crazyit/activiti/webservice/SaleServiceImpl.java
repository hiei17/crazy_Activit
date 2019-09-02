package org.crazyit.activiti.webservice;

import javax.jws.WebService;

@WebService()
public class SaleServiceImpl implements SaleService {
	
	public Sale createSale(String creator, String createDate) {
		System.out.println("创建人：" + creator);
		System.out.println("创建日期：" + createDate);		
		Sale sale = new Sale();
		sale.setSaleCode("SA00001");
		return sale;
	} 
}
