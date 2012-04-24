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

	void updateUser(User user);

	/**
	 * 根据不重复属性查找唯一用户，
	 * 找到返回该对象，否则返回null
	 * @param user
	 * @return
	 */
	User findUser(User user);

	List<User> findUsers(User user);

	String[] delUser(List<String> ids);
}
