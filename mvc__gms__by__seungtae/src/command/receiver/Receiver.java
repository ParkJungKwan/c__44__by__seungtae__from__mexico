package command.receiver;

import javax.servlet.http.HttpServletRequest;

import command.Command;
import command.Commander;

public class Receiver {
	public static Command cmd = new Command();
	public static void init(HttpServletRequest request) {
		cmd = Commander.order(request);
	}
}
