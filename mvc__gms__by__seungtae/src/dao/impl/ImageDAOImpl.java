package dao.impl;

import java.util.HashMap;
import java.util.Map;

import dao.ImageDAO;
import dao.template.QueryTemplate;
import dao.template.detail.AddQuery;
import dao.template.detail.RetrieveQuery;
import dao.template.values.Domain;
import domain.ImageBean;

public class ImageDAOImpl implements ImageDAO{
	private QueryTemplate q;
	private static ImageDAO instance = new ImageDAOImpl();
	public static ImageDAO getInstance() {return instance;}
	private ImageDAOImpl() {}

	@Override
	public void insert(ImageBean p) {
		q = new AddQuery();
		Map<String,Object> map = new HashMap<>();
		map.put("table", Domain.IMAGE);
		map.put("value1", p.getImgName());
		map.put("value2", p.getExtension());
		map.put("value3", p.getUserid());
		q.play(map);
		
		
	}

	@Override
	public String selectOne(Map<?,?>p) {
		q = new RetrieveQuery();
		Map<String,Object> map = new HashMap<>();
		map.put("table", Domain.IMAGE);
		map.put("column", "USERID");
		map.put("value", p.get(""));
		q.play(map);
		ImageBean img = ((ImageBean)q.getO());
		return (img != null)?img.getImgName()+"."+img.getExtension():"default.jpg";
	}

	

}
