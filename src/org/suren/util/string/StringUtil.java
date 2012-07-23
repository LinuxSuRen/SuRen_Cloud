/**
 * Create Date: 2012-2-1<br>
 * File Name: StringUtil.java
 */
package org.suren.util.string;

/**
 * @author Administrator<br>
 * Create Time: 03:02:28<br>
 * 字符串处理常用方法
 */
public class StringUtil
{

	public static boolean isEmpty(String str)
	{
		return str == null || "".equals(str);
	}

	public static boolean isNotEmpty(String str)
	{
		return str != null && !"".equals(str);
	}

	public static boolean equals(String arg1, String arg2)
	{
		if((arg1 == null && arg2 == null) || arg1.equals(arg2))
		{
			return true;
		}

		return false;
	}

	public static boolean notEquals(String arg1, String arg2)
	{
		return !equals(arg1, arg2);
	}
}
