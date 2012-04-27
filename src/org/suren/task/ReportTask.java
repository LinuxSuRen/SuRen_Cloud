/**
 *
 */
package org.suren.task;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * @author suren
 *
 */
public class ReportTask extends  Task{

	@Override
	public void run() {
		System.out.println("run....reporttask");
		Properties pro = new Properties();

		pro.setProperty("mail.smtp.host", "smtp.126.com");
		pro.setProperty("mail.smtp.starttls.enable", "true");
		pro.setProperty("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(pro, new Authenticator() {

			/* (non-Javadoc)
			 * @see javax.mail.Authenticator#getPasswordAuthentication()
			 */
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("zxjlwt", "walkman31415");
			}
		});

		session.setDebug(true);

		try {
			Message msg = new MimeMessage(session);

			msg.setFrom(new InternetAddress("zxjlwt@126.com"));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress("361981269@qq.com"));
			msg.setSubject("test javamail" + new Date());
			msg.setText("test text." + new Date());

			Transport.send(msg);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getName() {
		return "ReportTask";
	}

	@Override
	public String desc() {
		return "Report something to Admin.";
	}

}
