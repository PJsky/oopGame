package Projekt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Enemy extends GameObject{

	private handler handle;
	
	public Enemy(float x, float y, ID id, handler handle) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		this.handle = handle;
		velY = 0;
		velX = 0;
	}
	
	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x,(int)y,32,48); // returning the current hitbox
	}
	
	

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x +=velX;
		y +=velY;
		
		
		if(x <= 0 || x>= Game.WIDTH - 32) velX *= -1;
		if(y <= 0 || y>= Game.HEIGHT - 48) velY *= -1;
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 32, 48);
		
	}

	
}
