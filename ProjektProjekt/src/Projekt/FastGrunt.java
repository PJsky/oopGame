package Projekt;

import java.awt.Color;

public class FastGrunt extends SmartEnemyV2{

	public FastGrunt(float x, float y, ID id, handler handle, float health) {
		super(x, y, id, handle, health);
		// TODO Auto-generated constructor stub
		col = Color.green;
		this.health=3;
		this.speed=5;
		this.color=2;
	}

}
