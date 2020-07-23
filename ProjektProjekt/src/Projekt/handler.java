package Projekt;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

public class handler {

	LinkedList<GameObject> object = new LinkedList<GameObject>();
	
	public void tick() {
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.tick();
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
			
			
		}
		
		for(int i = object.size()-1; i >= 0; i--) {
			GameObject tempObject = object.get(i);
			if(tempObject.id == ID.Animation)
			tempObject.render(g);
		}
	}
	
	public void renderb(Graphics g) {
		for(int i = object.size()-1; i >= 0; i--) {
			GameObject tempObject = object.get(i);
			
			tempObject.render(g);
		}
		for(int i = object.size()-1; i >= 0; i--) {
			GameObject tempObject = object.get(i);
			if(tempObject.id == ID.Animation)
			tempObject.render(g);
		}
	}
	
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
	
	public void clearEnemies() {
		for(int i = 0; i < object.size(); i++) {
			GameObject tempObject = object.get(i);
			
			object.clear();

			
		}
	}
	
}
