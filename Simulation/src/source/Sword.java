package source;

import java.util.Date;
import java.util.Random;

public class Sword extends Weapon{
	
	double atlow;
	double athigh;
	int accur;
	double cChance = 25;
	double cDam = 2;
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
	
	int moves = 1;
	int movSelect;
	
	
	public Sword()
	{
		atlow = 0.8;
		athigh = 1.2;
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
		Random random = new Random((int) (new Date().getTime()/1000));
		movSelect = random.ints(1,(moves+1)).findFirst().getAsInt();
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
	
	
	
}
