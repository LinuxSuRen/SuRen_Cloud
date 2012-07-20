/**
 *
 */
package org.suren.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.suren.dao.CityDao;
import org.suren.entity.City;

/**
 * @author suren
 *
 */
@Service
public class CityServiceIpml implements CityService {
	@Autowired
	private CityDao dao;

	@Override
	public void save(City city) {
		dao.saveCity(city);
	}

	@Override
	public void saves(List<City> cities) {
		for(City city : cities)
		{
			dao.saveCity(city);
		}
	}

	@Override
	public List<City> findAll() {
		return dao.findCities(new City());
	}

	@Override
	public List<City> findCities(City city) {
		return dao.findCities(city);
	}

	@Override
	public City findCity(City city) {
		return dao.findCity(city);
	}

}
