package Projekt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends GameObject{

	private handler handle;
	protected int dmg=3;
	protected boolean sniper=false;
	
	public Bullet(float x, float y, ID id, handler handle, int facing) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		this.handle = handle;
		switch(facing) {
		case 0: velY = -5;
		break;
		case 1: velX = 5;
		break;
		case 2: velY = 5;
		break;
		case 3: velX = -5;
		}
	}
	
	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x,(int)y,8,8); // returning the current hitbox
	}
	
	

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x +=velX*3;
		y +=velY*3;
		
		if(x <= 0 || x>= Game.WIDTH - 32) handle.removeObject(this);
		if(y <= 0 || y>= Game.HEIGHT - 48) handle.removeObject(this);
		
		collision();
		
	}

	private void collision() {
		for(int i =0; i<handle.object.size(); i++) {
			GameObject tempObject = handle.object.get(i);
			
			if(tempObject.getID() == ID.Enemy||tempObject.getID() == ID.BossEnemy) {
				
				if(getBounds().intersects(tempObject.getBounds())) {
					//collision code
					
					tempObject.setHealth(tempObject.getHealth()-dmg);
					if(!sniper)handle.removeObject(this);
					if(sniper && tempObject.getID() == ID.BossEnemy)handle.removeObject(this);
					
				}
				
			}			
			
		}
	}
	
	
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.pink);
		g.fillRect((int)x, (int)y, 8, 8);
		
	}

	
}
