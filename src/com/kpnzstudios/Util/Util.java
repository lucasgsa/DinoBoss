package com.kpnzstudios.Util;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Util {
	public static BufferedImage getBufferedImage(String path, ClassLoader cl) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(cl.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
}
