package weimakeji.sercice;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.search.RecipientStringTerm;
import javax.mail.search.RecipientTerm;

/**
 * 邮件发送工具类
 * @author asus-pc
 *
 */
public class MailUtils {
    /**
     * 发邮件的方法
     * @throws MessagingException 
     * @throws Exception 
     */
	
	public static void sendMail(String to,String text) throws Exception{
		//1.创建连接对象，链接到邮箱服务器
		Properties props = new Properties();
		//props.setProperty(key, value);
		Session session = Session.getInstance(props,new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("service@store.com", "123");
			}
			
		});
		
		//2.创建邮件对象
		Message message =new MimeMessage(session);
		//2.1设置发件人
		message.setFrom(new InternetAddress("service@store.com"));
		
		//2.2设置收件人
		message.setRecipient(RecipientType.TO,new InternetAddress(to));
		
		//2.3设置邮件的主题
		message.setSubject("文件");
		//2.4邮件的正文
		message.setContent(text, "text/html;charset=UTF-8");
		
		//3发送一封邮件
		Transport.send(message);
	}
}
