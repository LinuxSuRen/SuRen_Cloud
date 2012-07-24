/**
 *
 */
package org.suren.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.dispatcher.Dispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.suren.entity.Module;
import org.suren.servcie.ModuleService;
import org.suren.util.string.StringUtil;

import com.opensymphony.xwork2.config.entities.ActionConfig;

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
	private List<String> actions;

	/*
	 * 显示module列表
	 */
	@Override
	public String execute()
	{
		modules = service.findModule(null);

		return SUCCESS;
	}

	/**
	 * 保存module信息
	 * @return
	 */
	public String save()
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

		return "save";
	}

	/**
	 * 新增、编辑module
	 * @return
	 */
	public String edit()
	{
		Map<String, Map<String, ActionConfig>> configs = Dispatcher.getInstance().
				getConfigurationManager().getConfiguration().
				getRuntimeConfiguration().getActionConfigs();
		actions = new ArrayList<String>();

		Set<String> namespaces = configs.keySet();
		for(String namespace : namespaces)
		{
			Map<String, ActionConfig> map = (Map<String, ActionConfig>)configs.get(namespace);
			Set<String> actionNames = map.keySet();

			for(String actionName : actionNames)
			{
				actions.add(("".equals(namespace) ? "" : namespace + "/") + actionName);
			}
		}

		if(module != null && StringUtil.isEmpty(module.getId()))
		{
			module = service.findByID(module.getId());
		}

		return "edit";
	}

	public String checkName()
	{
		if(module != null && StringUtil.isNotEmpty(module.getName()))
		{
			module = service.findByName(module.getName());

			System.out.println(module.getName());
		}
		else
		{
			module = null;
		}

		return JSON;
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

	/**
	 * @return the actions
	 */
	public List<String> getActions()
	{
		return actions;
	}
}
