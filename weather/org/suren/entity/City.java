/**
 *
 */
package org.suren.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author suren
 *
 */
@Entity(name = "suren_city")
public class City extends AbstractEntity {
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	private String id;
	private String name;
	private Long latitude_e6;
	private Long longitude_e6;
	/**
	 * @param name
	 * @param latitude_e6
	 * @param longitude_e6
	 */
	public City() {
	}
	/**
	 * @param name
	 * @param latitude_e6
	 * @param longitude_e6
	 */
	public City(String name, Long latitude_e6, Long longitude_e6) {
		this.name = name;
		this.latitude_e6 = latitude_e6;
		this.longitude_e6 = longitude_e6;
	}
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
	 * @return the latitude_e6
	 */
	public Long getLatitude_e6() {
		return latitude_e6;
	}
	/**
	 * @param latitude_e6 the latitude_e6 to set
	 */
	public void setLatitude_e6(Long latitude_e6) {
		this.latitude_e6 = latitude_e6;
	}
	/**
	 * @return the longitude_e6
	 */
	public Long getLongitude_e6() {
		return longitude_e6;
	}
	/**
	 * @param longitude_e6 the longitude_e6 to set
	 */
	public void setLongitude_e6(Long longitude_e6) {
		this.longitude_e6 = longitude_e6;
	}

}
