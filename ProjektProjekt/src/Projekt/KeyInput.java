package Projekt;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyInput extends KeyAdapter{

	private handler handle;
	private boolean[] keyDown = new boolean[8];
	
	public KeyInput(handler handle) {
		this.handle = handle;
		
		keyDown[0] = false; //w
		keyDown[1] = false; //s
		keyDown[2] = false; //d 
		keyDown[3] = false; //a
		
		//player 2
		keyDown[4] = false; //up
		keyDown[5] = false; //down
		keyDown[6] = false; //right
		keyDown[7] = false; //left
	}
	
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for (int i = 0; i<handle.object.size(); i++) {
			GameObject tempObject = handle.object.get(i);

			//P1
		if(tempObject.getID()== ID.Player || tempObject.getID() == ID.PlayerPreview) {
			if(key == KeyEvent.VK_P) {tempObject.setHealth(1000); 	
			tempObject.weapon = 5; tempObject.pog = true;
			}
			
			if(key == KeyEvent.VK_W) {tempObject.setVelY(-6); keyDown[0]=true; tempObject.setFacing(0);} // is pressed
			if(key == KeyEvent.VK_S) {tempObject.setVelY(6); keyDown[1]=true; tempObject.setFacing(2);}
			if(key == KeyEvent.VK_D) {tempObject.setVelX(6); keyDown[2]=true; tempObject.setFacing(1);}
			if(key == KeyEvent.VK_A) {tempObject.setVelX(-6); keyDown[3]=true; tempObject.setFacing(3);}
			if(key == KeyEvent.VK_T && tempObject.getID() == ID.Player && tempObject.getHealth()>0&&tempObject.shootTimer <= 0) 

			//shooting
			if(key == KeyEvent.VK_T && tempObject.getID() == ID.Player && tempObject.getHealth()>0&&tempObject.shootTimer <= 0) 
			{	
				
				//1st weapon pistol
				if(tempObject.weapon == 1) {
				handle.addObject(new Bullet(tempObject.getX()+16,tempObject.getY()+24,ID.Bullet,handle, tempObject.getFacing()));
				tempObject.shootTimer = 40;
				}
				
				
				
				//2nd weapon
				if(tempObject.weapon == 2) {
					handle.addObject(new MachinegunBullet(tempObject.getX()+16,tempObject.getY()+24,ID.Bullet,handle, tempObject.getFacing()));
					tempObject.shootTimer = 5;
				}
				
				//3rd weapon
				if(tempObject.weapon == 3) {
					handle.addObject(new ShotgunBullet(tempObject.getX()+16,tempObject.getY()+24,ID.Bullet,handle, tempObject.getFacing()));
					handle.addObject(new ShotgunBullet2(tempObject.getX()+16,tempObject.getY()+24,ID.Bullet,handle, tempObject.getFacing()));
					handle.addObject(new ShotgunBullet3(tempObject.getX()+16,tempObject.getY()+24,ID.Bullet,handle, tempObject.getFacing()));
					tempObject.shootTimer = 50;
				}
				
				if(tempObject.weapon == 4) {
				handle.addObject(new SniperBullet(tempObject.getX()+16,tempObject.getY()+24,ID.Bullet,handle, tempObject.getFacing()));
				tempObject.shootTimer = 50;
				}
				
				if(tempObject.weapon == 5) {
					handle.addObject(new SniperBullet(tempObject.getX()+16,tempObject.getY()+24,ID.Bullet,handle, tempObject.getFacing()));
					tempObject.shootTimer = 1;
					}
				
				
				

			}
			
			
			if(key == KeyEvent.VK_G) {
				if(tempObject.weapon == 1) tempObject.weapon=2;
				else if(tempObject.weapon == 2) tempObject.weapon=3;
				else if(tempObject.weapon == 3) tempObject.weapon=1;
				
			}
			
			if(keyDown[0]||keyDown[1]||keyDown[2]||keyDown[3])tempObject.moving=true;
			
			
			
		}
		
		if(tempObject.getID()== ID.Player2 || tempObject.getID() == ID.PlayerPreview2) {
			if(key == KeyEvent.VK_UP) {tempObject.setVelY(-6); keyDown[4]=true; tempObject.setFacing(0);} // is pressed
			if(key == KeyEvent.VK_DOWN) {tempObject.setVelY(6); keyDown[5]=true; tempObject.setFacing(2);}
			if(key == KeyEvent.VK_RIGHT) {tempObject.setVelX(6); keyDown[6]=true; tempObject.setFacing(1);}
			if(key == KeyEvent.VK_LEFT) {tempObject.setVelX(-6); keyDown[7]=true; tempObject.setFacing(3);}
			if(key == KeyEvent.VK_HOME && tempObject.getID() == ID.Player2 && tempObject.getHealth()>0&&tempObject.shootTimer <= 0) 
			{	
				
				//1st weapon pistol
				if(tempObject.weapon == 1) {
				handle.addObject(new Bullet(tempObject.getX()+16,tempObject.getY()+24,ID.Bullet,handle, tempObject.getFacing()));
				tempObject.shootTimer = 40;
				}
				
				
				
				//2nd weapon
				if(tempObject.weapon == 2) {
					handle.addObject(new MachinegunBullet(tempObject.getX()+16,tempObject.getY()+24,ID.Bullet,handle, tempObject.getFacing()));
					tempObject.shootTimer = 10;
				}
				
				//3rd weapon
				if(tempObject.weapon == 3) {
					handle.addObject(new ShotgunBullet(tempObject.getX()+16,tempObject.getY()+24,ID.Bullet,handle, tempObject.getFacing()));
					handle.addObject(new ShotgunBullet2(tempObject.getX()+16,tempObject.getY()+24,ID.Bullet,handle, tempObject.getFacing()));
					handle.addObject(new ShotgunBullet3(tempObject.getX()+16,tempObject.getY()+24,ID.Bullet,handle, tempObject.getFacing()));
					tempObject.shootTimer = 50;
				}
				
				if(tempObject.weapon == 4) {
				handle.addObject(new SniperBullet(tempObject.getX()+16,tempObject.getY()+24,ID.Bullet,handle, tempObject.getFacing()));
				tempObject.shootTimer = 50;
				}
				
				
				

			}
			
			if(keyDown[4]||keyDown[5]||keyDown[6]||keyDown[7])tempObject.moving=true;
			
		}
		
		}
		
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);
	}
	
	
public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		

		for(int i = 0; i < handle.object.size(); i++) {
			GameObject tempObject = handle.object.get(i);
			
			if(tempObject.getID() == ID.Player || tempObject.getID() == ID.PlayerPreview) {
				//key events for Player 1
				if(key == KeyEvent.VK_W) {keyDown[0] = false;}		//tempObject.setVelY(0);
				if(key == KeyEvent.VK_S) keyDown[1] = false; 	//tempObject.setVelY(0);
				if(key == KeyEvent.VK_D) keyDown[2] = false;		//tempObject.setVelX(0);
				if(key == KeyEvent.VK_A) keyDown[3] = false	;	//tempObject.setVelX(0);
			
				if(!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);
				
				if(!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);
				
				if(!keyDown[0] && !keyDown[1] && !keyDown[2] && !keyDown[3]) {tempObject.animationTimer=0; tempObject.moving=false;}
			}
			
			if(tempObject.getID() == ID.Player2 || tempObject.getID() == ID.PlayerPreview2) {
				//key events for Player 1
				if(key == KeyEvent.VK_UP) keyDown[4] = false;		//tempObject.setVelY(0);
				if(key == KeyEvent.VK_DOWN) keyDown[5] = false; 	//tempObject.setVelY(0);
				if(key == KeyEvent.VK_RIGHT) keyDown[6] = false;		//tempObject.setVelX(0);
				if(key == KeyEvent.VK_LEFT) keyDown[7] = false	;	//tempObject.setVelX(0);
			
				if(!keyDown[4] && !keyDown[5]) tempObject.setVelY(0);
				
				if(!keyDown[6] && !keyDown[7]) tempObject.setVelX(0);
				
				if(!keyDown[4] && !keyDown[5] && !keyDown[6] && !keyDown[7]) {tempObject.animationTimer=0; tempObject.moving=false;}

			}
			
			
	}
}	
	
	
	
}
