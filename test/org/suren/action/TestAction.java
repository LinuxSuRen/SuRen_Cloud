/**
 * Create Date: 2012-1-31<br>
 * File Name: TestAction.java
 */
package org.suren.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.suren.action.BaseAction;
import org.suren.entity.Student;
import org.suren.service.StudentService;


/**
 * @author Administrator<br>
 * Create Time: 04:01:58<br>
 */
public class TestAction extends BaseAction
{
	private static final long	serialVersionUID	= 1L;
	@Autowired
	private StudentService studentService;
	
	private String id;
	
	public String execute()
	{
		LOG.debug("log4j done.");
		LOG.debug("id : " + id);
		LOG.debug("studentService : " + studentService);
		
		
		Student stu1 = studentService.findById(id);
		Student stu2 = studentService.findById(id);
		
		LOG.debug("stu1 : " + stu1);
		LOG.debug("stu2 : " + stu2);
		
		stu1.setName("testaction");
		
		LOG.debug(stu1 == stu2);
		
//		if(true) return SUCCESS;
		
		LOG.debug("stu1.getAge() : " + stu1.getAge());
		
		stu2.setId(null);
		stu2.setAge(334);
		
		Student stu3 = new Student();
		stu3.setId(stu2.getId());
		stu3.setName("new student");
		
		studentService.update(stu2);
		
		LOG.debug("stu1.getAge() : " + stu1.getAge());
		
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
