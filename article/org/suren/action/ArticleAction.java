/**
 *
 */
package org.suren.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.lob.BlobImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.suren.entity.Article;
import org.suren.entity.Attachment;
import org.suren.service.ArticleService;
import org.suren.service.AttachmentService;

/**
 * @author suren
 *
 */
public class ArticleAction extends BaseAction {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private ArticleService service;
	@Autowired
	private AttachmentService attachmentService;

	private List<Article> articles;
	private String title;
	private String content;
	private File attachment;
	private String attachmentFileName;
	private String attachmentContentType;
	private InputStream attachmentStream;

	@Override
	public String execute() {
		articles = service.findByTitle("");

		return SUCCESS;
	}

	public String add() {
		log.debug("add artitle : " + title);
		log.debug("attachmentFileName:" + attachmentFileName);
		log.debug("attachmentContentType:" + attachmentContentType);

		Article article = new Article();

		article.setTitle(title);
		article.setContent(content);
		article.setAuthor(this.getCurrentUser());

		if(attachment != null)
		{
			Attachment attach = new Attachment();

			try {
				BlobImpl content = new BlobImpl(new FileInputStream(attachment), 0);

				attach.setContent(content);
				attach.setName(attachmentFileName);
				attach.setType(attachmentContentType);
				attach.setUploadUser(this.getCurrentUser());
			} catch (IOException e) {
				e.printStackTrace();
			}

			attachmentService.save(attach);

			article.setAttachment(attach);
		}

		service.saveArticle(article);

		return execute();
	}

	public String fetchAttachment() {
		String attID = this.getRequest().getParameter("attID");

		log.debug("attID:" + attID);

		Attachment attachment = new Attachment();
		attachment.setId(attID);

		List<Attachment> atts = attachmentService.find(attachment);

		if(atts != null && atts.size() > 0)
		{
			try {
				Attachment att = atts.get(0);

				setAttachmentContentType(att.getType());
				setAttachmentFileName(att.getName());

				log.debug("attachmentFileName:" + attachmentFileName);
				log.debug("attachmentContentType:" + attachmentContentType);

				attachmentStream = att.getContent().getBinaryStream();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else
		{
			//
		}

		return DOWNLOAD;
	}

	/**
	 * @return the articles
	 */
	public List<Article> getArticles() {
		return articles;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @param attachment
	 *            the attachment to set
	 */
	public void setAttachment(File attachment) {
		this.attachment = attachment;
	}

	/**
	 * @param attachmentFileName the attachmentFileName to set
	 */
	public void setAttachmentFileName(String attachmentFileName) {
		this.attachmentFileName = attachmentFileName;
	}

	/**
	 * @param attachmentContentType the attachmentContentType to set
	 */
	public void setAttachmentContentType(String attachmentContentType) {
		this.attachmentContentType = attachmentContentType;
	}

	/**
	 * @return the attachmentStream
	 */
	public InputStream getAttachmentStream() {
		return attachmentStream;
	}

	/**
	 * @return the attachmentFileName
	 */
	public String getAttachmentFileName() {
		return attachmentFileName;
	}

	/**
	 * @return the attachmentContentType
	 */
	public String getAttachmentContentType() {
		return attachmentContentType;
	}

}
