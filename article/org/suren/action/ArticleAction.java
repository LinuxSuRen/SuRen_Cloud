/**
 *
 */
package org.suren.action;

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

	@Override
	public String execute() {
		articles = service.findByTitle("");

		return SUCCESS;
	}

	public String add()
	{
		log.debug("add artitle : " + title);

		Article article = new Article();

		article.setTitle(title);
		article.setContent(content);
		article.setAuthor(this.getCurrentUser());

		service.saveArticle(article);

		return execute();
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

}
