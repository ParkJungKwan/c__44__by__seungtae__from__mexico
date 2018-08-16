package command.detail;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import command.Command;
import dao.template.values.Domain;
import domain.MemberBean;
import service.impl.ImageServiceImpl;
import service.impl.MemberServiceImpl;

public class RetrieveCommand extends Command{
	
	public RetrieveCommand(HttpServletRequest request) {
		setRequest(request);
		setDomain(request.getServletPath().substring(1, 
				request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		execute();
	}
	@Override
	public void execute() {
		super.execute();
		if(request.getParameter("table") != null) {
			Map<String,Object> map = new HashMap<>();
			map.put("table", request.getParameter("table"));
			map.put("column", request.getParameter("option"));
			map.put("value", request.getParameter("word"));
			request.getSession().setAttribute("user", 
					MemberServiceImpl
					.getInstance()
					.retrieve(map)
					);
		}
		
		request.getSession().setAttribute("profile", 
						"/upload/"
						+(ImageServiceImpl.getInstance().retrieve(null))
					);
	}
}
