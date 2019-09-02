package org.crazyit.activiti;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class JavaShell {

	public static void main(String[] args) throws Exception {
		//创建命令集合
		List<String> argList = new ArrayList<String>();
		argList.add("cmd");
		argList.add("/c");
		argList.add("echo");
		argList.add("hello");
		argList.add("crazyit");
		ProcessBuilder processBuilder = new ProcessBuilder(argList);
		// 执行命令返回进程
		Process process = processBuilder.start();
		// 解析输出
		String result = convertStreamToStr(process.getInputStream());
		System.out.println(result);
	}
	
	//读取输出流并转换为字符串
	public static String convertStreamToStr(InputStream is) throws IOException {
		if (is != null) {
			Writer writer = new StringWriter();
			char[] buffer = new char[1024];
			try {
				Reader reader = new BufferedReader(new InputStreamReader(is,
						"UTF-8"));
				int n;
				while ((n = reader.read(buffer)) != -1) {
					writer.write(buffer, 0, n);
				}
			} finally {
				is.close();
			}
			return writer.toString();
		} else {
			return "";
		}
	}
}
