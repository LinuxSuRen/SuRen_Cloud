/**
 * Create Date: 2012-1-31<br>
 * File Name: TestService.java
 */
package org.suren.service;

import org.suren.entity.Student;
import org.suren.util.Page;



/**
 * @author Administrator<br>
 * Create Time: 05:01:41<br>
 */
public interface StudentService
{
	void findByPage(Student student, Page<Student> page);
	
	Student findByAge(int age);
	
	Student findById(String id);
	
	void save(Student stu);
	
	void update(Student stu);
}
