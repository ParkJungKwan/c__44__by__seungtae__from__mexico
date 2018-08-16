package service;

import java.util.List;
import java.util.Map;
import domain.MemberBean;

public interface MemberService {
	public String add(MemberBean p);
	public List<MemberBean> search(Map<?,?>p);
	public MemberBean retrieve(Map<?,?>p);
	public int count(Map<?,?>p);
	public void modify(Map<?,?>p);
	public void remove(Map<?,?>p);
	public boolean exist(Map<?,?>p);
}
