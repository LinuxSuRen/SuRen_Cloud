/**
 *
 */
package org.suren.service;

import java.util.Date;
import java.util.List;

import org.suren.entity.City;
import org.suren.entity.Weather;

/**
 * @author suren
 *
 */
public interface WeatherService {

	void save(Weather weather);

	void update(Weather weather);

	List<Weather> findByCity(City city);

	List<Weather> findByDate(Date date);

}
