package com.kpnzstudios.Caracters;

import java.awt.image.BufferedImage;

import com.kpnzstudios.Graphics.GameInterface;
import com.kpnzstudios.Util.Animation;

public class Personagem {
	
	int x;
	int y;
	int velocidade_y;
	int size_x;
	int size_y;
	int plataform_y;
	int puloAtual = 0;
	int maxPulos = 2;
	Animation animations;
	
	public Personagem(int x, int y, int sizeX, int sizeY) {
		this.x = x;
		this.y = y;
		this.size_x = sizeX;
		this.size_y = sizeY;
		this.velocidade_y = 0;
		animations = new Animation();
		animations.addAnimation("main", "sprites/dino2.png");
		animations.addAnimation("main", "sprites/dino3.png");
		animations.addAnimation("main", "sprites/dino4.png");
		animations.addAnimation("pulo", "sprites/dino.png");
		animations.setAnimationTime("pulo", 25);
	}
	
	public int getSizeX() {
		return size_x;
	}

	public int getSizeY() {
		return size_y;
	}

	public BufferedImage getSprite() {
		return animations.getImage();
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void tick() {
		animations.tick();
		if (y < plataform_y-size_y) {
			velocidade_y -= 1;
		}
		if (y - velocidade_y < plataform_y-size_y) {
			y -= velocidade_y;	
		}
		else {
			y = plataform_y-size_y;
			puloAtual = 0;
		}
	}
	
	public void setPlataform(int pos) {
		plataform_y = pos;
	}
	
	public void pular() {
		this.setAnimation("pulo");
		if (puloAtual < maxPulos) {
			velocidade_y = 15;
			puloAtual += 1;
		}
	}
	
	public void setAnimation(String animation) {
		animations.setAnimation(animation);
	}
	
}
