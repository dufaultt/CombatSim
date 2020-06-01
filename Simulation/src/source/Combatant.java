package source;

public class Combatant {

	//Health Values
	int HP;
	int initialHP;
	
	//Attack Values
	Weapon wep1;
	
	//procs
	int blproc;
	int cproc;
	
	//Constants
	int cstr = 1;
	int cdex = 1;
	int cedu = 1;
	int citl = 1;
	int cwil = 1;
	int cagi = 1;
	int cper = 1;
	int cblproc = 1;
	int ccproc = 1;
	
	//Base Stats
	int str;
	int dex;
	int edu;
	int itl;
	int wil;
	int agi;
	int per;
	
	public Combatant(int Str, int End, int Dex, int Itl, int Wil, int Agi, int Per, Weapon wep)
	{
		str = Str;
		edu = End;
		dex = Dex;
		edu = End;
		itl = Itl;
		agi = Agi;
		per = Per;
		wep1 = wep;
		calcDerStats();
		
		initialHP = HP;
	}
	
	public void calcDerStats()
	{
		HP = (str*2)+(edu*10);
		cproc = (int) (dex*0.04);
		blproc = (int) (edu*0.01);
	}
	
	public int getcproc()
	{
		return cproc;
	}
	
	public int gethealth()
	{
		return HP;
	}
	
	public int getatlow()
	{
		return wep1.getatlow();
	}
	
	public int getathigh()
	{
		return wep1.getathigh();
	}

	public void sethealth(int health)
	{
		HP = health;
	}
	
	public void resethealth()
	{
		HP = initialHP;
	}
	
		
}
