package dao.template.detail;


import java.sql.ResultSet;

import dao.template.QueryTemplate;
import dao.template.values.MemberQuery;
import domain.MemberBean;

public class SearchQuery extends QueryTemplate{

	@Override
	public void initialize() {
		m.put("sql", 
				(!m.containsKey("column"))?
					String.format(
							MemberQuery.LIST.toString(), 
							((String)m.get("domain")))
					:
					String.format(
							MemberQuery.SEARCH.toString(),
							((String)m.get("domain")),
							((String)m.get("column")).toUpperCase())
					
				);
	}

	@Override
	public void startPlay() {
		try {
			int j = 0;
			if(m.containsKey("column")) {
				j++;
				pstmt.setString(j, 
					"%"+((String)m.get("value"))+"%");
			}
			j++;
			pstmt.setString(j, 
					(String)m.get("beginRow"));
			j++;
			pstmt.setString(j, (String)m.get("endRow"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void endPlay() {
		try {
			ResultSet rs = pstmt.executeQuery();
			MemberBean member = null;
			while(rs.next()) {
				member = new MemberBean();
				member.setUserid(rs.getString("USERID"));
				member.setPassword(rs.getString("PASSWORD"));
				member.setTeamid(rs.getString("TEAMID"));
				member.setName(rs.getString("NAME"));
				member.setGender(rs.getString("GENDER"));
				member.setAge(rs.getString("AGE"));
				member.setRoll(rs.getString("ROLL"));
				member.setSsn(rs.getString("SSN"));
				l.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
