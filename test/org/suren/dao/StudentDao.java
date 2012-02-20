/**
 * Create Date: 2012-2-1<br>
 * File Name: TestDao.java
 */
package org.suren.dao;

import java.util.List;

import org.suren.entity.Student;
import org.suren.util.Page;


/**
 * @author Administrator<br>
 * Create Time: 01:02:06<br>
 */
public interface StudentDao
{
	void findByPage(Student student, Page<Student> page);
	
	List<Student> findByAge(int age);
	
	Student findStuById(String id);
	
	Student saveStudent(Student stu);
	
	Student updateStudent(Student stu);
}
