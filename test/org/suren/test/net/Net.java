package org.suren.test.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;

public class Net {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		DatagramSocket server = new DatagramSocket(1122);

		while(true)
		{
			byte[] b = new byte[1024];
			DatagramPacket packet = new DatagramPacket(b, b.length);

			server.receive(packet);

			System.out.println(new String(packet.getData(), 0, packet.getLength()));
		}
	}

}
