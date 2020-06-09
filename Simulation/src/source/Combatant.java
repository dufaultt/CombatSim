package source;

public class Combatant {
	
	//Base Stats
	int str;
	int dex;
	int edu;
	int itl;
	int wil;
	int agi;
	int per;

	//Health Values
	int HP;				//Current Hit Points
	int initialHP;		//Max Hit Points
	int regenHP;		//Health Regen
	int Stam;			//Current Stamina
	int initialStam;	//Max Stamina
	int regenStam;		//Stamina Regen
	
	//Attack Values
	Weapon wep1;
	
	//Defensive Secondary Stats
	int blproc;			//Block Proc
	int rEva,mEva;		//Evasion for Ranged and Melee attacks
	
	//Offensive Secondar Stats
	int cproc;			//Crit Chance
	int rAcc,mAcc;		//Accuracy for Ranged and Melle attacks
	
	//Armour Values
	
	
	
	
	//Constant Modifiers//*********************************************
	
	//Base Stat Modifiers
	float cstr = 1;		//Constant Modifier for Strength
	float cdex = 1;		//Constant Modifier for Dexterity
	float cedu = 1;		//Constant Modifier for Endurance
	float citl = 1;		//Constant Modifier for floatelligence
	float cwil = 1;		//Constant Modifier for Willpower
	float cagi = 1;		//Constant Modifier for Agility
	float cper = 1;		//Constant Modifier for Perception
	
	//Defensive Modifiers
	float cblproc = 1;	//Constant Modifier for Block Chance
	float physDBres = 1;//Constant Modifier for Phyisical Debuff Resistance
	float mentDBres = 1;//Constant Modifier for Mental Debuff Resistance
	
	//Offensive Modifiers
	float ccproc = 1;	//Constant Modifier for Crit Chance
	float ccdproc = 1;	//Constant Modifier for Crit Damage
	float physDBproc = 1;//Constant Modifier for Physical Debuff Infliction Chance
	float mentDBproc = 1;//Constant Modifier for Physical Debuff Infliction Chance
	
	
	//Constant Modifiers//*********************************************
	
	
	
	
	
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
