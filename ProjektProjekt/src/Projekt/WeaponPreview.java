package Projekt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class WeaponPreview extends GameObject{
	
	private handler handle;
	protected Sheet sSheet = new Sheet(Game.sSheetW);
	private BufferedImage prz_skin;
	
	public WeaponPreview(float x, float y, ID id, handler handle, int weapon) {
		super(x, y, id);
		this.handle= handle;
		this.weapon = weapon;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub		
		y+=5;
		
	}
	


	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		switch(weapon) {
		case 2: 
		prz_skin = sSheet.getImage(1, 1, 24, 24);
		break;
		case 3: 
		prz_skin = sSheet.getImage(1, 2, 24, 24);
		break;
		case 4: 
		prz_skin = sSheet.getImage(1, 3, 24, 24);
		}
		
		
		g.drawImage(prz_skin,(int)x,(int)y,null);
		
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x,(int)y,16,16); // returning the current hitbox
	}

}
