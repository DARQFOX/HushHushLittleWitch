/*************************
 * Created: 30 July 2019
 * Author: Pearson Basham
 ************************/

import java.util.Random;

public class Board {
	Piece[] pieceArray = new Piece[5];
	
	public Board() {
		pieceArray[0] = new Piece("B");
		pieceArray[1] = new Piece("R");
		pieceArray[2] = new Piece("O");
		pieceArray[3] = new Piece("Y");
		pieceArray[4] = new Piece("G");
	}
	public void printBoard(boolean show, int position) {
		String sep = " | ";
		System.out.println("\nThe positon of each piece is as shown below.");
		
		for (int row = 5; row >= 0; row-- ) {
			if (row == 0) {
				String spaces = "";
				for (int i = 0; i < sep.length(); i++) {
					spaces += " ";
				}
				System.out.print(" ");
				for (int i = 0; i < 5; i ++) {
					System.out.print(spaces + (1 + i));
				}
			} else {			
				System.out.print(row + sep);
				for (int column = 0; column < 5; column++) {
					String checkSpace = "";
					if (row == pieceArray[column].getPostion()) {			
						if(show && position == column)
							checkSpace = pieceArray[column].getColor();
						else
							checkSpace = "X";
					} else {						
						checkSpace = " ";
					}
					System.out.print(checkSpace + sep);
				}
			}
			System.out.println();
		}
	}
	
	public void shuffle() {
		Random random = new Random();
		int position1 = random.nextInt(5);
		int position2 = random.nextInt(5);
		while(position1 == position2) {
			position2 = random.nextInt(5);
		}
		Piece temp = pieceArray[position1];
		pieceArray[position1] = pieceArray[position2];
		pieceArray[position2] = temp;
	}
	
	public boolean isGuessCorrect(int position, String dieColor) {
		if(pieceArray[position].getColor().equals(dieColor)) {
			pieceArray[position].movePostion();
			return true;
		}
		return false;
	}
	
	public boolean isWon() {
		for(Piece piece : pieceArray) {
			if(piece.getPostion() == 5)
				return true;
		}
		return false;
	}
}