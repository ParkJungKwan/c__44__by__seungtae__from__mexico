package dao.impl;

import java.util.*;

import dao.MemberDAO;
import dao.template.*;
import dao.template.detail.AddQuery;
import dao.template.detail.CountQuery;
import dao.template.detail.LoginQuery;
import dao.template.detail.RemoveQuery;
import dao.template.detail.RetrieveQuery;
import dao.template.detail.SearchQuery;
import dao.template.detail.UpdateQuery;
import dao.template.values.Domain;
import domain.*;

public class MemberDAOImpl implements MemberDAO{
	private QueryTemplate q;
	private static MemberDAO instance = new MemberDAOImpl();
	public static MemberDAO getInstance() {return instance;}
	private MemberDAOImpl() {}
	
	@Override
	public MemberBean selectOne(Map<?,?>p) {
		q = new RetrieveQuery();
		q.play(p);
		return (MemberBean) q.getO();
	}

	@Override
	public void update(Map<?,?>p) {
		q = new UpdateQuery();
		q.play(p);
	}

	@Override
	public void delete(Map<?,?>p) {
		q = new RemoveQuery();
		Map<String,Object> map = new HashMap<>();
		map.put("table", Domain.MEMBER);
		map.put("value1", p.get(""));
		map.put("value2", p.get(""));
		q.play(map);
	}
	
	@Override
	public boolean exist(Map<?, ?> map) {
		q = new LoginQuery();
		q.play(map);
		return (boolean)(q.getO());
	}
	@Override
	public String insert(MemberBean p) {
		String result = "";
		q = new AddQuery();
		HashMap<String, Object>map = new HashMap<>();
		map.put("table", Domain.MEMBER);
		map.put("value1", p.getUserid());
		map.put("value2", p.getName());
		map.put("value4", p.getPassword());
		map.put("value3", p.getSsn());
		map.put("value5", p.getAge());
		map.put("value6", p.getGender());
		map.put("value7", p.getRoll());
		map.put("value8", p.getTeamid().toUpperCase());
		q.play(map);
		return result;
	}
	@Override
	public int count(Map<?, ?> p) {
		q = new CountQuery();
		q.play(p);
		return q.getN();
	}
	@Override
	public List<MemberBean> selectSome(Map<?, ?> p) {
		List<MemberBean> list = new ArrayList<>();
		q = new SearchQuery();
		q.play(p);
		for(Object s : q.getL()) {
			list.add((MemberBean) s);
		}
		return list;
	}
}








