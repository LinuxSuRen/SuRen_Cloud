/**
 *
 */
package org.suren.core;

/**
 * @author suren
 *
 */
public final class SuRenContext {

	private SuRenContext(){}

	public static final String SESSION = "session_user";		/*在HttpSession中保存用户的key*/

	public static final String CONTEXT  = "contextPath";		/*应用路径*/

}
