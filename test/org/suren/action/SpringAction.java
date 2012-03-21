/**
 * Create Date: 2012-2-9<br>
 * File Name: SpringAction.java
 */
package org.suren.action;

import org.suren.test.BeanTestInterface;


/**
 * @author Administrator<br>
 * Create Time: 04:02:06<br>
 */
public class SpringAction extends BaseAction
{

	private static final long	serialVersionUID	= 1L;

	private BeanTestInterface beanTest;

	public String execute()
	{
		System.out.println("BeanTest : " + beanTest);

		beanTest.sayMyName();

		return SUCCESS;
	}

	/**
	 * @param beanTest the beanTest to set
	 */
	public void setBeanTest(BeanTestInterface beanTest)
	{
		this.beanTest = beanTest;
	}

}
