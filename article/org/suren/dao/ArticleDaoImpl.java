/**
 *
 */
package org.suren.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.suren.entity.Article;

/**
 * @author suren
 *
 */
@Service
public class ArticleDaoImpl extends BaseDao<Article> implements ArticleDao {

	/* (non-Javadoc)
	 * @see org.suren.dao.ArticleDao#saveArticle(org.suren.entity.Article)
	 */
	@Override
	public void saveArticle(Article entity) {
		this.save(entity);
	}

	/* (non-Javadoc)
	 * @see org.suren.dao.ArticleDao#findArticle(org.suren.entity.Article)
	 */
	@Override
	public List<Article> findArticle(Article entity) {
		Criteria criteria = this.getCritera();

		if(entity != null)
		{
			if(entity.getTitle() != null)
			{
				criteria.add(Restrictions.like("title", "%" + entity.getTitle() + "%"));
			}
		}

		return this.findByCriteria(criteria);
	}

	@Override
	public Class<?> setClass() {
		return Article.class;
	}

}
