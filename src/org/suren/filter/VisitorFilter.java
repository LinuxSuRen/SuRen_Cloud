/**
 *
 */
package org.suren.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.suren.core.SuRenContext;
import org.suren.entity.User;
import org.suren.entity.Visitor;
import org.suren.servcie.VisitorService;

/**
 * @author suren
 * 收集用户访问信息
 */
public class VisitorFilter implements SuRenFilter
{
	private VisitorService service;

	@Override
	public void destroy()
	{
		LOG.debug(getClass().getSimpleName() + " had destroyed.");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException
	{
		HttpServletRequest request = (HttpServletRequest)arg0;

		Visitor visitor = new Visitor();

		String remoteAddr = request.getRemoteAddr();
		String remoteHost = request.getRemoteHost();
		String userAgent = request.getHeader("User-Agent");
		String referrer = request.getHeader("Referer");

		visitor.setRemoteAddr(remoteAddr);
		visitor.setRemoteHost(remoteHost);
		visitor.setUserAgent(userAgent);
		visitor.setReferrer(referrer);

		Object session = request.getSession().getAttribute(SuRenContext.SESSION);

		if(session instanceof User)
		{
			User user = (User) session;

			visitor.setUserID(user.getId());
		}

		service.save(visitor);

		chain.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig config) throws ServletException
	{
		WebApplicationContext context =
				WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());

		service = (VisitorService) context.getBean("visitorServiceIpml");

		LOG.debug(getClass().getSimpleName() + " is completed.");
	}
}
