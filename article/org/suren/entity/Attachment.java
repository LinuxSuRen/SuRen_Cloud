/**
 *
 */
package org.suren.entity;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author suren
 *
 */
@Entity(name = "suren_attachment")
public class Attachment extends AbstractEntity implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	private String id;
	@Column(nullable = false)
	@Lob
	private Blob content;
	@Column(nullable = false)
	private String name;
	private String type;
	private Date uploadTime;
	@ManyToOne(fetch = FetchType.LAZY)
	private User uploadUser;
	private String remark;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the content
	 */
	public Blob getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(Blob content) {
		this.content = content;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the uploadTime
	 */
	public Date getUploadTime() {
		return uploadTime;
	}
	/**
	 * @param uploadTime the uploadTime to set
	 */
	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}
	/**
	 * @return the uploadUser
	 */
	public User getUploadUser() {
		return uploadUser;
	}
	/**
	 * @param uploadUser the uploadUser to set
	 */
	public void setUploadUser(User uploadUser) {
		this.uploadUser = uploadUser;
	}
	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
