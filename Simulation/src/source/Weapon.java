package source;

public abstract class Weapon {
	
	String name;
	
	double atlow; 		//Low-Variance
	double athigh;		//High-Variance
	double cChance;		//Crit Chance
	double cDam;		//Crit Damage
	int[] curDam = {0,0,0,0,0,0,0,0,0}; //Current Damage
	int accur;
	String movName;
	
	int pAt,sAt,iAt; //Attack values for Slash, Pierce, and Impact (Physical)
	int hAt,cAt,eAt; //Attack values for Heat, Cold, and Electric (Elemental)
	int rAt,bAt,oAt; //Attack values for Radioactive, Blast, and Corrosice (Special)
	
	int moves,hits;

	
	public double getatlow()
	{
		return atlow;
	}
	
	public double getathigh()
	{
		return athigh;
	}
	
	public void moveselect()
	{
		
	}
	
	public int getHits()
	{
		return hits;
	}
	
	public int[] getdam()
	{
		return curDam;
	}
	
	public int getAccur()
	{
		return accur;
	}
	
	public String getName()
	{
		return movName;
	}
	
}
