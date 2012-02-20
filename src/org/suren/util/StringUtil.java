/**
 * Create Date: 2012-2-1<br>
 * File Name: StringUtil.java
 */
package org.suren.util;

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
}
