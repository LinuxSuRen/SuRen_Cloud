/**
 *
 */
package org.suren.dao;

import org.suren.entity.Module;
import java.util.List;

/**
 * @author suren
 *
 */
public interface ModuleDao
{
	void saveModule(Module module);

	void delModule(Module module);

	List<Module> findModule(Module module);

	void updateModule(Module module);

}
