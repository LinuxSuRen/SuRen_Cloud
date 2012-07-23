/**
 *
 */
package org.suren.servcie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.suren.dao.UserDao;
import org.suren.entity.User;
import org.suren.util.string.StringUtil;

/**
 * @author suren
 *
**/
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

	@Override
	public void update(User user) {
		if(user == null)
		{
			return;
		}

		String id = user.getId();

		if(StringUtil.isNotEmpty(id))
		{
			User u = findByID(id);

			if(u == null)
			{
				return;
			}

			u.setName(user.getName());
			u.setPassword(user.getPassword());
			u.setEmail(user.getEmail());

			dao.updateUser(u);
		}
	}

}
