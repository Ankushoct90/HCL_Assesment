package api_scenario;

import static com.jayway.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.jayway.restassured.response.Response;

public class APITest {

	Map<String, String> map = new HashMap<String, String>();
	ObjectMapper mapper = new ObjectMapper();

	static String stationURL = "https://api.openweathermap.org/data/3.8/stations";

	private static final String APIKEY = "796fcdc13ca93d640a1bf5d21ed14232";

	// Test 1
	
	public void testServiceWithoutApiKey() throws IOException {

		int expectedCode = 401;
		String expectedErrorMsg = "Invalid API key. Please see http://openweathermap.org/faq#error401 for more info.";

		Response res = given().contentType("application/json").accept("application/json").when().get(stationURL)
				.thenReturn();

		assertEquals(res.getStatusCode(), expectedCode);

		JsonNode jn = mapper.readTree(res.getBody().asString());
		assertEquals(jn.get("message").asText(), expectedErrorMsg);
		System.out.println("Error Message from API " + jn.get("message").asText());
		System.out.println("Code from API " + res.getStatusCode());
	}

	// Test 2
	
	public void testregisterFirstStations() throws IOException {
		int expectedCode = 201;
		map.put("appid", APIKEY);
		ObjectNode rootNode = mapper.createObjectNode();

		String interViewStationName1 = "Interview Station " + randomStringGenerator("ANK");
		rootNode.put("external_id", "DEMO_TEST001");
		rootNode.put("name", interViewStationName1);
		rootNode.put("latitude", "33.33");
		rootNode.put("longitude", "-111.43");
		rootNode.put("altitude", "444");

		String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
		

		Response res = given().contentType("application/json").accept("application/json").when().body(jsonString)
				.queryParams(map).post(stationURL).thenReturn();

		System.out.println(res.getStatusCode() + " is the resposnse code ");

		assertEquals(res.getStatusCode(), expectedCode);

	}

	// Test 3
	
	public void getAddedStations() {
		map.put("appid", APIKEY);
		Response res = given().contentType("application/json").accept("application/json").when().queryParams(map)
				.get(stationURL).thenReturn();

		String response = res.getBody().asString();

		// we can use response for assert

	}

	public String randomStringGenerator(String textToAppend) {
		String randString;

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		String systemDate = dateFormat.format(date).replaceAll(" ", "").replaceAll(":", "").replaceAll("/", "");
		randString = textToAppend.concat(systemDate);
		return randString;
	}
	/*
	 * public static void main(String[] args) { Test t = new Test();
	 * t.testServiceWithoutApiKey();
	 * 
	 * }
	 */

}

/*
 * String body = "{\"external_id\": \"Interview1 \",\r\n" +
 * "\"name\": \"NNBG Tst Station 1234\", \"latitude\": 33.44,\r\n" +
 * "\"longitude\": -12.44,\r\n" + "\"altitude\": 444 \r\n" + "}";
 */