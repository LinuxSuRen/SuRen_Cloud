/**
 * Create Date: 2012-2-2<br>
 * File Name: UploadAction.java
 */
package org.suren.action;

import java.io.File;

import org.suren.action.BaseAction;

/**
 * @author Administrator<br>
 * Create Time: 10:02:35<br>
 */
public class UploadAction extends BaseAction
{
	private static final long	serialVersionUID	= 1L;
	public File file;
	
	public String execute()
	{
		LOG.info(file.getAbsolutePath());
		
		return UPLOAD;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(File file)
	{
		this.file = file;
	}

}
