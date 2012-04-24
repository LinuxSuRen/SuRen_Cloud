/**
 *
 */
package org.suren.test.host;

import java.io.File;

/**
 * @author suren
 *
 */
public class Host {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File[] roots = File.listRoots();

		for(File root : roots)
		{
			System.out.println(root.getPath());
		}
	}

}
