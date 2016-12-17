package src.org.travis.adventofcode;

public class tomCruise {

	public enum cardinalDirection {
		NORTH, EAST, SOUTH, WEST
	}
	
	public int[][] coordinates = new int[1][2];
	public cardinalDirection direction;
	
	public tomCruise(cardinalDirection direction, int[][] coordinates){
		this.direction = direction;
		this.coordinates = coordinates;
	}
	
	public int[][] getCoordinates() {
		return coordinates;
	}
	public cardinalDirection getDirection() {
		return direction;
	}
	
	public void setCoordinates(int[][] coordinates) {
		this.coordinates = coordinates;
	}
	public void setDirection(cardinalDirection direction) {
		this.direction = direction;
	}
}
