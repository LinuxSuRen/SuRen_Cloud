/**
 * Create Date: 2012-1-31<br>
 * File Name: BaseAction.java
 */
package org.suren.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.suren.core.SuRenContext;
import org.suren.entity.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

/**
 * @author Administrator<br>
 * Create Time: 05:01:23<br>
 * 包含action中常用的属性以及方法
 */
public abstract class BaseAction extends ActionSupport implements ServletRequestAware,
ServletResponseAware, Preparable
{
	private static final long	serialVersionUID	= 1L;

	protected static final Logger log = Logger.getLogger(BaseAction.class);

	protected static final String SUCCESS = "success";
	protected static final String ERROR = "error";
	protected static final String JSON = "json";
	protected static final String UPLOAD = "upload";
	protected static final String DOWNLOAD = "download";

	private HttpServletRequest request;
	private HttpServletResponse response;

	/* 该模块的默认功能
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public abstract String execute();

	@Override
	public void prepare() throws Exception {
		ActionContext.getContext().getApplication().put(SuRenContext.CONTEXT, getRequest().getContextPath());
	}

	/**
	 * @return the request
	 */
	public HttpServletRequest getRequest() {
		return request;
	}
	/**
	 * @return the response
	 */
	public HttpServletResponse getResponse() {
		return response;
	}
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
	}

	protected HttpSession getCurrentSession() {
		return getRequest().getSession();
	}

	protected User getCurrentUser()
	{
		HttpSession session = getCurrentSession();

		User sessionUser = (User) session.getAttribute(SuRenContext.SESSION);

		return sessionUser;
	}
}
