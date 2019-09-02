package org.crazyit.activiti;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class TestHttpClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// 创建默认的HttpClient
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 调用 GET 方法请求服务
		HttpGet httpget = new HttpGet("http://localhost:8080/test-web/person/1");
		// 获取响应
		HttpResponse response = httpclient.execute(httpget);
		// 根据 响应解析出字符串
		System.out.println(EntityUtils.toString(response.getEntity()));
	}


}
