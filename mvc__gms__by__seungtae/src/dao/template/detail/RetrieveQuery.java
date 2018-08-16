package dao.template.detail;

import java.sql.ResultSet;

import dao.template.QueryTemplate;
import dao.template.values.Domain;
import dao.template.values.ImageQuery;
import dao.template.values.MemberQuery;
import domain.ImageBean;
import domain.MemberBean;

public class RetrieveQuery extends QueryTemplate{

	@Override
	public void initialize() {
		switch((Domain)m.get("table")) {
		case MEMBER: 
			m.put("sql", 
					String.format(
							MemberQuery.RETRIEVE.toString(),
							m.get("column"))
					);
			System.out.println("-------------- SQL -------------\n"
					+m.get("sql")
			);
			
			
			break;
		case IMAGE: 
			m.put("sql", 
					String.format(ImageQuery.RETRIEVE.toString(), 
							m.get("column"))
					);
			break;
		default:
			break;
		}
		
	}

	@Override
	public void startPlay() {
		try {
			pstmt.setString(1, (String) m.get("value"));
			ResultSet rs = pstmt.executeQuery();
			MemberBean o = new MemberBean();
			if(rs.next()){
				o.setUserid(rs.getString("USERID"));
				o.setPassword(rs.getString("PASSWORD"));
				o.setTeamid(rs.getString("TEAMID"));
				o.setName(rs.getString("NAME"));
				o.setGender(rs.getString("GENDER"));
				o.setAge(rs.getString("AGE"));
				o.setRoll(rs.getString("ROLL"));
				o.setSsn(rs.getString("SSN"));
			}
			super.o = o;
			System.out.println(super.o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void endPlay() {
		try {
			ResultSet rs = pstmt.executeQuery();
			switch((Domain)m.get("table")) {
			case MEMBER:
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
					o = member;
				}
				break;
			case IMAGE:
				ImageBean img = null;
				while(rs.next()) {
					img = new ImageBean();
					img.setExtension(rs.getString("EXTENSION"));
					img.setImgName(rs.getString("IMG_NAME"));
					img.setUserid(rs.getString("USERID"));
					o = img;
				}
				break;
			default:
				break;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
