/**
 *
 */
package org.suren.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.suren.core.SuRenContext;
import org.suren.entity.AccountType;
import org.suren.entity.Status;
import org.suren.entity.User;
import org.suren.servcie.UserService;
import org.suren.task.WeatherTask;
import org.suren.util.Encryption;


/**
 * @author suren
 *
 */
public class LoginAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private String account = "";
	private String password;
	private String error;

	@Autowired
	private UserService service;

	/**
	 * 注册功能
	 * @return
	 */
	public String sign()
	{
		User user = new User();

		user.setAccount(account);
		user.setPassword(Encryption.encrypt(password));
		user.setName(account);

		service.save(user);

		return "sign";
	}

	/**
	 * 判断某个帐号是否已经存在
	 * @return
	 */
	public String existed()
	{
		log.debug("account:" + account);

		User user = service.findByAccount(account);

		account = user == null ? null : account;

		return JSON;
	}

	/* 登录功能
	 * @see org.suren.action.BaseAction#execute()
	 */
	public String execute()
	{
		User user = service.findByAccount(account);

		if(isLegal(user))
		{
			this.getRequest().getSession().setAttribute(SuRenContext.SESSION, user);

			log.debug("login success");

			return SUCCESS;
		}

		log.debug("login error");

		return ERROR;
	}

	/**注销功能
	 * @return
	 */
	public String logout()
	{
		User user = new User(AccountType.vistor, "Vistor");

		this.getRequest().getSession().setAttribute(SuRenContext.SESSION, user);

		return SUCCESS;
	}

	private boolean isLegal(User user)
	{
		if(user == null || !user.getPassword().equals(Encryption.encrypt(password)))
		{
			error = "帐号或密码有误。";

			return false;
		}

		if(Status.enable != user.getStatus())
		{
			error = "用户尚未启用。";

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

	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}

}
