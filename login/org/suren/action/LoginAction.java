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
public class LoginAction extends BaseAction {

	private String account = "";
	private String password;

	@Autowired
	private UserService service;

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public String execute()
	{
		User user = service.find(new User(account));

		if(user == null)
		{
			return ERROR;
		}
		else
		{
			this.getCurrentUser(user);

			return SUCCESS;
		}
	}

	public String sign()
	{
		User user = new User();

		user.setAccount(account);
		user.setPassword(password);

		service.save(user);

		return "sign";
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
