/**
 *
 */
package org.suren.servcie;

import java.util.List;

import org.suren.entity.Visitor;

/**
 * @author suren
 *
 */
public interface VisitorService
{
	void save(Visitor visitor);

	List<Visitor> find(Visitor visitor);
}
