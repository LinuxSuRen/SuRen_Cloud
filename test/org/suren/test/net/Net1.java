package org.suren.test.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Net1 {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		DatagramSocket client = new DatagramSocket();

		InetAddress address = InetAddress.getByName("10.0.32.22");

		byte[] b = new String("hello 1234").getBytes();
		DatagramPacket packet = new DatagramPacket(b, b.length, address, 8989);

		client.send(packet);
	}

}
