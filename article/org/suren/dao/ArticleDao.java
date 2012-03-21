/**
 *
 */
package org.suren.dao;

import java.util.List;

import org.suren.entity.Article;

/**
 * @author suren
 *
 */
public interface ArticleDao {

	void saveArticle(Article entity);

	List<Article> findArticle(Article entity);

}
