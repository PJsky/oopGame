package Projekt;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = -2726381095187940165L;
	private handler handle;
	private HUD hud;
	private Spawner spawn;
	private MainMenu menu;
	public static BufferedImage sSheet,sSheet2,sSheetE,sSheetW,sSheetH,sSheetBS,sSheetPog; //1 spritesheet for whole game
	
	public static final int WIDTH = 1280, HEIGHT = 960;
	private Thread thread; // 1 thread game
	private boolean running = false;
	
	public enum STATE {
		Menu,
		Game,
		Help,
		End,
		Win
	}
	
	public int players=1;
	public STATE gameState = STATE.Menu;
	
	public Game() {
		
		handle = new handler();
		
		
		hud = new HUD(handle, this);
		spawn = new Spawner(handle, hud);
		menu = new MainMenu(this,handle);
		this.addKeyListener(new KeyInput(handle));
		this.addMouseListener(menu);
		new Window(WIDTH, HEIGHT, "Tytul gry!", this);
		
		ImgLoader loader = new ImgLoader(); 
		
		sSheet = loader.loadImage("/Pitro.png");
		sSheet2 = loader.loadImage("/Pitro.png");
		sSheetE = loader.loadImage("/G.png");
		sSheetW = loader.loadImage("/prz.png");
		sSheetH = loader.loadImage("/H.png");
		sSheetBS = loader.loadImage("/Bs.png");
		sSheetPog = loader.loadImage("/PogChamp.png");


		
		
		if(gameState == STATE.Menu) {
			handle.addObject(new PlayerPreview(250-16,470-24, ID.PlayerPreview, handle,Color.white));
			handle.addObject(new PlayerPreview(1010-16,470-24, ID.PlayerPreview2, handle,Color.white));
		}
		
		
		if(gameState == STATE.Game) {
			//p1 spawn
			/*handle.addObject(new Player(100,100, ID.Player, handle,Color.white));
			//p2 spawn
			//handle.addObject(new Player(100,100, ID.Player2, handle));
			
			//handle.addObject(new BossEnemy(480,-100, ID.BossEnemy, handle));
			//handle.addObject(new Enemy(200,200, ID.Enemy, handle));
			//handle.addObject(new SmartEnemyV2(300,300, ID.Enemy, handle));*/
		}
		
	}
	

	public synchronized void start() {
		thread = new Thread(this);
		thread.start(); //running a thread begining the work
		running = true;
	}
	
	
	public synchronized void stop() {
		try {
			thread.join(); // waits for this tread to die, killing off the thread
			running = false;
		}catch(Exception e) {
			e.printStackTrace();// tells us why program stopped if it bugged
		}
	}
	
	
	
	
	public void run()
    {
		
		this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 9.0;
        double ns = 150000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running)
        {
                    long now = System.nanoTime();
                    delta += (now - lastTime) / ns;
                    lastTime = now;
                    while(delta >=1)
                            {
                                tick();
                                delta--;
                            }
                            if(running)
                                render();
                            frames++;
                            
                            if(System.currentTimeMillis() - timer > 1000)
                            {
                                timer += 1000;
                                System.out.println("FPS: "+ frames);
                                frames = 0;
                            }
        }
                stop();
    }
	
	
	
	private void tick() {
		handle.tick();
		if(spawn.win == true) {
			spawn.win = false;
			gameState = STATE.Win;
		}
		if(gameState == STATE.Game) {
			hud.tick();
			spawn.tick();
			
			
			
			
			
		}else if (gameState == STATE.Menu) {
			menu.tick();
		}else if (gameState == STATE.Help) {
			menu.tick();
		}else if (gameState == STATE.End) {
			hud.setScore(0);
			hud.setLevel(1);
			spawn.timeOn();
			gameState = STATE.Menu;
		}else if (gameState == STATE.Win) {
			menu.tick();
		}
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		
		Graphics g = bs.getDrawGraphics();
		
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		
		
		
		if(gameState == STATE.Game)
		{
			hud.render(g);
		}else if (gameState == STATE.Menu) {
			menu.render(g);
		}else if (gameState == STATE.Help) {
			menu.render(g);
		}else if (gameState == STATE.End) {
		}else if (gameState == STATE.Win) {
			menu.render(g);
		}
		handle.renderb(g);
		g.dispose();
		bs.show();
	}
	
	
	public static float clamp(float var, float min, float max) {
		if(var>=max) return var = max;
		else if (var<=min) return var = min;
		else return var;
	}
	
	
	
	public  static void main(String args[]) {
		new Game();
	}

}
