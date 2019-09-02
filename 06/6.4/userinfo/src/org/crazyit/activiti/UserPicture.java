package org.crazyit.activiti;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Picture;
import org.activiti.engine.identity.User;

/**
 * 设置用户图片
 * @author yangenxiong
 *
 */
public class UserPicture {

	public static void main(String[] args) throws Exception {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到身份服务组件实例
		IdentityService identityService = engine.getIdentityService();
		String id = UUID.randomUUID().toString();
		// 创建用户
		creatUser(identityService, id, "angus", "young", "yangenxiong@163.com", "abc");
		// 读取图片并转换为byte数组
		FileInputStream fis = new FileInputStream(new File("resource/artifact/picture.png"));		
		BufferedImage img = ImageIO.read(fis);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		ImageIO.write(img, "png", output);
		//获取图片的byte数组
		byte[] picArray = output.toByteArray();		
		// 创建Picture实例
		Picture picture = new Picture(picArray, "angus image");
		// 为用户设置图片
		identityService.setUserPicture(id, picture);		
	}

	//创建用户方法
	static void creatUser(IdentityService identityService, String id, String first, String last, String email, String passwd) {
		// 使用newUser方法创建User实例
		User user = identityService.newUser(id);
		// 设置用户的各个属性
		user.setFirstName(first);
		user.setLastName(last);
		user.setEmail(email);
		user.setPassword(passwd);
		// 使用saveUser方法保存用户
		identityService.saveUser(user);
	}
}
