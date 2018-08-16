package dao.template.detail;

import dao.template.QueryTemplate;
import dao.template.values.MemberQuery;
import domain.MemberBean;

public class UpdateQuery extends QueryTemplate{

	@Override
	public void initialize() {
		m.put("sql", 
				String.format(
					MemberQuery.UPDATE.toString(),
					"PASSWORD",
					"TEAMID",
					"ROLL")
				);
	}

	@Override
	public void startPlay() {
		try {
			pstmt.setString(1, ((MemberBean)m.get("member")).getPassword());
			pstmt.setString(2, ((MemberBean)m.get("member")).getTeamid());
			pstmt.setString(3, ((MemberBean)m.get("member")).getRoll());
			pstmt.setString(4, ((MemberBean)m.get("member")).getUserid());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void endPlay() {
		try {
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
