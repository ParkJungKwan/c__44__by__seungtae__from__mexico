package command.detail;

import javax.servlet.http.HttpServletRequest;

import command.Command;
import domain.MemberBean;
import service.impl.MemberServiceImpl;

public class RemoveCommand extends Command {
	public RemoveCommand(HttpServletRequest request) {
		setRequest(request);
		setAction(request.getParameter("action"));
		setDomain(request.getServletPath().substring(1, 
				request.getServletPath().indexOf(".")));
		execute();
	}
	@Override
	public void execute() {
		if(request.getParameter("password").equals(((MemberBean)(request.getSession().getAttribute("user"))).getPassword())) {
			MemberServiceImpl.getInstance()
			.remove(null);
			request.getSession().invalidate();
		}else {
			request.setAttribute("match", "FALSE");
		}
	}
}
