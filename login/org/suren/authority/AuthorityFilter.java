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

import org.suren.core.SuRenContext;
import org.suren.entity.AccountType;
import org.suren.entity.User;
import org.suren.filter.SuRenFilter;
import org.suren.util.string.StringUtil;

/**
 * @author suren
 *
 */
public class AuthorityFilter implements SuRenFilter {

	private FilterConfig filterConfig;

	private static String contextPath;

	@Override
	public void destroy() {
		filterConfig = null;

		LOG.debug(getClass().getSimpleName() + " had destroyed.");
	}

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

		LOG.debug("contextPath:" + contextPath);
		LOG.debug("URI:" + uri);
		LOG.debug("AccountType:" + sessionUser.getType());

		if(sessionUser.getType() == AccountType.vistor && isNotLogin(uri) &&
				StringUtil.notEquals(uri, contextPath) &&
				StringUtil.notEquals(uri, contextPath + "/"))
		{
			httpResponse.sendRedirect(contextPath + "/page/login/login.jsp" );
		}
		else
		{
			chain.doFilter(httpRequest, httpResponse);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		filterConfig = config;

		LOG.debug("server info : " + config.getServletContext().getServerInfo());

		LOG.debug(getClass().getSimpleName() + " is completed.");
	}

	private boolean isNotLogin(String uri)
	{
		return (!uri.endsWith(".js") &&
				!uri.endsWith("index.jsp")
				&& !uri.endsWith("login.jsp")
				&& !uri.endsWith("login.action")
				&& !uri.endsWith("sign.jsp")
				&& !uri.endsWith("login!sign.action")
				&& !uri.endsWith(".jar")
				&& !uri.endsWith(".jpg")
				&& !uri.endsWith(".jnlp"));
	}
}
