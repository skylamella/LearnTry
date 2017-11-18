package cn.xiaoji.lucky.service.impl;

import java.util.Date;

import javax.annotation.Resource;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import cn.xiaoji.lucky.service.MailService;
import cn.xiaoji.lucky.vo.Mail;

@Service("mailService")
public class MailServiceImpl implements MailService {
	@Resource
    private TaskExecutor taskExecutor;
    @Resource
    private JavaMailSender javaMailSender;
    
    public void sendMail(Mail mail){
    	// 1. 创建一封邮件
    	MimeMessage message = javaMailSender.createMimeMessage();
        try {
        	// 2. From: 发件人（昵称有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改昵称）
        	message.setFrom(new InternetAddress(mail.getFromEmail(), "小鸡项目组", "UTF-8"));
        	// 3. To: 收件人
        	message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(mail.getToEmail(), mail.getUserName(), "UTF-8"));
        	// 4. Subject: 邮件主题
        	message.setSubject(mail.getEmailSubject(), "UTF-8");
    		// 5. Content: 邮件正文（可以使用html标签）（内容有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改发送内容）
    		message.setContent(mail.getEmailContent(), "text/html;charset=UTF-8");
    		// 6. 设置发件时间
    		message.setSentDate(new Date());
    		// 7. 保存设置
    		message.saveChanges();
            addSendMailTask(message);
        } catch (Exception e) {
        	
        }
    }
    
    private void addSendMailTask(final MimeMessage message){
        try{
            taskExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    javaMailSender.send(message);
                }
            });
        }catch (Exception e){
        	
        }

    }
}
