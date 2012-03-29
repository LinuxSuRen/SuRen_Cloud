/**
 *
 */
package org.suren.servcie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.suren.dao.UserDao;
import org.suren.entity.User;

/**
 * @author suren
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;

	@Override
	public void save(User user) {
		dao.saveUser(user);
	}

	@Override
	public User findByAccount(String account) {
		if(account == null)
		{
			return null;
		}

		User user = new User();

		user.setAccount(account);

		return dao.findUser(user);
	}

	@Override
	public User findByID(String id) {
		if(id == null)
		{
			return null;
		}

		User user = new User();

		user.setId(id);

		return dao.findUser(user);
	}

}
