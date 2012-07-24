/**
 *
 */
package org.suren.dao;

import java.util.List;

import org.suren.entity.Visitor;

/**
 * @author suren
 *
 */
public interface VisitorDao
{
	void saveModule(Visitor visitor);

	List<Visitor> findVisitors(Visitor visitor);
}
