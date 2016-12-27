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
public class SingleEliminationTournament extends AbstractTournament {

	private Player currentRoundWinner = null;
	private List<Player> allPlayers;
	private List<List<Match>> matchsHistory;

	public SingleEliminationTournament() {
		this(new ArrayList<>());
	}

	public SingleEliminationTournament(List<Player> players) {
		super(players);
		allPlayers = new ArrayList<>(players);
		matchsHistory = new ArrayList<>();
		generateMatchs();

	}

	public boolean hasNextRound() {
		return ((players.size() > 1) && (currentRoundWinner != null));

	}

	public void nextRound() {
		if (!this.hasMatchsToPlay())
		this.generateMatchs();

	}

	@Override
	public void setResult(int id, Result result) {
		super.setResult(id, result);
		Match match = getMatch(id);
		if (match != null)
		{
			players.remove(match.getLoser());
		}
	}
	
	@Override
	public void generateMatchs() {
		if (players == null || matchsHistory == null) {
			return;
		}

		Match match;
		Collections.shuffle(players);

		if (this.currentRoundWinner != null) {
			this.players.add(this.currentRoundWinner);
			this.currentRoundWinner = null;
			Collections.shuffle(this.players);

		}

		if ((this.players.size() % 2) != 0) {
			Collections.shuffle(players);
			currentRoundWinner = players.remove(0);
		}

		this.matchs = new ArrayList<>();
		for (int i = 0; i < this.players.size(); i += 2) {
			match = new Match(this.players.get(i), this.players.get(i + 1));
			this.matchs.add(match);

		}

		this.matchsHistory.add(this.matchs);
	}

}
