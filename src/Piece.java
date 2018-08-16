/*************************
 * Created: 30 July 2019
 * Author: Pearson Basham 
 ************************/

public class Piece {
	private String color;
	private int position;
	
	public Piece(String color, int position) {
		this.color = color;
		this.position = position;
	}
	
	public Piece(String color) {
		this.color = color;
		position = 1;
	}
	
	public void setColor(String newColor) { color = newColor; }
	public String getColor() { return color; }
	
	public void movePostion() { position++; }
	public int getPostion() { return position; }
}
