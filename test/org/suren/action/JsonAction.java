/**
 * Create Date: 2012-2-2<br>
 * File Name: JsonAction.java
 */
package org.suren.action;

import org.apache.struts2.json.annotations.JSON;
import org.suren.action.BaseAction;

/**
 * @author Administrator<br>
 * Create Time: 09:02:22<br>
 */
public class JsonAction extends BaseAction
{
	private static final long	serialVersionUID	= 1L;
	public String text;
	public String noget;
	public String other;
	public String mark;
	public String format;
	
	public String execute()
	{
		text = "json success";
		format = "format";
		
		return JSON;
	}

	/**
	 * @return the text
	 */
	public String getText()
	{
		return text;
	}

	/**
	 * @return the other
	 */
	public String getOther()
	{
		return other;
	}

	/**
	 * @return the mark
	 */
	@JSON(serialize = false)
	public String getMark()
	{
		return mark;
	}

	/**
	 * @return the format
	 */
	@JSON(format = "test")
	public String getFormat()
	{
		return format;
	}
}
