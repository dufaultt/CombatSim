package source;

public abstract class Weapon {
	
	int atlow; 		//Low-Variance
	int athigh;		//High-Variance
	
	int sAt,pAt,iAt; //Attack values for Slash, Pierce, and Impact (Physical)
	int hAt,cAt,eAt; //Attack values for Heat, Cold, and Electric (Elemental)
	int rAt,bAt,oAt; //Attack values for Radioactive, Blast, and Corrosice (Special)

	
	public int getatlow()
	{
		return atlow;
	}
	
	public int getathigh()
	{
		return athigh;
	}
	
}
