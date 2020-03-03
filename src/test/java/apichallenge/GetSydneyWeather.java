package apichallenge;


import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Properties;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class GetSydneyWeather {

	Properties prop = new Properties();
	FileInputStream fis;
	
	
	//Load configuration properties file to read all the test data
	@BeforeTest
	public void setup() throws IOException {
		fis = new FileInputStream("config.properties");

		prop.load(fis);
	}

	//Fetch Sydney weather on Thursdays and verify if the temperature is warmer than 10 degrees
	@Test
	public void verifySydneyWeatherOnThursdays()

	{

		LocalDate dt = LocalDate.now();

		float actualTemperatureonThursday = 0.0f;

		float expectedTemperatureonThursday = 10.0f;

		String expectedLocation = "Australia/Sydney";

		String actualLocation;

		LocalDate expectedThursdayDate = dt.with(TemporalAdjusters.next(DayOfWeek.THURSDAY));

		RestAssured.baseURI = prop.getProperty("baseURI");

		Response res = RestAssured.given().when()
				.get(prop.getProperty("sydneyWeatherAPIResource")).then().assertThat()
				.contentType(ContentType.JSON).statusCode(200).extract().response();

		JsonPath js = new JsonPath(res.asString());

		int count = js.get("data.size()");

		System.out.println("Json Response size" + count);

		actualLocation = js.get("timezone");

		System.out.println("actualLocation is" + actualLocation);

		for (int i = 0; i < count; i++) {
			
			String strDate = js.get("data[" + i + "].valid_date");

			LocalDate actualDate = LocalDate.parse(strDate);

			boolean isEqual = expectedThursdayDate.isEqual(actualDate);

			if (isEqual == true) {
				actualTemperatureonThursday = js.get("data[" + i + "].high_temp");

				System.out.println("actualTemperatureonThursday" + actualTemperatureonThursday);

			}
		}

		Assert.assertEquals(expectedLocation, actualLocation);

		assertTrue(actualTemperatureonThursday > expectedTemperatureonThursday);

	}
}
