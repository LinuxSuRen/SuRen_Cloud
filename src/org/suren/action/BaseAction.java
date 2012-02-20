/**
 * Create Date: 2012-1-31<br>
 * File Name: BaseAction.java
 */
package org.suren.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator<br>
 * Create Time: 05:01:23<br>
 * 包含action中常用的属性以及方法
 */
public class BaseAction extends ActionSupport implements ServletRequestAware,
ServletResponseAware
{
	private static final long	serialVersionUID	= 1L;

	protected Logger log = Logger.getLogger(BaseAction.class);
	
	public static final String SUCCESS = "success";
	public static final String JSON = "json";
	public static final String UPLOAD = "upload";
	public static final String DOWNLOAD = "download";
	public HttpServletRequest request;
	public HttpServletResponse response;
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
		
	}
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		this.response = arg0;
		
	}
	
}
