/**
 *
 */
package org.suren.dao;

import java.util.List;

import org.suren.entity.Weather;

/**
 * @author suren
 *
 */
public interface WeatherDao {
	Weather findWeather(Weather weather);

	List<Weather> findWeathers(Weather weather);

	void saveWeather(Weather weather);

}
