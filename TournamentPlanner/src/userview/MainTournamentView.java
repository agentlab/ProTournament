/**
 * 
 */
package userview;

import java.util.List;
import java.util.Scanner;

import planner.MainTournament;
import planner.Player;
import planner.Result;

/**
 * @author Vilkova
 *
 */
public class MainTournamentView {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MainTournament mainTournament = new MainTournament();
		String command;

		System.out.println("Project Tournament");

		System.out.print(">");
		command = scanner.nextLine();

		while (!command.equals("exit") && !command.equals("quit")) {

			if (command.equals("help")) {
				showHelp();

			} else if (command.equals("open")) {
				mainTournament.openRegistration();
				if (mainTournament.isRegistrationOpen()) {
					System.out.println("Registration is now opened");
				} else {
					System.out.println("Registration was not now opened");
				}

			} else if (command.equals("close")) {
				mainTournament.closeRegistration();
				if (!mainTournament.isRegistrationOpen()) {
					System.out.println("Registration is now closed");
				} else {
					System.out.println("Registration was not now closed");
				}

			} else if (command.equals("status")) {
				if (mainTournament.isRegistrationOpen()) {
					System.out.println("Registration opened");
				} else {
					System.out.println("Registration closed");
				}

			} else if (command.equals("add")) {
				boolean isAdded;
				Player player;

				System.out.print("Type the name of the player: ");
				player = new Player(scanner.nextLine());
				isAdded = mainTournament.addPlayer(player);

				if (isAdded) {
					System.out.println("Player " + player.getName() + " was successfully added");
				} else {
					System.out.println("Player couldn't have been added, check the registration to be opened");
				}

			} else if (command.equals("remove")) {
				boolean isRemoved = false;
				Player player;
				int playerId;
				List<Player> playerList = mainTournament.getPlayers();
				String name = null;

				System.out.print("Type the id of the player: ");
				playerId = scanner.nextInt();
				scanner.nextLine();
				for (int i = 0; i < playerList.size(); i++) {
					player = playerList.get(i);
					if (player.getId() == playerId) {
						isRemoved = mainTournament.removePlayer(player);
						name = player.getName();
					}
				}

				if (isRemoved) {
					System.out.println("Player " + name + " was successfully removed");
				} else {
					System.out.println("Player couldn't have been removed, check the registration to be opened");
				}
			} else if (command.equals("freenumber")) {
				System.out.println("Free number for player: " + mainTournament.getFreeNumberPlayer());

			} else if (command.equals("players")) {
				System.out.println(mainTournament.getPlayers());

			} else if (command.equals("matchs")) {
				if (mainTournament.isRegistrationOpen()) {
					System.out.println("Matchs are not generated yet");
				} else {
					System.out.println(mainTournament.getMatchs());
				}

			} else if (command.equals("toplay")) {
				if (mainTournament.isRegistrationOpen()) {
					System.out.println("Matchs are not generated yet");
				} else {
					System.out.println(mainTournament.getMatchsToPlay());
				}

			} else if (command.equals("played")) {
				if (mainTournament.isRegistrationOpen()) {
					System.out.println("Matchs are not generated yet");
				} else {
					System.out.println(mainTournament.getMatchsPlayed());
				}

			} else if (command.equals("setresult")) {
				int id;
				String result;

				System.out.print("Enter match id: ");
				id = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter result (\"PLAYER1\" or \"PLAYER2\"): ");
				result = scanner.nextLine();
				if (result.equalsIgnoreCase("NOT_PLAYED")) {
					mainTournament.setRoundResult(id, Result.NOT_PLAYED);
					System.out.println("Result set to \"NOT_PLAYED\"");
				} else if (result.equalsIgnoreCase("PLAYER1")) {
					mainTournament.setRoundResult(id, Result.PLAYER1);
					System.out.println("Result set to \"PLAYER1\"");
				} else if (result.equalsIgnoreCase("PLAYER2")) {
					mainTournament.setRoundResult(id, Result.PLAYER2);
					System.out.println("Result set to \"PLAYER2\"");
				}

			} else if (command.equals("ranking")) {
				System.out.println(mainTournament.getRanking());

			} else if (command.equals("winner")) {
				System.out.println(mainTournament.getWinner());
			} else {
				System.out.println("Invalid command. Type \"help\"");
			}

			System.out.print(">");
			command = scanner.nextLine();

		}
	}

	private static void showHelp() {
		System.out.println("List of commands:");
		System.out.println("help\t\tshow this help\n" + "open\t\topen registration\n" + "close\t\tclose registration\n"
				+ "status\t\tshow registration status\n" + "add\t\tadd player\n" + "remove\t\tremove player\n"
				+ "players\t\tshow players list\n" + "freenumber\t\tshow free number for player\n"
				+ "matchs\t\tshow list of all matchs\n" + "toplay\t\tshow list of unplayed matchs\n"
				+ "played\t\tshow list of played matchs\n" + "setresult\t\tset match result\n"
				+ "ranking\t\tshow ranking\n" + "winner\t\tshow winner\n" + "exit\t\texit program\n");

	}
}
