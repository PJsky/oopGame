package Projekt;

import java.awt.image.BufferedImage;

public class Sheet {
	
	private BufferedImage sprite;
	
	public Sheet(BufferedImage ss) {
		this.sprite = ss;
	}
	

	public BufferedImage getImage(int column, int row, int width, int height) {
		BufferedImage img = sprite.getSubimage(row*32 - 32,column*48 - 48 , width, height);
		return img;
	}
	//Changing white pixels not visible
	
	/*public BufferedImage getImaga(int column, int row, int width, int height) {
		BufferedImage img = sprite.getSubimage(row*32 - 32,column*48 - 48 , width, height);
		int pixels[] = new int[width*height];
		img.getRGB(row*32-32, column*48-48, width, height, pixels, 0, width);
		
		for(int i =0; i<pixels.length; i++) {
			if(pixels[i] == 0xFFffffff) {
				pixels[i] = 0x00ffffff;
			}
			
		}
		img.setRGB(row*32-32, column*48-48, width, height, pixels, 0, width);
		return img;
	}*/
	
	
}
