/**
 *
 */
package org.suren.util.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;


/**
 * @author suren
 *
 */
public class DBHolder {

	private static final Logger log = Logger.getLogger(DBHolder.class);

	public static void backup(String script) throws IOException
	{
		Process process = Runtime.getRuntime().exec(script);

		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

		String str = null;
		while((str = reader.readLine()) != null)
		{
			log.debug(str);
		}
	}

	public static void restore(String script)
	{
		//
	}

}
