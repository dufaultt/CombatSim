package source;

public abstract class Weapon {
	
	String name;
	
	double atlow; 		//Low-Variance
	double athigh;		//High-Variance
	double cChance;		//Crit Chance
	double cDam;		//Crit Damage
	int[] curDam = {0,0,0,0,0,0,0,0,0}; //Current Damage
	int accur,bl;
	String movName;
	
	int pAt,sAt,iAt; //Attack values for Slash, Pierce, and Impact (Physical)
	int hAt,cAt,eAt; //Attack values for Heat, Cold, and Electric (Elemental)
	int rAt,bAt,oAt; //Attack values for Radioactive, Blast, and Corrosice (Special)
	
	int bpAt,bsAt,biAt; //Attack values for Slash, Pierce, and Impact (Physical)
	int bhAt,bcAt,beAt; //Attack values for Heat, Cold, and Electric (Elemental)
	int brAt,bbAt,boAt; //Attack values for Radioactive, Blast, and Corrosice (Special)
	
	int[] blockDam;
	int moves,hits;

	public double getcDam()
	{
		return cDam;
	}
	
	public double getcChance()
	{
		return cChance;
	}
	
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
	
	public int getBlock()
	{
		return bl;
	}
	
	public int[] getBlockA()
	{
		return blockDam;
	}
	
}
