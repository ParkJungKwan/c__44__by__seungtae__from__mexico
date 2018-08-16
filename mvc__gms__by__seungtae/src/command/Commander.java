package command;

import javax.servlet.http.HttpServletRequest;

import command.detail.AddCommand;
import command.detail.CountCommand;
import command.detail.FileCommand;
import command.detail.LoginCommand;
import command.detail.ModifyCommand;
import command.detail.MoveCommand;
import command.detail.RemoveCommand;
import command.detail.RetrieveCommand;
import command.detail.SearchCommand;
import command.receiver.Action;

public class Commander {
	public static Command order(
			HttpServletRequest request) {
		Command cmd = null;
		switch(Action.valueOf(request.getParameter("action")
				.toUpperCase())) {
		case ADD : 
		    cmd = new AddCommand(request);
			break;
		case SEARCH: 
			cmd = new SearchCommand(request);
			break;
		case RETRIEVE:
			cmd = new RetrieveCommand(request);
			break;
		case COUNT : 
			cmd = new CountCommand(request);
			break;
		case MODIFY:
			cmd = new ModifyCommand(request);
			break;
		case REMOVE:
			cmd = new RemoveCommand(request);
			break;
		case MOVE:
			cmd = new MoveCommand(request);
			break;
		case LOGIN: 
			cmd = new LoginCommand(request);
			break;
		case FILEUPLOAD: 
			cmd = new FileCommand(request);
			break;
		default:
			break;
		}
		return cmd;
	}

}
