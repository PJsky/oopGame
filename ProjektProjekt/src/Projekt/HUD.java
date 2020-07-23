package Projekt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import Projekt.Game.STATE;

public class HUD {

	private handler handle;
	private Game game;

	public static BufferedImage sSheethud;
	
	public static float HEALTH,HEALTH2=0;
	private static boolean player2alive = false;
	private int score=0,level=1;
	
	
	public HUD(handler handle,Game game) {
		this.handle = handle;
		this.game = game;
		
		ImgLoader loader = new ImgLoader(); 
		sSheethud = loader.loadImage("/Map.png");
	}
	
	
	
	public void tick() {
		for (int i = 0; i<handle.object.size(); i++) {
			GameObject tempObject = handle.object.get(i);
			if(tempObject.getID() == ID.Player) HEALTH = tempObject.getHealth();
			if(tempObject.getID() == ID.Player2) HEALTH2 = tempObject.getHealth();
		
		}
	if (HEALTH2>0) player2alive = true;
	HEALTH  = Game.clamp(HEALTH, 0, 3); //DZIALA
	
	score++;
	
	if (HEALTH<=0 && HEALTH2 >=0) {
		if(HEALTH2<=0) {game.gameState = STATE.Menu; handle.clearEnemies();
		handle.addObject(new PlayerPreview(250-16,470-24, ID.PlayerPreview, handle,Color.white));
		handle.addObject(new PlayerPreview(1010-16,470-24, ID.PlayerPreview2, handle,Color.white));
		game.gameState = STATE.End;}
	}
	if (HEALTH2<=0 && HEALTH >=0) {
		if(HEALTH<=0) {game.gameState = STATE.Menu; handle.clearEnemies();
		handle.addObject(new PlayerPreview(250-16,470-24, ID.PlayerPreview, handle,Color.white));
		handle.addObject(new PlayerPreview(1010-16,470-24, ID.PlayerPreview2, handle,Color.white));
		game.gameState = STATE.End;}
	}
	
	}
	
	public void render(Graphics g) {

		g.drawImage(sSheethud, 0, 0, null);	
	}
		
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getLevel() {
		return level;
	}
}
