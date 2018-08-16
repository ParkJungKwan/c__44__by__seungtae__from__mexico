package domain;

import lombok.Data;

@Data 
public class MemberBean {
	private String userid,
			ssn, 
			name,
			gender,
			age,
			roll, 
			teamid,
			password;
}
