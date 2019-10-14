import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class WeatherAPI {
	public static void main(String args[]) throws Exception {
		Scanner userInput = new Scanner(System.in);

		System.out.println("Welcome to the Weather API!!!");
		System.out.print("Start off by entering your desired city/zipcode: ");

		String location = userInput.nextLine();
		System.out.println("Do you want temperature[1] or description[2]?");
		int information = userInput.nextInt();

		System.out.println("Waiting to receive response...");

		WeatherAPI httpCall = new WeatherAPI();
		if (isNumber(location) == false) {
			httpCall.sendGet(location, true, information);
		}
		if (isNumber(location) == true) {
			httpCall.sendGet(location, false, information);
		}

	}

	public static boolean isNumber(String location) {
		try {
			Double.parseDouble(location);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}

	}

	private void sendGet(String city, boolean type, int info) throws Exception {

		String url = "http://api.openweathermap.org/data/2.5/weather?";

		Map<String, String> parameters = new HashMap<>();
		if (type == true)
			parameters.put("q", city);
		else
			parameters.put("zip", city);
		parameters.put("appid", "55a7c6c21fdc8ccf5b74356f68e86169");

		StringBuilder urlBuilder = new StringBuilder();
		urlBuilder.append(url);
		urlBuilder.append(ParameterStringBuilder.getParamsString(parameters));

		URL object = new URL(urlBuilder.toString());
		HttpURLConnection con = (HttpURLConnection) object.openConnection();

		con.setRequestMethod("GET");
		con.setRequestProperty("content-type", "application/json");

		int responseCode = con.getResponseCode();
		String response = FullResponseBuilder.getFullResponse(con);

		if (info == 1)
			getTemperature(response);
		else if (info == 2)
			getDescription(response);

	}

	private void getDescription(String response) {

		String[] input = response.split("Response: ");
		// System.out.println(input[1]);
		JsonElement jelement = new JsonParser().parse(input[1]);

		JsonObject jobject = jelement.getAsJsonObject();
		JsonArray jarray = jobject.getAsJsonArray("weather");
		jobject = jarray.get(0).getAsJsonObject();
		String result = jobject.get("main").getAsString();

		System.out.printf("Response Received! Description: " + result);

	}

	private void getTemperature(String response) {

		String[] input = response.split("Response: ");
		// System.out.println(input[1]);
		JsonElement jelement = new JsonParser().parse(input[1]);

		JsonObject jobject = jelement.getAsJsonObject();
		jobject = jobject.getAsJsonObject("main");
		double result = jobject.get("temp").getAsDouble();

		result = ((result - 273.15) * 9) / 5 + 32; // format for changing
		System.out.printf("Response Received! Temperature(F): " + ("%.2f"), result);

	}
}
