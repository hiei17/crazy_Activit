package org.crazyit.restlet;

import java.util.HashMap;
import java.util.Map;

import org.restlet.data.MediaType;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		ClientResource client = new ClientResource(
				"http://localhost:8080/test-web/person/1");
		// 调用get方法，由于服务器发布的是GET
		Representation response = client.get(MediaType.APPLICATION_JSON);
		// 创建JacksonRepresentation实例，将响应转换为Map
		JacksonRepresentation jr = new JacksonRepresentation(response, HashMap.class);
		// 获取转换后的Map对象
		Map result = (HashMap)jr.getObject();
		// 输出结果
		System.out.println(result.get("name"));
	}

}
