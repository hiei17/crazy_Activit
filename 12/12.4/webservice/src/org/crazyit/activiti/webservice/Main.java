package org.crazyit.activiti.webservice;

import javax.xml.ws.Endpoint;

public class Main {

    public static void main(String args[]) throws Exception {
    	Endpoint e = Endpoint.publish("http://localhost:9090/sale", new SaleServiceImpl());
        System.out.println("服务启动...");        
    }

}
