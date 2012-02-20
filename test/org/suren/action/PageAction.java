/**
 * Create Date: 2012-2-2<br>
 * File Name: PageAction.java
 */
package org.suren.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.suren.action.BaseAction;
import org.suren.entity.Student;
import org.suren.service.StudentService;
import org.suren.util.Page;


/**
 * @author Administrator<br>
 * Create Time: 01:02:51<br>
 */
public class PageAction extends BaseAction
{

	private static final long	serialVersionUID	= 1L;

	private Page<Student> paging;
	@Autowired
	private StudentService studentService;
	
	public String execute()
	{
		paging = paging == null ? new Page<Student>() : paging;
		
		studentService.findByPage(new Student(), paging);
		
		return SUCCESS;
	}

	/**
	 * @return the paging
	 */
	public Page<Student> getPaging()
	{
		return paging;
	}

	/**
	 * @param paging the paging to set
	 */
	public void setPaging(Page<Student> paging)
	{
		this.paging = paging;
	}

}
