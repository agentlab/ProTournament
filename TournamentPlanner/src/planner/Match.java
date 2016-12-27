/**
 * 
 */
package planner;

/**
 * @author Vilkova
 *
 */
public class Match {
	
	public static final int POINT_WINNER = 2;
	public static final int POINT_LOSER = 0;
	public static final int POINT_DRAW = 1;
	
	private int id;
	private static int nextId = 1;
	private Player[] players;
	private Result result;
	
	public Match (Player player1, Player player2) {
		this.players = new Player[2];
		this.players[0] = player1;
		this.players[1] = player2;
		this.result = Result.NOT_PLAYED;
		this.id = this.nextId;
		this.nextId++;
		
	}
	
	public int getId() {
		return id;
		
	}

	public Result getResult() {
		return result;
		
	}
	
	public void setResult(Result result) {
		this.result = result;
		if (this.result == Result.PLAYER1) {
			this.players[0].addPoints(POINT_WINNER);
			this.players[1].addPoints(POINT_LOSER);
		} else if (this.result == Result.PLAYER2) {
			this.players[0].addPoints(POINT_LOSER);
			this.players[1].addPoints(POINT_WINNER);
		}
		 
	}
	
	public boolean isPlayed() {
		return(this.result != Result.NOT_PLAYED);
		
	}
	
	public Player getWinner() {
		if (this.result == Result.PLAYER1) {
			return players[0];
		} else if (this.result == Result.PLAYER2) {
			return players[1];
		} else {
			return null;
			
		}
	
	}
	
	public Player getLoser() {
		if (this.result == Result.PLAYER1) {
			return players[1];
		} else if (this.result == Result.PLAYER2) {
			return players[0];
		} else {
			return null;
			
		}
	}
	
	@Override
	public String toString() {
		String result = "Math(" + id + "), players: ";
		for (Player player : players)
		{
			result += player.toString() + ", ";
		}
		result = result.substring(0, result.length() - 2);
		
		return result;
	}
}
