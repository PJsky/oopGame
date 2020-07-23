package Projekt;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import Projekt.Game.STATE;

public class MainMenu extends MouseAdapter{
	
	private Game game;
	private handler handle;
	private GameObject player, player2;
	Random r = new Random();
	
	public MainMenu(Game game, handler handle) {
		this.game = game;
		this.handle = handle;
	}
	
	
	
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX(); // getting x pos of mouse click
		int my = e.getY();	// y	
		
		if(game.gameState== STATE.Menu) {
			
			
			
			//play button
			if (mouseOver(mx,my,Game.WIDTH/2 - 150, 220, 300, 120)) {
				game.gameState = STATE.Game;
				//p1 spawn
				handle.addObject(new Player(100,100, ID.Player, handle,player.getColor(), player.getCol()));
				//p2 spawn
				if(game.players == 2) {
				handle.addObject(new Player(200,200, ID.Player2, handle,player2.getColor(),player2.getCol()));}
				
				handle.addObject(new Enemy(10000,10000, ID.Enemy, handle)); // Smart enemy needs 1 more object, not only p1
																			//^its a bugfix
				
				for (int i = 0; i<handle.object.size(); i++) {
					GameObject tempObject = handle.object.get(i);
					
					
					if(tempObject.getID() == ID.PlayerPreview) {
						
						handle.removeObject(tempObject);
						}
					

					
				}
				
				for (int i = 0; i<handle.object.size(); i++) {
					GameObject tempObject = handle.object.get(i);
					
					
					if(tempObject.getID() == ID.PlayerPreview2) {
						
						handle.removeObject(tempObject);
						}
					

					
				}
				
			}
			
			//change color left button P1
			if (mouseOver(mx,my,160, 680, 50, 50)) {
				
				
				switch(player.getCol()) {
				case 1:
					player.setCol(2);
					break;
				case 2:
					player.setCol(3);
					break;
				case 3:
					player.setCol(1);
					break;
				}
				
				
			}
			//change color right button P1
			if (mouseOver(mx,my,290, 680, 50, 50)) {
				
				
				switch(player.getCol()) {
				case 1:
					player.setCol(3);
					break;
				case 2:
					player.setCol(1);
					break;
				case 3:
					player.setCol(2);
					break;
				}
				
				
			}
			
			
			
			//change color left button P2
			if (mouseOver(mx,my,920, 680, 50, 50)) {

				
				switch(player2.getCol()) {
				case 1:
					player2.setCol(2);
					break;
				case 2:
					player2.setCol(3);
					break;
				case 3:
					player2.setCol(1);
					break;
				}
				
				
			}
			//right p2
			if (mouseOver(mx,my,1050, 680, 50, 50)) {
				
				
				switch(player2.getCol()) {
				case 1:
					player2.setCol(3);
					break;
				case 2:
					player2.setCol(1);
					break;
				case 3:
					player2.setCol(2);
					break;
				}
				
				
			}
			
			

			
			// players button
			if (mouseOver(mx,my,Game.WIDTH/2 - 150, 400, 300, 120)) {
				if(game.players == 1) game.players =2;
				else if(game.players == 2) game.players =1;
			}
			// help button
			if (mouseOver(mx,my,Game.WIDTH/2 - 150, 580, 300, 120)) {
				
				if(game.gameState==STATE.Menu)game.gameState = STATE.Help;
				return;
			}
			//quit button
			if (mouseOver(mx,my,Game.WIDTH/2 - 150, 760, 300, 120)) {
				System.exit(1);
			}
		}
		
		
		
		
		//Help menu inside
		//Back button
		if(game.gameState == STATE.Help)
		if (mouseOver(mx,my,Game.WIDTH/2 - 150, 550, 300, 120)) {
			
			game.gameState = STATE.Menu;
			return;
		}
		
		if(game.gameState == STATE.Win)
			if (mouseOver(mx,my,Game.WIDTH/2-300, 550, 600, 300)) {
				
				game.gameState = STATE.Menu;
				handle.addObject(new PlayerPreview(250-16,470-24, ID.PlayerPreview, handle,Color.white));
				handle.addObject(new PlayerPreview(1010-16,470-24, ID.PlayerPreview2, handle,Color.white));
				return;
			}
		
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx < x + width) {
			if(my > y && my < y + height) {
				return true;
			}else return false;
		}else return false;
	}
	
	
	public void tick() {
		for (int i = 0; i<handle.object.size(); i++) {
			//GameObject tempObject = handle.object.get(i);
			if(handle.object.get(i).getID() == ID.PlayerPreview) player = handle.object.get(i);
			if(handle.object.get(i).getID() == ID.PlayerPreview2) player2 = handle.object.get(i);
			
			
		}
	}
	
	public void render(Graphics g) {
		
		Font fnt = new Font("arial", 3, 200);
		Font fnt2 = new Font("arial", 1, 50);
		Font fntBig = new Font("arial", 1, 200);

		
		if(game.gameState == STATE.Menu) {
		
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("TITLE", 345, 200);
			
			g.setFont(fnt2);
			
			g.drawRect(Game.WIDTH/2 - 150, 220, 300, 120);// Play
			g.drawString("PLAY", Game.WIDTH/2 -70, 305);
			
			g.drawRect(Game.WIDTH/2 - 150, 400, 300, 120);// Player 1/2
			g.drawString(game.players + "PLAYER(s)", Game.WIDTH/2 -145, 485);
			
			g.drawRect(Game.WIDTH/2 - 150, 580, 300, 120);// Help
			g.drawString("HELP", Game.WIDTH/2 -70, 665);
			
			g.drawRect(Game.WIDTH/2 - 150, 760, 300, 120);// Quit
			g.drawString("QUIT", Game.WIDTH/2 -70, 845);

			
			
			
			g.drawRect(100, 310, 300, 320);// View of player 1
			g.drawRect(160, 680, 50, 50); // previous char
			g.drawRect(290, 680, 50, 50); // next char
			
			
			
			g.drawRect(860, 310, 300, 320);// View of player 2
			g.drawRect(920, 680, 50, 50); // previous char
			g.drawRect(1050, 680, 50, 50); // next char
			
			
		}
		
		if(game.gameState == STATE.Help) {
			g.setFont(fnt2);
			g.setColor(Color.white);
			
			g.fillRect(630, 0, 10, 550);
			g.fillRect(Game.WIDTH/2 - 150, 550, 300, 120);// Help
			g.fillRect(630, 670, 10, 290);// Help
			
			g.drawRect(100, 310, 300, 320);// View of player 1
			g.drawRect(160, 680, 50, 50); // previous char
			g.drawRect(290, 680, 50, 50); // next char
			
			
			
			g.drawRect(860, 310, 300, 320);// View of player 2
			g.drawRect(920, 680, 50, 50); // previous char
			g.drawRect(1050, 680, 50, 50); // next char
			g.drawString("WASD move, T Shoot", 20, 100);
			g.drawString("ARROWS to move,", 680, 100);
			g.drawString("7 to Shoot", 680, 180);
			g.setColor(Color.black);
			g.drawString("BACK", Game.WIDTH/2 - 70, 625);

			
		}
		if(game.gameState == STATE.Win) {
			g.setFont(fnt);
			g.setColor(Color.white);
			
			g.drawString("VICTORY!",140,480);
			g.setFont(fntBig);
			g.drawString("MENU", Game.WIDTH/2 - 290, 750);
			g.drawRect(Game.WIDTH/2-300, 550, 600, 300);// Help
		}
		
	}

}
