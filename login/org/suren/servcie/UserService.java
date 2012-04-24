/**
 *
 */
package org.suren.servcie;

import org.suren.entity.User;

/**
 * @author suren
 *
 */
public interface UserService {

	void save(User user);

	void update(User user);

	/**
	 * 根据account查找用户，找到返回该用户，找不到返回null
	 * @param account
	 * @return
	 */
	User findByAccount(String account);

	/**
	 * 根据id查找用户，找到返回该用户，找不到返回null
	 * @param id
	 * @return
	 */
	User findByID(String id);
}
