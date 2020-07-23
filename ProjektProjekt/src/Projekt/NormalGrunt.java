package Projekt;

import java.awt.Color;

public class NormalGrunt extends SmartEnemyV2{

	public NormalGrunt(float x, float y, ID id, handler handle, float health) {
		super(x, y, id, handle, health);
		// TODO Auto-generated constructor stub
		col = Color.pink;
		this.health=4;
		this.speed=4;
		this.color=1;
	}

}
