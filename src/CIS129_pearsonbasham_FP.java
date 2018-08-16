/*************************
 * Created: 30 July 2019
 * Author: Pearson Basham
 * Purpose: This is the main class of the project
 ************************/
import java.util.Scanner;

public class CIS129_pearsonbasham_FP{
	
		static RollTheDie rollTheDie = new RollTheDie();
		static Board board = new Board();
		static String dieColors[] = {"B", "R", "O", "Y", "G"};
		static Scanner sc = new Scanner(System.in);
	
		public static void main(String[] args) {
			int numberOfPlayers = askNumberOfPalyers();
			System.out.println("No. of pLayers: "+numberOfPlayers);
			board.printBoard(false, -1);
			play(numberOfPlayers);
			
		}
		
		public static void play(int players) {
			int currentPlayer = 0;
			int position;
			while(true) {
				System.out.println("Player "+ (char)(currentPlayer+65));
				int dieRolled = rollTheDie.updateDie();
				if(dieRolled == 6) {
					board.shuffle();
					board.printBoard(false, -1);
				} else {
					System.out.println("Guess the Position of Color (1 to 5)");
					position = sc.nextInt() - 1;
					while (position < 0 || position > 4) {
						System.out.println("Please enter a value between 1 and 5");
						System.out.println("Guess the Position of Color (1 to 5)");
						position = sc.nextInt() - 1;
					}
					boolean answer = board.isGuessCorrect(position, dieColors[dieRolled-1]);					
					if(!answer) {
						currentPlayer = (currentPlayer+1)%players;
						System.out.println("Wrong Answer, next PLayer, "+currentPlayer);
						board.printBoard(false, -1);
					}else {
						if(board.isWon()) {
							board.printBoard(true, position);
							String checkSpace = "";
							int column = 0;
							checkSpace = board.pieceArray[column].getColor();
							System.out.println("Player "+ (char)(currentPlayer+65) + " won the Game! Thanks playing!");
							break;
						}
						board.printBoard(true, position);
					}
				}
				
			}
			sc.close();
		}
		public static int askNumberOfPalyers() {
			int numberOfPlayers;
			
			System.out.println("How many are playing today? \\nChoose between 2 and 4 players.");
			numberOfPlayers = sc.nextInt();
			while (numberOfPlayers < 2 || numberOfPlayers > 4) {
				System.out.println("Please enter a number of players between 2 and 4");
				System.out.println("How many are playing today? \nChoose between 2 and 4 players.");
				numberOfPlayers = sc.nextInt();
			}
			return numberOfPlayers;
		}
}


