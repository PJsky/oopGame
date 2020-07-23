package Projekt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class BossSpawner extends GameObject{

	private handler handle;
	
	private int timer = 150;
	private int timer2 = 50;
	private int timer3 = 20;
	Random r = new Random();
	protected Sheet sSheet = new Sheet(Game.sSheetBS);
	private BufferedImage b_skin;
	
	
	public BossSpawner(float x, float y, ID id, handler handle) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		this.handle = handle;
		velY = 0;
		velX = 4;
		health = 50;
	}
	
	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x,(int)y,96,96); // returning the current hitbox 
	}
	
	

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		animationTimer++;
		if(animationTimer>30)animationTimer=0;
		x +=velX;
		y +=velY;
		
		if(timer <= 0) velX = 0;
		else timer--;
		
		if(timer<= 0) timer2--;
		if(timer2<=0) {
			if(velY == 0) velY = 5;
			timer3--;
		}
		if(timer3<=0) {
			switch(r.nextInt(3)) {
			case 0:
				handle.addObject(new NormalGrunt((int)x+48, (int)y+48, ID.Enemy,handle, 1));
				break;
			case 1:
				handle.addObject(new FastGrunt((int)x+48, (int)y+48, ID.Enemy,handle, 1));
				break;
			case 2:
				handle.addObject(new TankyGrunt((int)x+48, (int)y+48, ID.Enemy,handle, 1));
				break;
			
			}
			timer3 = 100;
		}
		
		if(y <= 80 || y>= 850 - 200) velY *= -1;
		if(health !=0) 
		if(health == 0) {
			handle.removeObject(this);
		}
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub

		g.setColor(Color.green);
		g.fillRect(430, 870, (int)health * 6, 40);
		

		if(animationTimer<=15)b_skin = sSheet.getImage(3, 1, 96, 96);
		if(animationTimer>15)b_skin = sSheet.getImage(3, 4, 96, 96);
		g.drawImage(b_skin,(int)x,(int)y,null);
	}

	
}
