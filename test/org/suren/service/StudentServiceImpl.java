/**
 * Create Date: 2012-1-31<br>
 * File Name: TestServiceImpl.java
 */
package org.suren.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.suren.dao.StudentDao;
import org.suren.entity.Student;
import org.suren.util.Page;


/**
 * @author Administrator<br>
 * Create Time: 05:01:38<br>
 */
@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired
	private StudentDao studentDao;

	/* (non-Javadoc)
	 * @see com.nercis.cbtes.service.StudentService#findByPage(com.nercis.cbtes.entity.Student, com.nercis.cbtes.util.Page)
	 */
	@Override
	public void findByPage(Student student, Page<Student> page)
	{
		studentDao.findByPage(student, page);
	}

	/* (non-Javadoc)
	 * @see com.nercis.cbtes.service.StudentService#findByAge(int)
	 */
	@Override
	public Student findByAge(int age)
	{
		return studentDao.findByAge(age).get(0);
	}

	/* (non-Javadoc)
	 * @see com.nercis.cbtes.service.StudentService#findById(java.lang.String)
	 */
	@Override
	public Student findById(String id)
	{
		Student stu = studentDao.findStuById(id);

		stu.setName("surenyufu");

		return stu;
	}

	/* (non-Javadoc)
	 * @see com.nercis.cbtes.service.StudentService#save(com.nercis.cbtes.entity.Student)
	 */
	@Override
	public void save(Student stu)
	{
		studentDao.saveStudent(stu);
	}

	/* (non-Javadoc)
	 * @see com.nercis.cbtes.service.StudentService#update(com.nercis.cbtes.entity.Student)
	 */
	@Override
	public void update(Student stu)
	{
		studentDao.updateStudent(stu);
	}
}
