/*************************
 * Created: 30 July 2019
 * Author: Pearson Basham
 ************************/

import java.util.Random;

public class RollTheDie {
	
	Random roll;

	public RollTheDie() {
		roll = new Random();
	}
	
	public int updateDie() {
		int numberRolled;
		String colorRolled = null;
		
		numberRolled = rollDice();
		
			switch (numberRolled) {
			case 1:
				colorRolled = "Blue";
				break;
			case 2:
				colorRolled = "Red";
				break;
			case 3:
				colorRolled = "Orange";
				break;
			case 4:
				colorRolled = "Yellow";
				break;
			case 5:
				colorRolled = "Green";
				break;
			case 6:
				colorRolled = "Shuffle";
				break;
			default:
				System.out.println("That is not a valid entry");
				break;
			
			}
		System.out.println(colorRolled);
		return numberRolled;
	}

	private int rollDice() {
		System.out.println("Rolling a Dice...");
		int dice = roll.nextInt(6) + 1;
		return dice;
	}

}
