/**
 *
 */
package org.suren.test.xml;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @author suren
 *
 */
public class WeatherXML {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		URL url = new URL("http://www.google.com/ig/api?hl=zh-cn&weather=,,,116000000,40000000");

		InputStream stream = url.openStream();

		File file = new File("d:/wea.xml");

		SAXReader reader = new SAXReader();

		Document doc = reader.read(file);

		reader.setEncoding("utf8");
		doc = reader.read(stream);

		Element root = doc.getRootElement();

		Element weather = root.element("weather");

		List<Element> forecast_conditions = weather.elements("forecast_conditions");

		for(Element forecast_condition : forecast_conditions)
		{
			System.out.println(forecast_condition.element("low").attribute("data"));
		}

		url = new URL("http://www.google.com/ig/cities?output=xml&hl=en-us&country=cn");
		url = new URL("http://www.google.com/ig/countries?output=xml&hl=en-us");

		stream = url.openStream();

		byte[] b = new byte[1024];
		int len;

		while((len = stream.read(b)) != -1)
		{
			System.out.println(new String(b, 0, len));
		}
	}

}
