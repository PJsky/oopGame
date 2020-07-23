package Projekt;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImgLoader {

	BufferedImage image = new BufferedImage(400,400,BufferedImage.TYPE_INT_ARGB);
	
	public BufferedImage loadImage(String path) {
		
		try {
		image = ImageIO.read(getClass().getResource(path));
		
		}catch(IOException e) {
			e.printStackTrace();
		}
		return image;
	}
	
	

	
}
