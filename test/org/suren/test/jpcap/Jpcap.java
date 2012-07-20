package org.suren.test.jpcap;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;

import jpcap.JpcapCaptor;
import jpcap.JpcapSender;
import jpcap.NetworkInterface;
import jpcap.packet.EthernetPacket;
import jpcap.packet.IPPacket;
import jpcap.packet.Packet;
import jpcap.packet.TCPPacket;
import jpcap.packet.UDPPacket;

public class Jpcap  {

	private static final byte[] mac_235 =new byte[] { Integer.valueOf("c4", 16).byteValue(), Integer.valueOf("ca", 16).byteValue(), Integer.valueOf("d9", 16).byteValue(),
		Integer.valueOf("df", 16).byteValue(),	Integer.valueOf("5f", 16).byteValue(), Integer.valueOf("70", 16).byteValue() };

	private static final byte[] mac_10 =new byte[] { Integer.valueOf("c4", 16).byteValue(), Integer.valueOf("ca", 16).byteValue(), Integer.valueOf("d9", 16).byteValue(),
		Integer.valueOf("df", 16).byteValue(),	Integer.valueOf("5f", 16).byteValue(), Integer.valueOf("70", 16).byteValue() };

	private static final byte[] mac_22 =new byte[] { Integer.valueOf("22", 16).byteValue(), Integer.valueOf("22", 16).byteValue(), Integer.valueOf("5e", 16).byteValue(),
		Integer.valueOf("1c", 16).byteValue(),	Integer.valueOf("3d", 16).byteValue(), Integer.valueOf("73", 16).byteValue() };

	private static final byte[] mac_21 =new byte[] { Integer.valueOf("08", 16).byteValue(), Integer.valueOf("00", 16).byteValue(), Integer.valueOf("27", 16).byteValue(),
		Integer.valueOf("3d", 16).byteValue(),	Integer.valueOf("08", 16).byteValue(), Integer.valueOf("28", 16).byteValue() };

	private static InetAddress local;

	private static InetAddress ip_235;

	private static InetAddress ip_21;

	static {
		try {
			local = InetAddress.getByName("10.0.32.22");

			ip_235 = InetAddress.getByName("10.0.31.235");

			ip_21 = InetAddress.getByName("10.0.32.21");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		NetworkInterface[] list = JpcapCaptor.getDeviceList();
		NetworkInterface inter = list[0];

		JpcapCaptor jpcap = JpcapCaptor.openDevice(inter, 2000000, false, 1000);

		int port = 0;

		for (int i = 0; i < 400000000; i++) {
			Packet packet = jpcap.getPacket();

			if(packet != null && packet instanceof IPPacket)
			{
				IPPacket ip = (IPPacket) packet;

				if(ip.toString().indexOf("10.0.21.43") != -1)
				{
					System.out.println(ip);
				}

				if(ip instanceof TCPPacket)
				{
					TCPPacket tcp = (TCPPacket) ip;

//					if(tcp.dst_port == 3456)
//					{
//						print(tcp);
//						System.out.println("***" + tcp);

//						EthernetPacket ether = (EthernetPacket) tcp.datalink;
//						ether.src_mac = mac_22;
//						ether.dst_mac = mac_21;

//						port = tcp.src_port;

//						tcp.dst_port = 8080;
//						tcp.dst_ip = local;

//						tcp.src_port = 1234;
//						tcp.src_ip = local;

//						tcp.datalink = ether;

//						print(tcp);
//						System.out.println("-----" + tcp);
//
//						JpcapSender sender = jpcap.getJpcapSenderInstance();
//
//						sender.sendPacket(tcp);
//						continue;
//					}
				}
				else if(ip instanceof UDPPacket)
				{
					UDPPacket udp = (UDPPacket)ip;
//					System.out.println("^^^^^^^^" + udp.dst_port);
//
//					if(udp.dst_port == 8989)
//					{
//						System.out.println("^^^^^^^^");
//
//						udp.dst_port = 1122;
//
//						JpcapSender sender = jpcap.getJpcapSenderInstance();
//
//						sender.sendPacket(udp);
//					}
				}
			}
		}
	}

	private static void print(TCPPacket packet)
	{
		EthernetPacket ether = (EthernetPacket) packet.datalink;
		System.out.print(packet.src_ip.getHostName() + " + " + packet.src_port + " + " + cover(ether.src_mac) +
				"========>>" + packet.dst_ip.getHostName() + " + " + packet.dst_port + " + " + cover(ether.dst_mac));
	}

	private static String cover(byte[] bs)
	{
		StringBuffer buffer = new StringBuffer();

		for(byte b : bs)
		{
			buffer.append(Integer.toHexString(b & 0xff) + ":");
		}

		return buffer.substring(0, buffer.length() - 1);
	}

	private static byte[] getmac(InetAddress address)
	{
		try {
			java.net.NetworkInterface add = java.net.NetworkInterface.getByInetAddress(address);

			return add.getHardwareAddress();
		} catch (SocketException e) {
			e.printStackTrace();
			return new byte[]{};
		}
	}
}
