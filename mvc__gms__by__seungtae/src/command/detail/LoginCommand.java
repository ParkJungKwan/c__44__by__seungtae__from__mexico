package command.detail;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import command.Command;
import dao.template.values.Domain;
import domain.MemberBean;
import service.impl.ImageServiceImpl;
import service.impl.MemberServiceImpl;

public class LoginCommand extends Command {
	public LoginCommand(HttpServletRequest request) {
		setRequest(request);
		setAction(request.getParameter("action"));
		setDomain(request.getServletPath().substring(1,
						request.getServletPath().indexOf(".")));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		super.execute();
		Map<String,Object> p = new HashMap<>();
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		p.put("userid",userid);
		p.put("password", password);
		boolean exist = MemberServiceImpl.getInstance().exist(p);
		if(exist) {
			request.setAttribute("match", "TRUE");
			p.put("table", Domain.MEMBER);
			p.put("column", "USERID");
			p.put("value", p.get("userid"));
			MemberBean member = MemberServiceImpl.getInstance()
					.retrieve(p);
			request.getSession().setAttribute("user",member);
			/*request.getSession().setAttribute(
					"profile", 
					"/upload/"+ImageServiceImpl.getInstance()
						.retrieve(null));*/
		}else {
			request.setAttribute("match", "FALSE");
		}
	}
}
