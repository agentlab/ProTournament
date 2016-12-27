/**
 * 
 */
package planner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vilkova
 *
 */
abstract class AbstractTournament {

	protected List<Player> players;
	protected List<Match> matchs;

	public AbstractTournament(List<Player> players) {
		matchs = new ArrayList<>();

		this.players = players;
		generateMatchs();

	}

	public Match getMatch(int id) {
		for (Match match : matchs) {
			if (match.getId() == id) {
				return match;
			}
		}

		return null;
	}

	public List<Player> getPlayers() {
		return players;

	}

	public List<Match> getMatchs() {
		return matchs;

	}

	public void setPlayers(List<Player> players) {
		this.players = players;

	}

	public void setResult(int id, Result result) {
		Match match;
		match = getMatch(id);
		if (match != null) {
			match.setResult(result);
		}
	}

	public List<Match> getMatchsToPlay() {
		Match match;
		List<Match> matchsToPlay = new ArrayList<>();
		for (int i = 0; i < matchs.size(); i++) {
			match = matchs.get(i);
			if (!match.isPlayed()) {
				matchsToPlay.add(match);
			}
		}
		return matchsToPlay;

	}

	public List<Match> getMatchsPlayed() {
		List<Match> matchsPlayed = new ArrayList<>();
		for (Match match : matchs) {
			if (match.isPlayed()) {
				matchsPlayed.add(match);
			}
		}
		return matchsPlayed;

	}

	public boolean hasMatchsToPlay() {
		return (!getMatchsToPlay().isEmpty());

	}

	protected abstract void generateMatchs();

}
