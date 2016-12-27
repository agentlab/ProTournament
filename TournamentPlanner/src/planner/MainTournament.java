/**
 * 
 */
package planner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Vilkova
 *
 */
public class MainTournament {
	
	public static final int MAX_NUMBER_PLAYER = 100;
	
	private List<Player> players;
	private SingleEliminationTournament singleEliminationTournament;
	private boolean registrationOpen;
	private boolean roundPlaying;
	

	public SingleEliminationTournament getSingleEliminationTournament() {
		if (singleEliminationTournament == null) {
			if (players != null) {
				singleEliminationTournament = new SingleEliminationTournament(players);
			}
			else {
				singleEliminationTournament = new SingleEliminationTournament();
			}
		}
		return singleEliminationTournament;
	}
	
	public void openRegistration() {
		this.players = new ArrayList<>();
		getSingleEliminationTournament().setPlayers(players);
		this.registrationOpen = true;
		this.roundPlaying = false;
		
	}
	
	public void closeRegistration() {
		this.registrationOpen = false;
		this.roundPlaying = true;
		getSingleEliminationTournament().generateMatchs();
	}
	
	public boolean isRegistrationOpen() {
		return this.registrationOpen;
		
	}
	
	public boolean addPlayer(Player player) {
		if ((players.size() < MAX_NUMBER_PLAYER) && (this.registrationOpen) && (player != null)) {
			this.players.add(player);
			return true;
		} else {
			return false;
			
		}
	}

	public boolean removePlayer(Player player) {
		if ((players.size() > 0) && (this.registrationOpen) && (this.players.contains(player))) {
			this.players.remove(player);
			return true;
		} else {
			return false;
			
		}
	}
	
	public int getFreeNumberPlayer() {
		return (MAX_NUMBER_PLAYER - players.size());
		
	}
	
	public List<Player> getPlayers(){
		return this.players;
		
	}
	
	public List<Match> getMatchs(){
		List<Match> matchs = new ArrayList<>();
		if (this.roundPlaying) {
			matchs = this.getSingleEliminationTournament().getMatchs();
		}
		return matchs;
	}
	
	public boolean hasMatchsToPlay() {
		boolean hasMatchsToPlay = false;
		if (this.roundPlaying) {
			hasMatchsToPlay = this.getSingleEliminationTournament().hasMatchsToPlay();
		} 
		
		return hasMatchsToPlay;
			
	}
	
	public List<Match> getMatchsToPlay(){
		List<Match> matchs = new ArrayList<>();
		
		if (this.roundPlaying) {
			matchs = this.getSingleEliminationTournament().getMatchs();
		}
		return matchs;
		
	}
	
	public List<Match> getMatchsPlayed(){
		List<Match> matchs = new ArrayList<>();
		
		if (this.roundPlaying) {
			matchs = this.getSingleEliminationTournament().getMatchsPlayed();
		}
		return matchs;
		
	}
	
	public void setRoundResult(int id, Result result) {
		Player roundLoser=null;
		if (this.getSingleEliminationTournament().hasMatchsToPlay()) {
			this.getSingleEliminationTournament().setResult(id, result);
		} 
		if (!this.hasMatchsToPlay()) {
			this.getSingleEliminationTournament().nextRound();
			
		}
	}
	
	public List<Player> getRanking(){
		List<Player> ranking = players;
		Collections.sort(ranking);
		return ranking;
		
	}
	
	public Player getWinner() {
		Match lastMatch;
		Player winner = null;
		List<Match> matchsToPlay = this.getSingleEliminationTournament().getMatchsToPlay();
		
		if ((!getSingleEliminationTournament().hasNextRound()) && (matchsToPlay.size() == 1)) {
			lastMatch = this.getSingleEliminationTournament().getMatchs().get(0);
			winner = lastMatch.getWinner();		
		}
		return winner;
		
	}
	
}
