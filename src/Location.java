import java.util.ArrayList;


public class Location{
	
	protected int distance;
	protected String name;
	protected int xPos;
	protected int yPos;
	protected ArrayList<Location> restaurants;
	protected ArrayList<Location> gasStations;
	protected ArrayList<Location> attractions;
	protected ArrayList<Location> cities;
	
	public Location(int x, int y, String name) {
		this.xPos = x;
		this.yPos = y;
		this.name = name;
		this.distance = 0;
		this.restaurants = new ArrayList<Location>();
		this.gasStations = new ArrayList<Location>();
		this.attractions = new ArrayList<Location>();
		this.cities = new ArrayList<Location>();
	}
	
	
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
	public void setDistance(int newDist) {
		this.distance = newDist;
	}

}
