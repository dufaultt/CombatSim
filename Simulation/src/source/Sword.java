package source;

import java.util.Date;
import java.util.Random;

public class Sword extends Weapon{
	
	double atlow;
	double athigh;
	int accur,bl;
	double cChance;
	double cDam;
	int[] curDam = {0,0,0,0,0,0,0,0,0};
	int hits;
	char atType;
	
	
	String movName;

	int pAt = 50;
	int sAt = 50;	
	int iAt = 30;
	int hAt = 0;
	int cAt = 0;
	int eAt = 0;
	int rAt = 0;
	int bAt = 0;
	int oAt = 0;
	
	int moves = 2;
	int movSelect;
	
	Random random = new Random((int) (new Date().getTime()/1000));
	
	public Sword()
	{
		atlow = 0.8;
		athigh = 1.2;
		bl = 5;
		cChance = 25;
		cDam = 2;
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
		
		movSelect = random.ints(1,(moves+1)).findFirst().getAsInt();
		//System.out.println(movSelect);
		//Resetting damage
		for(int i = 0; i<9; i++)
		{
			curDam[i] = 0;
		}
		hits = 0;
		
		if(movSelect == 1)
		{
			movName = "Slash";
			curDam[1]=sAt;
			accur = 75;
			hits = 1;
			atType = 'M';
		}
		else if(movSelect == 2)
		{
			movName = "Double Slash";
			curDam[1]=(int)(0.75*sAt);
			
			accur = 50;
			hits = 2;
			atType = 'M';
		}
		else
		{
			System.out.println("error, move select issue");
		}
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
