/**
 *
 */
package org.suren.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.suren.entity.User;

/**
 * @author suren
 *
 */
@Service
public class UserDaoImpl extends BaseDao<User> implements UserDao {

	/* (non-Javadoc)
	 * @see org.suren.dao.UserDao#find(org.suren.entity.User)
	 */
	@Override
	public User findUser(User user) {
		Criteria criteria = this.getCritera();

		if(user.getAccount() != null)
		{
			criteria.add(Restrictions.eq("account", user.getAccount()));
		}

		return this.findByCriteriaUnique(criteria);
	}

	/* (non-Javadoc)
	 * @see org.suren.dao.UserDao#delUser(java.util.List)
	 */
	@Override
	public String[] delUser(List<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<?> setClass() {
		return User.class;
	}

	@Override
	public void saveUser(User user) {
		this.save(user);
	}

}
