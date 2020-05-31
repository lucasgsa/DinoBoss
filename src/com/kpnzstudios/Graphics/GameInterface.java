package com.kpnzstudios.Graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import com.kpnzstudios.Caracters.Personagem;
import com.kpnzstudios.Util.KeyBoardQueue;
import com.kpnzstudios.Util.Util;

public class GameInterface extends Canvas {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Define tamanho da tela.
	 */
	final static int[] windowsSize = {1280,720};
	
	private long lastTickTime;
	
	private long lastFpsTime;
	
	private int maxTick;
	
	private int maxFps;
	
	private Personagem personagem;
	
	private KeyBoardQueue keyState;
	
	private BufferedImage wallpaper;
	
	public GameInterface() {
		this.setPreferredSize(new Dimension(windowsSize[0], windowsSize[1]));
		maxTick = 64;
		maxFps = 90;
		personagem = new Personagem(100, 0, 150, 225);
		personagem.setPlataform(600);
		keyState = new KeyBoardQueue();
		this.addKeyListener(keyState);
		wallpaper = Util.getBufferedImage("sprites/wallpaper.png");
	}
	
	public void checarTeclas() {
		if (keyState.hasUp()) {
			personagem.pular();
			System.out.println("pulo");
		}
	}
	
	public Long tick() {
		Long initTime = System.currentTimeMillis();
		checarTeclas();
		personagem.tick();
		return (System.currentTimeMillis() - initTime);
	}
	
	public long render() {
		Long initTime = System.currentTimeMillis();
		
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return 0;
		}
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(new Color(198, 190, 173));
		g.drawImage(wallpaper, 0, 0, windowsSize[0], windowsSize[1], null);
		
		g.drawImage(personagem.getSprite(), personagem.getX(), personagem.getY(), personagem.getSizeX(), personagem.getSizeY(), null);
		
		g.dispose();
		bs.show();
		
		return (System.currentTimeMillis() - initTime);
	}
	
	public void start() {
		
		//Tick
		new Thread() {
		    @Override
		    public void run() {
		    	while (true){
			    	Long delayTick = tick();
			    	if (delayTick < 1000/maxTick) {
			    		try {
							Thread.sleep(1000/maxTick - delayTick);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
			    	}
		    	}
		    }
		  }.start();
		  
		//Fps
		new Thread() {
			@Override
		    public void run() {
		    	while (true){
		    		Long init = System.currentTimeMillis();
			    	Long delayTick = render();
			    	if (delayTick < 1000/maxFps) {
			    		try {
							Thread.sleep(1000/maxFps - delayTick);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
			    	}
			    	if (delayTick != 0) System.out.println("FPS:" + 1000/(System.currentTimeMillis()-init));
		    	}
		    }
		  }.start();
		  
	}

}
