/**
 *
 */
package org.suren.authority;

import org.suren.interceptor.SuRenInterceptor;

import com.opensymphony.xwork2.ActionInvocation;

/**
 * @author suren
 *
 */
public class AuthorityInterceptor extends SuRenInterceptor {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
//		ActionContext context = invocation.getInvocationContext();

//		Map<String, Object> session = context.getSession();

		String invoke = invocation.invoke();

		log.debug("invoke : " + invoke);

		return invoke;
	}

}
