package Projekt;

public class SniperBullet extends Bullet{

	public SniperBullet(float x, float y, ID id, handler handle, int facing) {
		super(x, y, id, handle, facing);
		dmg=5;
		
		switch(facing) {
		case 0: velY = -7;
		break;
		case 1: velX = 7;
		break;
		case 2: velY = 7;
		break;
		case 3: velX = -7;
		}
		sniper = true;
	}

}
