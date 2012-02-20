/**
 * Create Date: 2012-2-1<br>
 * File Name: Page.java
 */
package org.suren.util;

import java.util.List;

/**
 * @author Administrator<br>
 * Create Time: 03:02:41<br>
 * 用于数据库分页查询：
 * title，作为当前分页的标题
 * current，作为当前分页的页码，默认为0
 * totoal，总的记录数
 * size，每一页的记录数，默认为15条
 * result，当前页的记录
 */
public class Page<T>
{
	private String title;
	private int start = 0;
	private int limit = 15;
	private int total;
	private int current = 0;
	private int size;
	private int next;
	private int previous;
	private List<T> result;
	/**
	 * @return the title
	 */
	public String getTitle()
	{
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}
	/**
	 * @return the start
	 */
	public int getStart()
	{
		return start;
	}
	/**
	 * @param start the start to set
	 */
	public void setStart(int start)
	{
		this.start = start;
	}
	/**
	 * @return the limit
	 */
	public int getLimit()
	{
		return limit;
	}
	/**
	 * @param limit the limit to set
	 */
	public void setLimit(int limit)
	{
		this.limit = limit;
	}
	/**
	 * @return the total
	 */
	public int getTotal()
	{
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(int total)
	{
		this.total = total;
	}
	/**
	 * @return the current
	 */
	public int getCurrent()
	{
		current = start / limit + 1;
		
		return current;
	}
	/**
	 * @return the size
	 */
	public int getSize()
	{
		size = total / limit + (total % limit == 0 ? 0 : 1);
		
		return size;
	}
	/**
	 * @return the next
	 */
	public int getNext()
	{
		next = start + limit;
		
		next = next > total ? -1 : next;
		
		return next;
	}
	/**
	 * @return the previous
	 */
	public int getPrevious()
	{
		previous = start - limit;
		
		previous = previous < 0 ? -1 : previous;
		
		return previous;
	}
	/**
	 * @return the result
	 */
	public List<T> getResult()
	{
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(List<T> result)
	{
		this.result = result;
	}

}
