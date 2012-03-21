/**
 *
 */
package org.suren.servcie;

import org.suren.entity.User;

/**
 * @author suren
 *
 */
public interface UserService {

	void save(User user);

	User find(User user);
}
