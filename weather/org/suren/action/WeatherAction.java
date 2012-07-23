/**
 *
 */
package org.suren.action;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.suren.entity.City;
import org.suren.service.CityService;

/**
 * @author suren
 *
 */
public class WeatherAction extends BaseAction {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private CityService cityService;

	private List<City> cities;

	@Override
	public String execute()
	{
		cities = cityService.findAll();

		return SUCCESS;
	}

	/**
	 * 初始化数据
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 */
	public  String init() throws DocumentException, IOException
	{
		URL url = new URL("http://www.google.com/ig/cities?output=xml&hl=en-us&country=cn");

		SAXReader reader = new SAXReader();
		reader.setEncoding("utf8");

		Document doc = reader.read(url.openStream());
		Element root = doc.getRootElement();
		Element cities = root.element("cities");

		List<Element> cityList = cities.elements("city");
		for(Element ele : cityList)
		{
			String name = ele.element("name").attributeValue("data");
			String latitude = ele.element("latitude_e6").attributeValue("data");
			String longitude = ele.element("longitude_e6").attributeValue("data");

			City city = new City(name, Long.valueOf(latitude), Long.valueOf(longitude));

			cityService.save(city);
		}

		return "init";
	}

	/**
	 * @return the cities
	 */
	public List<City> getCities() {
		return cities;
	}

}
