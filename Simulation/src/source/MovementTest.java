package source;

public class MovementTest {
	
	public MovementTest()
	{
		int x = 10; 
		int y = 10;
		int[][] field = new int[x][y];
		
		
		
		for(int i = 0; i < x; i++)
		{
			for(int j = 0; j < y; j++)
			{
				field[i][j] = (10*i) + j + 1; 
			}
		}
		
		for(int i = 0; i < x; i++)
		{
			for(int j = 0; j < y; j++)
			{
				System.out.println(field[i][j]);
			}
		}
	}

}
