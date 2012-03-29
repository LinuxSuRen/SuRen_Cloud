package org.suren.test.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Net2 {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		ServerSocket serverSocket = new ServerSocket(236);

		Socket socket = serverSocket.accept();

		System.out.println("receive");

		InputStream in = socket.getInputStream();

		byte[] b = new byte[1024];
		int len = -1;
		if((len = in.read(b)) != -1)
		{
			System.out.println(new String(b, 0, len));
		}

		OutputStream out= socket.getOutputStream();

		out.write("hello".getBytes());
	}

}
