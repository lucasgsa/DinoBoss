package com.kpnzstudios.Util;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class KeyBoardQueue implements KeyListener {
	
	private ArrayList<String> queue;

	public KeyBoardQueue() {
		queue = new ArrayList<String>();
	}
	
	public boolean hasRight() {
		if (queue.contains("RIGHT")) {
			queue.remove("RIGHT");
			return true;
		}
		return false;
	}
	
	public boolean hasLeft() {
		if (queue.contains("LEFT")) {
			queue.remove("LEFT");
			return true;
		}
		return false;
	}
	
	public boolean hasUp() {
		if (queue.contains("UP")) {
			queue.remove("UP");
			return true;
		}
		return false;
	}
	
	public boolean hasDown() {
		if (queue.contains("DOWN")) {
			queue.remove("DOWN");
			return true;
		}
		return false;
	}
	
	public void pressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_RIGHT && !queue.contains("RIGHT")) {
			queue.add("RIGHT");
		}
		if (keyCode == KeyEvent.VK_LEFT && !queue.contains("LEFT")) {
			queue.add("LEFT");
		}
		if (keyCode == KeyEvent.VK_UP && !queue.contains("UP")) {
			queue.add("UP");
		}
		if (keyCode == KeyEvent.VK_DOWN && !queue.contains("DOWN")) {
			queue.add("DOWN");
		}
		System.out.println(queue.toString());
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		pressed(arg0);
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
