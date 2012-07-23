/**
 *
 */
package org.suren.entity;

import java.io.Serializable;

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
	private String link;
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
	 * @return the link
	 */
	public String getLink()
	{
		return link;
	}
	/**
	 * @param link the link to set
	 */
	public void setLink(String link)
	{
		this.link = link;
	}
}
