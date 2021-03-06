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
	
	//Weapons
	Weapon wep1;
	

	//Defensive Secondary Stats
	double mEva;		//Evasion for Melee attacks
	double rEva;		//Evasion for Ranged attacks
	int[] arm = {0,0,0,0,0,0,0,0,0};
	int sDf,pDf,iDf;	//Armor Stats for Phyiscal attacks
	int hDf,cDf,eDf;	//Armor Stats for Elemental attacks
	int rDf,bDf,oDf;	//Armor Stats for Special attacks
	
	//Constant Modifiers//*********************************************START
	
	//Base Stat Modifiers
	double cstr = 1;		//Constant Modifier for Strength
	double cdex = 1;		//Constant Modifier for Dexterity
	double cedu = 1;		//Constant Modifier for Endurance
	double citl = 1;		//Constant Modifier for doubleelligence
	double cwil = 1;		//Constant Modifier for Willpower
	double cagi = 1;		//Constant Modifier for Agility
	double cper = 1;		//Constant Modifier for Perception
	
	//Defensive Modifiers
	double cblproc = 1;		//Constant Modifier for Block Chance
	double physDBres = 1;	//Constant Modifier for Phyisical Debuff Resistance
	double mentDBres = 1;	//Constant Modifier for Mental Debuff Resistance
	double cmEva = 1;		//Constant Modifier for Melee Evasion
	double crEva = 1;		//Constant Modifier for Ranged Evasion
	
	//Offensive Modifiers
	double ccproc = 1;		//Constant Modifier for Crit Chance
	double ccdproc = 1;		//Constant Modifier for Crit Damage
	double physDBproc = 1;	//Constant Modifier for Physical Debuff Infliction Chance
	double mentDBproc = 1;	//Constant Modifier for Physical Debuff Infliction Chance
	double rAcc = 1;		//Constant Modifier for Ranged accuracy
	double mAcc = 1;		//Constant Modifier for Melee accuracy	
	double melDam = 1;		//Constant Modifier for Melee damage
	
	
	//Constant Modifiers//*********************************************END
	
	
	
	
	
	public Combatant(int Str, int End, int Dex, int Itl, int Wil, int Agi, int Per, Weapon wep)
	{
		str = Str;
		edu = End;
		dex = Dex;
		itl = Itl;
		wil = Wil;
		agi = Agi;
		per = Per;
		wep1 = wep;
		calcDerStats();
		
		HP = initialHP;
	}
	
	public void calcDerStats()
	{
		initialHP = (str*2)+(edu*10);
		rAcc = rAcc + (dex*0.001);
		mAcc = mAcc + (agi*0.001);
		ccproc = ccproc + (per*0.0005);
		ccdproc = ccdproc + (itl*0.0005);
		melDam = melDam + (str*0.001);
		rEva = agi*0.1;
		mEva = agi*0.1;
		physDBres = physDBres + (edu*0.001);
		mentDBres = mentDBres + (wil*0.001);
		physDBproc = physDBproc + ((itl*0.0005) + (per*0.0005));
		mentDBproc = mentDBproc + ((itl*0.0005) + (wil*0.0005));
		
	}
	
	public int gethealth()
	{
		return HP;
	}
	
	public double getatlow()
	{
		return wep1.getatlow();
	}
	
	public double getathigh()
	{
		return wep1.getathigh();
	}

	public void sethealth(int health)
	{
		HP = health;
	}
	
	public double getWepcChance()
	{
		return wep1.getcChance()*ccproc;
	}
	
	public double  getWepcdam()
	{
		return wep1.getcDam()*ccdproc;
	}
	
	public void resethealth()
	{
		HP = initialHP;
	}
	
	public void setArmor(int ipDf,int isDf,int iiDf,int ihDf,int icDf,int ieDf,int irDf,int ibDf,int ioDf)
	{
		pDf = ipDf;
		sDf = isDf;
		iDf = iiDf;
		hDf = ihDf;
		cDf = icDf;
		eDf = ieDf;
		rDf = irDf;
		bDf = ibDf;
		oDf = ioDf;
		updateArmor();
		
	}
	
	public void updateArmor()
	{
		arm[0] = pDf;
		arm[1] = sDf;
		arm[2] = iDf;
		arm[3] = hDf;
		arm[4] = cDf;
		arm[5] = eDf;
		arm[6] = rDf;
		arm[7] = bDf;
		arm[8] = oDf;
	}
	
	public int[] getArmor()
	{
		return arm;
	}
	
	public double getMEva()
	{
		return mEva;
	}
	
	public double getREva()
	{
		return rEva;
	}
	
	public double getMAcc()
	{
		return mAcc;
	}
	
	public double getRAcc()
	{
		return rAcc;
	}
	
	public int getBlockC()
	{
		return wep1.getBlock();
	}
	
	public int[] getBlockA()
	{
		return wep1.getBlockA();
	}
	
	public double getMelDam()
	{
		return melDam;
	}
	
		
}
