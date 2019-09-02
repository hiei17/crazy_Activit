package org.crazyit.activiti.rest;

import java.io.InputStream;

import javax.ws.rs.core.Response;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.jaxrs.client.WebClient;

public class TestDeployments {

	public static void main(String[] args) throws Exception {
		// 创建WebClient，设置URL、认证用户名和密码
		WebClient client = WebClient
				.create("http://localhost:8080/activiti-rest/service/"
						+ "repository/deployments?sort=name&nameLike=%processes",
						"crazyit", "123456", null);
		// 设置认证格式为基础认证格式
		String authorizationHeader = "Basic "
				+ org.apache.cxf.common.util.Base64Utility
						.encode("user:password".getBytes());
		client.header("Authorization", authorizationHeader);
		// 获取响应
		Response response = client.get();
		// 获取响应内容
		InputStream ent = (InputStream) response.getEntity();
		String content = IOUtils.readStringFromStream(ent);
		// 输出字符串
		System.out.println(content);
	}

}
