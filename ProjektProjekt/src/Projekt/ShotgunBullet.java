package Projekt;

public class ShotgunBullet extends Bullet{

	public ShotgunBullet(float x, float y, ID id, handler handle, int facing) {
		super(x, y, id, handle, facing);
		dmg=3;
		
		switch(facing) {
		case 0: velY = -5;
		break;
		case 1: velX = 5;
		break;
		case 2: velY = 5;
		break;
		case 3: velX = -5;
		}
	}

}
