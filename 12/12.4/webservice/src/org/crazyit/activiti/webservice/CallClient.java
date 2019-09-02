package org.crazyit.activiti.webservice;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public class CallClient {

	public static void main(String[] args) throws Exception {
	    JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();	    
	    Client client = dcf.createClient("http://localhost:9090/sale?wsdl");
	    Object[] vars = new Object[]{"crazyit", "2018-10-10 10:10:10"};
	    Object[] object = client.invoke("createSale", vars);
	    Sale sale = (Sale)object[0];
	    System.out.println("请求WebService后返回的销售单号：" + sale.getSaleCode());
	}
}
