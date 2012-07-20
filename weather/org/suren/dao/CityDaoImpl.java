/**
 *
 */
package org.suren.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.suren.entity.City;

/**
 * @author suren
 *
 */
@Service
public class CityDaoImpl extends BaseDao<City> implements CityDao {

	/*
	 * 如果根据给定的条件能找到一条记录则返回该记录，否则返回null
	 * @see org.suren.dao.CityDao#findCity(org.suren.entity.City)
	 */
	@Override
	public City findCity(City city) {
        Criteria criteria = this.getCritera();

        if(city.getLatitude_e6() != null)
        {
            criteria.add(Restrictions.eq("latitude_e6", city.getLatitude_e6()));
        }

        if(city.getLongitude_e6() != null)
        {
            criteria.add(Restrictions.eq("longitude_e6", city.getLongitude_e6()));
        }

        List<City> cities = this.findByCriteria(criteria);

        return cities != null && cities.size() > 0 ? cities.get(0) : null;
    }

	/* (non-Javadoc)
	 * @see org.suren.dao.CityDao#findCities(org.suren.entity.City)
	 */
	@Override
	public List<City> findCities(City city) {
        Criteria criteria = this.getCritera();

        if(city.getLatitude_e6() != null)
        {
            criteria.add(Restrictions.eq("latitude_e6", city.getLatitude_e6()));
        }

        if(city.getLongitude_e6() != null)
        {
            criteria.add(Restrictions.eq("longitude_e6", city.getLongitude_e6()));
        }

        if(city.getName() != null)
        {
        	criteria.add(Restrictions.like("name", "%" + city.getName() + "%"));
        }

        return this.findByCriteria(criteria);
    }

	/* (non-Javadoc)
	 * @see org.suren.dao.CityDao#saveCity(org.suren.entity.City)
	 */
	@Override
	public void saveCity(City city) {
		this.save(city);
	}

	@Override
	public Class<?> setClass() {
		return City.class;
	}

}
