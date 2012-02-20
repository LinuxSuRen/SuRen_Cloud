/**
 * Create Date: 2012-2-9<br>
 * File Name: MyAroundInterceptor.java
 */
package org.suren.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author Administrator<br>
 * Create Time: 04:02:49<br>
 */
public class MyAroundInterceptor implements MethodInterceptor
{

	/* (non-Javadoc)
	 * @see org.aopalliance.intercept.MethodInterceptor#invoke(org.aopalliance.intercept.MethodInvocation)
	 */
	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable
	{
		System.out.println("调用方法" + arg0.getMethod() + "之前");
		
		Object result = arg0.proceed();
		
		System.out.println("调用 方法之后");
		
		return result;
	}

}
