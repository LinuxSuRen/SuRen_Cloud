/**
 *
 */
package org.suren.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author suren
 *
 */
@Entity(name = "suren_visitor")
public class Visitor extends AbstractEntity implements Serializable
{

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	private String id;
	private String userID;
	private String remoteAddr;
	private String remoteHost;
	private String userAgent;
	private String referrer;
	private Date date;
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
	 * @return the userID
	 */
	public String getUserID()
	{
		return userID;
	}
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(String userID)
	{
		this.userID = userID;
	}
	/**
	 * @return the remoteAddr
	 */
	public String getRemoteAddr()
	{
		return remoteAddr;
	}
	/**
	 * @param remoteAddr the remoteAddr to set
	 */
	public void setRemoteAddr(String remoteAddr)
	{
		this.remoteAddr = remoteAddr;
	}
	/**
	 * @return the remoteHost
	 */
	public String getRemoteHost()
	{
		return remoteHost;
	}
	/**
	 * @param remoteHost the remoteHost to set
	 */
	public void setRemoteHost(String remoteHost)
	{
		this.remoteHost = remoteHost;
	}
	/**
	 * @return the userAgent
	 */
	public String getUserAgent()
	{
		return userAgent;
	}
	/**
	 * @param userAgent the userAgent to set
	 */
	public void setUserAgent(String userAgent)
	{
		this.userAgent = userAgent;
	}
	/**
	 * @return the referrer
	 */
	public String getReferrer()
	{
		return referrer;
	}
	/**
	 * @param referrer the referrer to set
	 */
	public void setReferrer(String referrer)
	{
		this.referrer = referrer;
	}
	/**
	 * @return the date
	 */
	public Date getDate()
	{
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date)
	{
		this.date = date;
	}
}
