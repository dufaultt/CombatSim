package source;

public class Sword extends Weapon{
	
	double atlow;
	double athigh;
	float accur;
	
	int sAt = 50;
	int pAt = 50;
	int iAt = 30;
	int hAt = 0;
	int cAt = 0;
	int eAt = 0;
	int rAt = 0;
	int bAt = 0;
	int oAt = 0;
	
	
	public Sword()
	{
		atlow = 0.8;
		athigh = 1.2;
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
