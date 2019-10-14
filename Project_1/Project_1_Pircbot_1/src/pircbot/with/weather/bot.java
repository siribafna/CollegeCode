package pircbot.with.weather;

import org.jibble.pircbot.PircBot;

// bot class
public class bot extends PircBot {

	// fields of each API to be used so we can use their methods
	private WeatherAPI wAPI;
	private PlanetsAPI pAPI;
	private YoutubeAPI yAPI;

	public bot() {
		// initialize them when you make a bot
		this.setName("sBafnaBot");
		this.wAPI = new WeatherAPI();
		this.pAPI = new PlanetsAPI();
		this.yAPI = new YoutubeAPI();

	}

	public void onMessage(String channel, String sender, String login, String hostname, String message) {
		// method for testing input output from freeNode

		if (message.contains("weather") && message.contains("in")) { // if message from user contains any of this,

			String[] input = message.split("in ");
			String location = input[1];
			sendMessage(channel, "Weather for " + input[1] + " coming right up!");
			try {
				String output = wAPI.sendGetLocation(location, 1); // call weather api get location
				sendMessage(channel, "Weather: " + output); // and present to user

			} catch (Exception e) {
				sendMessage(channel,
						"Uh oh! Either you entered a misspelled location, or that city does not exist. Try again!");
				e.printStackTrace();
			}
		}
		if (message.contains("temperature") && message.contains("in")) {
			// repeat with temperature
			String[] input = message.split("in ");
			sendMessage(channel, message);
			String location = input[1];
			sendMessage(channel, location);
			sendMessage(channel, "Temperature for " + input[1] + " coming right up!");
			try {
				String output = wAPI.sendGetLocation(location, 0);
				sendMessage(channel, "Temperature(F): " + output);

			} catch (Exception e) {
				sendMessage(channel,
						"Uh oh! Either you entered a misspelled location, or that city does not exist. Try again!");
				e.printStackTrace();
			}
		}
		if (message.contains("weather description") && message.contains("for")) {
			// repeat with description

			String[] input = message.split("for ");
			String location = input[1];
			sendMessage(channel, "Weather description for " + input[1] + " coming right up!");
			try {
				String location2 = wAPI.sendGetLocation(location, -1);
				sendMessage(channel, "Weather description:" + location2);

			} catch (Exception e) {
				sendMessage(channel,
						"Uh oh! Either you entered a wrong location, or that city does not exist. Try again!");
				e.printStackTrace();
			}
		}

		if (message.contains("hey") || message.contains("hello")) {
			// to regulate casual conversation
			sendMessage(channel,
					"Hello " + sender + "! Ask me anything and I'll respond! Ex. Weather in Frisco, Gravity in Mars");
		}

		if (message.equalsIgnoreCase("how are you?")) {
			sendMessage(channel, "I'm doin' great, how are you " + sender + " ?");
		}

		if (message.contains("gravity") && message.contains("in")) {
			// to test the space Api

			String[] input = message.split("in ");
			String planet = input[1];
			sendMessage(channel, "Gravity Pressure in " + input[1] + " coming right up!");
			try {
				String output = pAPI.sendGet(planet, 2); // call method in the api
				sendMessage(channel, "Gravity Pressure (SI UNITS) : " + output);

			} catch (Exception e) {
				sendMessage(channel,
						"Uh oh! Either you entered a misspelled planet, or that planet does not exist. You know Pluto isn't a planet anymore right? Try again!");
				e.printStackTrace();
			}
		}

		if (message.contains("youtube")) {
			// to test the youtube api
			String[] categories = new String[32];
			try {
				categories = yAPI.sendGet();
				for (int i = 0; i < categories.length; i++) {
					sendMessage(channel, ((i + 1) + ") " + categories[i])); // call method in api and present through an
																			// array
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
