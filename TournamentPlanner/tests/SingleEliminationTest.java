import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import planner.MainTournament;
import planner.Match;
import planner.Player;
import planner.Result;

public class SingleEliminationTest {
	
	private static final int PLAYERS_COUNT = 20;
	
	private MainTournament mainTournament;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		mainTournament = new MainTournament();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		mainTournament.openRegistration();
		fillPlayers();
		mainTournament.closeRegistration();

		while (!mainTournament.getMatchs().isEmpty())
		{
			System.err.println("Players: " + mainTournament.getPlayers());
			System.err.println("Mathces: " + mainTournament.getMatchs());
			
			for (Match match : mainTournament.getMatchs())
			{
				mainTournament.setRoundResult(match.getId(), Result.PLAYER1);
			}		
		}
		
	}
	
	@Test
	public void testAdd()
	{
		mainTournament.openRegistration();
		for (int playerIndex = 0; playerIndex <= PLAYERS_COUNT; playerIndex++)
		{
			mainTournament.addPlayer(new Player("Player " + playerIndex));
			System.out.println(mainTournament.getPlayers());
		}
		mainTournament.closeRegistration();
	}

	private void fillPlayers() {
		for (int playerIndex = 0; playerIndex < PLAYERS_COUNT; playerIndex++)
		{
			mainTournament.addPlayer(new Player("Player " + playerIndex));
		}
	}
	
}
