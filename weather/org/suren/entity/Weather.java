/**
 *
 */
package org.suren.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author suren
 *
 */
@Entity(name = "suren_weather")
public class Weather extends AbstractEntity {
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@GeneratedValue(generator = "uuid")
	private String id;
	private Date fetchDate;
	@ManyToOne
	private City city;
	private Integer low;
	private Integer high;
	private String ico;
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
	 * @return the fetchDate
	 */
	public Date getFetchDate() {
		return fetchDate;
	}
	/**
	 * @param fetchDate the fetchDate to set
	 */
	public void setFetchDate(Date fetchDate) {
		this.fetchDate = fetchDate;
	}
	/**
	 * @return the city
	 */
	public City getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(City city) {
		this.city = city;
	}
	/**
	 * @return the low
	 */
	public Integer getLow() {
		return low;
	}
	/**
	 * @param low the low to set
	 */
	public void setLow(Integer low) {
		this.low = low;
	}
	/**
	 * @return the high
	 */
	public Integer getHigh() {
		return high;
	}
	/**
	 * @param high the high to set
	 */
	public void setHigh(Integer high) {
		this.high = high;
	}
	/**
	 * @return the ico
	 */
	public String getIco() {
		return ico;
	}
	/**
	 * @param ico the ico to set
	 */
	public void setIco(String ico) {
		this.ico = ico;
	}
}
