/**
 *
 */
package org.suren.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.suren.dao.ArticleDao;
import org.suren.entity.Article;

/**
 * @author suren
 *
 */
@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDao dao;

	/* (non-Javadoc)
	 * @see org.suren.service.ArticleService#saveArticle(org.suren.entity.Article)
	 */
	@Override
	public void saveArticle(Article entity) {
		entity.setCreateDate(new Date());
		entity.setLastModify(new Date());

		dao.saveArticle(entity);
	}

	/* (non-Javadoc)
	 * @see org.suren.service.ArticleService#findByTitle(java.lang.String)
	 */
	@Override
	public List<Article> findByTitle(String title) {
		Article article = new Article();

		article.setTitle(title);

		return dao.findArticle(article);
	}

	@Override
	public Article findByID(String id) {
		Article article = new Article();

		article.setId(id);

		List<Article> articles = dao.findArticle(article);

		return articles != null && articles.size() > 0 ? articles.get(0) : null;
	}

}
