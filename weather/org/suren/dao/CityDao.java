/**
 *
 */
package org.suren.dao;

import java.util.List;

import org.suren.entity.City;

/**
 * @author suren
 *
 */
public interface CityDao {
	City findCity(City city);

	List<City> findCities(City city);

	void saveCity(City city);

}
