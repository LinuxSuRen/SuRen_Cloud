/**
 *
 */
package org.suren.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.suren.task.Task;

/**
 * @author suren
 *
 */
public class Mail {
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(Task.class);

	private static final Properties pro = new Properties();
	private static final Session session = Session.getDefaultInstance(pro, new Authenticator() {

		/* (non-Javadoc)
		 * @see javax.mail.Authenticator#getPasswordAuthentication()
		 */
		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication("zxjlwt", "walkman31415");
		}
	});

	static {
		pro.setProperty("mail.smtp.host", "smtp.126.com");
		pro.setProperty("mail.smtp.starttls.enable", "true");
		pro.setProperty("mail.smtp.auth", "true");
	}

	public static void send(String msg) throws MessagingException
	{
		Message message = new MimeMessage(session);

		message.setFrom(new InternetAddress("zxjlwt@126.com"));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress("361981269@qq.com"));
		message.setSubject("Active  User");
		message.setText(msg);

		Transport.send(message);
	}

}
