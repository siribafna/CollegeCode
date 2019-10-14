/*
 * PircBot class project
 * Siri Bafna
 * Purpose: use Pircbot and Freenode and create a chatting system with different means of APIS
 */

package pircbot.with.weather;

import java.io.IOException;

import org.jibble.pircbot.IrcException;

public class ChatBot {

	// chatBot class inspired from PircBot initialization website
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bot ChatBot = new bot();
		ChatBot.setVerbose(true);
		try {
			ChatBot.connect("irc.freenode.net");
		} catch (IOException | IrcException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ChatBot.joinChannel("#siriBafnaChannel"); // needs to change into actual channel name

	}

}
