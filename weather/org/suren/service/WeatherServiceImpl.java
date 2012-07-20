/**
 *
 */
package org.suren.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.suren.dao.WeatherDao;
import org.suren.entity.City;
import org.suren.entity.Weather;

/**
 * @author suren
 *
 */
@Service
public class WeatherServiceImpl implements WeatherService {

	@Autowired
	private WeatherDao dao;

	@Override
	public void save(Weather weather) {
		dao.saveWeather(weather);
	}

	@Override
	public void update(Weather weather) {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Weather> findByCity(City city) {
		Weather weather = new Weather();

		weather.setCity(city);

		return dao.findWeathers(weather);
	}

	@Override
	public List<Weather> findByDate(Date date) {
		Weather weather = new Weather();

		weather.setFetchDate(date);

		return dao.findWeathers(weather);
	}

}
