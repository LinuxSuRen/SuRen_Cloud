/**
 * Create Date: 2012-2-1<br>
 * File Name: TestDaoImpl.java
 */
package org.suren.dao;

import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.suren.dao.BaseDao;
import org.suren.entity.Student;
import org.suren.util.Page;


/**
 * @author Administrator<br>
 * Create Time: 01:02:50<br>
 */
@Service
public class StudentDaoImpl extends BaseDao<Student> implements StudentDao
{
	/* (non-Javadoc)
	 * @see com.nercis.cbtes.dao.StudentDao#findByPage(org.hibernate.Criteria, com.nercis.cbtes.util.Page)
	 */
	@Override
	public void findByPage(Student student, Page<Student> page)
	{
		Criteria criteria = this.getCritera();
		
		this.findByCriteria(criteria, page);
	}

	/* (non-Javadoc)
	 * @see com.nercis.cbtes.dao.BaseDao#setClass()
	 */
	@Override
	public
	Class<?> setClass()
	{
		return Student.class;
	}

	/* (non-Javadoc)
	 * @see com.nercis.cbtes.dao.StudentDao#findByAge(int)
	 */
	@Override
	public List<Student> findByAge(int age)
	{
		Criteria criteria = this.getCritera();
		
		criteria.add(Restrictions.eq("age", age));
		
		criteria.setCacheable(true);
		criteria.setCacheMode(CacheMode.GET);
		
		return criteria.list();
	}

	/* (non-Javadoc)
	 * @see com.nercis.cbtes.dao.StudentDao#findById(java.lang.String)
	 */
	@Override
	public Student findStuById(String id)
	{
//		return this.findById(id, true);
		return this.findById(id);
	}

	/* (non-Javadoc)
	 * @see com.nercis.cbtes.dao.StudentDao#saveStudent(com.nercis.cbtes.entity.Student)
	 */
	@Override
	public Student saveStudent(Student stu)
	{
		this.save(stu);
		
		return stu;
	}

	/* (non-Javadoc)
	 * @see com.nercis.cbtes.dao.StudentDao#updateStudent(com.nercis.cbtes.entity.Student)
	 */
	@Override
	public Student updateStudent(Student stu)
	{
		this.update(stu, false);
		
		return stu;
	}

}
