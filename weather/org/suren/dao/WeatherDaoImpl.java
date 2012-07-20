/**
 *
 */
package org.suren.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import org.suren.entity.Weather;

/**
 * @author suren
 *
 */
@Service
public class WeatherDaoImpl extends BaseDao<Weather> implements WeatherDao {

    @Override
    public Weather findWeather(Weather weather) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.suren.dao.WeatherDao#findWeather(org.suren.entity.Weather)
     */
    @Override
    public List<Weather> findWeathers(Weather weather) {
        Criteria criteria = this.getCritera();

        if(weather.getCity() != null)
        {
            criteria.add(Restrictions.eq("city", weather.getCity()));
        }

        if(weather.getFetchDate() != null)
        {
            criteria.add(Restrictions.eq("date", weather.getFetchDate()));
        }

        return this.findByCriteria(criteria);
    }

    /* (non-Javadoc)
     * @see org.suren.dao.WeatherDao#saveWeather(org.suren.entity.Weather)
     */
    @Override
    public void saveWeather(Weather weather) {
       this.save(weather);
    }

    @Override
    public Class<?> setClass() {
        return Weather.class;
    }

}
