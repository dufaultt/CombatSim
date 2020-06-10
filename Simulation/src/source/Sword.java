package source;

public class Sword extends Weapon{
	
	int atlow;
	int athigh;
	float accur;
	
	public Sword()
	{
		atlow = 25;
		athigh = 50;
		accur = 1;
	}
	
	public double getatlow()
	{
		return atlow;
	}
	
	public double getathigh()
	{
		return athigh;
	}
	
	public float getaccur()
	{
		return accur;
	}

}
