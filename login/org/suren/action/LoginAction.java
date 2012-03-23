/**
 *
 */
package org.suren.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.suren.core.SuRenContext;
import org.suren.entity.AccountType;
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

		if(isLegal(user))
		{
			this.getRequest().getSession().setAttribute(SuRenContext.SESSION, user);

			return SUCCESS;
		}

		return ERROR;
	}

	public String logout()
	{
		User user = new User(AccountType.vistor, "Vistor");

		this.getRequest().getSession().setAttribute(SuRenContext.SESSION, user);

		return SUCCESS;
	}

	public String sign()
	{
		User user = new User();

		user.setAccount(account);
		user.setPassword(password);
		user.setName(account);

		service.save(user);

		return "sign";
	}

	private boolean isLegal(User user)
	{
		if(user == null)
		{
			return false;
		}

		return true;
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
