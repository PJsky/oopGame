package Projekt;

import java.util.Random;

public class Spawner {
	
	
	
	private handler handle;
	private HUD hud;
	private Random r = new Random();
	
	private int gameTime = 1,roundTime = 1000; 
	private boolean timeOn = true;
	public boolean win = false;
	
	
	public Spawner(handler handle, HUD hud) {
		this.handle = handle;
		this.hud = hud;
	}
	
	public void tick() {
		if(timeOn)
		gameTime++;
		
		
		for (int i = 0; i<handle.object.size(); i++) {
			GameObject tempObject = handle.object.get(i);
			
			
			if(tempObject.getID() == ID.BossEnemy) {
				
				if(tempObject.getHealth() <= 0) {
				handle.removeObject(tempObject);	
				timeOn = true;
				}
				
				}
			

			
		}
		
		if(gameTime%100 == 3) {
			switch(r.nextInt(3)) {
			case 0:
				handle.addObject(new NormalGrunt(1350, 0, ID.Enemy,handle, 1));
				break;
			case 1:
				handle.addObject(new FastGrunt(1350, 300, ID.Enemy,handle, 1));
				break;
			case 2:
				handle.addObject(new TankyGrunt(1350, 600, ID.Enemy,handle, 1));
				break;
			
			}
		}
		
		if(hud.getScore()%700==1) {
			handle.addObject(new Helicopter(1400,300, ID.Animation, handle));// losowy drop
		}
		
		if(gameTime > roundTime) {
			gameTime = 0;	
			hud.setLevel(hud.getLevel()+1);
			
			
			if(hud.getLevel() == 2) {
				handle.addObject(new BossSpawner(-100,370, ID.BossEnemy, handle));

				timeOn = false;
				
			}
			
			if(hud.getLevel() == 4) {
				handle.addObject(new BossEnemy(1080,760, ID.BossEnemy, handle));
				timeOn = false;
				gameTime = roundTime-100;
						}
			if(hud.getLevel() == 5) {
				handle.object.clear();	
				gameTime = 0;
				hud.setScore(0);
				win= true;
			}
		}
		
		
	}
	
	
	public void setGameTime(int gameTime) {
		this.gameTime = gameTime;
	}
	
	public int getGameTime() {
		return gameTime;
	}
	
	public void timeOn () {
		this.timeOn = true;
	}

}
