/**
 *
 */
package org.suren.service;

import java.util.List;

import org.suren.entity.Article;

/**
 * @author suren
 *
 */
public interface ArticleService {

	void saveArticle(Article entity);

	List<Article> findByTitle(String title);

	Article findByID(String id);
}
