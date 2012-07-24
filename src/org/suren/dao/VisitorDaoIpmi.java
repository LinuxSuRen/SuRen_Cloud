/**
 *
 */
package org.suren.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.suren.entity.Visitor;
import org.suren.util.string.StringUtil;

/**
 * @author suren
 *
 */
@Service
public class VisitorDaoIpmi extends BaseDao<Visitor> implements VisitorDao
{

	@Override
	public void saveModule(Visitor visitor)
	{
		if(visitor != null)
		{
			visitor.setDate(new Date());

			this.save(visitor);
		}
	}

	@Override
	public List<Visitor> findVisitors(Visitor visitor)
	{
		Criteria criteria = this.getCritera();

		if(visitor != null)
		{
			if(StringUtil.isNotEmpty(visitor.getId()))
			{
				criteria.add(Restrictions.eq("id", visitor.getId()));
			}
		}

		return this.findByCriteria(criteria);
	}

	@Override
	public Class<?> setClass()
	{
		return Visitor.class;
	}

}
