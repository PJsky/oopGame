package Projekt;

import java.awt.Color;

public class TankyGrunt extends SmartEnemyV2{

	public TankyGrunt(float x, float y, ID id, handler handle, float health) {
		super(x, y, id, handle, health);
		// TODO Auto-generated constructor stub
		col = Color.blue;
		this.health=6;
		this.speed=3;
		this.color=3;
	}

}
