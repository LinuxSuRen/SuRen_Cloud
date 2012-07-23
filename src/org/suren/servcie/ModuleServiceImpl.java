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

	@Override
	public Module findByID(String id)
	{
		Module module = new Module();

		module.setId(id);

		List<Module> modules = findModule(module);

		return modules != null ? modules.get(0) : null;
	}

	@Override
	public void update(Module module)
	{
		dao.updateModule(module);
	}
}
