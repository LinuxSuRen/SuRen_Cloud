/**
 * Create Date: 2012-2-9<br>
 * File Name: BeanTest.java
 */
package org.suren.test;

/**
 * @author Administrator<br>
 * Create Time: 03:02:28<br>
 */
public class BeanTest implements BeanTestInterface
{
	private String name;
	
	public BeanTest()
	{
		System.out.println("==========================");
		System.out.println("new BeanTest");
		
		System.out.println("Name : " + name);
		System.out.println("==========================");
	}
	
	public void sayMyName()
	{
		System.out.println("My name is " + name);
	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

}
