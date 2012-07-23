/**
 *
 */
package org.suren.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.suren.entity.Module;

/**
 * @author suren
 *
 */
@Service
public class ModuleDaoImpl extends BaseDao<Module> implements ModuleDao
{

	@Override
	public void saveModule(Module module)
	{
		this.save(module);
	}

	@Override
	public void delModule(Module module)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public List<Module> findModule(Module module)
	{
		Criteria criteria = this.getCritera();

		if(module != null)
		{
			if(module.getName() != null)
			{
				criteria.add(Restrictions.eq("name", module.getName()));
			}
		}

		return this.findByCriteria(criteria);
	}

	/* (non-Javadoc)
	 * @see org.suren.dao.ModuleDao#updateModule(org.suren.entity.Module)
	 */
	@Override
	public void updateModule(Module module)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public Class<?> setClass()
	{
		return Module.class;
	}

}
