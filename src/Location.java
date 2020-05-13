
public abstract class Location {
	
	protected int distance;
	protected String name;
	protected int xPos;
	protected int yPos;
	
	public Location(int x, int y, String name) {
		this.xPos = x;
		this.yPos = y;
		this.name = name;
		this.distance = 0;
	}
	
	public abstract int shortestRoute();
	
	public int distanceFrom(Location otherLoc) {
		return (int) Math.sqrt(Math.pow(xPos- otherLoc.xPos, 2) - Math.pow(yPos- otherLoc.yPos, 2));
	}
	
	
	
	public String getName() {
		return name;
	}
	
	public int getXPos() {
		return xPos;
	}
	
	public int getYPos() {
		return yPos;
	}
	
	public int getDistance() {
		return distance;
	}
	

}
