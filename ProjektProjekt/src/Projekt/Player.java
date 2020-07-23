package Projekt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Player extends GameObject {

	handler handle;
	private static boolean damaged = false;
	private static int iFrame;
	protected Sheet sSheet = new Sheet(Game.sSheet);
	protected Sheet sSheet2 = new Sheet(Game.sSheet2);
	protected Sheet sSheetPog = new Sheet(Game.sSheetPog);


	private BufferedImage player_skin,head;


	
	public Player(float x, float y, ID id, handler handle, Color col, int color) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		this.handle = handle;
		health = 3;
		this.col = col;
		this.color = color;
		
		
		
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
		
		x = Game.clamp(x, 70, 1070-33);
		y = Game.clamp(y, 110, 850 - 49);
		
		collision();
		iFrame --;
		if(iFrame <= 0) damaged = false;

		shootTimer--;
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
		if(!pog) {
		if(this.id==ID.Player||this.id==ID.PlayerPreview) {
		if(animationTimer>=0&&animationTimer<10)player_skin = sSheet.getImage(facing+1, 3*color-2, 32, 48);
		if(animationTimer>10&&animationTimer<20)player_skin = sSheet.getImage(facing+1, 3*color-1, 32, 48);
		if(animationTimer>=20)player_skin = sSheet.getImage(facing+1, 3*color, 32, 48);
			}
		}
		
		if(this.id==ID.Player2||this.id==ID.PlayerPreview2) {
		if(animationTimer>=0&&animationTimer<10)player_skin = sSheet2.getImage(facing+1, 3*color-2, 32, 48);
		if(animationTimer>10&&animationTimer<20)player_skin = sSheet2.getImage(facing+1, 3*color-1, 32, 48);
		if(animationTimer>=20)player_skin = sSheet2.getImage(facing+1, 3*color, 32, 48);
		}
		
		
		if(pog) {
		if(this.id==ID.Player||this.id==ID.PlayerPreview) {
		if(animationTimer>=0&&animationTimer<10)player_skin = sSheetPog.getImage(facing+1, 3*color-2, 32, 48);
		if(animationTimer>10&&animationTimer<20)player_skin = sSheetPog.getImage(facing+1, 3*color-1, 32, 48);
		if(animationTimer>=20)player_skin = sSheetPog.getImage(facing+1, 3*color, 32, 48);
		}
		}
	
		//p1 stats
		if(this.id==ID.Player) {
			if(!pog)
			head = sSheet.getImage(3, 3*color-2, 32, 30);
			else if(pog) head = sSheetPog.getImage(3, 3*color-2, 32, 30);
			else	head = sSheet.getImage(3, 3*color-2, 32, 30);

			
			if(health>=1)g.drawImage(head, 20, 18, null);
			if(health>=2)g.drawImage(head, 90, 18, null);
			if(health>=3)g.drawImage(head, 160, 18, null);
		}
		
		//p2 stats
		if(this.id==ID.Player2) {
			head = sSheet2.getImage(3, 3*color-2, 32, 30);
			
			if(health>=1)g.drawImage(head, 720, 18, null);
			if(health>=2)g.drawImage(head, 790, 18, null);
			if(health>=3)g.drawImage(head, 860, 18, null);
		}
		
		g.drawImage(player_skin,(int)x,(int)y,null);
		
	}



}
