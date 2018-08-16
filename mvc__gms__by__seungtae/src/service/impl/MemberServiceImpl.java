package service.impl;

import java.util.List;
import java.util.Map;

import dao.impl.MemberDAOImpl;
import domain.MemberBean;
import service.MemberService;

public class MemberServiceImpl implements MemberService{
	private static MemberService instance = new MemberServiceImpl();
	public static MemberService getInstance() {return instance;}
	private MemberServiceImpl() {}
	
	@Override
	public String add(MemberBean p) {
		return MemberDAOImpl.getInstance().insert(p);
	}
	@Override
	public List<MemberBean> search(Map<?,?>p) {
		return MemberDAOImpl.getInstance().selectSome(p);
	}
	@Override
	public MemberBean retrieve(Map<?,?>p) {
		return MemberDAOImpl.getInstance().selectOne(p);
	}
	@Override
	public int count(Map<?,?>p) {
		return MemberDAOImpl.getInstance().count(p);
	}
	@Override
	public void modify(Map<?,?>p) {
		MemberDAOImpl.getInstance().update(p);
		
	}
	@Override
	public void remove(Map<?,?>p) {
		MemberDAOImpl.getInstance().delete(p);
	}
	@Override
	public boolean exist(Map<?, ?> p) {
		return MemberDAOImpl.getInstance().exist(p);
	}
}
