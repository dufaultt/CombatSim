package source;
import java.io.*;
import java.util.Date;
import java.util.Random;

public class Main {
	
	public static void main(String args[]) throws IOException
	{
		Combatant c1,c2;
		int str1,str2,edu1,edu2,dex1,dex2,wil1,wil2,itl1,itl2,agi1,agi2,per1,per2,lAtk1,lAtk2,hAtk1,hAtk2;
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
		
		c1.setArmor(0, 0, 0, 0, 0, 0, 0, 0, 0);
		c2.setArmor(0, 0, 0, 0, 0, 0, 0, 0, 0);
		
		int dam,bl,hits,wHits,accur,mark;
		int rounds = 0, sets = 0;
		int c1wins = 0, c2wins = 0;
		int nexround = 0;
		int calchealth;						//Check health after damage
		int blstat=0,blstat2=0;				//Legacy Block stats
		int damstat = 0;
		int[] curDam = {0,0,0,0,0,0,0,0,0};
		int[] curArm = {0,0,0,0,0,0,0,0,0};
		double vardam,indam;
		Random random = new Random((int) (new Date().getTime()/1000));
		Random random2 = new Random((int) (new Date().getTime()/1000)+1);
		
		File file = new File("H:/Work/Simulation/Specialout.txt");
		File file2 = new File("H:/Work/Simulation/BattleLog.txt");
        FileWriter fr = null;
        FileWriter fr2 = null;
    
        fr = new FileWriter(file);
        fr2 = new FileWriter(file2);
        fr.write("Global Stats\n");
        
		

		while(sets<10)
		{
			while(rounds<10)
			{	
				nexround = 0;
				//Turn1
				
				c1.wep1.moveselect();//select move
				wHits = c1.wep1.getHits();//get number of hits
				dam = 0;//reset damage
				hits = 0;
				accur = c1.wep1.getAccur();

				for(int i = 0; i<wHits; i++)//calculate misses/hits
				{
					mark = random2.ints(0,(100+1)).findFirst().getAsInt();
					if(mark < accur)
					{
						hits++;
					}
					
				}
				
				for(int i = 0; i<hits; i++)//Calculate total damage
				{
					vardam = random.doubles(c1.wep1.getatlow(),(c1.wep1.getathigh())).findFirst().getAsDouble();
					curDam = c1.wep1.getdam();
					curArm = c2.getArmor();
					for(int j = 0;j<9;j++)
					{
						indam = (curDam[j]*vardam)-curArm[j];
						
						if(indam < 0)
						{
							indam = 0;
						}
						
						dam = dam + (int)indam;
						
					}
					 
					if(dam < 1) 
					{
						dam = 1;
					}
					
				}
				
				
				bl = random2.ints(0,(100+1)).findFirst().getAsInt();
				fr2.write("C1 attacks\n");
				
				if(bproc2 > bl)
				{
					dam = dam/2;
					blstat++;
					blstat2 = blstat2+dam;
					fr2.write("Blocked!\n");
				}
				
				if(dam<=0)
					dam=1;
				
				
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
				//System.out.println("C1 Health " + c1.gethealth());
				//System.out.println("C2 Health " + c2.gethealth());
				////////////////////////////////////////////////////////////////////////////////////////////////////////
				
				//Turn2
				if(nexround == 0)
				{
					
					c2.wep1.moveselect();//select move
					wHits = c2.wep1.getHits();//get number of hits
					dam = 0;//reset damage
					hits = 0;
					accur = c2.wep1.getAccur();

					for(int i = 0; i<wHits; i++)//calculate misses/hits
					{
						mark = random2.ints(0,(100+1)).findFirst().getAsInt();
						if(mark < accur)
						{
							hits++;
						}
						
					}
					
					for(int i = 0; i<hits; i++)
					{
						vardam = random.doubles(c2.wep1.getatlow(),(c2.wep1.getathigh())).findFirst().getAsDouble();
						curDam = c2.wep1.getdam();
						curArm = c1.getArmor();
						for(int j = 0;j<9;j++)
						{
							indam = (curDam[j]*vardam)-curArm[j];
							if(indam < 0)
							{
								indam = 0;
							}
							
							dam = dam + (int)indam;
							
						}
						
						if(dam < 1)
						{
							dam = 1;
						}
						
					}

					bl = random2.ints(0,(100+1)).findFirst().getAsInt();
					fr2.write("C2 attacks\n");
					
					if(bproc1 > bl)
					{
						fr2.write("Blocked! " + dam );
						dam = dam/8;
						
					}
					
					if(dam<=0)
						dam=1;
					
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

}
