/**
 * 处理模块相关的业务逻辑
 */
package org.suren.servcie;

import java.util.List;

import org.suren.entity.Module;

/**
 * @author suren
 *
 */
public interface ModuleService
{
	/**
	 * 保存模块
	 * @param module
	 */
	void save(Module module);

	/**
	 * 根据模块的属性删除
	 * @param module
	 */
	void delModule(Module module);

	List<Module> findModule(Module module);

	/**
	 * 根据模块id来查找，找不到返回null
	 * @param id
	 * @return
	 */
	Module findByID(String id);

	void update(Module module);

}
