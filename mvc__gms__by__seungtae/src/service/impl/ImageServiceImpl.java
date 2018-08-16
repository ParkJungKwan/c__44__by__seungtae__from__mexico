package service.impl;

import java.util.Map;

import dao.impl.ImageDAOImpl;
import domain.ImageBean;
import service.ImageService;

public class ImageServiceImpl implements ImageService{
	private static ImageService instance = new ImageServiceImpl();
	public static ImageService getInstance() {return instance;}
	private ImageServiceImpl() {}
	
	@Override
	public void add(ImageBean p) {
		ImageDAOImpl.getInstance().insert(p);
	}
	@Override
	public String retrieve(Map<?,?>p) {
		return ImageDAOImpl.getInstance().selectOne(p);
	}

}
