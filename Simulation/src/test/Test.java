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
		
		
		for(int i=0; i<100;i++)
		{
			d = random.ints(1,(2)).findFirst().getAsInt();
			System.out.println(d);
		}
	}
}
