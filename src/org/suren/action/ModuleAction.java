/**
 *
 */
package org.suren.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.suren.entity.Module;
import org.suren.servcie.ModuleService;
import org.suren.util.string.StringUtil;

/**
 * @author suren
 *
 */
public class ModuleAction extends BaseAction
{
	private static final long	serialVersionUID	= 1L;

	@Autowired
	private ModuleService service;

	private List<Module> modules;
	private Module module;

	@Override
	public String execute()
	{
		modules = service.findModule(null);

		return SUCCESS;
	}

	public String edit()
	{
		if(StringUtil.isEmpty(module.getId()))
		{
			LOG.debug("add a module");

			service.save(module);
		}
		else
		{
			LOG.debug("edit module");

			service.update(module);
		}

		return "edit";
	}

	/**
	 * @return the modules
	 */
	public List<Module> getModules()
	{
		return modules;
	}

	/**
	 * @return the module
	 */
	public Module getModule()
	{
		return module;
	}

	/**
	 * @param module the module to set
	 */
	public void setModule(Module module)
	{
		this.module = module;
	}
}
