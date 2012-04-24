/**
 *
 */
package org.suren.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.suren.entity.User;
import org.suren.servcie.UserService;

/**
 * @author suren
 *
 */
public class UserAction extends BaseAction {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private UserService service;

	private User user;

	/* (non-Javadoc)
	 * @see org.suren.action.BaseAction#execute()
	 */
	@Override
	public String execute()
	{
		service.update(user);

		return SUCCESS;
	}

	/**
	 * 修改用户信息
	 * @return
	 */
	public String edit()
	{
		String id = this.getRequest().getParameter("id");
		log.debug("user'id: " + id);

		user = service.findByID(id);

		return "edit";
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
}
