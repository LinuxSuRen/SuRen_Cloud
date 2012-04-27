/**
 *
 */
package org.suren.test.mail;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

/**
 * @author suren
 *
 */
public class TestSendMail {

	/**
	 * @param args
	 * @throws MessagingException
	 * @throws MalformedURLException
	 */
	public static void main(String[] args) throws Exception {
		sendTextMail();
		for(int i = 0; i < 10; i++)
		{
		}
	}

	static void sendTextMail() throws MessagingException, IOException
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

		FileInputStream fis = new FileInputStream("c:/users/suren/desktop/test.htm");

		byte[] b = new byte[1024];
		int len;
		StringBuffer sb = new StringBuffer();
		while((len = fis.read(b)) != -1)
		{
			sb.append(new String(b, 0, len));
		}

		msg.setDataHandler(new DataHandler(new ByteArrayDataSource(sb.toString().replace("gril", "boy"), "text/html")));
		fis.close();

		MimeBodyPart mime = new MimeBodyPart();
		mime.attachFile(new File("c:/users/suren/desktop/informationcollector.collectorplugin.tc3600.rar"));

		MimeMultipart part = new MimeMultipart();
		part.addBodyPart(mime);

		msg.setContent(part);

		Transport.send(msg);
	}

}
