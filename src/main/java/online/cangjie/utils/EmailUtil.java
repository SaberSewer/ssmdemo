package online.cangjie.utils;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

import online.cangjie.po.User;

public class EmailUtil {
	private static EmailUtil emailUtil;
	private static Properties properties;
	private static MailSSLSocketFactory ssl;
	
	private EmailUtil(){}
	
	static {
		InputStream in = EmailUtil.class.getClassLoader().getResourceAsStream("email.properties");
		properties = new Properties();
		try {
			properties.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		properties.setProperty("mail.smtp.host", properties.getProperty("SMTP"));
		properties.put("mail.smtp.auth", "true");
		try {
			ssl = new MailSSLSocketFactory();
			ssl.setTrustAllHosts(true);
			properties.put("mail.smtp.ssl.enable", "true");
			properties.put("mail.smtp.ssl.socketFactory", ssl);
		} catch (GeneralSecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public void sendEmail(String title, String msg, String to) {
		Session session = Session.getDefaultInstance(properties,
				new User(properties.getProperty("From"), properties.getProperty("Password")));
		MimeMessage message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(properties.getProperty("From")));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(title);
			message.setText(msg);
			Transport.send(message);
			System.out.println("。。。。。。。。。。。。OK");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static EmailUtil getEmailUtil(){
		if(emailUtil == null){
			synchronized (EmailUtil.class) {
				if(emailUtil == null){
					emailUtil = new EmailUtil();
				}
			}
		}
		return emailUtil;
	}
}
