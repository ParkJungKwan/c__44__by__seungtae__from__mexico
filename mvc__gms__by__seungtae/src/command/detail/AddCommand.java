package command.detail;

import javax.servlet.http.HttpServletRequest;

import command.Command;
import dao.template.values.Domain;
import domain.MemberBean;
import proxy.ParamMap;
import service.impl.MemberServiceImpl;

public class AddCommand extends Command{
	public AddCommand(HttpServletRequest request) {
		setRequest(request);
		setAction(request.getParameter("action"));
		setDomain(request.getServletPath()
				.substring(1, 
						request.getServletPath().indexOf(".")));
		setPage(request.getParameter("page"));
		execute();
	}
	
	@Override
	public void execute() {
		switch(Domain.valueOf(domain.toUpperCase())) {
		case MEMBER : 
			MemberBean member = new MemberBean();
			member.setUserid(request.getParameter("userid"));
			member.setPassword(request.getParameter("pass"));
			member.setName(request.getParameter("name"));
			member.setSsn(request.getParameter("ssn"));
			member.setGender(request.getParameter("gender"));
			member.setAge(request.getParameter("age"));
			member.setRoll(request.getParameter("roll"));
			member.setTeamid(request.getParameter("teamid"));
			//member.setSubject(ParamMap.getValues(request, "subject"));
			MemberServiceImpl.getInstance().add(member);
			break;
		default:
			break;
		}
		super.execute();
	}
}
