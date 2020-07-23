package Projekt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
// abstract class
	
	protected float x,y,
				velX, velY,
				health;
	protected int facing = 2,weapon = 1,shootTimer=5,color=1,
					animationTimer=0,speed=0;
	protected boolean moving=false;
	protected ID id;
	public boolean pog = false;
	protected Color col;
	
	public GameObject(float x, float y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
		
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds(); // so we can use rectangle intersection from jre
	
	public void setX(float x) {
		this.x = x;
	}
	
	public float getX() {
		return x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public float getY() {
		return y;
	}
	
	public ID getID() {
		return id;
	}
	
	public void setVelX(float velX) {
		this.velX = velX;
	}
	
	public float getVelX() {
		return velX;
	}
	
	public void setVelY(float velY) {
		this.velY = velY;
	}
	
	public float getVelY() {
		return velY;
	}
	
	public float getHealth() {
		return health;
	}
	
	public void setHealth(float health) {
		this.health = health;
	}
	
	public int getFacing() {
		return facing;
	}
	
	public void setFacing(int facing) {
		this.facing = facing;
	}
	
	public Color getColor() {
		return col;
	}
	public void setColor(Color col) {
		this.col = col;
	}
	
	public int getCol() {
		return color;
	}
	public void setCol(int color) {
		this.color = color;
	}
	
	public int getATimer() {
		return animationTimer;
	}
	
	public void setATimer(int animationTimer) {
		this.animationTimer = animationTimer;
	}
}