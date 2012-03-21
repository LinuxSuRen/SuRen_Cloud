/**
 *
 */
package org.suren.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.suren.entity.Article;
import org.suren.service.ArticleService;

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

	private List<Article> articles;
	private String title;
	private String content;
	private File attachment;

	private String fileName;

	@Override
	public String execute() {
		articles = service.findByTitle("");

		try {
			for(Article article : articles)
			{
				File file = article.getAttachment();
				
				FileInputStream fis = new FileInputStream(file);
				
				FileOutputStream fos = new FileOutputStream(new File("d:/" + article.getTitle()));
				
				byte[] b = new byte[1024];
				int len = -1;
				while((len = fis.read(b)) != -1)
				{
					fos.write(b, 0, len);
				}
				
				fos.close();
				fis.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}

	public String add()
	{
		log.debug("add artitle : " + title);

		Article article = new Article();

		article.setTitle(title);
		article.setContent(content);
		article.setAuthor(this.getCurrentUser());
		article.setAttachment(attachment);

		service.saveArticle(article);

		return execute();
	}
	
	public String fetchAttachment()
	{
		return execute();
	}
	
	public InputStream getInputStream() throws FileNotFoundException
	{
		return new FileInputStream(new File("D:/Work/Tom Clancy's H.A.W.X/HAWX.exe"));
	}

	/**
	 * @return the articles
	 */
	public List<Article> getArticles() {
		return articles;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @param attachment the attachment to set
	 */
	public void setAttachment(File attachment) {
		this.attachment = attachment;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName()
	{
		return fileName;
	}

}
