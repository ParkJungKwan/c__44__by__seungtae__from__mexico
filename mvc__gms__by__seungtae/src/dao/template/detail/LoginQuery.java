package dao.template.detail;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.template.QueryTemplate;
import dao.template.values.MemberQuery;
import domain.MemberBean;

public class LoginQuery extends QueryTemplate{

	@Override
	public void initialize() {
		m.put("sql", MemberQuery.LOGIN.toString());
		
	}

	@Override
	public void startPlay() {
		try {
			pstmt.setString(1, (String) m.get("userid"));
			pstmt.setString(2, (String) m.get("password"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void endPlay() {
		try {
			o = (pstmt.executeQuery().next());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
