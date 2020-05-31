package com.kpnzstudios.Util;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

public class Animation {
	
	HashMap<String, ArrayList<BufferedImage>> animations;
	HashMap<String, Integer> animationsTimes;
	
	String idAtualArray = "main";
	int idAnimation = 0;
	int animationTimeAtual = 0;
	
	public Animation() {
		animations = new HashMap<String, ArrayList<BufferedImage>>();
		animationsTimes = new HashMap<String, Integer>();
		animations.put("main", new ArrayList<BufferedImage>());
		animationsTimes.put("main", 10);
	}
	
	public void addAnimation(String id, String imagePath) {
		if (animations.containsKey(id)){
			animations.get(id).add(Util.getBufferedImage(imagePath));
		}
		else {
			animations.put(id, new ArrayList<BufferedImage>());
			animationsTimes.put(id, 10);
			addAnimation(id, imagePath);
		}
	}
	
	public void tick() {
		//Define o tempo de cada imagem
		if (animationTimeAtual != animationsTimes.get(idAtualArray)) {
			animationTimeAtual++;
			return;
		}
		
		//Quando uma animação chega ao final
		if (animations.get(idAtualArray).size()-1 <= idAnimation) {
			idAnimation = 0;
			idAtualArray = "main";
			animationTimeAtual = 0;
		}
		//Passar para a outra imagem da animação
		else {
			idAnimation++;
			animationTimeAtual = 0;
		}
	}
	
	public BufferedImage getImage() {
		return animations.get(idAtualArray).get(idAnimation);
	}
	
	public void setAnimation(String animation) {
		this.idAtualArray = animation;
		idAnimation = 0;
		animationTimeAtual = 0;
	}
	public void setAnimationTime(String animation, int time) {
		animationsTimes.put(animation, time);
	}
}
