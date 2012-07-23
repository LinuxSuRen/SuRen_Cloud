/**
 *
 */
package org.suren.test.socket;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author suren
 *
 */
public class FetchJnlp
{

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception
	{
		new FetchJnlp().fetch("10.0.31.62", "ADMIN", "ADMIN", new File("c:/users/suren/desktop"));
	}

	/**
	 * @param host
	 * @param user
	 * @param pwd
	 * @param file 存放jnlp文件的目录
	 * @throws IOException
	 */
	public void fetch(String host, String user, String pwd, File file) throws IOException
	{
		if(file == null)
		{
			return;
		}

		if(file.isDirectory())
		{
			file = new File(file, "jviewer.jnlp");
		}

		String jnlp = fetch(host, user, pwd);

		if(jnlp == null)
		{
			return;
		}

		FileOutputStream fos = new FileOutputStream(file);
		fos.write(jnlp.getBytes());
		fos.close();
	}

	/**
	 * @param host
	 * @param user
	 * @param pwd
	 * @return 获取失败返回null
	 * @throws IOException
	 */
	public File fetchFile(String host, String user, String pwd) throws IOException
	{
		File file = File.createTempFile("suren", "jnlp");

		fetch(host, user, pwd, file);

		return file;
	}

	/**
	 * 获取JNLP文件
	 * @param host
	 * @param user
	 * @param pwd
	 * @return  获取失败返回null
	 * @throws IOException
	 */
	public String fetch(String host, String user, String pwd) throws IOException
	{
		if(host == null || user == null || pwd == null)
		{
			return null;
		}

		Map<String, String> browserInf = new HashMap<String, String>();

		browserInf.put("User-Agent",
				"Mozilla/5.0 (Windows NT 6.1; rv:11.0) Gecko/20100101 Firefox/11.0");

		String sessionText = requestInf("http://" + host + "/rpc/WEBSES/create.asp?" +
				"WEBVAR_USERNAME=" + user + "&WEBVAR_PASSWORD=" + pwd, browserInf);

		browserInf.put("Cookie", "test=1;SessionCookie=" + getSessionCookie(sessionText) + ";Username=" + user + ";1Item=0");

		return requestInf("http://" + host + "/Java/jviewer.jnlp", browserInf);
	}

	/**
	 * 根据给定的URL获取返回信息
	 * @param url
	 * @param pro
	 * @return 发生错误返回null
	 */
	private String requestInf(String url, Map<String, String> pro)
	{
		String content = null;

		try
		{
			HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();

			con.setReadTimeout(3000);
			con.setRequestMethod("GET");

			Set<String> keys = pro.keySet();
			for(String key : keys)
			{
				con.setRequestProperty(key, pro.get(key));
			}

			BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));

			StringBuffer buffer = new StringBuffer();

			String tmp = null;
			while((tmp = reader.readLine()) != null)
			{
				buffer.append(tmp);

				if(tmp.contains("</jnlp>"))
				{
					break;
				}
			}

			reader.close();

			content = buffer.toString();
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return content;
	}

	/**
	 * @param sessionText
	 * @return 如何找不到SESSION_COOKIE，返回null
	 */
	private String getSessionCookie(String sessionText)
	{
		String cookie = sessionText;

		String session_cookie = "'SESSION_COOKIE'";

		int index = sessionText.indexOf(session_cookie);

		if(index == -1)
		{
			return null;
		}

		cookie = cookie.substring(index + session_cookie.length());
		cookie = cookie.substring(cookie.indexOf("'") + 1);
		cookie = cookie.substring(0, cookie.lastIndexOf("'"));

		return cookie;
	}
}
