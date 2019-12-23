package Four_In_A_Row;

import java.util.Scanner;

public class Launcher {
	
	public void launch() {
		Game game = new Game("PLAYER 1","PLAYER 2");
		Scanner sc = new Scanner(System.in);
	
		while (!game.isGameOver)
			{
			game.display(game.grid);
			System.out.println("Move #: "+game.getCounter());	
			System.out.println(game.isRedsMove ? game.p1 + " to move" : game.p2 + " to move");
			System.out.println("Which column will you choose? (1-7)");		
			
			if (!game.move(sc.nextInt())) 
				continue;
			
			if (game.getCounter()==42) 
				{
				game.isGameOver=true;
				System.out.println("This game is a tie.");
				}
			}
		
		
		game.display(game.grid);
		sc.close();
		
	}
}