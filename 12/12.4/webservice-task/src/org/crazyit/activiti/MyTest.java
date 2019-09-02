package org.crazyit.activiti;

import java.net.URL;
import java.util.Enumeration;

public class MyTest {

	public static void main(String[] args) throws Exception {
		Enumeration<URL> xjcBindingUrls = Thread.currentThread().getContextClassLoader().getResources("activiti-bindings.xjc");
		System.out.println(xjcBindingUrls.hasMoreElements());
		while(xjcBindingUrls.hasMoreElements()) {
			URL u = xjcBindingUrls.nextElement();
			System.out.println(u);
		}
	}
	

}
