package dao.template.detail;
import dao.template.QueryTemplate;
import dao.template.values.Domain;
import dao.template.values.ImageQuery;
import dao.template.values.MemberQuery;
public class AddQuery extends QueryTemplate{

	@Override
	public void initialize() {
		switch((Domain) m.get("table")) {
		case MEMBER: 
			m.put("sql",MemberQuery.INSERT.toString());
			break;
		case IMAGE: 
			m.put("sql", ImageQuery.INSERT.toString());
			break;
		
		default:
			break;
		
		}
	}
	@Override
	public void startPlay() {
		try {
			for(int i=1;i<((String)m.get("sql")).split("\\?").length;i++) {
				pstmt.setString(i, m.get("value"+i).toString());
			}
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
