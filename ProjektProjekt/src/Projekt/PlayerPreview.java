package Projekt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class PlayerPreview extends GameObject {

	handler handle;
	private static boolean damaged = false;
	private static int iFrame;
	protected Sheet sSheet = new Sheet(Game.sSheet);
	protected Sheet sSheet2 = new Sheet(Game.sSheet2);
	private BufferedImage player_skin;
	
	public PlayerPreview(float x, float y, ID id, handler handle,Color col) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		//velX =1;
		this.handle = handle;
		health = 3;
		this.col = col;
	}
	
	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle((int)x,(int)y,32,48); // returning the current hitbox
	}
	

	
	
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x += velX;
		y += velY;
		if(x<400) {
		x = Game.clamp(x, 100, 400-32);
		y = Game.clamp(y, 310, 630-48);}
		else {
			x= Game.clamp(x,860, 1160-32);
			y = Game.clamp(y, 310, 630-48);
		}
		
		
		collision();
		iFrame --;
		if(iFrame <= 0) damaged = false;
		if (health == 0) {
			System.out.println("DEAD");

		}
		
		if(moving)animationTimer++;
		if(animationTimer>=30) animationTimer = 1;
	}
	
	
	
	private void collision() {
		for(int i =0; i<handle.object.size(); i++) {
			GameObject tempObject = handle.object.get(i);
			
			if(tempObject.getID() == ID.Enemy) {
				
				if(getBounds().intersects(tempObject.getBounds())) {
					//collision code
					if(damaged == false) {
					health -=1;
					damaged = true;
					iFrame = 100;}
					
				}
				
			}
			if(tempObject.getID()== ID.Player) {
				if(tempObject.health == 0) {
				handle.removeObject(tempObject);
				handle.addObject(new PlayerGhost(tempObject.getX(),tempObject.getY(), ID.Player, handle));
				}
				
			}
			
			if(tempObject.getID()== ID.Player2) {
				if(tempObject.health == 0) {
				handle.removeObject(tempObject);
				handle.addObject(new PlayerGhost(tempObject.getX(),tempObject.getY(), ID.Player2, handle));
				}
				
			}
			
			
			
		}
	}
	
	

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
		if(this.id==ID.Player||this.id==ID.PlayerPreview) {
		if(animationTimer>=0&&animationTimer<10)player_skin = sSheet.getImage(facing+1, 3*color-2, 32, 48);
		if(animationTimer>10&&animationTimer<20)player_skin = sSheet.getImage(facing+1, 3*color-1, 32, 48);
		if(animationTimer>=20)player_skin = sSheet.getImage(facing+1, 3*color, 32, 48);
		}
		
		if(this.id==ID.Player2||this.id==ID.PlayerPreview2) {
		if(animationTimer>=0&&animationTimer<10)player_skin = sSheet2.getImage(facing+1, 3*color-2, 32, 48);
		if(animationTimer>10&&animationTimer<20)player_skin = sSheet2.getImage(facing+1, 3*color-1, 32, 48);
		if(animationTimer>=20)player_skin = sSheet2.getImage(facing+1, 3*color, 32, 48);
		}
		
		g.drawImage(player_skin,(int)x,(int)y,null);
		
	}



}
