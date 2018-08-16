package dao;

import java.util.Map;

import domain.ImageBean;

public interface ImageDAO {
	public void insert(ImageBean p);
	public String selectOne(Map<?,?>p);
}
