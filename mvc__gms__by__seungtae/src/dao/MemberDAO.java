package dao;

import java.util.List;
import java.util.Map;

import domain.MemberBean;

public interface MemberDAO {
	public String insert(MemberBean p);
	public List<MemberBean> selectSome(Map<?,?>p);
	public MemberBean selectOne(Map<?,?>p);
	public int count(Map<?,?>p);
	public void update(Map<?,?>p);
	public void delete(Map<?,?>p);
	public boolean exist(Map<?,?>p);
}
