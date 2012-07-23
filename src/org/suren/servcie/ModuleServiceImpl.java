/**
 *
 */
package org.suren.servcie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.suren.dao.ModuleDao;
import org.suren.entity.Module;

/**
 * @author suren
 *
 */
@Service
public class ModuleServiceImpl implements ModuleService
{
	@Autowired
	private ModuleDao dao;

	/*
	 * 保存模块，如果参数为null，则直接返回
	 */
	@Override
	public void save(Module module)
	{
		if(module == null)
		{
			return;
		}

		dao.saveModule(module);
	}

	/* (non-Javadoc)
	 * @see org.suren.servcie.ModuleService#delModule(org.suren.entity.Module)
	 */
	@Override
	public void delModule(Module module)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public List<Module> findModule(Module module)
	{
		return dao.findModule(module);
	}

	/* (non-Javadoc)
	 * @see org.suren.servcie.ModuleService#findByID(java.lang.String)
	 */
	@Override
	public Module findByID(String id)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
