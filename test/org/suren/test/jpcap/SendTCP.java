package org.suren.test.jpcap;

import java.net.InetAddress;

import jpcap.*;
import jpcap.packet.EthernetPacket;
import jpcap.packet.IPPacket;
import jpcap.packet.TCPPacket;

public class SendTCP {
	public static void main(String[] args) throws java.io.IOException {
		NetworkInterface[] devices = JpcapCaptor.getDeviceList();

		args = new String[1];
		args[0] = "0";

		if (args.length < 1) {
			System.out
					.println("Usage: java SentTCP <device index (e.g., 0, 1..)>");
			for (int i = 0; i < devices.length; i++)
				System.out.println(i + ":" + devices[i].name + "("
						+ devices[i].description + ")");
			System.exit(0);
		}

		int index = Integer.parseInt(args[0]);
		JpcapSender sender = JpcapSender.openDevice(devices[index]);

		TCPPacket p = new TCPPacket(8080, 22, 56, 78, false, false, false, false,
				true, true, true, true, 10, 10);

		p.setIPv4Parameter(0, false, false, false, 0, false, false, false, 0,
				1010101, 100, IPPacket.IPPROTO_TCP,
				InetAddress.getByName("10.0.32.22"),
				InetAddress.getByName("10.0.31.10"));

		p.data = ("data").getBytes();

		EthernetPacket ether = new EthernetPacket();

		ether.frametype = EthernetPacket.ETHERTYPE_IP;
		ether.src_mac = new byte[] { Integer.valueOf("22", 16).byteValue(), Integer.valueOf("22", 16).byteValue(), Integer.valueOf("5e", 16).byteValue(), Integer.valueOf("1c", 16).byteValue(),
				Integer.valueOf("3d", 16).byteValue(), Integer.valueOf("73", 16).byteValue() };

		ether.dst_mac =new byte[] { Integer.valueOf("c4", 16).byteValue(), Integer.valueOf("ca", 16).byteValue(), Integer.valueOf("d9", 16).byteValue(), Integer.valueOf("df", 16).byteValue(),
				Integer.valueOf("5f", 16).byteValue(), Integer.valueOf("70", 16).byteValue() };

		p.datalink = ether;

		for (int i = 0; i < 3; i++)
		{
			sender.sendPacket(p);
		}
	}
}