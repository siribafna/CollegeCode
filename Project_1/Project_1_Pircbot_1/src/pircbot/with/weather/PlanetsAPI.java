package pircbot.with.weather;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class PlanetsAPI {

	PlanetsAPI() {
	}

	public String sendGet(String planet, int choice) throws Exception {

		// calls the API
		String url = "https://api.le-systeme-solaire.net/rest/bodies/{" + planet + "}?";

		Map<String, String> parameters = new HashMap<>();
		parameters.put("exclude", "id");

		StringBuilder urlBuilder = new StringBuilder();
		urlBuilder.append(url);
		urlBuilder.append(ParameterStringBuilder.getParamsString(parameters));

		URL object = new URL(urlBuilder.toString());
		HttpURLConnection con = (HttpURLConnection) object.openConnection();

		con.setRequestMethod("GET");
		con.setRequestProperty("content-type", "application/json");

		int responseCode = con.getResponseCode();
		String response = FullResponseBuilder.getFullResponse(con);

		if (choice == 2)
			return parseAndDisplayGravity(response); // calls the gravity method
		else
			return "";

	}

	public String parseAndDisplayGravity(String response) {
		String[] input = response.split("Response: ");
		System.out.print("Gravity(SI Units): ");

		// parses and returns
		JsonElement jelement = new JsonParser().parse(input[1]);
		JsonObject jobject = jelement.getAsJsonObject();
		String gravity = jobject.get("gravity").getAsString();
		return gravity;
	}

}