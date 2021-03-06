package Projekt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BossEnemyBullet extends GameObject{

	private handler handle;
	Random r = new Random(); 
	
	public BossEnemyBullet(float x, float y, ID id, handler handle) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		this.handle = handle;
		velY = (r.nextInt(5 - -5) + -5);
		velX = -13;
	}
	
	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x,(int)y,10,10); // returning the current hitbox
	}
	
	

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x +=velX;
		y +=velY;
		
		if(x <= 0 || x>= Game.WIDTH - 50) handle.removeObject(this);
		if(y <= 0 || y>= Game.HEIGHT - 50) handle.removeObject(this);

		
			}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 10, 10);
		
	}

	
}
