package Projekt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class SmartEnemyV2 extends GameObject{

	protected Sheet sSheet = new Sheet(Game.sSheetE);
	
	private handler handle;
	private GameObject player,player2;

	private BufferedImage enemy_skin;

	
	public SmartEnemyV2(float x, float y, ID id, handler handle,float health) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		this.handle = handle;
		this.health = health;
		this.speed=1;
		this.col = Color.pink;
		this.color = 3;
		for(int i= 0; i<handle.object.size();i++) {
			if(handle.object.get(i).getID() == ID.Player) player = handle.object.get(i);
			else player2 = handle.object.get(i);
		}
		for(int i= 0; i<handle.object.size();i++) {if(handle.object.get(i).getID() == ID.Player2)
			player2 = handle.object.get(i);}
		
		
	}
	
	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x,(int)y,32,48); // returning the current hitbox
	}
	
	

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		animationTimer++;
		if(animationTimer>45)animationTimer=0;
		
		x +=velX*speed;
		y +=velY*speed;
		
		float diffX = x - player.getX() - 16;
		float diffY = y - player.getY() - 16;
		float distance = (float) Math.sqrt((x-player.getX())*(x-player.getX()) + (y-player.getY())*(y-player.getY()));
		float diffX2 = x - player2.getX() - 16;
		float diffY2 = y - player2.getY() - 16;
		float distance2 = (float) Math.sqrt((x-player2.getX())*(x-player2.getX()) + (y-player2.getY())*(y-player2.getY()));

		if(player.health == 0) {
			distance = 10000;
		}
		if(player2.health == 0 ) {
			distance2 = 10000;
		}
		if(player2.id==ID.Enemy) distance2 =10001;
		if(player2.id==ID.BossEnemy) distance2 =10001;
		
		if (distance* distance > distance2 * distance2) {
			diffX = diffX2;
			diffY = diffY2;
			distance = distance2;

		}
		
		velX = (float) ((-1.0/distance) * diffX ); // vel = 4 to where u are
		velY = (float) ((-1.0/distance) * diffY );
		if (velX>=0)facing = 1;
		else if(velX<0)facing = 2;
		if(health <= 0) {
			handle.removeObject(this);
		}
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
		if(animationTimer<=15)enemy_skin = sSheet.getImage(facing, 3*color-2, 32, 48);
		if(animationTimer>15&&animationTimer<=30)enemy_skin = sSheet.getImage(facing, 3*color-1, 32, 48);
		if(animationTimer>30)enemy_skin = sSheet.getImage(facing, 3*color, 32, 48);

		
		g.drawImage(enemy_skin,(int)x,(int)y,null);
		
		
	}

	
}
