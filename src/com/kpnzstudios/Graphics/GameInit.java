package com.kpnzstudios.Graphics;

import javax.swing.JFrame;

import com.kpnzstudios.Graphics.GameInterface;

public class GameInit {
	public static void main(String[] args) {
		GameInterface game = new GameInterface();
		JFrame frame = new JFrame("DinoBoss");
		frame.add(game);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		game.start();
	}
}
