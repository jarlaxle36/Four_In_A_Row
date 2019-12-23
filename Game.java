package Four_In_A_Row;

public class Game {
	public final static int NUM_ROWS=6;
	public final static int NUM_COLS=7;
	String p1, p2;
	boolean isGameOver, isWinner;
	private int counter;
	boolean isRedsMove;
	public int[][] grid;
	public int dropped;
	
	
	public Game(String player1, String player2) 
		{
		grid = new int[NUM_COLS][NUM_ROWS];
		this.p1 = player1;
		this.p2 = player2;
		isGameOver = false;
		isRedsMove = true;
		counter=1;
		}

	public void display(int[][] grid) 
	{
		
		for (int j=Game.NUM_ROWS-1;j>=0;j--) {
			System.out.println("---------------------------------------");
				for (int i=0;i<Game.NUM_COLS;i++)
					System.out.print(grid[i][j]>0 ? " |  "+grid[i][j] : " |   ");
					System.out.print("  |");
					System.out.println("");
					}
			System.out.println("----------------------------------------");
	}
	
	public int getCounter() 	
		{
			return counter;
		}
	boolean didWin(int x, int y) 
		{
			if (checkRow(grid,x,y) ||
			checkCol(grid, x,y) ||
			checkLeftDiag(grid, x,y) ||
			checkRightDiag(grid,x,y))
				
			{
				isGameOver=true;
				System.out.println("Game Over.  "+ (!isRedsMove ? "Red" : "Yellow") + " has won!");
				return true;
			} else {
				return false;
			}
		}	
		

		
		
		public boolean move(int input) 	
			{		
				try{return addPiece(input-1);}
				catch (RuntimeException r) {
					System.out.println("Sorry, that is not a valid column #");
					return false;
				}
				
			}
		
		
	public boolean addPiece(int c) 
		 
			{
			int open=0;
			
			while (open<6)
				if (grid[c][open] > 0) open += 1;
				else break;
			
				if (open==6)				
					{System.out.println("Sorry, this column is full.  Try again.");
					return false;}
				else 
					{
					grid[c][open]=isRedsMove ? 1 : 2 ;
					
					isRedsMove = !isRedsMove;
					counter++;
					return didWin(c,open)? true : false;
					}
				
			}
	public boolean checkRow(int[][] spot, int x, int y) 
		{
			if (spot[0][y] != 0 &&
				spot[0][y]==spot[1][y] && 
				spot[0][y]==spot[2][y] &&
				spot[0][y]==spot[3][y]) return true;
					
				
			else if (spot[1][y] != 0 &&
					spot[1][y]==spot[2][y] && 
					spot[1][y]==spot[3][y] &&
					spot[1][y]==spot[4][y]) return true;
					
				
			else if (spot[2][y] != 0 &&
					spot[2][y]==spot[3][y] && 
					spot[2][y]==spot[4][y] &&
					spot[2][y]==spot[5][y]) return true;
					
				
			else if (spot[3][y] != 0 &&
					spot[3][y]==spot[4][y] && 
					spot[3][y]==spot[5][y] &&
					spot[3][y]==spot[6][y]) return true;
			else return false;
					
				
		}
	
	public boolean checkCol(int[][] spot, int x, int y) 
	{
		if (spot[x][0] != 0 &&
			spot[x][0]==spot[x][1] && 
			spot[x][0]==spot[x][2] &&
			spot[x][0]==spot[x][3]) return true;
				
			
		else if (spot[x][1] != 0 &&
				spot[x][1]==spot[x][2] && 
				spot[x][1]==spot[x][3] &&
				spot[x][1]==spot[x][4]) return true;
				
			
		else if (spot[x][2] != 0 &&
				spot[x][2]==spot[x][3] && 
				spot[x][2]==spot[x][4] &&
				spot[x][2]==spot[x][5]) return true;
				
		else return false;
				
			
	}
	
	public boolean checkLeftDiag(int[][]spot, int x, int y) 
		{
		switch (x+y)
		{
		case 3: 
			if (spot[3][0] != 0 &&
			spot[3][0]==spot[2][1] && 
			spot[3][0]==spot[1][2] &&
			spot[3][0]==spot[0][3]) return true;
			else return false;
			
		case 4: 
			if (spot[4][0] != 0 &&
			spot[4][0]==spot[3][1] && 
			spot[4][0]==spot[2][2] &&
			spot[4][0]==spot[1][3]) return true;
			
			else if (spot[3][1] != 0 &&
					spot[3][1]==spot[2][2] && 
					spot[3][1]==spot[1][3] &&
					spot[3][1]==spot[0][4]) return true;
			else return false;
			
		case 5: 
			if (spot[5][0] != 0 &&
			spot[5][0]==spot[4][1] && 
			spot[5][0]==spot[3][2] &&
			spot[5][0]==spot[2][3]) return true;
			
			else if (spot[4][1] != 0 &&
					spot[4][1]==spot[3][2] && 
					spot[4][1]==spot[2][3] &&
					spot[4][1]==spot[1][4]) return true;
			
			else if (spot[3][2] != 0 &&
					spot[3][2]==spot[2][3] && 
					spot[3][2]==spot[1][4] &&
					spot[3][2]==spot[0][5]) return true;
			else return false;
			
		case 6: 
			if (spot[6][0] != 0 &&
			spot[6][0]==spot[5][1] && 
			spot[6][0]==spot[4][2] &&
			spot[6][0]==spot[3][3]) return true;
			
			else if (spot[5][1] != 0 &&
					spot[5][1]==spot[4][2] && 
					spot[5][1]==spot[3][3] &&
					spot[5][1]==spot[2][4]) return true;
			
			else if (spot[4][2] != 0 &&
					spot[4][2]==spot[3][3] && 
					spot[4][2]==spot[2][4] &&
					spot[4][2]==spot[1][5]) return true;
			else return false;
			
		case 7: 
			if (spot[6][1] != 0 &&
			spot[6][1]==spot[5][2] && 
			spot[6][1]==spot[4][3] &&
			spot[6][1]==spot[3][4]) return true;
			
			else if (spot[5][2] != 0 &&
					spot[5][2]==spot[4][3] && 
					spot[5][2]==spot[3][4] &&
					spot[5][2]==spot[2][5]) return true;
			else return false;
			
		case 8: 
			if (spot[6][2] != 0 &&
			spot[6][2]==spot[5][3] && 
			spot[6][2]==spot[4][4] &&
			spot[6][2]==spot[3][5]) return true;
			else return false;
		default: return false;
		}
		}
	
	public boolean checkRightDiag(int[][] spot, int x, int y) 
		{
			switch (x-y)
			{
			case -2: 
				if (spot[0][2] != 0 &&
				spot[0][2]==spot[1][3] && 
				spot[0][2]==spot[2][4] &&
				spot[0][2]==spot[3][5]) return true;
				else return false;
				
			case -1: 
				if (spot[0][1] != 0 &&
				spot[0][1]==spot[1][2] && 
				spot[0][1]==spot[2][3] &&
				spot[0][1]==spot[3][4]) return true;
				
				else if (spot[1][2] != 0 &&
						spot[1][2]==spot[2][3] && 
						spot[1][2]==spot[3][4] &&
						spot[1][2]==spot[4][5]) return true;
				else return false;
				
			case 0: 
				if (spot[0][0] != 0 &&
				spot[0][0]==spot[1][1] && 
				spot[0][0]==spot[2][2] &&
				spot[0][0]==spot[3][3]) return true;
				
				else if (spot[1][1] != 0 &&
						spot[1][1]==spot[2][2] && 
						spot[1][1]==spot[3][3] &&
						spot[1][1]==spot[4][4]) return true;
				
				else if (spot[2][2] != 0 &&
						spot[2][2]==spot[3][3] && 
						spot[2][2]==spot[4][4] &&
						spot[2][2]==spot[5][5]) return true;
				else return false;
				
			case 1: 
				if (spot[1][0] != 0 &&
				spot[1][0]==spot[2][1] && 
				spot[1][0]==spot[3][2] &&
				spot[1][0]==spot[4][3]) return true;
				
				else if (spot[2][1] != 0 &&
						spot[2][1]==spot[3][2] && 
						spot[2][1]==spot[4][3] &&
						spot[2][1]==spot[5][4]) return true;
				
				else if (spot[3][2] != 0 &&
						spot[3][2]==spot[4][3] && 
						spot[3][2]==spot[5][4] &&
						spot[3][2]==spot[6][5]) return true;
				else return false;
				
			case 2: 
				if (spot[2][0] != 0 &&
				spot[2][0]==spot[3][1] && 
				spot[2][0]==spot[4][2] &&
				spot[2][0]==spot[5][3]) return true;
				
				else if (spot[3][1] != 0 &&
						spot[3][1]==spot[4][2] && 
						spot[3][1]==spot[5][3] &&
						spot[3][1]==spot[6][4]) return true;
				else return false;
				
			case 3: 
				if (spot[3][0] != 0 &&
				spot[3][0]==spot[4][1] && 
				spot[3][0]==spot[5][2] &&
				spot[3][0]==spot[6][3]) return true;
				else return false;
			default: return false;
			}
		}


		
	}
	

