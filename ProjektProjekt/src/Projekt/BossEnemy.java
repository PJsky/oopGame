package Projekt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class BossEnemy extends GameObject{

	private handler handle;
	
	private int timer = 0;
	private int timer2 = 50;
	Random r = new Random();
	protected Sheet sSheet = new Sheet(Game.sSheetBS);
	private BufferedImage b_skin;
	
	public BossEnemy(float x, float y, ID id, handler handle) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		this.handle = handle;
		velY = 0;
		velX = 2;
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
			int spawn = r.nextInt(10);
			if(spawn == 0) handle.addObject(new BossEnemyBullet((int)x+10, (int)y+25, ID.Enemy,handle));
			
		}
		
		
		if(y <= 0 || y>= Game.HEIGHT - 48) velY *= -1;
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub		
		g.setColor(Color.green);
		g.fillRect(430, 870, (int)health * 6, 40);
		
		
		if(animationTimer<=15)b_skin = sSheet.getImage(1, 1, 96, 96);
		if(animationTimer>15)b_skin = sSheet.getImage(1, 4, 96, 96);
		g.drawImage(b_skin,(int)x,(int)y,null);
		
		
	}

	
}
