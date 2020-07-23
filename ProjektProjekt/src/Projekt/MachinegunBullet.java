package Projekt;

import java.util.Random;

public class MachinegunBullet extends Bullet{
	
	Random r = new Random();

	public MachinegunBullet(float x, float y, ID id, handler handle, int facing) {
		super(x, y, id, handle, facing);
		dmg=1;
		
		switch(facing) {
		case 0: velY = -5; velX = r.nextInt(3); velX = -1 + velX; velX = velX/4;
		break;
		case 1: velX = 5; velY = r.nextInt(3); velY = -1 + velY; velY = velY/4;
		break;
		case 2: velY = 5; velX = r.nextInt(3); velX = -1 + velX; velX = velX/4;
		break;
		case 3: velX = -5; velY = r.nextInt(3); velY = -1 + velY; velY = velY/4;
		}
	}

}
