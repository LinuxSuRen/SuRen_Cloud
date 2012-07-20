/**
 *
 */
package org.suren.task;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.suren.action.BaseAction;
import org.suren.entity.City;
import org.suren.entity.Weather;
import org.suren.service.CityService;
import org.suren.service.WeatherService;

/**
 * @author suren
 *
 */
public class WeatherTask extends QuartzJobBean{

	protected static final Logger log = Logger.getLogger(BaseAction.class);

	@Override
	protected void executeInternal(JobExecutionContext jobexecutioncontext)
			throws JobExecutionException {
		Object cityObj = jobexecutioncontext.getJobDetail().getJobDataMap().get("cityService");
		Object weatherObj = jobexecutioncontext.getJobDetail().getJobDataMap().get("weatherService");

		CityService cityService;
		WeatherService weatherService;

		if(cityObj instanceof CityService && weatherObj instanceof WeatherService)
		{
			cityService = (CityService) cityObj;
			weatherService = (WeatherService) weatherObj;
		}
		else
		{
			log.error("cityService or weatherService is not enable.");
			return;
		}

		try {
			URL url = new URL("http://www.google.com/ig/api?hl=zh-cn&weather=,,,38849998,115569999");

			log.debug("get weather from " + url);

			SAXReader reader = new SAXReader();
			reader.setEncoding("utf8");

			Document doc = reader.read(url.openStream());
			Element root = doc.getRootElement();

			Element w = root.element("weather");

			Element info = w.element("forecast_information");

			String latitude = info.element("latitude_e6").attributeValue("data");
			String longitude = info.element("longitude_e6").attributeValue("data");

			City city = new City();

			city.setLatitude_e6(Long.valueOf(latitude));
			city.setLongitude_e6(Long.valueOf(longitude));

			if((city = cityService.findCity(city) )!= null)
			{
				log.debug("found city : " + city);
				Weather weather = new Weather();

				weather.setCity(city);

				List<Element> forecast_conditions = w.elements("forecast_conditions");
				if(forecast_conditions == null || forecast_conditions.size() < 1)
				{
					log.warn("forecast_conditions not matcd.");
					return;
				}

				String low = forecast_conditions.get(0).element("low").attributeValue("data");
				String high = forecast_conditions.get(0).element("high").attributeValue("data");
				String ico = forecast_conditions.get(0).element("icon").attributeValue("data");

				weather.setLow(Integer.valueOf(low));
				weather.setHigh(Integer.valueOf(high));
				weather.setIco(ico);
				weather.setFetchDate(new  Date());

				weatherService.save(weather);

				log.debug("save weather success.");
			}
		} catch (MalformedURLException e) {
			log.error(e.getMessage());
		} catch (DocumentException e) {
			log.error(e.getMessage());
		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}
}
