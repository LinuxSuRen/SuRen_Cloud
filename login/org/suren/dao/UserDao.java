/**
 *
 */
package org.suren.dao;

import java.util.List;

import org.suren.entity.User;

/**
 * @author suren
 *
 */
public interface UserDao {

	void saveUser(User user);

	User findUser(User user);

	String[] delUser(List<String> ids);
}
