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
	private UserDao userDao;

	/* (non-Javadoc)
	 * @see org.suren.servcie.UserService#find(org.suren.entity.User)
	 */
	@Override
	public User find(User user) {
		return userDao.findUser(user);
	}

	@Override
	public void save(User user) {
		userDao.saveUser(user);
	}

}
