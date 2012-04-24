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

/**
 * @author suren
 *
 */
public class TestSendMail {

	/**
	 * @param args
	 * @throws MessagingException
	 */
	public static void main(String[] args) throws MessagingException {
		sendTextMail();
		for(int i = 0; i < 10; i++)
		{
		}
	}

	static void sendTextMail() throws MessagingException
	{
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

		Message msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress("zxjlwt@126.com"));
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress("361981269@qq.com"));
		msg.setSubject("test javamail");
		msg.setText("test text.");

		Transport.send(msg);
	}

}
