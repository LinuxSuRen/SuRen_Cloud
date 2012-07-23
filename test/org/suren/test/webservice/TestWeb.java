//package org.suren.test.webservice;
//
//import java.util.List;
//
//import org.virtualbox_4_1.IConsole;
//import org.virtualbox_4_1.IMachine;
//import org.virtualbox_4_1.ISession;
//import org.virtualbox_4_1.IVirtualBox;
//import org.virtualbox_4_1.VirtualBoxManager;
//
//public class TestWeb
//{
//
//	/**
//	 * @param args
//	 */
//	public static void main(String[] args)
//	{
//		VirtualBoxManager virtualboxManager = VirtualBoxManager.createInstance(null);
//
//		virtualboxManager.connect("http://localhost:18083", "test", "test");
//
//		IVirtualBox vbox = virtualboxManager.getVBox();
//
//		List<IMachine> machines = vbox.getMachines();
//
//		if(machines != null)
//		{
//			for(IMachine m : machines)
//			{
//				String name = m.getName();
//
//				virtualboxManager.startVm(name, null, 6000);
//
//				System.out.println("cpu count:" + m.getCPUCount());
//				System.out.println(m.getDescription());
//				System.out.println("logFolder:" + m.getLogFolder());
//				System.out.println("mem:" + m.getMemorySize());
//
//				try
//				{
//					ISession session = virtualboxManager.openMachineSession(m);
//
//					String warpped = session.getWrapped();
//
//					System.out.println("warpped:" + warpped);
//
//					IConsole console = session.getConsole();
//
//					console.saveState();
//				}
//				catch (Exception e)
//				{
//					e.printStackTrace();
//				}
//			}
//		}
//	}
//
//}
