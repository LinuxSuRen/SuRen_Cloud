/**
 *
 */
package org.suren.util;

import java.io.File;

import javax.swing.filechooser.FileSystemView;

/**
 * @author suren
 *
 */
public class Cumputer {

	public static  void main(String[] args)
	{
		FileSystemView view = FileSystemView.getFileSystemView();

//		println(view.getDefaultDirectory());
//
//		println(view.getHomeDirectory());

		File[] files = view.getRoots();
		for(File file : files)
		{
			File[] files1 = view.getFiles(file, true);

			for(File f : files1)
			{
				println(f);
			}
		}
	}

	private static void print(Object obj)
	{
		System.out.print(obj);
	}

	private static void println(Object obj)
	{
		System.out.println(obj);
	}

}
