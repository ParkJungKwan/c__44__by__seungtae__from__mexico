package dao.template.detail;

import java.sql.SQLException;

import dao.template.QueryTemplate;
import dao.template.values.Domain;
import dao.template.values.MemberQuery;

public class RemoveQuery extends QueryTemplate{

	@Override
	public void initialize() {
		switch((Domain)(m.get("table"))) {
		case MEMBER : 
			m.put("sql", MemberQuery.DELETE.toString());
			break;
		default:
			break;
		}
	}

	@Override
	public void startPlay() {
		for(int i = 1;i<(((String)m.get("sql")).split("\\?")).length;i++) {
			try {
				pstmt.setString(i, (String)m.get("value"+i));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void endPlay() {
		try {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
