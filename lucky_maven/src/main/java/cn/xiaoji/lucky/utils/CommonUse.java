package cn.xiaoji.lucky.utils;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

import cn.xiaoji.lucky.vo.Mail;

@SuppressWarnings("unchecked")
public class CommonUse {
	/***
	 * MD5加密
	 * @param oldstr 需要加密的字符串
	 * @return
	 */
	public static String MD5Password(String oldstr) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		byte[] oldbytes = oldstr.getBytes();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");// 获取对象
			md.update(oldbytes);// 初始化对象
			byte[] newBytes = md.digest();// 运行加密算法
			char[] newStr = new char[32];
			for (int i = 0; i < 16; i++) {
				byte temp = newBytes[i];
				newStr[2 * i] = hexDigits[temp >>> 4 & 0xf];
				newStr[2 * i + 1] = hexDigits[temp & 0xf];

			}
			return new String(newStr);
		} catch (NoSuchAlgorithmException e) {
			return null;
		}

	}
	
	/***
	 * 生成上传文件的文件名（唯一）
	 * @param uploadFileName 上传文件的原始文件名
	 * @return
	 */
	public static String generateFileName(String uploadFileName) {
		Date dt = new Date();
		SimpleDateFormat matter1 = new SimpleDateFormat("yyyy-MM-dd");
		String filename = matter1.format(dt) + RandomStringUtils.randomAlphanumeric(32);
		String sname = uploadFileName.substring(uploadFileName.lastIndexOf("."));
		String upFileName = filename + sname;
		return upFileName;
	}
	
	/***
	 * 判断字符串是否为空
	 * @param str 被检测的字符串
	 * @return
	 */
	public static boolean nullStringCheck(String str){
		if(str != null && str != ""){
			return true;
		}else{
			return false;
		}
	}
	
	/***
	 * 生成数字与小写字母的随机字符串
	 * @param nums 随机验证码的数量
	 * @return
	 */
	public static String createRandom(int nums) {
		String str = "0123456789qwertyuiopasdfghjklzxcvbnm";
		char[] rands = new char[nums];
		Random random = new Random();
		for (int i = 0; i < nums; i++) {
			rands[i] = str.charAt(random.nextInt(36));
		}
		return new String(rands);
	}
	
	/***
	 * 生成数字与大小写字母的随机字符串（验证时区分大小写）
	 * @param nums 随机验证码的数量
	 * @return
	 */
	public static String createCheckRandom(int nums) {
		String str = "0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
		char[] rands = new char[nums];
		Random random = new Random();
		for (int i = 0; i < nums; i++) {
			rands[i] = str.charAt(random.nextInt(36));
		}
		return new String(rands);
	}
	
	/***
	 * 生成一封拥有8位随机验证码的邮件对象
	 * @param sendMailAccount 发件人邮箱地址
	 * @param receiveMailAccount 收件人邮箱地址
	 * @param user_name 收件人称呼
	 * @return
	 */
	public static Mail createCheckEmail(String sendMailAccount, String receiveMailAccount, String user_name) {
		String rands = createRandom(8);
		String emailTitle = "请查收您申请的验证码";
		String emailText = "您的验证码是：" + rands + "，请在10分钟内输入，超时请重新获取！";
		Mail mail = new Mail();
		mail.setEmailContent(emailText);
		mail.setEmailSubject(emailTitle);
		mail.setToEmail(receiveMailAccount);
		mail.setFromEmail(sendMailAccount);
		mail.setUserName(user_name);
		mail.setCheckCode(rands);
		return mail;
	}
	
	/***
	 * 读取classpath下的properties配置文件
	 * @param propertiesName properties配置文件名
	 * @return
	 * @throws IOException 
	 */
	public static Properties getPropertiesMap (String propertiesName) throws IOException{
		Properties prop = new Properties();
		InputStream in = null;
		try {
			String url = Class.forName(CommonUse.class.getName()).getClassLoader().getResource(propertiesName).toString();
			url = url.substring(6,url.length()); 
			in = new BufferedInputStream(new FileInputStream(url));
			prop.load(in);
		} catch (Exception e) {
			prop.clear();
		} finally {
			in.close();
		}
		return prop;
	}
	
	/***
	 * 写入classpath下的properties配置文件（测试未成功，需要更正）
	 * @param propertiesName properties配置文件名
	 * @param prop 需要写入的properties配置文件内容
	 */
	public static void setPropertiesMap(String propertiesName, Properties prop){
		try {
			String url = Class.forName(CommonUse.class.getName()).getClassLoader().getResource(propertiesName).toString();
			url = url.substring(6,url.length()); 
			//String path = CommonUse.class.getResource(url).getPath();  
			FileOutputStream outputFile = new FileOutputStream(url);  
			//FileOutputStream oFile = new FileOutputStream(url, true);//true表示追加打开
			prop.store(outputFile, null);
			outputFile.flush();
			outputFile.close();
			
		} catch (Exception e) {
		}
	}
}
