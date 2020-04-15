import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class HackBot {
	public static void main(String[] args) throws Exception {
		String server = "irc.freenode.net";
		String nick = "simple_bot";
		String login = "simple_bot";
		
		String channel = "#irchacks";
		
		Socket socket = new Socket(server, 6667);
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	
		writer.write("NICK " + nick + "\r\n");
		writer.write("USER " + login + " 8 * : Java IRC Hacks Bot\r\n");
		writer.flush();
		
		String line = null;
		while((line = reader.readLine()) != null) {
			if(line.indexOf("004") >= 0) {
				break;
			}
			else if(line.indexOf("433") >= 0) {
				System.out.println("Nickname is already in use");
				return;
			}
		}
	
		writer.write("JOIN " + channel + "\r\n");
		writer.flush();
		
		while((line = reader.readLine()) != null) {
			if(line.toLowerCase().startsWith("PING")) {
				writer.write("PONG " + line.substring(5) + "\r\n");
				writer.write("PRIVMSG " + channel + " :I got pinged!\r\n");
				writer.flush();
			}
			else {
				System.out.println(line);
			}
		}
	
	
	}

}
