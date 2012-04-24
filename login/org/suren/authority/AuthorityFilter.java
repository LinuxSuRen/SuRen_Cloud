/**
 *
 */
package org.suren.authority;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.suren.core.SuRenContext;
import org.suren.entity.AccountType;
import org.suren.entity.User;
import org.suren.filter.SuRenFilter;

/**
 * @author suren
 *
 */
public class AuthorityFilter implements SuRenFilter {

	private static final Logger log = Logger.getLogger(AuthorityFilter.class);

	@SuppressWarnings("unused")
	private FilterConfig filterConfig;

	private static String contextPath;

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		filterConfig = null;

		log.debug("AuthorityFilter had destroyed.");
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		contextPath = httpRequest.getContextPath();

		String uri = httpRequest.getRequestURI();


		HttpSession session = httpRequest.getSession();
		User sessionUser = (User) session.getAttribute(SuRenContext.SESSION);
		session.setAttribute(SuRenContext.CONTEXT, contextPath);
		if (sessionUser == null)
		{
			sessionUser = new User(AccountType.vistor, "Vistor");

			session.setAttribute(SuRenContext.SESSION, sessionUser);
		}

		log.debug("contextPath:" + contextPath);
		log.debug("URI:" + uri);
		log.debug("AccountType:" + sessionUser.getType());

		if(sessionUser.getType() == AccountType.vistor && isNotLogin(uri))
		{
			httpResponse.sendRedirect(contextPath + "/page/login/login.jsp" );
		}
		else
		{
			chain.doFilter(httpRequest, httpResponse);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig config) throws ServletException {
		filterConfig = config;

		log.debug("server info : " + config.getServletContext().getServerInfo());

		log.debug("AuthorityFilter is completed.");
	}

	private boolean isNotLogin(String uri)
	{
		return (!uri.endsWith("index.jsp") && !uri.endsWith("login.jsp")
				&& !uri.endsWith("login.action") && !uri.endsWith("sign.jsp")
				&& !uri.endsWith("login!sign.action"));
	}

}
