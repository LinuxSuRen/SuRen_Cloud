package org.suren.test.jpcap;

import java.io.IOException;
import java.net.InetAddress;

import jpcap.JpcapCaptor;
import jpcap.JpcapSender;
import jpcap.NetworkInterface;
import jpcap.packet.ARPPacket;
import jpcap.packet.EthernetPacket;
import jpcap.packet.IPPacket;

public class Jpcap implements Runnable {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		NetworkInterface[] list = JpcapCaptor.getDeviceList();
		NetworkInterface inter = list[0];

		JpcapCaptor jpcap = JpcapCaptor.openDevice(inter, 2000, false, 1000);
//		jpcap.setFilter("arp", true);

		byte[] srcMac = inter.mac_address;
		byte[] dstMac = new byte[] {
				(byte) Integer.valueOf("ff", 16).byteValue(),
				(byte) Integer.valueOf("ff", 16).byteValue(),
				(byte) Integer.valueOf("ff", 16).byteValue(),
				(byte) Integer.valueOf("ff", 16).byteValue(),
				(byte) Integer.valueOf("ff", 16).byteValue(),
				(byte) Integer.valueOf("ff", 16).byteValue() };

		ARPPacket arpPacket = new ARPPacket();
		arpPacket.hardtype = ARPPacket.HARDTYPE_ETHER;
		arpPacket.prototype = ARPPacket.PROTOTYPE_IP;
		arpPacket.operation = ARPPacket.RARP_REPLY;
		arpPacket.hlen = 6;
		arpPacket.plen = 4;
		arpPacket.sender_hardaddr = srcMac;
		arpPacket.sender_protoaddr = InetAddress.getByName("10.0.32.62")
				.getAddress();
		arpPacket.target_hardaddr = dstMac;
		arpPacket.target_protoaddr = InetAddress.getByName("10.0.31.111")
				.getAddress();

		EthernetPacket ether = new EthernetPacket();

		ether.frametype = EthernetPacket.ETHERTYPE_ARP;
		ether.src_mac = srcMac;
		ether.dst_mac = dstMac;
		arpPacket.datalink = ether;

		JpcapSender sender = jpcap.getJpcapSenderInstance();

		for (int i = 0; i < 100000; i++) {
//			sender.sendPacket(arpPacket);

			System.out.println(jpcap.getPacket());
		}
	}

	@Override
	public void run() {
		try {
			NetworkInterface[] list = JpcapCaptor.getDeviceList();
			NetworkInterface inter = list[0];

			JpcapCaptor jpcap = JpcapCaptor.openDevice(inter, 2000, false, 1000);

			jpcap.setFilter("ip", true);

			for (int i = 0; i < 100; i++) {
				IPPacket packet = (IPPacket) jpcap.getPacket();

				System.out.println(packet);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
