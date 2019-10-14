import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class PlanetsAPI {
	public static void main(String args[]) throws Exception {

		System.out.println("Welcome to the Planet API!");
		System.out.println(
				"This API program will give you a few of the moons and gravity pressure of the planet of your choice!! ");
		String[] planetsArray = new String[] { "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus",
				"Neptune" };

		PlanetsAPI httpCall = new PlanetsAPI();
		String userChoice = getUserChoice(planetsArray);

		httpCall.sendGet(userChoice);
	}

	private static String getUserChoice(String[] planetsArray) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter any one of the 8 planets that you want information for: ");
		boolean loop = true;
		while (loop) {
			String userChoice = input.nextLine();
			for (int i = 0; i < planetsArray.length; i++) {
				if (userChoice.equalsIgnoreCase(planetsArray[i])) {
					return userChoice;
				}
			}
			System.out.println("Try again! Your choice is either spelled incorrectly or does not exist.");
		}
		return "";
	}

	private void sendGet(String planet) throws Exception {

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

		parseAndDisplayMoons(response);
		parseAndDisplayGravity(response);

	}

	public void parseAndDisplayMoons(String response) {
		String[] input = response.split("Response: ");
		System.out.println("Waiting to receive response from the API...");
		System.out.println();
		System.out.println("Moons: ");

		JsonElement jelement = new JsonParser().parse(input[1]);
		JsonObject jobject = jelement.getAsJsonObject();
		JsonArray jarray = jobject.getAsJsonArray("moons");
		for (int i = 0; i < jarray.size(); i++) {
			jobject = jarray.get(i).getAsJsonObject();
			String result = jobject.get("moon").getAsString();
			System.out.print(result + " ");
		}
		System.out.println();
	}

	public void parseAndDisplayGravity(String response) {
		String[] input = response.split("Response: ");
		System.out.print("Gravity(SI Units): ");

		JsonElement jelement = new JsonParser().parse(input[1]);
		JsonObject jobject = jelement.getAsJsonObject();
		String gravity = jobject.get("gravity").getAsString();
		System.out.print(gravity);
	}

}