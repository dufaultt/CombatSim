package source;
import java.io.*;
import java.util.Date;
import java.util.Random;

public class Main {
	
	static Random rGlobal = new Random((int) (new Date().getTime()/1000)+2);
	static double vardam;
	static double varcrit;
	static int varblockc;
	double indam;
	static int[] curDam = {0,0,0,0,0,0,0,0,0};
	static int[] curArm = {0,0,0,0,0,0,0,0,0};
	static String atkName;
	static FileWriter fr2 = null;
	static File file2 = new File("H:/Work/Simulation/BattleLog.txt");
	
	public static void main(String args[]) throws IOException
	{
			
		Combatant c1,c2;
		int str1,str2,edu1,edu2,dex1,dex2,wil1,wil2,itl1,itl2,agi1,agi2,per1,per2;
		int bproc1,bproc2;
		Weapon wep1,wep2;
		
		//Combatant 1
		str1 = 100;
		edu1 = 100;
		dex1 = 50;
		wil1 = 50;
		itl1 = 50;
		agi1 = 50;
		per1 = 50;
		bproc1 = 0;
		wep1 = new Sword(); 
		
		
		//Combatant 2
		str2 = 100;
		edu2 = 100;
		dex2 = 50;
		wil2 = 50;
		itl2 = 50;
		agi2 = 50;
		per2 = 50;
		wil2 = 50;
		bproc2 = 0;
		wep2 = new Sword();
		
		c1 = new Combatant(str1,edu1,dex1,wil1,itl1,agi1,per1,wep1);
		c2 = new Combatant(str2,edu2,dex2,wil2,itl2,agi2,per2,wep2);
		
		c1.setArmor(0, 1, 0, 0, 0, 0, 0, 0, 0);
		c2.setArmor(0, 1, 0, 0, 0, 0, 0, 0, 0);
		
		int dam,bl,hits,wHits,accur,mark;
		int rounds = 0, sets = 0;
		int c1wins = 0, c2wins = 0;
		int nexround = 0;
		int calchealth;						//Check health after damage
		int blstat=0,blstat2=0;				//Legacy Block stats
		int damstat = 0;

		
		
		Random random = new Random((int) (new Date().getTime()/1000));
		Random random2 = new Random((int) (new Date().getTime()/1000)+1);
		
		File file = new File("H:/Work/Simulation/Specialout.txt");
		
        FileWriter fr = null;
        //FileWriter fr2 = null;
    
        fr = new FileWriter(file);
        fr2 = new FileWriter(file2);
        fr.write("Global Stats\n");
        
		

		while(sets<10)
		{
			while(rounds<10)
			{	
				nexround = 0;
				//Turn1
				dam = attack(c1,c2);
				
				fr2.write("C1 attacks using " + atkName + "\n");
				
				calchealth = c2.gethealth() - dam;
				fr2.write("C2 takes " + dam + " damage\n");
				if(calchealth <= 0)
				{
					c2.resethealth();
					c1.resethealth();
					rounds++;
					c1wins++;
					fr2.write("C1 wins round\n\n");			
				}
				else
				{
					c2.sethealth(calchealth);
					fr2.write("C2 to " + c2.gethealth() + " health\n");
				}
				
				
				damstat = damstat+dam;
				////////////////////////////////////////////////////////////////////////////////////////////////////////
				////////////////////////////////////////////////////////////////////////////////////////////////////////
				
				//Turn2
				if(nexround == 0)
				{
					dam = attack(c2,c1);
					
					fr2.write("C2 attacks using " + atkName + "\n");
					
					
					calchealth = c1.gethealth() - dam;
					fr2.write("C1 takes " + dam + " damage\n");
					if(calchealth <= 0)
					{
						//System.out.println("here2");
						c1.resethealth();
						c2.resethealth();
						rounds++;
						c2wins++;
						fr2.write("C2 wins round\n\n");
					}
					else
					{
							c1.sethealth(calchealth);
							fr2.write("C1 to " + c1.gethealth() + " health\n");
					}
					damstat = damstat+dam;
				}
				
			}
			System.out.println(c1wins + " " + c2wins);
			rounds = 0;
			sets++;
			c1wins = 0;
			c2wins = 0;
			
			
		}
		fr.write("Total Damage Dealt: "+Integer.toString(damstat)+"\n");
		fr.write("Blocks: "+Integer.toString(blstat)+"\n");
		fr.write("Damage Mitigated: "+Integer.toString(blstat2)+"\n");
		fr.close();
		fr2.close();
	

				
	}
	
	public static int attack(Combatant com1, Combatant com2) throws IOException
	{
		com1.wep1.moveselect();//select move
		int wHits = com1.wep1.getHits();//get number of hits
		int dam = 0;//reset damage
		double indam = 0;//reset in progress damage
		int hits = 0;//reset hits
		int accur = com1.wep1.getAccur();//get Accuracy
		double crit = com1.getWepcChance();
		double critd = com1.getWepcdam();
		atkName = com1.wep1.getName();

		//Accuracy Modifier calculation
		if(com1.wep1.getAtType() == 'M')//Melee Accuracy
		{
			accur = (int) (accur*com1.getMAcc());
		}
		else if(com1.wep1.getAtType() == 'R')//Ranged Accuracy
		{
			accur = (int) (accur*com1.getRAcc());
		}
		
		for(int i = 0; i<wHits; i++)//calculate misses/hits
		{ 
			int mark = rGlobal.ints(0,(100+1)).findFirst().getAsInt();
			if(mark < accur)
			{
				hits++;
			}
			
		}
		
		if(hits == 0)//no hits delivered  
			return 0;  
		
		for(int i = 0; i<hits; i++)//Calculate total damage
		{
			vardam = rGlobal.doubles(com1.wep1.getatlow(),(com1.wep1.getathigh())).findFirst().getAsDouble();
			varcrit = rGlobal.doubles(0,(100)).findFirst().getAsDouble();
			curDam = com1.wep1.getdam();
			curArm = com2.getArmor();
			
			if(crit > varcrit)//Checking Crit Chance
			{
				fr2.write("Crit! \n");
				vardam = vardam*critd;
			}
			
			Block(com1,com2);//Checking Block chance and reducing damage accordingly
			
			for(int j = 0;j<9;j++)
			{
				indam = (curDam[j]*vardam)-curArm[j];//Multiplying damage by variance and subtracting armor
				
				if(indam < 0)//no negative damage
				{
					indam = 0;
				}
				
				dam = dam + (int)indam;
				
			}
			 
		}
		
		if(dam < hits)//At least 1 Damage per Hit
		{
			dam = hits;
		}
		return dam;
	
	}
	
	public static void Block(Combatant com1, Combatant com2) throws IOException
	{
		int chance = com1.getBlockC();
		int mark = rGlobal.ints(0,(100+1)).findFirst().getAsInt();
		int[] reduction;
		
		
		
		if(mark<chance)
		{
			fr2.write("Block! \n");
			reduction = com1.getBlockA();
			
			for(int j = 0;j<9;j++)
			{	
				if(curDam[j] !=0)
				{
					curDam[j] = (int)(curDam[j] - ((float)curDam[j]*((float)reduction[j]/100)));
				}
			}
		}
		
		//return dam;
	}
}
