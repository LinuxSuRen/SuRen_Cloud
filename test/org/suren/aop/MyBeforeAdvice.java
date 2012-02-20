/**
 * Create Date: 2012-2-9<br>
 * File Name: MyBeforeAdvice.java
 */
package org.suren.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;


/**
 * @author Administrator<br>
 * Create Time: 04:02:54<br>
 */
public class MyBeforeAdvice implements MethodBeforeAdvice
{

	/* (non-Javadoc)
	 * @see org.springframework.aop.MethodBeforeAdvice#before(java.lang.reflect.Method, java.lang.Object[], java.lang.Object)
	 */
	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable
	{
		System.out.println("方法调用钱。。。");
		System.out.println("调用的方法是： " + arg0);
		System.out.println("调用方法的参数是：" + arg1);
		System.out.println("目标对象：" + arg2);
	}

}
