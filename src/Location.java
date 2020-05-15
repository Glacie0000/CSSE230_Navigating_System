import java.util.Comparator;
import java.util.PriorityQueue;

public abstract class Location implements Comparator<Location>{
	
	protected int distance;
	protected String name;
	protected int xPos;
	protected int yPos;
	protected PriorityQueue<Location> locationQueue;
	
	public Location(int x, int y, String name) {
		this.xPos = x;
		this.yPos = y;
		this.name = name;
		this.distance = 0;
		this.locationQueue = new PriorityQueue<Location>(10, locationComparator());
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
	public void setDistance(int newDist) {
		this.distance = newDist;
	}
	
	public int compareTo(Location otherLoc) {
		if(this.distance > otherLoc.distance) {
			return 1;
		}
		else if(this.distance < otherLoc.distance) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
	public Comparator<Location> locationComparator(){
		return new Comparator<Location>() {
			@Override
			public int compare(Location loc1, Location loc2) {
				// TODO Auto-generated method stub
				return loc1.compareTo(loc2);
			}
		};
	}
	
	

}
