package source;

public abstract class Weapon {
	
	String name;
	
	double atlow; 		//Low-Variance
	double athigh;		//High-Variance
	double cChance;	//Crit Chance
	double cDam;		//Crit Damage
	
	int sAt,pAt,iAt; //Attack values for Slash, Pierce, and Impact (Physical)
	int hAt,cAt,eAt; //Attack values for Heat, Cold, and Electric (Elemental)
	int rAt,bAt,oAt; //Attack values for Radioactive, Blast, and Corrosice (Special)

	
	public double getatlow()
	{
		return atlow;
	}
	
	public double getathigh()
	{
		return athigh;
	}
	
}
