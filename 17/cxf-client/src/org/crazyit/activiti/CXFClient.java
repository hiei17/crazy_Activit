package org.crazyit.activiti;

import java.io.InputStream;

import javax.ws.rs.core.Response;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.jaxrs.client.WebClient;


public class CXFClient {

	public static void main(String[] args) throws Exception {
		// 创建WebClient
		WebClient client = WebClient
				.create("http://localhost:8080/test-web/person/1");
		// 获取响应
		Response response = client.get();
		// 获取响应内容
		InputStream ent = (InputStream) response.getEntity();
		String content = IOUtils.readStringFromStream(ent);
		// 输出字符串
		System.out.println(content);
	}

}
