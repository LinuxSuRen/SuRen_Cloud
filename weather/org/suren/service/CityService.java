/**
 *
 */
package org.suren.service;

import java.util.List;

import org.suren.entity.City;

/**
 * @author suren
 *
 */
public interface CityService {

	void save(City city);

	void saves(List<City> cities);

	List<City> findAll();

	List<City> findCities(City city);

	City findCity(City city);

}
