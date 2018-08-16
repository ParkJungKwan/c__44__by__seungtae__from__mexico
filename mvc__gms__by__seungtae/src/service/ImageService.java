package service;

import java.util.Map;

import domain.ImageBean;

public interface ImageService {
	public void add(ImageBean p);
	public String retrieve(Map<?,?>p);
}
