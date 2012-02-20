/**
 * Create Date: 2012-2-17<br>
 * File Name: Abstract_1.java
 */
package org.suren.test;

/**
 * @author Administrator<br>
 * Create Time: 04:02:38<br>
 */
public abstract class Abstract_1 extends Abstract implements Interface_1, Interface_2
{

	/* (non-Javadoc)
	 * @see com.nercis.cbtes.test.Interface_2#_2()
	 */
	@Override
	public void _2()
	{
	}

	/* (non-Javadoc)
	 * @see com.nercis.cbtes.test.Interface_3#_3()
	 */
	@Override
	public void _3()
	{
	}

	/* (non-Javadoc)
	 * @see com.nercis.cbtes.test.Abstact#_abs()
	 */
	@Override
	void _abs()
	{
	}
	
	public static void main(String[] args)
	{
		int a = 1;
		
		switch(a)
		{
			default : System.out.println("default");
			case 1 : System.out.println(1);
			case 2 : System.out.println(2);return;
			case 3 : System.out.println(3);
		}
		
		System.out.println("return");
	}

}
