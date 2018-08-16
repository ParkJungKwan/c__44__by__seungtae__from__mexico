package dao.template.detail;
import java.sql.ResultSet;

import dao.template.QueryTemplate;
import dao.template.values.MemberQuery;
public class CountQuery extends QueryTemplate{

	@Override
	public void initialize() {
		m.put("sql", 
				(m.get("column")!=null)?
				String.format(
				MemberQuery.SEARCHED_COUNT.toString(),
				m.get("column").toString())
				:MemberQuery.COUNT.toString());
	}

	@Override
	public void startPlay() {
		if(m.get("column")!=null) {
			try {
				pstmt.setString(1, 
						"%"+(String) m.get("value")+"%");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void endPlay() {
		try {
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				n = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
