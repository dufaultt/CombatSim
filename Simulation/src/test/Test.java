package test;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

public class Test {
	public static void main(String args[]) throws IOException
	{
		Random random = new Random((int) (new Date().getTime()/1000));
		random.ints(1,(2)).findFirst().getAsInt();
		int d;
		double e;
		
		
		for(int i=0; i<9;i++)
		{
			d = random.ints(1,(2)).findFirst().getAsInt();
			e = random.doubles(0,(100)).findFirst().getAsDouble();
			System.out.println(d);
			System.out.println(e);
		}
	}
}
