/**
 * Create Date: 2012-2-3<br>
 * File Name: CacheAction.java
 */
package org.suren.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.suren.action.BaseAction;
import org.suren.entity.Student;
import org.suren.service.StudentService;


/**
 * @author Administrator<br>
 * Create Time: 11:02:22<br>
 */
@SuppressWarnings("serial")
public class CacheAction extends BaseAction
{
	@Autowired
	private StudentService studentService;
	
	private String id;
	
	public String execute()
	{
//		studentService.findByAge(2);
		
		log.debug("id :" + id);
		
		Student stu = studentService.findById(id);
		
		log.debug(stu == null);
		
		stu.getAge();
		
//		log.debug(stu == null);
		
		return SUCCESS;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id)
	{
		this.id = id;
	}

}
