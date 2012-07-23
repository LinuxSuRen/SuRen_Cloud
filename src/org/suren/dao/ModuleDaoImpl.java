/**
 *
 */
package org.suren.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.suren.entity.Module;
import org.suren.util.string.StringUtil;

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
		module.setCreateDate(new Date());

		this.save(module);
	}

	@Override
	public void delModule(Module module)
	{
	}

	@Override
	public List<Module> findModule(Module module)
	{
		Criteria criteria = this.getCritera();

		if(module != null)
		{
			if(StringUtil.isNotEmpty(module.getId()))
			{
				criteria.add(Restrictions.eq("id", module.getId()));
			}

			if(module.getName() != null)
			{
				criteria.add(Restrictions.eq("name", module.getName()));
			}
		}

		return this.findByCriteria(criteria);
	}

	@Override
	public void updateModule(Module module)
	{
		this.update(module);
	}

	@Override
	public Class<?> setClass()
	{
		return Module.class;
	}

}
