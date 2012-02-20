/**
 * Create Date: 2012-2-2<br>
 * File Name: DownloadAction.java
 */
package org.suren.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.suren.action.BaseAction;

/**
 * @author Administrator<br>
 * Create Time: 11:02:18<br>
 */
public class DownloadAction extends BaseAction
{

	private static final long	serialVersionUID	= 1L;
	private String fileName;
	
	public String execute()
	{
		fileName = "suren.txt";
		
		return DOWNLOAD;
	}
	
	public InputStream getInputStream() throws FileNotFoundException
	{
		return new FileInputStream(new File("D:/Work/Tom Clancy's H.A.W.X/HAWX.exe"));
	}

	/**
	 * @return the fileName
	 */
	public String getFileName()
	{
		return fileName;
	}

}
