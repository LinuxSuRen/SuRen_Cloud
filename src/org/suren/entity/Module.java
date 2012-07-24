/**
 *
 */
package org.suren.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author suren
 *
 */
@Entity(name = "suren_module")
public class Module extends AbstractEntity implements Serializable
{

	private static final long	serialVersionUID	= 1L;
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	private String id;
	@Column(unique = true, nullable = true)
	private String name;
	private String action;
	private String home;
	private Boolean visible;
	private String desc;
	private Date createDate;
	private Date modifyDate;

	/**
	 * @return the id
	 */
	public String getId()
	{
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id)
	{
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	/**
	 * @return the action
	 */
	public String getAction()
	{
		return action;
	}
	/**
	 * @param action the action to set
	 */
	public void setAction(String action)
	{
		this.action = action;
	}
	/**
	 * @return the home
	 */
	public String getHome()
	{
		return home;
	}
	/**
	 * @param home the home to set
	 */
	public void setHome(String home)
	{
		this.home = home;
	}
	/**
	 * @return the visible
	 */
	public Boolean getVisible()
	{
		return visible;
	}
	/**
	 * @param visible the visible to set
	 */
	public void setVisible(Boolean visible)
	{
		this.visible = visible;
	}
	/**
	 * @return the desc
	 */
	public String getDesc()
	{
		return desc;
	}
	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc)
	{
		this.desc = desc;
	}
	/**
	 * @return the createDate
	 */
	public Date getCreateDate()
	{
		return createDate;
	}
	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}
	/**
	 * @return the modifyDate
	 */
	public Date getModifyDate()
	{
		return modifyDate;
	}
	/**
	 * @param modifyDate the modifyDate to set
	 */
	public void setModifyDate(Date modifyDate)
	{
		this.modifyDate = modifyDate;
	}
}
