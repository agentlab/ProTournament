/**
 * 
 */
package planner;

/**
 * @author Vilkova
 *
 */
public class Player implements Comparable<Player>{
	
	private String name;
	private int points;
	private int id;
	private static int nextId = 1;
	
	public Player(String name) {
		this.name = name;
		this.id = this.nextId;
		this.nextId++;
		
	}
	
	public String getName() {
		return name;
		
	}
	
	public int getId() {
		return id;
		
	}
	
	public int getPoints() {
		return points;
		
	}
	
	public void setPoints(int points) {
		this.points = points;
		
	}
	
	public void addPoints(int points) {
		this.points += points;
		
	}
	
	@Override
	public int compareTo(Player e) {
		return this.points - e.getPoints();
	}
	
	@Override
	public String toString() {
		return name;
	}
}
