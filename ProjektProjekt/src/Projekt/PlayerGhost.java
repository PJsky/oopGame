package Projekt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class PlayerGhost extends GameObject {

	handler handle;
	protected Sheet sSheet = new Sheet(Game.sSheetW);
	private BufferedImage rip_skin;
	private static boolean damaged = false;
	private static int iFrame;
	
	
	public PlayerGhost(float x, float y, ID id, handler handle) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		//velX =1;
		this.handle = handle;
		health = 0;
	}
	
	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x,(int)y,32,48); // returning the current hitbox
	}
	

	
	
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
	}
	
	

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
		rip_skin = sSheet.getImage(2, 1, 32, 48);
		g.drawImage(rip_skin,(int)x,(int)y,null);

		
	}



}
