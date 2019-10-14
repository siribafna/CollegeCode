import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class YouTubeAPI {
	public static void main(String args[]) throws Exception {

		System.out.println("Welcome to the YouTube API!");
		System.out.println("The following API will be showing all the video categories that Youtube provides.");

		YouTubeAPI httpCall = new YouTubeAPI();
		httpCall.sendGet();
	}

	private void sendGet() throws Exception {

		String url = "https://www.googleapis.com/youtube/v3/videoCategories?";

		Map<String, String> parameters = new HashMap<>();
		parameters.put("key", "AIzaSyDzUhKxzDrUumuSiaWzaps86S66nr3F_JQ");
		parameters.put("part", "snippet");
		parameters.put("regionCode", "US");

		StringBuilder urlBuilder = new StringBuilder();
		urlBuilder.append(url);
		urlBuilder.append(ParameterStringBuilder.getParamsString(parameters));
		// System.out.println(" URL >>> " + urlBuilder.toString());

		URL object = new URL(urlBuilder.toString());
		HttpURLConnection con = (HttpURLConnection) object.openConnection();

		con.setRequestMethod("GET");
		con.setRequestProperty("content-type", "application/json");

		int responseCode = con.getResponseCode();
		String response = FullResponseBuilder.getFullResponse(con);

		parseAndDisplayResponse(response);

	}

	public void parseAndDisplayResponse(String response) {
		String[] input = response.split("Response: ");
		System.out.println("Waiting to receive response from the API...");

		JsonElement jelement = new JsonParser().parse(input[1]);

		System.out.println("Video Categories:");
		for (int i = 0; i < 32; i++) {
			JsonObject jobject = jelement.getAsJsonObject();
			JsonArray jarray = jobject.getAsJsonArray("items");
			jobject = jarray.get(i).getAsJsonObject();
			jobject = jobject.getAsJsonObject("snippet");
			String result = jobject.get("title").getAsString();
			System.out.println("                 " + (i + 1) + ") " + result);
		}

	}

}
