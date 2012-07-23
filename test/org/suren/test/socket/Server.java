/**
 *
 */
package org.suren.test.socket;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author suren
 *
 */
public class Server
{

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception
	{
		ServerSocket serverSocket = new ServerSocket(9999);

		while(true)
		{
			Socket socket = serverSocket.accept();

			InputStream in = socket.getInputStream();

			byte[] b = new byte[1024];
			int len = -1;
			while((len = in.read(b)) != -1)
			{
				System.out.println(new String(b, 0, len));
			}
		}
	}

}
