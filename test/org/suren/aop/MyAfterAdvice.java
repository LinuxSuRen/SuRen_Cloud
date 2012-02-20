/**
 * Create Date: 2012-2-9<br>
 * File Name: MyAfterAdvice.java
 */
package org.suren.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

/**
 * @author Administrator<br>
 * Create Time: 04:02:11<br>
 */
public class MyAfterAdvice implements AfterReturningAdvice
{

	/* (non-Javadoc)
	 * @see org.springframework.aop.AfterReturningAdvice#afterReturning(java.lang.Object, java.lang.reflect.Method, java.lang.Object[], java.lang.Object)
	 */
	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3)
			throws Throwable
	{
		System.out.println("方法调用结束");
		System.out.println("调用方法的返回值：" + arg0);
		System.out.println("调用方法是：" + arg1);
		System.out.println("调用方法的参数是：" + arg2);
		System.out.println("调用方法的对象：" + arg3);
	}

}
