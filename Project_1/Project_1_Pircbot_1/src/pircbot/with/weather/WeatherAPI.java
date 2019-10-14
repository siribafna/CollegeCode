package pircbot.with.weather;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class WeatherAPI {

	WeatherAPI() {
	}

	public static boolean isNumber(String location) {
		// method to test and see if its a zipcode or a name
		try {
			Double.parseDouble(location);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}

	}

	public String sendGetLocation(String location, int choice) throws Exception {
		// calls API

		String url = "http://api.openweathermap.org/data/2.5/weather?";

		boolean cityOrZip = isNumber(location);
		Map<String, String> parameters = new HashMap<>();
		if (cityOrZip == false)
			parameters.put("q", location);
		else if (cityOrZip == true)
			parameters.put("zip", location);
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

		// PARSES and calls different methods for getting different responses
		double temperature = getTemperature(response);
		String temp = ("Temperature: " + temperature);
		String description = getDescription(response);

		String tempAndDescrip = (description + " with a temperature of " + temperature);
		if (choice == 1)
			return tempAndDescrip;
		else if (choice == 0)
			return temp;
		else
			return description;

	}

	private String getDescription(String response) {

		String[] input = response.split("Response: ");

		JsonElement jelement = new JsonParser().parse(input[1]);

		JsonObject jobject = jelement.getAsJsonObject();
		JsonArray jarray = jobject.getAsJsonArray("weather");
		jobject = jarray.get(0).getAsJsonObject();
		String result = jobject.get("main").getAsString();

		return result;

	}

	private double getTemperature(String response) {

		String[] input = response.split("Response: ");

		JsonElement jelement = new JsonParser().parse(input[1]);

		JsonObject jobject = jelement.getAsJsonObject();
		jobject = jobject.getAsJsonObject("main");
		double result = jobject.get("temp").getAsDouble();

		result = ((result - 273.15) * 9) / 5 + 32; // format for changing
		return result;

	}

}
